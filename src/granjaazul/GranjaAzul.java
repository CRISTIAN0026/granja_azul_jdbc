/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package granjaazul;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author crist
 */
public class GranjaAzul {
    public static void main(String[] args) {
        String usuario = "sandbox";
        String password = "sandbox";
        String url = "jdbc:mysql://localhost:3306/granja_azul";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conexion = DriverManager.getConnection(url, usuario, password)) {
                
                String sqlInsert = "INSERT INTO USUARIOS(ID,Nombre,Email, Contraseña, Rol) VALUES(?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = conexion.prepareStatement(sqlInsert)) {
                    preparedStatement.setInt(1, 15);
                    preparedStatement.setString(2, "Cristian");
                    preparedStatement.setString(3, "cristianpaez009@gmail.com");
                    preparedStatement.setString(4, "123456789Cr");
                    preparedStatement.setString(5, "cliente");
                    preparedStatement.executeUpdate();
                }

                
                String sqlUpdate = "UPDATE USUARIOS SET Nombre = ? WHERE ID = ?";
                try (PreparedStatement preparedStatement = conexion.prepareStatement(sqlUpdate)) {
                    preparedStatement.setString(1, "NuevoNombre");
                    preparedStatement.setInt(2, 17);
                    preparedStatement.executeUpdate();
                }

                
                String sqlDelete = "DELETE FROM USUARIOS WHERE ID = ?";
                try (PreparedStatement preparedStatement = conexion.prepareStatement(sqlDelete)) {
                    preparedStatement.setInt(1, 16);
                    preparedStatement.executeUpdate();
                }

                
                String sqlSelect = "SELECT * FROM USUARIOS";
                try (PreparedStatement preparedStatement = conexion.prepareStatement(sqlSelect);
                     ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + " : " + rs.getString("Nombre"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GranjaAzul.class.getName()).log(Level.SEVERE, "Error al conectar con la base de datos", ex);
        }
    }
}

