/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import database.Database;
import database.Usuario;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Usuário
 */
public class Main {

    public static void main(String[] args) {
        Database db = new Database();
        Scanner sc = new Scanner(System.in);
        Looca looca = new Looca();

        String respostaInterfaceGrafica;
        do {
            System.out.println("Deseja interface gráfica? (s/n)");
            respostaInterfaceGrafica = sc.nextLine();
            if (!respostaInterfaceGrafica.equals("s") && !respostaInterfaceGrafica.equals("n")) {
                System.out.println("Valor errado! Insira um valor correto");
            }

        } while (!respostaInterfaceGrafica.equals("s") && !respostaInterfaceGrafica.equals("n"));

        if (respostaInterfaceGrafica.equals("s")) {
            TelaLogin login = new TelaLogin();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        } else if (respostaInterfaceGrafica.equals("n")) {
            // CLI
            System.out.println("Usuário da máquina: ");
            String usuario = sc.nextLine();
            System.out.println("Senha:");
            String senha = sc.nextLine();
            System.out.println("Efetuando Login...");

            Integer idTotem = db.selectIdTotem(usuario);
            Integer freqAlerta = db.selectAlerta(usuario).getFreqAlerta();
            Integer cpuAlerta = db.selectAlerta(usuario).getCpuAlerta();
            Integer cpuCritico = db.selectAlerta(usuario).getCpuCritico();
            Integer ramAlerta = db.selectAlerta(usuario).getRamAlerta();
            Integer ramCritico = db.selectAlerta(usuario).getRamCritico();
            Integer hdAlerta = db.selectAlerta(usuario).getHdAlerta();
            Integer hdCritico = db.selectAlerta(usuario).getCpuCritico();
            db.ligarMaquina(usuario, idTotem);

            TelaExibicaoDeDados exibicaoDeDados = new TelaExibicaoDeDados(usuario,
                    idTotem,
                    freqAlerta,
                    cpuAlerta,
                    cpuCritico,
                    ramAlerta,
                    ramCritico,
                    hdAlerta,
                    hdCritico);
            TelaCadastroPrimeiraVez cadastroPrimeiraVez = new TelaCadastroPrimeiraVez(usuario);

            if (db.selectLogin(usuario, senha)) {

                if (db.verificarCadastro(usuario)) {
                    // Caso o cadastro não seja a primeira vez
                    Integer intervalo = freqAlerta * 1000;
                    System.out.println("Coletando dados:");

                    new Timer().scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            exibicaoDeDados.inserirDados();
                            System.out.println("");
                        }
                    }, 0, intervalo);
 
                    //this.setVisible(false);
                    //exibicaoDeDados.setLocationRelativeTo(null);
                    //exibicaoDeDados.setVisible(true);
                } else {
                    // Fazer caso seja a primeira vez o cadastro
                    System.out.println("Cadastro primeira vez");
                    // Caso o cadastro seja a primeira vez
                    //this.setVisible(false);
                    //cadastroPrimeiraVez.setLocationRelativeTo(null);
                    //cadastroPrimeiraVez.setVisible(true);
                }

            } else {
                System.out.println("Login inválido!");
            }

        } else {
            System.out.println("Deu Bomba!");
        }

    }
}
