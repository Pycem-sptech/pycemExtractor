/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author eduardo
 */
public class DatabaseMySQL {
    
    private BasicDataSource dataSource;
    private JdbcTemplate template;
    
    public DatabaseMySQL(){
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://LocalHost:3306/banco1?useTimezone=true&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("urubu100");
        template = new JdbcTemplate(dataSource);
    
    }
    
    public Boolean selectLogin(String usuario, String senha) {
        Totem totemListado = template.queryForObject("SELECT usuario, senha FROM totem WHERE usuario = ? AND senha = ?;",
                new BeanPropertyRowMapper<Totem>(Totem.class), usuario, senha);
        
        if (totemListado.getUsuario().equals(usuario)){
            return true;
        } else {
            return false;
        }
    }
}
