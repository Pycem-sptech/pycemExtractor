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
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import com.github.britooo.looca.api.util.Conversor;
import database.Database;
import telas.Utilitarios;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuário
 */
public class TelaLogin extends javax.swing.JFrame {
    Database db = new Database();
    Utilitarios util = new Utilitarios();
    Scanner sc = new Scanner(System.in);
    Looca looca = new Looca();
   
   
   
    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        Log log= new Log();
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        Utilitarios util = new Utilitarios();
        util.InserirIcone(this);
        log.escreverTexto("log.txt", "login Realizado");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgLogin = new javax.swing.JLabel();
        imgPycem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        boxLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pycem²");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1175, 679));
        getContentPane().setLayout(null);

        imgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/imgLogin.png"))); // NOI18N
        getContentPane().add(imgLogin);
        imgLogin.setBounds(71, 60, 509, 509);

        imgPycem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pycem.png"))); // NOI18N
        getContentPane().add(imgPycem);
        imgPycem.setBounds(752, 98, 233, 66);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(810, 200, 150, 50);

        txtLogin.setBackground(new java.awt.Color(255, 255, 255));
        txtLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(183, 183, 183));
        txtLogin.setText("Usuário");
        txtLogin.setToolTipText("Insira seu usuário");
        txtLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoginFocusLost(evt);
            }
        });
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        getContentPane().add(txtLogin);
        txtLogin.setBounds(720, 270, 290, 50);

        txtSenha.setBackground(new java.awt.Color(255, 255, 255));
        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(183, 183, 183));
        txtSenha.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSenha.setText("Senha");
        txtSenha.setToolTipText("Insira sua senha");
        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSenhaFocusLost(evt);
            }
        });
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(720, 340, 290, 50);

        btnEntrar.setBackground(new java.awt.Color(98, 165, 227));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(null);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(800, 420, 130, 60);

        boxLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/boxLogin.png"))); // NOI18N
        getContentPane().add(boxLogin);
        boxLogin.setBounds(660, 180, 410, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
   
    }//GEN-LAST:event_txtLoginActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        
        String usuario = txtLogin.getText();
        String senha = txtSenha.getText();
        
        Integer idTotem = db.selectIdTotem(usuario);
        Integer freqAlerta = db.selectAlerta(usuario).getFreqAlerta();
        Integer cpuAlerta = db.selectAlerta(usuario).getCpuAlerta();
        Integer cpuCritico = db.selectAlerta(usuario).getCpuCritico();
        Integer ramAlerta = db.selectAlerta(usuario).getRamAlerta();
        Integer ramCritico = db.selectAlerta(usuario).getRamCritico();
        Integer hdAlerta = db.selectAlerta(usuario).getHdAlerta();
        Integer hdCritico = db.selectAlerta(usuario).getCpuCritico();
        db.ligarMaquina(usuario, idTotem);
        
        TelaExibicaoDeDados exibicaoDeDados = new TelaExibicaoDeDados(usuario,
                idTotem,
            freqAlerta,
            cpuAlerta,
            cpuCritico,
            ramAlerta,
            ramCritico,
            hdAlerta,
            hdCritico);
        TelaCadastroPrimeiraVez cadastroPrimeiraVez = new TelaCadastroPrimeiraVez(usuario);
        
        if(db.selectLogin(usuario, senha)){
            
            if (db.verificarCadastro(usuario)){
                this.setVisible(false);
                exibicaoDeDados.setLocationRelativeTo(null);
                exibicaoDeDados.setVisible(true);
                
            } else {
                this.setVisible(false);
                cadastroPrimeiraVez.setLocationRelativeTo(null);
                cadastroPrimeiraVez.setVisible(true);
                
            }
            
            
        }else{
            System.out.println("Login inválido!");
        }
        

    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusGained
        if(txtLogin.getText().equals("Usuário")){
            txtLogin.setText("");
            txtLogin.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_txtLoginFocusGained

    private void txtLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusLost
        if(txtLogin.getText().equals("")){
            txtLogin.setText("Usuário");
            txtLogin.setForeground(new Color(183,183,183));
        }
    }//GEN-LAST:event_txtLoginFocusLost

    private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained
        if(txtSenha.getText().equals("Senha")){
            txtSenha.setText("");
            txtSenha.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_txtSenhaFocusGained

    private void txtSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusLost
        if(txtSenha.getText().equals("")){
            txtSenha.setText("Senha");
            txtSenha.setForeground(new Color(183,183,183));
        }
    }//GEN-LAST:event_txtSenhaFocusLost

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel boxLogin;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel imgLogin;
    private javax.swing.JLabel imgPycem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
