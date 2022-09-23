/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.MTeacher;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *Controller to create, delete, modify and read data methods of Teacher
 * @author santi
 */
public class CTeacher {
    /*El mero matatan llego*/
    
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    private MTeacher mdlDocen = new MTeacher();
    
    protected int ID;
    private String apellidosdocente;
    private String nombresdocente;
    private String direccion;
    private String dui;
    private String correo;
    private String fecha_nac;
    private int idgrado;
    private int idgenero;
    private String contacto;
    private int idusuario;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public MTeacher getMdlDocen() {
        return mdlDocen;
    }

    public void setMdlDocen(MTeacher mdlDocen) {
        this.mdlDocen = mdlDocen;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getApellidosdocente() {
        return apellidosdocente;
    }

    public void setApellidosdocente(String apellidosdocente) {
        this.apellidosdocente = apellidosdocente;
    }

    public String getNombresdocente() {
        return nombresdocente;
    }

    public void setNombresdocente(String nombresdocente) {
        this.nombresdocente = nombresdocente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public MTeacher getModeloGeneros() {
        return modeloGeneros;
    }

    public void setModeloGeneros(MTeacher modeloGeneros) {
        this.modeloGeneros = modeloGeneros;
    }

    public MTeacher getModeloUsuarios() {
        return modeloUsuarios;
    }

    public void setModeloUsuarios(MTeacher modeloUsuarios) {
        this.modeloUsuarios = modeloUsuarios;
    }

    public MTeacher getModeloDocentesC() {
        return modeloDocentesC;
    }

    public void setModeloDocentesC(MTeacher modeloDocentesC) {
        this.modeloDocentesC = modeloDocentesC;
    }

    
    
    public boolean DocenteNuevoController() {
        return mdlDocen.RegistrarDocenteModel(apellidosdocente, nombresdocente, direccion, dui, correo, fecha_nac, idgrado, idgenero, contacto, con);
    }

    public CTeacher(String apellidosdocente, String nombresdocente, String direccion, String dui, String correo, String fecha_nac, int idgrado, int idgenero, String contacto) {
        this.apellidosdocente = apellidosdocente;
        this.nombresdocente = nombresdocente;
        this.direccion = direccion;
        this.dui = dui;
        this.correo = correo;
        this.fecha_nac = fecha_nac;
        this.idgrado = idgrado;
        this.idgenero = idgenero;
        this.contacto = contacto;
    }
    
    
    
    public boolean EliminarDocenteController() {
        return mdlDocen.EliminarDocenteModel(ID, con);
    }

    public CTeacher(int ID) {
        this.ID = ID;
    }

    public boolean ActualizarDocente() {
        return mdlDocen.ActualizarDocenteModel(ID, apellidosdocente, nombresdocente, direccion, dui, correo, fecha_nac, idgrado, idgenero, contacto, con);
    } 

    public CTeacher(int ID, String apellidosdocente, String nombresdocente, String direccion, String dui, String correo, String fecha_nac, int idgrado, int idgenero, String contacto) {
        this.ID = ID;
        this.apellidosdocente = apellidosdocente;
        this.nombresdocente = nombresdocente;
        this.direccion = direccion;
        this.dui = dui;
        this.correo = correo;
        this.fecha_nac = fecha_nac;
        this.idgrado = idgrado;
        this.idgenero = idgenero;
        this.contacto = contacto;
    }
    
    MTeacher modeloGeneros = new MTeacher();
    MTeacher modeloUsuarios = new MTeacher();
    MTeacher modeloDocentesC = new MTeacher();
    
    public ResultSet CCargarGeneros(){
       return modeloGeneros.MCargarGenero(con);
    }
    
    public ResultSet CCargarUsuarios() {
        return modeloUsuarios.MCargarUsuarios(con);
    }
    
    public ResultSet CCargarDocentes(){
        return modeloDocentesC.mostrarDocentes(con);
    }

    public CTeacher() {
    }
    
    
    
    
}
