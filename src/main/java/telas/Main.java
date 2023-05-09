/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.util.Conversor;
import database.Database;
import database.DatabaseMySQL;
import database.Usuario;
import java.util.List;
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
        CLI cli = new CLI(looca);
        DatabaseMySQL dbMysql = new DatabaseMySQL(); 

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
            
            if(dbMysql.selectLogin(usuario, senha)){
                System.out.println("Logado no MySQL com sucesso!");
            } else {
                System.out.println("Falha ao logar na máquina");
            }
            
            if (db.selectLogin(usuario, senha)) {

                if (db.verificarCadastro(usuario)) {
                    // Caso o cadastro não seja a primeira vez

                    cli.capturarDados(freqAlerta, exibicaoDeDados);

                } else {
                    // Caso o cadastro seja a primeira vez
                    System.out.println("Faça o cadastro da sua máquina:");
                    String respostaPreenchimentoAutomatico;
                    do {
                        System.out.println("Deseja preenchimento automático? (s/n)");
                        respostaPreenchimentoAutomatico = sc.nextLine();
                        if (!respostaPreenchimentoAutomatico.equals("s") && !respostaPreenchimentoAutomatico.equals("n")) {
                            System.out.println("Valor errado! Insira um valor correto");
                        }

                    } while (!respostaPreenchimentoAutomatico.equals("s") && !respostaPreenchimentoAutomatico.equals("n"));

                    if (respostaPreenchimentoAutomatico.equals("s")) {
                        //Rede
                        String redeIpv6 = cli.getRedeIpv6();
                        String redeMacAdress = cli.getRedeMacAdress();
                        
                        System.out.println("ID Processador: ");
                        String processadorID = cli.getProcessadorID();
                        System.out.println(processadorID);
                        System.out.println("Nome Processador: ");
                        String processadorNome = cli.getProcessadorNome();
                        System.out.println(processadorNome);
                        System.out.println("CPU Físicas");
                        String processadorCPUFisica = cli.getProcessadorCPUFisica();
                        System.out.println(processadorCPUFisica);
                        System.out.println("CPU Lógicas");
                        String processadorCPULogica = cli.getProcessadorCPULogica();
                        System.out.println(processadorCPULogica);
                        System.out.println("Memória RAM(Quantidade):");
                        String memoriaRAM = cli.getMemoriaRAM();
                        System.out.println(memoriaRAM);
                        System.out.println("Memória de Massa:");
                        System.out.println("Nome: ");
                        String memoriaMassa = cli.getMemoriaMassaNome();
                        System.out.println(memoriaMassa);
                        System.out.println("Tamanho: ");
                        String memoriaMassaTamanho = cli.getMemoriaMassaTamanho();
                        System.out.println(memoriaMassaTamanho);
                        System.out.println("Tipo(SDD ou HD): ");
                        String memoriaMassaTipo = sc.nextLine();
                        System.out.println("Realizando cadastro...");
                        // Inserindo as informações no banco de dados
                        db.atualizarCadastro(usuario, processadorID, processadorNome, memoriaRAM, memoriaMassaTipo, memoriaMassaTamanho, redeIpv6, redeMacAdress);
                        System.out.println("Cadastro realizado com sucesso");
                        cli.capturarDados(freqAlerta, exibicaoDeDados);

                    } else if (respostaPreenchimentoAutomatico.equals("n")) {
                        //Rede
                        String redeIpv6 = cli.getRedeIpv6();
                        String redeMacAdress = cli.getRedeMacAdress();
                        
                        System.out.println("ID Processador: ");
                        String processadorID = sc.nextLine();
                        System.out.println("Nome Processador: ");
                        String processadorNome = sc.nextLine();
                        System.out.println("CPU Físicas");
                        String processadorCPUFisica = sc.nextLine();
                        System.out.println("CPU Lógicas");
                        String processadorCPULogica = sc.nextLine();
                        System.out.println("Memória RAM(Quantidade):");
                        String memoriaRAM = sc.nextLine();
                        System.out.println("Memória de Massa:");
                        System.out.println("Nome: ");
                        String memoriaMassaNome = sc.nextLine();
                        System.out.println("Tamanho: ");
                        String memoriaMassaTamanho = sc.nextLine();
                        System.out.println("Tipo(SDD ou HD): ");
                        String memoriaMassaTipo = sc.nextLine();
                        System.out.println("Realizando cadastro...");
                        // Inserindo as informações no banco de dados
                        db.atualizarCadastro(usuario, processadorID, processadorNome, memoriaRAM, memoriaMassaTipo, memoriaMassaTamanho, redeIpv6, redeMacAdress);
                        System.out.println("Cadastro realizado com sucesso");
                        cli.capturarDados(freqAlerta, exibicaoDeDados);
                    }

                }

            } else {
                System.out.println("Login inválido!");
            }

        } else {
            System.out.println("Deu Bomba!");
        }

    }


}
