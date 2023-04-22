package database;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class Database {

    private BasicDataSource dataSource;
    private JdbcTemplate template;

    public Database() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://servidor-pycem.database.windows.net:1433;databaseName=pycem-db");
        dataSource.setUsername("adminpy");
        dataSource.setPassword("#Gfgrupo8");
        template = new JdbcTemplate(dataSource);
    }
    // Trocar o login pelo da máquina
    public Boolean selectLogin(String usuario, String senha) {
        Totem totemListado = template.queryForObject("SELECT usuario, senha FROM [dbo].[totem] WHERE usuario = ? AND senha = ?;",
                new BeanPropertyRowMapper<Totem>(Totem.class), usuario, senha);
        
        System.out.println(totemListado.getUsuario());
        System.out.println(totemListado.getSenha());
        if (totemListado.getUsuario().equals(usuario)){
            System.out.println(totemListado.getUsuario());
            return true;
        } else {
            return false;
        }
        //List<String> dadosUsuario = new ArrayList();
        //dadosUsuario.add(usuarioListado.getEmail());
        //dadosUsuario.add(usuarioListado.getSenha());
        //dadosUsuario.add(usuarioListado.getNome());
        //dadosUsuario.add(usuarioListado.getCpf());
        //dadosUsuario.add(usuarioListado.getCargo());
        //return dadosUsuario;
    }
    // Verificar o cadastro da máquina
    public Boolean verificarCadastro(String usuario){
        Totem totemListado = template.queryForObject("SELECT usuario FROM totem WHERE usuario = ?",
                new BeanPropertyRowMapper<Totem>(Totem.class), usuario);
        
        if (totemListado.getProcessador() == null){
            return false;
        } else {
            return true;
        }        
    } 
    
    public void atualizarCadastro(
            String usuario,
            String numeroSerie,
            String processador,
            String ram,
            String tipoArmazenamento,
            String qtdArmazenamento,
            String ipv4,
            String macAdress){
        template.update(
                "UPDATE [dbo].[totem] SET numeroSerie = ?, processador = ?, ram = ?, tipo_armazenamento = ?, qtd_armazenamento = ?, "
                        + "ipv4 = ?, mac_address = ? WHERE usuario = ?;", 
                numeroSerie, 
                processador, 
                ram, 
                tipoArmazenamento, 
                qtdArmazenamento, 
                ipv4, 
                macAdress,
                usuario);
    
    }
}
