/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author karen
 */
public class Conexionbdo {
     private static final String URL = "jdbc:postgresql://1.pgsqlserver.com:5432/gamabasis_karencita";
    private static final String USER = "gamabasis_karencita";
    private static final String PASSWORD = "RvvV570xC#";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
