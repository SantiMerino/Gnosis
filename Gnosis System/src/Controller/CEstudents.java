/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.MEstudents;
import java.sql.Connection;
/**
 *
 * @author PC
 */
public class CEstudents {
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    private MEstudents mdlEstu = new MEstudents();
    
    protected int ID;
    private String NombresAlumno;
    private String ApellidosAlumno;
    private String DireccionAlumno;
    private String TelefonoAlumno;
    private String FechaNacimiento;
    private String DUIAlumno;
    private String CorreoAlumno;
    private String CodigoCarnet;
    private int idGeneroAlumno;
    private int idEstadoAlumno;
    private int idConjuntoNiveles;
    private int idUsuario;

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

    public String getNombresAlumno() {
        return NombresAlumno;
    }

    public void setNombresAlumno(String NombresAlumno) {
        this.NombresAlumno = NombresAlumno;
    }

    public String getApellidosAlumno() {
        return ApellidosAlumno;
    }

    public void setApellidosAlumno(String ApellidosAlumno) {
        this.ApellidosAlumno = ApellidosAlumno;
    }

    public String getDireccionAlumno() {
        return DireccionAlumno;
    }

    public void setDireccionAlumno(String DireccionAlumno) {
        this.DireccionAlumno = DireccionAlumno;
    }

    public String getTelefonoAlumno() {
        return TelefonoAlumno;
    }

    public void setTelefonoAlumno(String TelefonoAlumno) {
        this.TelefonoAlumno = TelefonoAlumno;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDUIAlumno() {
        return DUIAlumno;
    }

    public void setDUIAlumno(String DUIAlumno) {
        this.DUIAlumno = DUIAlumno;
    }

    public String getCorreoAlumno() {
        return CorreoAlumno;
    }

    public void setCorreoAlumno(String CorreoAlumno) {
        this.CorreoAlumno = CorreoAlumno;
    }

    public String getCodigoCarnet() {
        return CodigoCarnet;
    }

    public void setCodigoCarnet(String CodigoCarnet) {
        this.CodigoCarnet = CodigoCarnet;
    }

    public int getIdGeneroAlumno() {
        return idGeneroAlumno;
    }

    public void setIdGeneroAlumno(int idGeneroAlumno) {
        this.idGeneroAlumno = idGeneroAlumno;
    }

    public int getIdEstadoAlumno() {
        return idEstadoAlumno;
    }

    public void setIdEstadoAlumno(int idEstadoAlumno) {
        this.idEstadoAlumno = idEstadoAlumno;
    }

    public int getIdConjuntoNiveles() {
        return idConjuntoNiveles;
    }

    public void setIdConjuntoNiveles(int idConjuntoNiveles) {
        this.idConjuntoNiveles = idConjuntoNiveles;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public boolean AlumnoNuevoController(){
        return mdlEstu.RegistrarDocenteModel(NombresAlumno, ApellidosAlumno, DireccionAlumno, TelefonoAlumno, FechaNacimiento, DUIAlumno, CorreoAlumno, CodigoCarnet, idGeneroAlumno, idEstadoAlumno, idConjuntoNiveles, idUsuario, con);
    }

    public CEstudents(String NombresAlumno, String ApellidosAlumno, String DireccionAlumno, String TelefonoAlumno, String FechaNacimiento, String DUIAlumno, String CorreoAlumno, String CodigoCarnet, int idGeneroAlumno, int idEstadoAlumno, int idConjuntoNiveles, int idUsuario) {
        this.NombresAlumno = NombresAlumno;
        this.ApellidosAlumno = ApellidosAlumno;
        this.DireccionAlumno = DireccionAlumno;
        this.TelefonoAlumno = TelefonoAlumno;
        this.FechaNacimiento = FechaNacimiento;
        this.DUIAlumno = DUIAlumno;
        this.CorreoAlumno = CorreoAlumno;
        this.CodigoCarnet = CodigoCarnet;
        this.idGeneroAlumno = idGeneroAlumno;
        this.idEstadoAlumno = idEstadoAlumno;
        this.idConjuntoNiveles = idConjuntoNiveles;
        this.idUsuario = idUsuario;
    }
    
    public boolean ActualizarEstudiante() {
        return mdlEstu.ActualizarEstudianteModel(ID, NombresAlumno, ApellidosAlumno, DireccionAlumno, TelefonoAlumno, FechaNacimiento, DUIAlumno, CorreoAlumno, CodigoCarnet, idGeneroAlumno, idEstadoAlumno, idConjuntoNiveles, idUsuario, con);
    }

    public CEstudents(int ID, String NombresAlumno, String ApellidosAlumno, String DireccionAlumno, String TelefonoAlumno, String FechaNacimiento, String DUIAlumno, String CorreoAlumno, String CodigoCarnet, int idGeneroAlumno, int idEstadoAlumno, int idConjuntoNiveles, int idUsuario) {
        this.ID = ID;
        this.NombresAlumno = NombresAlumno;
        this.ApellidosAlumno = ApellidosAlumno;
        this.DireccionAlumno = DireccionAlumno;
        this.TelefonoAlumno = TelefonoAlumno;
        this.FechaNacimiento = FechaNacimiento;
        this.DUIAlumno = DUIAlumno;
        this.CorreoAlumno = CorreoAlumno;
        this.CodigoCarnet = CodigoCarnet;
        this.idGeneroAlumno = idGeneroAlumno;
        this.idEstadoAlumno = idEstadoAlumno;
        this.idConjuntoNiveles = idConjuntoNiveles;
        this.idUsuario = idUsuario;
    }
    
    public boolean EliminarEstudiante() {
        return mdlEstu.EliminarEstudianteModel(ID, con);
    }

    public CEstudents(int ID) {
        this.ID = ID;
    }
    
}
