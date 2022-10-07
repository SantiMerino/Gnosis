/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MConnection;
import Model.MUsers;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Controller of Methods of creating, deleting, modifying and reading data on Users. This class contains everything from the resource Users.
 * @author josec
 */
public class CUsers {
    
    public int ID;
    public int idnivelusuario;
    public String username;
    public String clave;
    public int pin;
    public int idestadousuario;
    public int idalumno;
    public int iddocente;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdnivelusuario() {
        return idnivelusuario;
    }

    public void setIdnivelusuario(int idnivelusuario) {
        this.idnivelusuario = idnivelusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getIdestadousuario() {
        return idestadousuario;
    }

    public void setIdestadousuario(int idestadousuario) {
        this.idestadousuario = idestadousuario;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    /**
     * Data insertion controller.
     * @param idnivelusuario
     * @param username
     * @param clave
     * @param pin
     * @param idestadousuario
     * @param idalumno
     * @param iddocente 
     */
    public CUsers(int idnivelusuario, String username, String clave, int pin, int idestadousuario, int idalumno, int iddocente) {
        this.idnivelusuario = idnivelusuario;
        this.username = username;
        this.clave = clave;
        this.pin = pin;
        this.idestadousuario = idestadousuario;
        this.idalumno = idalumno;
        this.iddocente = iddocente;
    }

    /**
     * Controller for data update.
     * @param ID
     * @param idnivelusuario
     * @param username
     * @param clave
     * @param pin
     * @param idestadousuario
     * @param idalumno
     * @param iddocente 
     */
    public CUsers(int ID, int idnivelusuario, String username, String clave, int pin, int idestadousuario, int idalumno, int iddocente) {
        this.ID = ID;
        this.idnivelusuario = idnivelusuario;
        this.username = username;
        this.clave = clave;
        this.pin = pin;
        this.idestadousuario = idestadousuario;
        this.idalumno = idalumno;
        this.iddocente = iddocente;
    }

    /**
     * Controller for data deletion.
     * @param ID 
     */
    public CUsers(int ID) {
        this.ID = ID;
    }

    /**
     * Controller Users
     */
    public CUsers() {
    }
    
    MUsers mdlUsers = new MUsers();
    private Connection con = MConnection.getConnectionWithoutParameters();
    
    public ResultSet CargarEstadoUsuarioResultSet() {
        return mdlUsers.CargaCmbEstadoUsuario();
    }
    
    public ResultSet CargarNivelUsuarioResultSet() {
        return mdlUsers.CargaCmbNivelUsuario();
    }
    
    public ResultSet CargarAlumnoResultSet(){
        return mdlUsers.CargaCmbAlumnos();
    }
    
    public ResultSet CargarDocenteResultSet(){
        return mdlUsers.CargaCmbDocentes();
    }
    
    public ResultSet CargarUsuariosResultSet() {
        return mdlUsers.mostrarUsuarios(con);
    }
    
    /**
     * Users controller for users insertion with the encryption of the pasword.
     * @return 
     */
    public boolean UsuarioNuevo() {
        String claveMD5 = CValidaciones.getMD5(clave);
        return mdlUsers.RegistrarUsuariosModel(idnivelusuario, username, claveMD5, pin, idestadousuario, idalumno, iddocente, con);
    }

    /**
     * Users Controller for updating the users.
     * @return 
     */
    public boolean ActualizarUsuario() {
        return mdlUsers.ActualizarUsuariosModel(ID, idnivelusuario, username, clave, pin, idestadousuario, idalumno, iddocente, con);
    }

    /**
     * Users Controller for the removal of the users.
     * @return 
     */
    public boolean EliminarUsuario() {
        return mdlUsers.EliminarUsuarioModel(ID, con);
    }
    
    public boolean EliminarUsuario(int id) {
        return mdlUsers.EliminarUsuarioModelU(id, con);
    }
    
}
