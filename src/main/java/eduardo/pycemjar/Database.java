
package eduardo.pycemjar;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class Database {
       Usuario usuario = new Usuario();
       

       public void realizarSelect(String email, String senha){
            
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setUrl("jdbc:sqlserver://pycem-db.database.windows.net:1433;database=pycem-db;encryp" +
"t=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
            dataSource.setUsername("adminpy");
            dataSource.setPassword("#Gfgrupo8");
            
            JdbcTemplate template = new JdbcTemplate(dataSource);
            Usuario usuarioListado = template.queryForObject("select * from usuario where email = ? and senha = ?", 
            new BeanPropertyRowMapper<Usuario>(Usuario.class), email, senha);
            
            System.out.println(usuarioListado);
           
       }
    
    
    
    
}
