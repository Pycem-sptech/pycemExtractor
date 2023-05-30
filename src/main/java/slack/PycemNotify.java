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
    
    String usuario;
    Integer cpuAlerta ;
    Integer cpuCritico ;
    Integer ramAlerta;
    Integer ramCritico ;
    Integer hdAlerta ;
    Integer hdCritico;

    public PycemNotify(String usuario) {
        this.usuario = usuario;
        cpuAlerta = bd.selectAlerta(usuario).getCpuAlerta();
        cpuCritico = bd.selectAlerta(usuario).getCpuCritico();
        ramAlerta = bd.selectAlerta(usuario).getRamAlerta();
        ramCritico = bd.selectAlerta(usuario).getRamCritico();
        hdAlerta = bd.selectAlerta(usuario).getHdAlerta();
        hdCritico = bd.selectAlerta(usuario).getHdCritico();
    }
    
    public void enviarNotificacao(String mensagem) throws IOException, InterruptedException{
        JSONObject json = new JSONObject();
        json.put("text", mensagem);
        SlackConfig.notificar(json);
    }
    
    public void integracaoSlack() throws IOException, InterruptedException{
            Processador processador = looca.getProcessador();

            Memoria memoria = looca.getMemoria();
            Double memoriaEmUso = memoria.getEmUso() / 1073741824.0;
            Double memoriaTotal = memoria.getTotal() / 1073741824.0;
            Double porcentagemRam = memoriaEmUso * 100 / memoriaTotal;

            DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
            Double memoriaMassaDisponivel = grupoDeDiscos.getVolumes().get(0).getDisponivel() / 1073741824.0;
            Double memoriaMassaTotal = grupoDeDiscos.getVolumes().get(0).getTotal() / 1073741824.0;
            Double porcentagemMemoriaMassa = 100 - memoriaMassaDisponivel * 100 / memoriaMassaTotal;

            if (processador.getUso() >= cpuAlerta && processador.getUso() < cpuCritico) {
                enviarNotificacao(String.format("A máquina %s está com a cpu em status de alerta", this.usuario));
            } else if (processador.getUso() >= cpuCritico) {
                enviarNotificacao(String.format("A máquina %s apresentou um pico de uso na CPU considerado crítico,"
                        + " recomendamos entrar com uma medida preventiva imediatamente", this.usuario));
            }

            if (porcentagemRam >= ramAlerta && porcentagemRam < ramCritico) {
                enviarNotificacao(String.format("A máquina %s está com a ram em status de alerta", this.usuario));
            } else if (porcentagemRam >= ramCritico) {
                enviarNotificacao(String.format("A máquina %s apresentou um pico de uso na RAM considerado crítico,"
                        + " recomendamos entrar com uma medida preventiva imediatamente", this.usuario));
            } 

            if (porcentagemMemoriaMassa >= hdAlerta && porcentagemMemoriaMassa < hdAlerta) {
                enviarNotificacao(String.format("A máquina %s está com a memória de massa em status de alerta", this.usuario));
            } else if (porcentagemMemoriaMassa >= hdAlerta) {
                enviarNotificacao(String.format("A máquina %s apresentou um pico de uso no HD considerado crítico,"
                        + " recomendamos entrar com uma medida preventiva imediatamente", this.usuario));
            } 

    }
    
}
