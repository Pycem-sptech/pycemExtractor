/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import database.Database;
import database.Usuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Usuário
 */
public class Main {
    
    
    public static void main(String[] args) {      
        TelaLogin login = new TelaLogin();  
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
