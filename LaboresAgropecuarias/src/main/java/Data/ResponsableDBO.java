/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Conexion.Conexionbdo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Responsable;
/**
 *
 * @author karen
 */
public class ResponsableDBO {
    public boolean AgregarResponsable(Responsable r) {
            
    String sql = "INSERT INTO \"Responsable\" "
              + "(\"Identificacion\",\"Nombre\", \"Correo\", \"Telefono\", \"TipoResponsable\", \"TipoDerivado\") "
               + "VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexionbdo.conectar()) {

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, r.getIdentificacion());
        ps.setString(2, r.getNombre());
        ps.setString(3, r.getCorreo());
        ps.setInt(4, r.getTelefono());
        ps.setString(5, r.getTipoResponsable());
        ps.setString(6, r.getTipoDerivado());
       
        int filas = ps.executeUpdate();
        
        System.out.println("Responsable agregado correctamente. Filas afectadas: " + filas);
        return filas > 0;
        }
    } catch (SQLException e) {
        System.err.println("Error al registrar responsable: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
         }
   
    
    public List<Responsable> ListaResponsable(String texto){
        List<Responsable> listaResponsable=new ArrayList<>();
        
        String sql = "SELECT \"Identificacion\", \"Nombre\", \"Correo\", \"Telefono\", \"TipoResponsable\", \"TipoDerivado\" "
                + "FROM \"Responsable\" "
                + "WHERE LOWER(\"Nombre\") LIKE LOWER(?)";
        
        try (Connection conn = Conexionbdo.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "%" + texto + "%");
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                Responsable r=new Responsable();
                
                    r.setIdentificacion(rs.getInt("Identificacion"));
                    r.setNombre(rs.getString("Nombre"));
                    r.setCorreo(rs.getString("Correo"));
                    r.setTelefono(rs.getInt("Telefono"));
                    r.setTipoResponsable(rs.getString("TipoResponsable"));    
                    r.setTipoDerivado(rs.getString("TipoDerivado"));
                    
            
            listaResponsable.add(r);
            } 
            
            } catch(Exception e){
             System.out.println("Error al generar la lista de Responsable: "+ e.getMessage());
             e.printStackTrace();
         }
        return listaResponsable;
    }
    
    public Responsable ObtenerResponsable(int identificacion){
        String sql = "SELECT \"Identificacion\", \"Nombre\", \"Correo\", \"Telefono\", \"TipoResponsable\", \"TipoDerivado\" "
                   + "FROM \"Responsable\" WHERE \"Identificacion\" = ?";
        
        try(Connection conn = Conexionbdo.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
           ps.setInt(1, identificacion);
            try (ResultSet rs=ps.executeQuery()){
                if (rs.next()){
                return new Responsable(
                    rs.getInt("Identificacion"),
                    rs.getString("Nombre"),
                    rs.getString("Correo"),
                    rs.getInt("Telefono"),
                    rs.getString("TipoResponsable"),    
                    rs.getString("TipoDerivado")
                           );
                    }
                }
 
        } catch (Exception e){
            System.out.println("Error de consulta de el Responsable: "+ e.getMessage());
        }
        return null;
    }
    
    
    public boolean BorrarResponsable(int identificacion) throws SQLException {
        
        String sql = "DELETE FROM \"Responsable\" WHERE \"Identificacion\" = ?";
        
        try (Connection conn = Conexionbdo.conectar();
              PreparedStatement ps = conn.prepareStatement(sql)){               
                                          
            ps.setInt(1, identificacion);
            int filas = ps.executeUpdate();
            return filas > 0;
            
        }
         catch(Exception e){
            System.out.println("Error al intentar borrar el Responsable" + e.getMessage());
            e.printStackTrace();
             return false;
         }
        
    }
    
    public boolean ModificarResponsable(Responsable r) throws SQLException{
        
        String sql = "UPDATE \"Responsable\" SET \"Nombre\" = ?, \"Correo\" = ?, \"Telefono\" = ?, \"TipoResponsable\" = ?, \"TipoDerivado\" = ? "
                   + "WHERE \"Identificacion\" = ?";
        
        try(Connection conn = Conexionbdo.conectar();
                
           PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, r.getIdentificacion());
            ps.setString(2, r.getNombre());
            ps.setString(3, r.getCorreo());
            ps.setInt(4, r.getTelefono());
            ps.setString(5, r.getTipoResponsable());
            ps.setString(6, r.getTipoDerivado());
            
            int filas = ps.executeUpdate();
            return filas > 0;
              
           }catch(SQLException e){
            System.out.println("Ocurrio un error al actualizar el Responsable,  porfavor intente de nuevo" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
