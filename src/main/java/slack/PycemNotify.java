/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slack;

import com.github.britooo.looca.api.core.Looca;
import java.io.IOException;
import org.json.JSONObject;

/*
 * @author Cris
 */
public class PycemNotify {
    
    Looca looca = new Looca();
    
    public void enviarNotificacao(String mensagem) throws IOException, InterruptedException{
        
        JSONObject json = new JSONObject();
        json.put("text", mensagem);
        SlackConfig.notificar(json);
    }

}
