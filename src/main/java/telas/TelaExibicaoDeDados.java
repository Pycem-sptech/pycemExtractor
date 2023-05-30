/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.util.Conversor;
import database.Database;
import database.DatabaseMySQL;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import slack.PycemNotify;


/**
 *
 * @author Usuário
 */
public class TelaExibicaoDeDados extends javax.swing.JFrame {
  
    Looca looca = new Looca();
    Utilitarios util = new Utilitarios();
    Database db = new Database();
    DatabaseMySQL dbMySQL = new DatabaseMySQL();
    private String usuario;
    private Integer fkTotem;
    private Integer freqAlerta;
    private Integer cpuAlerta;
    private Integer cpuCritico;
    private Integer ramAlerta;
    private Integer ramCritico;
    private Integer hdAlerta;
    private Integer hdCritico;

    /**
     * Creates new form TelaExibicaoDeDados
     */
    public TelaExibicaoDeDados() {
        initComponents();
        util.InserirIcone(this);
    }

    public TelaExibicaoDeDados(
            String usuario,
            Integer fkTotem,
            Integer freqAlerta,
            Integer cpuAlerta,
            Integer cpuCritico,
            Integer ramAlerta,
            Integer ramCritico,
            Integer hdAlerta,
            Integer hdCritico) {
        initComponents();
        util.InserirIcone(this);
        this.usuario = usuario;
        this.fkTotem = fkTotem;
        this.freqAlerta = freqAlerta;
        this.cpuAlerta = cpuAlerta;
        this.cpuCritico = cpuCritico;
        this.ramAlerta = ramAlerta;
        this.ramCritico = ramCritico;
        this.hdAlerta = hdAlerta;
        this.hdCritico = hdCritico;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblInfoProcessadorFabricante = new javax.swing.JLabel();
        btnProcessador = new javax.swing.JButton();
        lblInfoProcessadorNome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblInfoProcessadorCPUFisicas = new javax.swing.JLabel();
        lblInfoProcessadorCPULogica = new javax.swing.JLabel();
        lblInfoProcessadorEmUso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblInfoRAMEmUso = new javax.swing.JLabel();
        lblInfoRAMDisponivel = new javax.swing.JLabel();
        lblInfoMemoriaMassaNome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblInfoMemoriaMassaModelo = new javax.swing.JLabel();
        lblInfoMemoriaMassaTamanho = new javax.swing.JLabel();
        lblInfoRAMTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblDesempenho = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Processador:");

        lblInfoProcessadorFabricante.setText("Fabricante:");
        lblInfoProcessadorFabricante.setMaximumSize(new java.awt.Dimension(200, 500));

        btnProcessador.setText("Atualizar Dados");
        btnProcessador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessadorActionPerformed(evt);
            }
        });

        lblInfoProcessadorNome.setText("Nome:");
        lblInfoProcessadorNome.setMaximumSize(new java.awt.Dimension(200, 500));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("Dados do Computador");

        lblInfoProcessadorCPUFisicas.setText("Número de CPU Física:");
        lblInfoProcessadorCPUFisicas.setMaximumSize(new java.awt.Dimension(200, 500));

        lblInfoProcessadorCPULogica.setText("Número de CPU Lógica:");
        lblInfoProcessadorCPULogica.setMaximumSize(new java.awt.Dimension(200, 500));

        lblInfoProcessadorEmUso.setText("Em uso:");
        lblInfoProcessadorEmUso.setMaximumSize(new java.awt.Dimension(200, 500));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Memória RAM:");

        lblInfoRAMEmUso.setText("Em uso:");
        lblInfoRAMEmUso.setMaximumSize(new java.awt.Dimension(200, 500));

        lblInfoRAMDisponivel.setText("Disponível:");
        lblInfoRAMDisponivel.setMaximumSize(new java.awt.Dimension(200, 500));

        lblInfoMemoriaMassaNome.setText("Nome:");
        lblInfoMemoriaMassaNome.setMaximumSize(new java.awt.Dimension(200, 500));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Memória de Massa:");

        lblInfoMemoriaMassaModelo.setText("Modelo:");
        lblInfoMemoriaMassaModelo.setMaximumSize(new java.awt.Dimension(200, 500));

        lblInfoMemoriaMassaTamanho.setText("Tamanho:");
        lblInfoMemoriaMassaTamanho.setMaximumSize(new java.awt.Dimension(200, 500));

        lblInfoRAMTotal.setText("Total:");
        lblInfoRAMTotal.setMaximumSize(new java.awt.Dimension(200, 500));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Carcaterísticas do Hardware:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Processador:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Memória RAM:");

        lblDesempenho.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDesempenho.setText("Desempenho:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(lblInfoMemoriaMassaTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblInfoMemoriaMassaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblInfoMemoriaMassaNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(334, 334, 334))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel1)
                                                .addGap(401, 401, 401))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblInfoProcessadorFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblInfoProcessadorCPULogica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblInfoProcessadorCPUFisicas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblInfoProcessadorNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(98, 98, 98))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnProcessador, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(lblInfoProcessadorEmUso, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(48, 48, 48)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblInfoRAMEmUso, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(lblInfoRAMDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(170, 170, 170))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(lblInfoRAMTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(786, Short.MAX_VALUE)
                    .addComponent(lblDesempenho)
                    .addGap(304, 304, 304)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInfoProcessadorFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfoProcessadorEmUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfoRAMEmUso, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInfoProcessadorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfoRAMDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoProcessadorCPUFisicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoProcessadorCPULogica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoRAMTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(lblInfoMemoriaMassaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfoMemoriaMassaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfoMemoriaMassaTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(btnProcessador)
                .addGap(67, 67, 67))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addComponent(lblDesempenho)
                    .addContainerGap(575, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessadorActionPerformed
        Integer intervalo = freqAlerta != null ? freqAlerta * 1000 : 5 * 1000;
        exibirDados();
        inserirDados();
        PycemNotify slack = new PycemNotify(usuario);
        new Timer().scheduleAtFixedRate(new TimerTask() {  
        @Override
        public void run()  {
         inserirDados();  
         try {
            slack.integracaoSlack();
        } catch (IOException ex) {
            Logger.getLogger(TelaExibicaoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TelaExibicaoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }, 0, intervalo);
    }//GEN-LAST:event_btnProcessadorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        db.desligarMaquina(usuario, fkTotem);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaExibicaoDeDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExibicaoDeDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExibicaoDeDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExibicaoDeDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExibicaoDeDados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcessador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblDesempenho;
    private javax.swing.JLabel lblInfoMemoriaMassaModelo;
    private javax.swing.JLabel lblInfoMemoriaMassaNome;
    private javax.swing.JLabel lblInfoMemoriaMassaTamanho;
    private javax.swing.JLabel lblInfoProcessadorCPUFisicas;
    private javax.swing.JLabel lblInfoProcessadorCPULogica;
    private javax.swing.JLabel lblInfoProcessadorEmUso;
    private javax.swing.JLabel lblInfoProcessadorFabricante;
    private javax.swing.JLabel lblInfoProcessadorNome;
    private javax.swing.JLabel lblInfoRAMDisponivel;
    private javax.swing.JLabel lblInfoRAMEmUso;
    private javax.swing.JLabel lblInfoRAMTotal;
    // End of variables declaration//GEN-END:variables

    public void exibirDados() {
        Processador processador = looca.getProcessador();
        System.out.println(processador);
        lblInfoProcessadorFabricante.setText("Fabricante: " + processador.getFabricante());
        lblInfoProcessadorNome.setText("Nome: " + processador.getNome());
        lblInfoProcessadorCPUFisicas.setText("Número de CPU Física: " + processador.getNumeroCpusFisicas().toString());
        lblInfoProcessadorCPULogica.setText("Número de CPU Lógica: " + processador.getNumeroCpusLogicas().toString());
        lblInfoProcessadorEmUso.setText(String.format("Em uso: %.2f", processador.getUso()));

        Memoria memoria = looca.getMemoria();
        System.out.println(memoria);
        String memoriaEmUso = Conversor.formatarBytes(memoria.getEmUso());
        String memoriaTotal = Conversor.formatarBytes(memoria.getTotal());
        String memoriaDisponivel = Conversor.formatarBytes(memoria.getDisponivel());

        lblInfoRAMEmUso.setText(String.format("Em uso: %s", memoriaEmUso));
        lblInfoRAMDisponivel.setText(String.format("Disponível: %s", memoriaDisponivel));
        lblInfoRAMTotal.setText(String.format("Total: %s", memoriaTotal));

        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        List<Disco> discos = grupoDeDiscos.getDiscos();
        for (Disco disco : discos) {
            System.out.println(disco);

            lblInfoMemoriaMassaNome.setText(String.format("Nome: %s", disco.getNome()));
            lblInfoMemoriaMassaModelo.setText(String.format("Modelo: %s", disco.getModelo()));
            lblInfoMemoriaMassaTamanho.setText(String.format("Tamanho: %s", Conversor.formatarBytes(disco.getTamanho())));

        }
    }

    public void inserirDados() {
        Log log = new Log();
        Processador processador = looca.getProcessador();
        String usoProcessador = String.format("%.0f", processador.getUso());

        Memoria memoria = looca.getMemoria();
        Double memoriaEmUso = memoria.getEmUso() / 1073741824.0;
        Double memoriaTotal = memoria.getTotal() / 1073741824.0;
        Double porcentagemRam = memoriaEmUso * 100 / memoriaTotal;
        String porcentagemRamFinal = String.format("%.0f", porcentagemRam);

        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        Double memoriaMassaDisponivel = grupoDeDiscos.getVolumes().get(0).getDisponivel() / 1073741824.0;
        Double memoriaMassaTotal = grupoDeDiscos.getVolumes().get(0).getTotal() / 1073741824.0;
        Double porcentagemMemoriaMassa = 100 - memoriaMassaDisponivel * 100 / memoriaMassaTotal;
        String porcentagemMemoriaMassaFinal = String.format("%.0f", porcentagemMemoriaMassa);

        String statusCPU;
        String statusRam;
        String statusHd;
        
        Integer contador = 0;
        
        if (cpuAlerta > processador.getUso()) {
            statusCPU = "Saudavel";
        } else if (processador.getUso() >= cpuAlerta && processador.getUso() < cpuCritico) {
            statusCPU = "Alerta";
        } else {
            statusCPU = "Critico";
            contador++;
        }

        if (ramAlerta > porcentagemRam) {
            statusRam = "Saudavel";
        } else if ( porcentagemRam >= ramAlerta && porcentagemRam < ramCritico ) {
            statusRam = "Alerta";
        } else {
            statusRam = "Critico";
            contador++;
        }

        if (hdAlerta > porcentagemMemoriaMassa) {
            statusHd = "Saudavel";
        } else if (porcentagemMemoriaMassa >= hdAlerta && porcentagemMemoriaMassa < hdCritico) {
            statusHd = "Alerta";
        } else {
            statusHd = "Critico";
            contador++;
        }
        
        if (contador >= 2){
            db.abrirChamado(fkTotem);
        }
        

        System.out.println("Status da CPU: " + statusCPU);
        System.out.println("Status da Memória RAM: " + statusRam);
        System.out.println("Status do HD: " + statusHd);
        System.out.println("\nUso processador: " + usoProcessador + "%");
        System.out.println("Porcentagem de uso da Memória RAM: " + porcentagemRamFinal + "%");
        System.out.println("Porcentagem de uso da Memória de Massa: " + porcentagemMemoriaMassaFinal + "%");
      
        
        db.inserirDados(usoProcessador, porcentagemRamFinal, porcentagemMemoriaMassaFinal, statusCPU, statusRam, statusHd, fkTotem);
        dbMySQL.inserirDados(usoProcessador, porcentagemRamFinal, statusHd);

    }
    
    
}
