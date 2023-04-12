/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Usuário
 */
public class Utilitarios {
    public void InserirIcone(JFrame frm){
        frm.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/Py.png")));
    }
}
