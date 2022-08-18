/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.MTeacher;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author santi
 */
public class CTeacher {
    /*El mero matatan llego*/
    
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    private MTeacher mdlDocen = new MTeacher();
    
    protected int ID;
    private String NombresDocente;
    private String ApellidosDocente;
    private String DireccionDocente;
    private String TelefonoDocente;
    private String FechaNacimiento;
    private String DUI;
    private String Correo;
    private int idGeneroDocente;
    private int idUsuario;

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

    public String getNombresDocente() {
        return NombresDocente;
    }

    public void setNombresDocente(String NombresDocente) {
        this.NombresDocente = NombresDocente;
    }

    public String getApellidosDocente() {
        return ApellidosDocente;
    }

    public void setApellidosDocente(String ApellidosDocente) {
        this.ApellidosDocente = ApellidosDocente;
    }

    public String getDireccionDocente() {
        return DireccionDocente;
    }

    public void setDireccionDocente(String DireccionDocente) {
        this.DireccionDocente = DireccionDocente;
    }

    public String getTelefonoDocente() {
        return TelefonoDocente;
    }

    public void setTelefonoDocente(String TelefonoDocente) {
        this.TelefonoDocente = TelefonoDocente;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getIdGeneroDocente() {
        return idGeneroDocente;
    }

    public void setIdGeneroDocente(int idGeneroDocente) {
        this.idGeneroDocente = idGeneroDocente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public boolean DocenteNuevoController() {
        return mdlDocen.RegistrarDocenteModel(NombresDocente, ApellidosDocente, DireccionDocente, TelefonoDocente, FechaNacimiento, DUI, Correo, idGeneroDocente, idUsuario, con);
    }

    public CTeacher(String NombresDocente, String ApellidosDocente, String DireccionDocente, String TelefonoDocente, String FechaNacimiento, String DUI, String Correo, int idGeneroDocente, int idUsuario) {
        this.NombresDocente = NombresDocente;
        this.ApellidosDocente = ApellidosDocente;
        this.DireccionDocente = DireccionDocente;
        this.TelefonoDocente = TelefonoDocente;
        this.FechaNacimiento = FechaNacimiento;
        this.DUI = DUI;
        this.Correo = Correo;
        this.idGeneroDocente = idGeneroDocente;
        this.idUsuario = idUsuario;
    }
    
    public boolean EliminarDocenteController() {
        return mdlDocen.EliminarDocenteModel(ID, con);
    }

    public CTeacher(int ID) {
        this.ID = ID;
    }

    public boolean ActualizarDocente() {
        return mdlDocen.ActualizarDocenteModel(ID, NombresDocente, ApellidosDocente, DireccionDocente, TelefonoDocente, FechaNacimiento, DUI, Correo, idGeneroDocente, idUsuario, con);
    } 

    public CTeacher(int ID, String NombresDocente, String ApellidosDocente, String DireccionDocente, String TelefonoDocente, String FechaNacimiento, String DUI, String Correo, int idGeneroDocente, int idUsuario) {
        this.ID = ID;
        this.NombresDocente = NombresDocente;
        this.ApellidosDocente = ApellidosDocente;
        this.DireccionDocente = DireccionDocente;
        this.TelefonoDocente = TelefonoDocente;
        this.FechaNacimiento = FechaNacimiento;
        this.DUI = DUI;
        this.Correo = Correo;
        this.idGeneroDocente = idGeneroDocente;
        this.idUsuario = idUsuario;
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
    
    
}
