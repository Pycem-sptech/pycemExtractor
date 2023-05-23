/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slack;

import java.io.IOException;
import org.json.JSONObject;

/*
 * @author Cris
 */
public class PycemNotify {
    
    
    public void enviarNotificacao(String mensagem) throws IOException, InterruptedException{
        JSONObject json = new JSONObject();
        json.put("text", mensagem);
        SlackConfig.notificar(json);
    }
    
}
