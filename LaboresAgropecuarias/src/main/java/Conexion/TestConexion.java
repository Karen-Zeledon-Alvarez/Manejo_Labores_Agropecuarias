/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import Conexion.Conexionbdo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author karen
 */
public class TestConexion {
     public static void main(String[] args) {
        try {
            Connection conn = Conexionbdo.conectar();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT NOW();");

            if (rs.next()) {
                System.out.println("Conectado. Fecha BD: " + rs.getString(1));
            }

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
