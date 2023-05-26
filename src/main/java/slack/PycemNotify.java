/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slack;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import database.Alerta;
import database.Database;
import java.io.IOException;
import org.json.JSONObject;

/*
 * @author Cris
 */
public class PycemNotify {
    
    Looca looca = new Looca();
    Alerta alerta = new Alerta();
    Database bd = new Database();
    
   
    
    public void enviarNotificacao(String mensagem) throws IOException, InterruptedException{
        JSONObject json = new JSONObject();
        json.put("text", mensagem);
        SlackConfig.notificar(json);
    }
    
   
    
}
