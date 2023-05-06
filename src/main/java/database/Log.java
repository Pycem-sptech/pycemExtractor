/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.time.LocalDateTime;

/**
 *
 * @author yara
 */
public class Log {

      Database db = new Database();
    
     LocalDateTime dataHoraAtual = LocalDateTime.now();;    
      
      
    public void ligarDelisgarMaquina(Boolean estado, String nome, Integer idTotem){
        if(estado == true){
            System.out.println("Ligada \nvalor: " + estado + "\nnome :" + nome +"\nid: " + idTotem + "\nData e hora" + dataHoraAtual);
        }else if(estado == false){
            System.out.println("Desligada \nvalor: " + estado + "\nnome :" + nome +"\nid: " + idTotem + "\nData e hora " + dataHoraAtual);
        }
    }
    
    
    public void login(Boolean estado, String nome){
        
        if(estado == true){
            System.out.println("O usuario: " + nome + " logou as " + dataHoraAtual);
        }else if(estado == false){
            System.out.println("O usuario: " + nome + " deslogou as " + dataHoraAtual);
        }
    }
    
    public void dadosProcessadorRamMassa(String processador, String ram, String massa){
        
        System.out.println("Ultimo dados "
                + "\nProcessador: " + processador
                + "\nMemoria RAM: " + ram
                + "\nMemoria em Massa: " + massa
                + "\nData e hora: " + dataHoraAtual);
    
    }
    
}
