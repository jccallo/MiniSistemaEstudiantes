package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection conexion;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/MiniSistemaEstudiantes?useSSL=false&allowPublicKeyRetrieval=true";
    String usuario = "root";
    String clave = "Mysql2004";
    
    public Connection mysql() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }
}
