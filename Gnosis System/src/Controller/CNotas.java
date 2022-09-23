/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.MNotas;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 * Handler to create, delete, modify and read data methods on launch in notes
 * @author Usuario
 */
public class CNotas {
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    private MNotas mdlnotas = new MNotas();
    
    
    /*Encapsulamiento*/
    protected int ID;
    private int idperfil;
    private int idalumno;
    
    /*Getter and Setter*/

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public MNotas getMdlnotas() {
        return mdlnotas;
    }

    public void setMdlnotas(MNotas mdlnotas) {
        this.mdlnotas = mdlnotas;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }
    
    /*Data insertion*/
    
    public boolean RegistroNuevoController(){
        return mdlnotas.RegistrarRegistroNotas(idperfil, idalumno, con);
    }
    
    /*insert constructor*/

    public CNotas(int idperfil, int idalumno) {
        this.idperfil = idperfil;
        this.idalumno = idalumno;
    }
    
    /*Update*/
    
    public boolean ActualizarRegistroController(){
        return mdlnotas.ActualizarRegistroNotas(ID, idperfil, idalumno, con);
    }
    
    /*update builder*/

    public CNotas(int ID, int idperfil, int idalumno) {
        this.ID = ID;
        this.idperfil = idperfil;
        this.idalumno = idalumno;
    }
    
    /*data deletion*/
    
    public boolean EliminarRegistroController(){
        return mdlnotas.EliminarEstudianteModel(ID, con);
    }
    
    /*delete constructor*/

    public CNotas(int ID) {
        this.ID = ID;
    }
    
}
