/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slack;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cris
 */
public class TesteSlack {
    public static void main(String[] args) {
        PycemNotify slack = new PycemNotify();
        
        try {
            slack.integracaoSlack();
        } catch (IOException ex) {
            Logger.getLogger(TesteSlack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TesteSlack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
