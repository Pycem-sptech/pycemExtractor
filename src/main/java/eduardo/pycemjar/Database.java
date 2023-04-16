
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
                dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                dataSource.setUrl("jdbc:sqlserver://servidor-pycem.database.windows.net:1433;databaseName=pycem-db");
                dataSource.setUsername("adminpy");
                dataSource.setPassword("#Gfgrupo8");
            
            JdbcTemplate template = new JdbcTemplate(dataSource);
            Usuario usuarioListado = template.queryForObject("select * from usuario where email = ? and senha = ?", 
            new BeanPropertyRowMapper<Usuario>(Usuario.class), email, senha); 
            
            List<String> dadosUsuario = new ArrayList();
                dadosUsuario.add(usuarioListado.getEmail());
                dadosUsuario.add(usuarioListado.getSenha());
                dadosUsuario.add(usuarioListado.getNome());
                dadosUsuario.add(usuarioListado.getCpf());
                dadosUsuario.add(usuarioListado.getCargo());
            return dadosUsuario;
       }
    
}
