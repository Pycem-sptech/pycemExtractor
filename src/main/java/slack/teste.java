/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slack;

import java.io.IOException;


/**
 *
 * @author Cris
 */
public class teste {
    public static void main(String[] args) throws IOException, InterruptedException {
        PycemNotify slack  = new PycemNotify();
        slack.enviarNotificacao("cris");
    }
}
