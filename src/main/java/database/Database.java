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
    
    public Integer selectIdTotem(String usuario) {
        Totem totemListado = template.queryForObject("SELECT idTotem FROM [dbo].[totem] WHERE usuario = ?;",
                new BeanPropertyRowMapper<Totem>(Totem.class), usuario);
        return totemListado.getIdTotem();
    }
    
    public Alerta selectAlerta() {
        Alerta alerta = template.queryForObject("SELECT * FROM [dbo].[alerta] WHERE fkEmpresa = ?;",
                new BeanPropertyRowMapper<Alerta>(Alerta.class), 100);
        return alerta;
    }
    
    // Trocar o login pelo da máquina
    public Boolean selectLogin(String usuario, String senha) {
        Totem totemListado = template.queryForObject("SELECT usuario, senha FROM [dbo].[totem] WHERE usuario = ? AND senha = ?;",
                new BeanPropertyRowMapper<Totem>(Totem.class), usuario, senha);
        
        if (totemListado.getUsuario().equals(usuario)){
            System.out.println(totemListado.getUsuario());
            return true;
        } else {
            return false;
        }
    }
    // Verificar o cadastro da máquina
    public Boolean verificarCadastro(String usuario){
        Totem totemListado = template.queryForObject("SELECT processador FROM totem WHERE usuario = ?",
                new BeanPropertyRowMapper<Totem>(Totem.class), usuario);
        
        String teste = String.format("%s", totemListado.getProcessador());
        if (totemListado.getProcessador().equals("Não Especificado")){
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
    
    public void inserirDados(
            String usoProcessador,
            String usoRam,
            String usoHd,
            String cpuStatus,
            String ramStatus,
            String hdStatus,
            Integer fkTotem
    ){
        template.update("INSERT INTO [dbo].[registro](uso_processador, uso_ram, uso_hd, cpu_status, ram_status, hd_status, data_registro, fkTotem) "
                + "VALUES (?, ?, ?, ?, ?, ?, getDate(), ?)",
                usoProcessador,
                usoRam,
                usoHd,
                cpuStatus,
                ramStatus,
                hdStatus,
                fkTotem);
    
    }
}
