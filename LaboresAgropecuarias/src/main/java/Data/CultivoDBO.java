/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Cultivo;
import Model.CultivoAnual;
import Model.CultivoPerenne;
import Conexion.Conexionbdo;
/**
 *
 * @author karen
 */
public class CultivoDBO {
   
     public boolean AgregarCultivo(Cultivo cultivo) {
            
    String sql = "INSERT INTO \"Cultivo\" "
              + "(\"CodigoCultivo\",\"NombreCultivo\", \"Variedad\", \"FechaSiembra\", \"TipoCultivo\", \"CategoriaCultivo\") "
               + "VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexionbdo.conectar()) {
        
        // Obtener el siguiente ID
        String sqlMax = "SELECT COALESCE(MAX(\"CodigoCultivo\"), 0) + 1 FROM \"Cultivo\"";
        int nuevoId = 1;
        
        try (PreparedStatement psMax = conn.prepareStatement(sqlMax);
             ResultSet rs = psMax.executeQuery()) {
            if (rs.next()) {
                nuevoId = rs.getInt(1);
            }
        }

        cultivo.setCodigoCultivo(nuevoId);

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, cultivo.getCodigoCultivo());
        ps.setString(2, cultivo.getNombreCultivo());
        ps.setString(3, cultivo.getVariedad());
        ps.setDate(4, java.sql.Date.valueOf(cultivo.getFechaSiembra()));
        ps.setString(5, cultivo.getTipoCultivo());
        ps.setString(6, cultivo.getCategoriaCultivo());
       
        int filas = ps.executeUpdate();
        
        System.out.println("Cultivo insertado correctamente. Filas afectadas: " + filas);
        return filas > 0;
        }
    } catch (SQLException e) {
        System.err.println("Error al registrar reserva: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
         }
   
    
    public List<Cultivo> ListaCultivo(String texto){
        
        List<Cultivo> listaCultivo=new ArrayList<>();
        
        String sql = "SELECT \"CodigoCultivo\", \"NombreCultivo\", \"Variedad\", \"FechaSiembra\", \"TipoCultivo\", \"CategoriaCultivo\" "
                + "FROM \"Cultivo\" "
                + "WHERE LOWER(\"NombreCultivo\") LIKE LOWER(?)";
        
        try (Connection conn = Conexionbdo.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
             ps.setString(1, "%" + texto + "%");
             
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                String categoria = rs.getString("CategoriaCultivo");
                Cultivo c;
                
                if(categoria != null && categoria.equalsIgnoreCase("Anual")){

                    c = new CultivoAnual();

                    }else{

                    c = new CultivoPerenne();
                }
                    c.setCodigoCultivo(rs.getInt("CodigoCultivo"));
                    c.setNombreCultivo(rs.getString("NombreCultivo"));
                    c.setVariedad(rs.getString("Variedad"));
                    c.setFechaSiembra(rs.getDate("FechaSiembra").toLocalDate());
                    c.setTipoCultivo(rs.getString("TipoCultivo"));
                    c.setCategoriaCultivo(categoria);
                    
                    
            
            listaCultivo.add(c);
            } 
            
            } catch(Exception e){
             System.out.println("Error al generar la lista de Cultivo: "+ e.getMessage());
             e.printStackTrace();
         }
        return listaCultivo;
    }
    
    public Cultivo ObtenerCultivo(int codigoCultivo){
        String sql = "SELECT \"CodigoCultivo\", \"NombreCultivo\", \"Variedad\", \"FechaSiembra\", \"TipoCultivo\", \"CategoriaCultivo\" "
                   + "FROM \"Cultivo\" WHERE \"CodigoCultivo\" = ?";
        
        try(Connection conn = Conexionbdo.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
           ps.setInt(1, codigoCultivo);
            try (ResultSet rs=ps.executeQuery()){
                if (rs.next()){
                String categoria =
                        rs.getString("CategoriaCultivo");

                Cultivo cultivo;

                if(categoria.equalsIgnoreCase("Anual")){

                    cultivo = new CultivoAnual();

                }else{

                    cultivo = new CultivoPerenne();
                }
                        
                        
                   cultivo.setCodigoCultivo(
                        rs.getInt("CodigoCultivo"));

                cultivo.setNombreCultivo(
                        rs.getString("NombreCultivo"));

                cultivo.setVariedad(
                        rs.getString("Variedad"));

                cultivo.setFechaSiembra(
                        rs.getDate("FechaSiembra").toLocalDate());

                cultivo.setTipoCultivo(
                        rs.getString("TipoCultivo"));
                cultivo.setCategoriaCultivo(categoria);
                        return cultivo;   
                    }
                }
 
        } catch (Exception e){
            System.out.println("Error de consulta de el Cultivo: "+ e.getMessage());
        }
        return null;
    }
    
    
    public boolean BorrarCultivo(int codigoCultivo) throws SQLException {
        
        String sql = "DELETE FROM \"Cultivo\" WHERE \"CodigoCultivo\" = ?";
        
        try (Connection conn = Conexionbdo.conectar();
              PreparedStatement ps = conn.prepareStatement(sql)){               
                                          
            ps.setInt(1, codigoCultivo);
            int filas = ps.executeUpdate();
            return filas > 0;
            
        }
         catch(Exception e){
            System.out.println("Error al intentar borrar el Cultivo" + e.getMessage());
            e.printStackTrace();
             return false;
         }
        
    }
    
    public boolean ModificarCultivo(Cultivo cultivo) throws SQLException{
        
        String sql = "UPDATE \"Cultivo\" SET \"NombreCultivo\" = ?, \"Variedad\" = ?, \"FechaSiembra\" = ?, \"TipoCultivo\" = ?, \"CategoriaCultivo\" = ? "
                   + "WHERE \"CodigoCultivo\" = ?";
        
        try(Connection conn = Conexionbdo.conectar();
                
           PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, cultivo.getNombreCultivo());
            ps.setString(2, cultivo.getVariedad());
            ps.setDate(3, java.sql.Date.valueOf(cultivo.getFechaSiembra()));
            ps.setString(4, cultivo.getTipoCultivo());
            ps.setString(5, cultivo.getCategoriaCultivo());
            
            int filas = ps.executeUpdate();
            return filas > 0;
              
           }catch(SQLException e){
            System.out.println("Ocurrio un error al actualizar el cultivo,  porfavor intente de nuevo" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
