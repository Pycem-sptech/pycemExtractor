/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduardo.pycemjar;

import com.github.britooo.looca.api.core.Looca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eduardo
 */
public class Main {
    public static void main(String[] args) {
        
        List<Usuario> listaUsuarios = new ArrayList();
        Usuario usuarioAdmin = new Usuario("admin", "admin");
        listaUsuarios.add(usuarioAdmin);
        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("---------------------------------");
        System.out.println("|                               |");
        System.out.println("| Bem-vindo ao Pycem Extractor! |");
        System.out.println("|                               |");
        System.out.println("---------------------------------");
        
        Boolean loginFeitoComSucesso = false;
        do {            
            System.out.println("Efetue seu login para entra em nosso sistema:");
            System.out.println("Login:");
            String login = sc.nextLine();
            System.out.println("Senha:");
            String senha = sc.nextLine();
            
            for (Usuario usuario : listaUsuarios) {
                if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
                    loginFeitoComSucesso = true;
                }
            }
            System.out.println("");
        } while (loginFeitoComSucesso == false);
        
       
        
    }
}
