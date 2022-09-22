/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.MEstudents;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author PC
 */
public class CEstudents {
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    private MEstudents mdlEstu = new MEstudents();
    
    protected int ID;
    public static int idalumno;
    private String apellidosalumno;
    private String nombresalumno;
    private int idgenero;
    private int idgrado;
    private String correo;
    private String direccion;
    private String contacto;
    private String dui;
    private String fecha_nac;
    private int idusuario;
    private String codigocarnet;


    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public MEstudents getMdlEstu() {
        return mdlEstu;
    }

    public void setMdlEstu(MEstudents mdlEstu) {
        this.mdlEstu = mdlEstu;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getApellidosalumno() {
        return apellidosalumno;
    }

    public void setApellidosalumno(String apellidosalumno) {
        this.apellidosalumno = apellidosalumno;
    }

    public String getNombresalumno() {
        return nombresalumno;
    }

    public void setNombresalumno(String nombresalumno) {
        this.nombresalumno = nombresalumno;
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getCodigocarnet() {
        return codigocarnet;
    }

    public void setCodigocarnet(String codigocarnet) {
        this.codigocarnet = codigocarnet;
    }

    public ResultSet idAlumnoforUsuario(){
        return mdlEstu.idAlumnoParaUsuario(correo, con);
    }
    
    
    public boolean CrearUsuarioAlumnoController (){
        String clave = CValidaciones.getMD5("gnosis123");
        return mdlEstu.RegistrarUsuarioAlumno(1, correo,idalumno ,clave, con);
    }
    
    public boolean AlumnoNuevoController(){
        return mdlEstu.RegistrarAlumnoModel(apellidosalumno, nombresalumno, idgenero, idgrado, correo, direccion, contacto, dui, fecha_nac, codigocarnet, con);
    }

    public CEstudents(String apellidosalumno, String nombresalumno, int idgenero, int idgrado, String correo, String direccion, String contacto, String dui, String fecha_nac, int idusuario, String codigocarnet) {
        this.apellidosalumno = apellidosalumno;
        this.nombresalumno = nombresalumno;
        this.idgenero = idgenero;
        this.idgrado = idgrado;
        this.correo = correo;
        this.direccion = direccion;
        this.contacto = contacto;
        this.dui = dui;
        this.fecha_nac = fecha_nac;
        this.idusuario = idusuario;
        this.codigocarnet = codigocarnet;
    }
    
    public boolean ActualizarEstudiante() {
        return mdlEstu.ActualizarEstudianteModel(ID, apellidosalumno, nombresalumno, idgenero, idgrado, correo, direccion, contacto, dui, fecha_nac, codigocarnet, con);
    }

    public CEstudents(int ID, String apellidosalumno, String nombresalumno, int idgenero, int idgrado, String correo, String direccion, String contacto, String dui, String fecha_nac, int idusuario, String codigocarnet) {
        this.ID = ID;
        this.apellidosalumno = apellidosalumno;
        this.nombresalumno = nombresalumno;
        this.idgenero = idgenero;
        this.idgrado = idgrado;
        this.correo = correo;
        this.direccion = direccion;
        this.contacto = contacto;
        this.dui = dui;
        this.fecha_nac = fecha_nac;
        this.idusuario = idusuario;
        this.codigocarnet = codigocarnet;
    }
    
    public boolean EliminarEstudiante() {
        return mdlEstu.EliminarEstudianteModel(ID, con);
    }

    public CEstudents(int ID) {
        this.ID = ID;
    }
}
