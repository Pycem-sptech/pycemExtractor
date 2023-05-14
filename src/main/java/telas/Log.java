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
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.servicos.Servico;
import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EmptyStackException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yara
 */
public class Log {
  
        public static void escreverTexto(String pCaminhoArquivo, String pTextoEscrever){

            Conversor conversor = new Conversor();

            Sistema sistema = new Sistema();
            Memoria memoria = new Memoria();
            Processador processador = new Processador();
            //DiscosGroup discosGroup = new DiscosGroup();
            //ProcessosGroup processosGroup = new ProcessosGroup();

            String usoProcessador = processador.getUso().toString();
            String usoMemoria = conversor.formatarBytes(memoria.getEmUso());
            String memoriaTotal = conversor.formatarBytes(memoria.getTotal());
            //String tamanhoDisco = conversor.formatarBytes(discosGroup.getTamanhoTotal());
            String sistemaOperacional = sistema.getSistemaOperacional();
            String arquitetura = sistema.getArquitetura().toString();
            String fabricante = sistema.getFabricante();
            String tempoAtividade = conversor.formatarSegundosDecorridos(sistema.getTempoDeAtividade());
            //String totalProcessos = processosGroup.getTotalProcessos().toString();

            try(

                    FileWriter criadorDeArquivos = new FileWriter(pCaminhoArquivo, true);
                    BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
                    PrintWriter escritorDeArquivos = new PrintWriter(buffer);){



                escritorDeArquivos.append(pTextoEscrever.toString() +"; " +
                        InetAddress.getLocalHost().getHostName() + "; " +
                        InetAddress.getLocalHost().getHostAddress() + "; " +
                        usoProcessador +"; " +
                        usoMemoria +"; " +
                        memoriaTotal +"; " +
                        //tamanhoDisco +"; " +
                        sistemaOperacional +"; " +
                        arquitetura +"; " +
                        fabricante +"; " +
                        tempoAtividade +"; ");
                        //totalProcessos);

            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        
    
}
