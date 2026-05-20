/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;


import Model.Parcela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexion.Conexionbdo;
import java.sql.SQLException;
/**
 *
 * @author karen
 */
public class ParcelaBDO {
   
    public boolean AgregarParcela(Parcela p) {

        String sql = "INSERT INTO \"Parcela\" "
                + "(\"CodigoParcela\", \"NombreParcela\", "
                + "\"Ubicacion\", \"Area\", "
                + "\"TipoSuelo\", \"EstadoParcela\") "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexionbdo.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getCodigoParcela());
            ps.setString(2, p.getNombreParcela());
            ps.setString(3, p.getUbicacion());
            ps.setString(4, p.getArea());
            ps.setString(5, p.getTipoSuelo());
            ps.setString(6, p.getEstadoParcela());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error al guardar parcela");
            e.printStackTrace();

            return false;
        }
    }

    public List<Parcela> ListaParcela(String texto) {

        List<Parcela> lista = new ArrayList<>();

        String sql = "SELECT * FROM \"Parcela\" "
                + "WHERE LOWER(\"NombreParcela\") "
                + "LIKE LOWER(?)";

        try (Connection conn = Conexionbdo.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + texto + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Parcela p = new Parcela();

                p.setCodigoParcela(
                        rs.getInt("CodigoParcela"));

                p.setNombreParcela(
                        rs.getString("NombreParcela"));

                p.setUbicacion(
                        rs.getString("Ubicacion"));

                p.setArea(
                        rs.getString("Area"));

                p.setTipoSuelo(
                        rs.getString("TipoSuelo"));

                p.setEstadoParcela(
                        rs.getString("EstadoParcela"));

                lista.add(p);
            }

        } catch (Exception e) {

            System.out.println("Error lista parcela");
            e.printStackTrace();
        }

        return lista;
    }

    
    public Parcela ObtenerParcela(int codigoParcela){
        String sql = "SELECT \"CodigoParcela\", \"NombreParcela\", \"Ubicacion\", \"Area\", \"TipoSuelo\", \"EstadoParcela\" "
                   + "FROM \"Parcela\" WHERE \"CodigoParcela\" = ?";
        
        try(Connection conn = Conexionbdo.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
           ps.setInt(1, codigoParcela);
            try (ResultSet rs=ps.executeQuery()){
                if (rs.next()){
                return new Parcela(
                    rs.getInt("CodigoParcela"),
                    rs.getString("NombreParcela"),
                    rs.getString("Ubicacion"),
                    rs.getString("Area"),
                    rs.getString("TipoSuelo"),    
                    rs.getString("EstadoParcela")
                           );
                    }
                }
 
        } catch (Exception e){
            System.out.println("Error de consulta de la Parcela: "+ e.getMessage());
        }
        return null;
    }
    
    
    public boolean BorrarParcela(int codigoParcela) throws SQLException {
        
        String sql = "DELETE FROM \"Parcela\" WHERE \"CodigoParcela\" = ?";
        
        try (Connection conn = Conexionbdo.conectar();
              PreparedStatement ps = conn.prepareStatement(sql)){               
                                          
            ps.setInt(1, codigoParcela);
            int filas = ps.executeUpdate();
            return filas > 0;
            
        }
         catch(Exception e){
            System.out.println("Error al intentar borrar la Parcela" + e.getMessage());
            e.printStackTrace();
             return false;
         }
        
    }
    
    public boolean ModificarParcela(Parcela parcela) throws SQLException{
        
        String sql = "UPDATE \"Parcela\" SET \"NombreParcela\" = ?, \"Ubicacion\" = ?, \"Area\" = ?, \"TipoSuelo\" = ?, \"EstadoParcela\" = ? "
                   + "WHERE \"CodigoParcela\" = ?";
        
        try(Connection conn = Conexionbdo.conectar();
                
           PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, parcela.getNombreParcela());
            ps.setString(2, parcela.getUbicacion());
            ps.setString(3, parcela.getArea());
            ps.setString(4, parcela.getTipoSuelo());
            ps.setString(5, parcela.getEstadoParcela());
            
            int filas = ps.executeUpdate();
            return filas > 0;
              
           }catch(SQLException e){
            System.out.println("Ocurrio un error al actualizar el Parcela,  porfavor intente de nuevo" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


}
