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
import com.github.britooo.looca.api.util.Conversor;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class Teste {
    public static void main(String[] args) {
        Looca looca = new Looca();
        Processador processador = looca.getProcessador();
        String usoProcessador = String.format("%.0f", processador.getUso());
        
        Memoria memoria = looca.getMemoria();
        Double memoriaEmUso = memoria.getEmUso() / 1073741824.0;
        Double memoriaTotal = memoria.getTotal() / 1073741824.0;
        Double porcentagemRam = memoriaEmUso * 100 / memoriaTotal;
        String porcentagemFinal = String.format("%.0f", porcentagemRam);
        
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        Double memoriaMassaDisponivel = grupoDeDiscos.getVolumes().get(0).getDisponivel() / 1073741824.0;
        Double memoriaMassaTotal = grupoDeDiscos.getVolumes().get(0).getTotal() / 1073741824.0;
        Double porcentagemMemoriaMassa = 100 - memoriaMassaDisponivel * 100 / memoriaMassaTotal;
        String porcentagemMemoriaMassaFinal = String.format("%.0f", porcentagemMemoriaMassa);
        
        
        
        
    }
}
