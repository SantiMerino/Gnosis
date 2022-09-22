/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class MNotas {
    PreparedStatement ps;
    
    /*Llenado de combobox*/
    
    /**
     * Metodo para cargar perfiles desde el modelo
     * @param con
     * @return 
     */
    
    public ResultSet MCargarPefiles(Connection con){
        try {
            String query = "SELECT * FROM tbPerfiles";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }
    
    /**
     * Metodo para cargar alumnos desde el modelo
     * @param con
     * @return 
     */
    
    public ResultSet MCargarAlumnos(Connection con){
        try {
            String query = "SELECT * FROM tbAlumnos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }

    /*Mostrar Tabla*/
    
    /**
     * Metodo para llenar la tabla con una consulta desde el modelo 
     * @param con
     * @return 
     */
    
    public ResultSet MCargarRegistrosNotas(Connection con){
        try {
            String query = "SELECT * FROM tbRegistroNotas";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }
    
    /**
     * Metodo en el modelo para el ingreso de datos a la base de datos
     * @param idperfil
     * @param idalumno
     * @param con
     * @return 
     */
    
    /*Insercion de datos*/
    public boolean RegistrarRegistroNotas(int idperfil, int idalumno,Connection con){
         try {
             String query = "INSERT INTO tbRegistroNotas VALUES(?,?)";
             ps = con.prepareStatement(query);
             ps.setInt(1, idperfil);
             ps.setInt(2, idalumno);
             if (ps.executeUpdate () == 1) {
                 return true;
             }else {
                 return false;
             }
         } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos, verifique la conexion. " + e.toString());
            return false;
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro critico. " + ex.toString());
            return false;
        }
     }
    
    /*Actualizacion*/
    /**
     * Metodo en el modelo para la actualizacion de datos 
     * @param ID
     * @param idperfil
     * @param idalumno
     * @param con
     * @return 
     */
    public boolean ActualizarRegistroNotas(int ID, int idperfil, int idalumno, Connection con){
        try {
            String query = "UPDATE tbRegistroNotas SET idperfil = ?, idalumno = ? WHERE idnota = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idperfil);
            ps.setInt(2, idalumno);
            ps.setInt(3, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
             return false;
        }
    }
    
    /*Eliminacion*/
    /**
     * Metodo en el modelo para la eliminacion de registros 
     * @param ID
     * @param con
     * @return 
     */
    
    public boolean EliminarEstudianteModel(int ID, Connection con){
         try {
             String query = "DELETE tbAlumnos WHERE idnota = ?";
             ps = con.prepareStatement(query);
             ps.setInt(1, ID);
             ps.execute();
             return true;
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro seleccionado, verifique la conexion");
             return false;
         }
     }
    
    /**
     * Metodo para la busqueda por nombre del perfil en el modelo
     * @param ID
     * @param con
     * @return 
     */
    
    public ResultSet SearchCrnt(int ID, Connection con) {
        try {
            String query = "SELECT nombreperfil FROM tbPerfiles WHERE idperfil = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return  null;
        }        
    }
    
    /**
     * obtener nota mediante el id del perfil
     * @param ID
     * @param con
     * @return 
     */
    
    public ResultSet ObtenerId(int ID, Connection con) {
        try {
            String query = "SELECT nota FROM tbPerfiles WHERE idperfil = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return  null;
        }        
    }
    

    
    /*Combobox*/
    
     public ResultSet MCargarTipoPerfil(Connection con){
        try {
            String query = "SELECT * FROM tbTipoPerfiles";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los tipos de perfiles: " + e.toString());
            return null;
        }
    }
     
     public ResultSet MCargarGrado(Connection con){
        try {
            String query = "SELECT * FROM tbGrados";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los grados: " + e.toString());
            return null;
        }
    }
     
     public ResultSet MCargarFase(Connection con){
        try {
            String query = "SELECT * FROM tbFases";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo las fases: " + e.toString());
            return null;
        }
    }
     
     /*Filtro*/
     
     /**
      * Metodo con la busqueda de registros mediante filtros
      * @param busca
      * @param param
      * @param con
      * @return 
      */
     
     public ResultSet BuscarPerfilParam(String busca, String param, Connection con){
        //System.out.println(busca + " "+ param);
        try {
            String sentencia = "select * from viewPerfiles where tipoperfil like '"+busca+"%' and grado like '"+param+"%'";
            ps = con.prepareStatement(sentencia);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleados" + e.toString(), "error de base de datos", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
