
package eduardo.pycemjar;


import java.util.List;
import java.util.ArrayList;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class Database {
       Usuario usuario = new Usuario();

       public List realizarSelect(String email, String senha){
            
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/pycem?serverTimezone=America/Sao_Paulo");
            dataSource.setUsername("root");
            dataSource.setPassword("titila123");
            
            JdbcTemplate template = new JdbcTemplate(dataSource);
            Usuario usuarioListado = template.queryForObject("select * from usuario where email = ? and senha = ?", 
            new BeanPropertyRowMapper<Usuario>(Usuario.class), email, senha);
            
            System.out.println(usuarioListado.getNome());
            
            List<String> dadosUsuario = new ArrayList();
            dadosUsuario.add(usuarioListado.getEmail());
            dadosUsuario.add(usuarioListado.getSenha());
           
            System.out.println(dadosUsuario);
            
            return dadosUsuario;
       }
    
}
