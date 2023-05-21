
package slack;

import java.io.IOException;
import org.json.JSONObject;

/**
 * @author Cris
 */
public class PycemNotify {
    
    public void enviarNotificacao(String mensagem) throws IOException, InterruptedException{
        
        JSONObject json = new JSONObject();
        
        json.put("text", mensagem);
        
        SlackConfig.notificar(json);
        
    }

}
