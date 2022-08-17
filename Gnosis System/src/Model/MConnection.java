/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class MConnection {
    public static Connection getConnection(String IP, String port, String db, String user, String password){
        Connection con;
        try {
            String url = "jdbc:sqlserver://"+IP+":"+port+ ";"
                   + "databse = "+db+";"
                   + "user = " +user+ ";"
                   + "password = " +password+ ";"
                   + "loginTimeOut = 30";
            con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos, E001" + e.toString());
            return null;
        }
    }
    
    
        public static Connection getConnectionWithoutParameters(){
        //Variable conexión y será la variable a retornar.
        Connection con;
        try {
            //Valores de conexión
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "database = Task1;"
                    + "user = sa;"
                    + "password = itr2022;"
                    + "loginTimeOut = 10";
            //Asignación de valores a objeto conexión
            con = DriverManager.getConnection(url);
            //Retorno de objeto conexión
            return con;
        } catch (Exception e) {
            //Mensaje de error en caso no se establezca correctamente una conexión
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos, E001   "+ e.toString());
            return null;
        }
    }
}
