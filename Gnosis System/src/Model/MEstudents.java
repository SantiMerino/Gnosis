/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Model of Methods of creating, deleting, modifying and reading data on Students. This class contains everything from the resource Students.
 *
 * @author PC
 */
public class MEstudents {

    /*Llenar combobox*/
    PreparedStatement ps;

    public ResultSet MCargarGenero(Connection con) {
        try {
            String query = "SELECT * FROM tbGeneros";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }

    public ResultSet MCargarGrados(Connection con) {
        try {
            String query = "SELECT * FROM tbGrados";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los estados: " + e.toString());
            return null;
        }
    }

    public ResultSet MCargarUsuarios(Connection con) {
        try {
            String query = "SELECT * FROM tbUsuario";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los usuarios: " + e.toString());
            return null;
        }
    }

    public ResultSet mostrarEstudiantes(Connection con) {
        try {
            String query = "SELECT * FROM tbAlumnos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los alumnos: " + e.toString());
            return null;
        }
    }

    public ResultSet idAlumnoParaUsuario(String correo, Connection con) {
        try {
            String query = "SELECT (idalumno) FROM tbAlumnos WHERE correo = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se consiguio el id del alumnos: " + e.toString());
            return null;
        }
    }

    public ResultSet DatosAlumnoLog(int idalumno, Connection con) {
        try {
            String query = "SELECT * FROM viewAlumnos WHERE idalumno = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idalumno);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No fue posible cargar los datos de los alumnos " + e.toString());
            return null;
        }
    }

    /**
     * Method in the Student Model to register the student's user.
     *
     * @param nivel
     * @param correo
     * @param idalumno
     * @param clavedefault
     * @param con
     * @return
     */
    public boolean RegistrarUsuarioAlumno(int nivel, String correo, int idalumno, String clavedefault, Connection con) {
        int estadouser = 2;
        int pindefault = 12345;
        try {
            String query = "EXEC crearUsuarioEstudiante ?, ?, ?, ?, ?, ?";
            ps = con.prepareStatement(query);
            ps.setEscapeProcessing(true);
            ps.setInt(1, nivel);
            ps.setString(2, correo);
            ps.setString(3, clavedefault);
            ps.setInt(4, pindefault);
            ps.setInt(5, estadouser);
            ps.setInt(6, idalumno);
            ResultSet rs = ps.executeQuery();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Method in the Student Model to register a student.
     *
     * @param ApellidosAlumno
     * @param NombresAlumno
     * @param idgenero
     * @param idgrado
     * @param correo
     * @param direccion
     * @param contacto
     * @param dui
     * @param fecha_nac
     * @param codigocarnet
     * @param con
     * @return
     */
    public boolean RegistrarAlumnoModel(String ApellidosAlumno, String NombresAlumno, int idgenero, int idgrado, String correo, String direccion, String contacto, String dui, String fecha_nac, String codigocarnet, Connection con) {
        try {
            String query = "INSERT INTO tbAlumnos VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, ApellidosAlumno);
            ps.setString(2, NombresAlumno);
            ps.setInt(3, idgenero);
            ps.setInt(4, idgrado);
            ps.setString(5, correo);
            ps.setString(6, direccion);
            ps.setString(7, contacto);
            ps.setString(8, dui);
            ps.setString(9, fecha_nac);
//             ps.setInt(10, idusuario);
            ps.setString(10, codigocarnet);
            if (ps.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos, verifique la conexion. " + e.toString());
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro critico. " + ex.toString());
            return false;
        }
    }

    /**
     * Method in the Student Model to update a student.
     *
     * @param ID
     * @param ApellidosAlumno
     * @param NombresAlumno
     * @param idgenero
     * @param idgrado
     * @param correo
     * @param direccion
     * @param contacto
     * @param dui
     * @param fecha_nac
     * @param codigocarnet
     * @param con
     * @return
     */
    public boolean ActualizarEstudianteModel(int ID, String ApellidosAlumno, String NombresAlumno, int idgenero, int idgrado, String correo, String direccion, String contacto, String dui, String fecha_nac, String codigocarnet, Connection con) {
        try {
//             JOptionPane.showMessageDialog(null, idgenero);
            String query = "UPDATE tbAlumnos SET apellidos_alumno = ?, nombres_alumno = ?, idgenero = ?, idgrado = ?, correo = ?, direccion = ?, contacto = ?, dui = ?, fecha_nac = ? WHERE idalumno = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, ApellidosAlumno);
            ps.setString(2, NombresAlumno);
            ps.setInt(3, idgenero);
            ps.setInt(4, idgrado);
            ps.setString(5, correo);
            ps.setString(6, direccion);
            ps.setString(7, contacto);
            ps.setString(8, dui);
            ps.setString(9, fecha_nac);
//             ps.setInt(10, idusuario);
//             ps.setString(10, codigocarnet);
            ps.setInt(10, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
            return false;
        }
    }

    /**
     * Method in the Student Model to remove a student.
     *
     * @param ID
     * @param con
     * @return
     */
    public boolean EliminarEstudianteModel(int ID, Connection con) {
        try {
            String query = "DELETE tbAlumnos WHERE idAlumno = ?";
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
     * Method in the Student Model to search for a student using their card code or name.
     *
     * @param carnet
     * @param con
     * @return
     */
    public ResultSet SearchCrnt(String carnet, Connection con) {
        try {
            String query = "select * from tbAlumnos where codigocarnet like(?) or nombres_alumno like(?) or apellidos_alumno like(?)";
            ps = con.prepareStatement(query);
            ps.setString(1, carnet);
            ps.setString(2, carnet);
            ps.setString(3, carnet);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
}
