package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao {
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion conexion = new Conexion();
    Connection acceso;
    
    public List listar() {
        List<Estudiante> lista = new ArrayList<>(); // lista de contendrá a los objetos estudiantes
        String sql = "SELECT * FROM estudiante"; // la cadena de consulta
        
        try {
            acceso = conexion.mysql(); // nos conectamos a la base de datos
            ps = acceso.prepareStatement(sql); // preparamos la consulta
            rs = ps.executeQuery(); // usamos el metodo exceteQuery para listar
            
            while (rs.next()) {
                Estudiante estudiante = new Estudiante(); // creamos un estudiante para llenarlo
                estudiante.setId(rs.getInt(1)); // llenamos todos sus atributos
                estudiante.setNombre(rs.getString(2));
                estudiante.setApellido(rs.getString(3));
                estudiante.setDni(rs.getString(4));
                estudiante.setEmail(rs.getString(5));
                estudiante.setTelefono(rs.getString(6));
                
                lista.add(estudiante); // agregamos a la lista de estudiantes
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public int agregar(Estudiante estudiante) {
        int respuesta = 0; // respuesta por default que es cero
        String sql = "INSERT INTO estudiante (nombre, apellido, dni, email, telefono) VALUES (?, ?, ?, ?, ?)"; // la cadena de consulta
        
        try {
            acceso = conexion.mysql(); // nos conectamos a la base de datos
            ps = acceso.prepareStatement(sql); // preparamos nuestra consulta
            ps.setString(1, estudiante.getNombre()); // establecemos los valores de la consulta
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getDni());
            ps.setString(4, estudiante.getEmail());
            ps.setString(5, estudiante.getTelefono());
            respuesta = ps.executeUpdate(); // usamos el metodo exceteUpdate para agregar
                                            // retorna las filas afectadas en este caso el numero 1
        } catch (Exception e) {
            e.printStackTrace();
        }
     
        return respuesta;
    }
    
    public int actualizar(Estudiante estudiante) {
        int respuesta = 0;
        String sql = "UPDATE estudiante SET nombre=?, apellido=?, dni=?, email=?, telefono=? WHERE id=?";
        
        try {
            acceso = conexion.mysql(); // nos conectamos a la base de datos
            ps = acceso.prepareStatement(sql); // preparamos nuestra consulta
            ps.setString(1, estudiante.getNombre()); // establecemos los valores de la consulta
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getDni());
            ps.setString(4, estudiante.getEmail());
            ps.setString(5, estudiante.getTelefono());
            ps.setInt(6, estudiante.getId());
            respuesta = ps.executeUpdate(); // usamos el metodo exceteUpdate para actualizar
                                            // retorna las filas afectadas en este caso el numero 1
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return respuesta;
    }
    
    public int eliminar(int id) {
        int respuesta = 0;
        String sql = "DELETE FROM estudiante WHERE id=?";
        
        try {
            acceso = conexion.mysql(); // nos conectamos a la base de datos
            ps = acceso.prepareStatement(sql); // preparamos nuestra consulta
            ps.setInt(1, id);
            respuesta = ps.executeUpdate(); // usamos el metodo exceteUpdate para eliminar
                                            // retorna las filas afectadas en este caso el numero 1
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return respuesta;
    }
    
    public Estudiante validar(String email, String dni) {
        Estudiante estudiante = new Estudiante(); 
        String sql = "SELECT * FROM estudiante WHERE email=? AND dni=?";
        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {                
                estudiante.setId(rs.getInt(1));
                estudiante.setNombre(rs.getString(2));
                estudiante.setApellido(rs.getString(3));
                estudiante.setDni(rs.getString(4));
                estudiante.setEmail(rs.getString(5));
                estudiante.setTelefono(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudiante;
    }
}
