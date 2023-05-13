/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import database.Database;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yara
 */
public class Log {
    Database db = new Database();
    
     LocalDateTime dataHoraAtual = LocalDateTime.now();
     String ldmaquina;
     String loginUsuario;
     String dadosProcessador;

    public String getLoginusuario() {
        return loginUsuario;
    }

    public void setLoginusuario(String loginusuario) {
        this.loginUsuario = loginusuario;
    }
      
     
     
     
    public void ligarDelisgarMaquina(Boolean estado, String nome, Integer idTotem){
        String logGravado = "";
        if(estado == true){
          logGravado = String.format("A Maquina %s com o id %s Ligou as",nome, idTotem);
        }else if(estado == false){
          logGravado = String.format("A Maquina %s com o id %s Desligou as",nome, idTotem);
        }
        ldmaquina = logGravado;
        
    }
    
    
        
    
    
    public void dadosProcessadorRamMassa(String processador, String ram, String massa){
        String logGravado = "";
        logGravado= String.format("Os Ultimos dados"
                + "\nProcessador: %s, Memoria Ram: %s, Memoria em massa: %s, Data e hora:",
                processador, ram, massa);
        dadosProcessador = logGravado;
      
    }
    
      public String gravaLog(){ 
        
        try {
            FileWriter arq = new FileWriter("log.txt", true);
             PrintWriter lerArq = new PrintWriter(arq);
              
              //lerArq.println("Processador: " + this.dadosProcessador);
              //lerArq.println("Maquina: " + this.ldmaquina);
              lerArq.println("Usuario: " + this.loginUsuario);
              //lerArq.println("Data" + this.dataHoraAtual);
              //lerArq.println("asddddddddddd");
              lerArq.flush();
              lerArq.close();
              arq.close();
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "salvo";
            
    }

    @Override
    public String toString() {
        return "Log{" + "db=" + db + ", dataHoraAtual=" + dataHoraAtual + ", ldmaquina=" + ldmaquina + ", loginusuario=" + loginUsuario + ", dadosProcessador=" + dadosProcessador + '}';
    }

    
}
