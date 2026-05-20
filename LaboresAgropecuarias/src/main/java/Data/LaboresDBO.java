/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Conexion.Conexionbdo;
import Model.Cultivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Labores;
import Model.Responsable;
import Model.Parcela;

/**
 *
 * @author karen
 */
public class LaboresDBO {
    
        CultivoDBO cultivoDBO= new CultivoDBO();
        ResponsableDBO resDBO=new ResponsableDBO();
        ParcelaBDO parcelabdo=new ParcelaBDO();
    public boolean AgregarLabores(Labores labor) {
            
    String sql = "INSERT INTO \"Labores\" "
              + "(\"CodigoLabor\", \"CultivoAso\", \"ResponsableAso\", \"FechaLabor\", \"TipoLabor\", \"Descripcion\", \"CostoEstimado\", \"ParcelaAso\") "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexionbdo.conectar()) {
        
        // Obtener el siguiente ID
        String sqlMax = "SELECT COALESCE(MAX(\"CodigoLabor\"), 0) + 1 FROM \"Labores\"";
        int nuevoId = 1;
        
        try (PreparedStatement psMax = conn.prepareStatement(sqlMax);
             ResultSet rs = psMax.executeQuery()) {
            if (rs.next()) {
                nuevoId = rs.getInt(1);
            }
        }

        labor.setCodigoLabor(nuevoId);

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, labor.getCodigoLabor());
        ps.setInt(2, labor.getCultivoAso().getCodigoCultivo());
        ps.setInt(3, labor.getResponsableAso().getIdentificacion());
        ps.setDate(4, labor.getFechaLabor());
        ps.setString(5, labor.getTipoLabor());
        ps.setString(6, labor.getDescripcion());
        ps.setInt(7, labor.getCostoEstimado());
       ps.setInt(8, labor.getParcela().getCodigoParcela());
       
        int filas = ps.executeUpdate();
        
        System.out.println("Labor insertada correctamente. Filas afectadas: " + filas);
        return filas > 0;
        }
    } catch (SQLException e) {
        System.err.println("Error al registrar Labores: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
         }
   
    
    public List<Labores> ListaLabores(String text){
        List<Labores> listaLabores=new ArrayList<>();
        
        String sql = "SELECT \"CodigoLabor\", \"CultivoAso\", "
           + "\"ResponsableAso\", \"FechaLabor\", \"TipoLabor\", "
           + "\"Descripcion\", \"CostoEstimado\", \"ParcelaAso\" "
           + "FROM \"Labores\" "
           + "WHERE CAST(\"CodigoLabor\" AS TEXT) LIKE ? "
           + "OR CAST(\"ParcelaAso\" AS TEXT) LIKE ?"
           + "OR CAST(\"CultivoAso\" AS TEXT) LIKE ? "
           + "OR CAST(\"ResponsableAso\" AS TEXT) LIKE ? "
           + "OR LOWER(\"TipoLabor\") LIKE LOWER(?)";
        
        try (Connection conn = Conexionbdo.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + text + "%");
            ps.setString(2, "%" + text + "%");
            ps.setString(3, "%" + text + "%");
            ps.setString(4, "%" + text + "%");
            ps.setString(5, "%" + text + "%");
            
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int codigoParcela=rs.getInt("ParcelaAso");
                Parcela parcela= parcelabdo.ObtenerParcela(codigoParcela);
                int codigoCultivo=rs.getInt("CultivoAso");
                    Cultivo cultivo= cultivoDBO.ObtenerCultivo(codigoCultivo);
                    int idResponsable= rs.getInt("ResponsableAso");
                    Responsable responsable=resDBO.ObtenerResponsable(idResponsable);
                Labores c=new Labores();
                
                    c.setCodigoLabor(rs.getInt("CodigoLabor"));
                    c.setParcela(parcela);
                    c.setCultivoAso(cultivo);
                    c.setResponsableAso(responsable);
                    c.setFechaLabor(rs.getDate("FechaLabor"));    
                    c.setTipoLabor(rs.getString("TipoLabor"));
                    c.setDescripcion(rs.getString("Descripcion"));
                    c.setCostoEstimado(rs.getInt("CostoEstimado"));
                
                    
            
            listaLabores.add(c);
            } 
            
            } catch(Exception e){
             System.out.println("Error al generar la lista de Labores: "+ e.getMessage());
             e.printStackTrace();
         }
        return listaLabores;
    }
    
    public Labores ObtenerLabores(int codigoLabor){
        
        String sql = "SELECT \"CodigoLabor\", \"CultivoAso\", \"ResponsableAso\", \"FechaLabor\", \"TipoLabor\", \"Descripcion\", \"CostoEstimado\", \"ParcelaAso\" "
                   + "FROM \"Labores\" WHERE \"CodigoLabor\" = ?";
        
        try(Connection conn = Conexionbdo.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
           ps.setInt(1, codigoLabor);
            try (ResultSet rs=ps.executeQuery()){
                if (rs.next()){
                    int codigoParcela=rs.getInt("ParcelaAso");
                Parcela parcela= parcelabdo.ObtenerParcela(codigoParcela);
                    int codigoCultivo=rs.getInt("CultivoAso");
                    Cultivo cultivo= cultivoDBO.ObtenerCultivo(codigoCultivo);
                    int idResponsable= rs.getInt("ResponsableAso");
                    Responsable responsable= resDBO.ObtenerResponsable(idResponsable);
                return new Labores(
                    rs.getInt("CodigoLabor"),
                    parcela,
                    cultivo,
                    responsable,
                    rs.getDate("FechaLabor"),    
                    rs.getString("TipoLabor"),
                    rs.getString("Descripcion"),
                    rs.getInt("CostoEstimado")
                           );
                    }
                }
 
        } catch (Exception e){
            System.out.println("Error de consulta de el Labores: "+ e.getMessage());
        }
        return null;
    }
    
    
    public boolean BorrarLabores(int codigoLabor) throws SQLException {
        
        String sql = "DELETE FROM \"Labores\" WHERE \"CodigoLabor\" = ?";
        
        try (Connection conn = Conexionbdo.conectar();
              PreparedStatement ps = conn.prepareStatement(sql)){               
                                          
            ps.setInt(1, codigoLabor);
            int filas = ps.executeUpdate();
            return filas > 0;
            
        }
         catch(Exception e){
            System.out.println("Error al intentar borrar el Labores" + e.getMessage());
            e.printStackTrace();
             return false;
         }
        
    }
    
   
}
