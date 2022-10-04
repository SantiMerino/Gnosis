/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.MNotas;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 * Controller of Methods of creating, deleting, modifying and reading data on Grades. This class contains everything from the resource Grades.
 * @author Usuario
 */
public class CNotas {
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    private MNotas mdlnotas = new MNotas();
    
    
    //Potting
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
      
    /**
     * Data insertion controller.
     * 
     * @param idperfil
     * @param idalumno 
     */
    public CNotas(int idperfil, int idalumno) {
        this.idperfil = idperfil;
        this.idalumno = idalumno;
    }

    /**
     * Controller for data update.
     * 
     * @param ID
     * @param idperfil
     * @param idalumno 
     */
    public CNotas(int ID, int idperfil, int idalumno) {
        this.ID = ID;
        this.idperfil = idperfil;
        this.idalumno = idalumno;
    }
  
    /**
     * Controller for data deletion.
     * 
     * @param ID 
     */
    public CNotas(int ID) {
        this.ID = ID;
    }
    
    /**
     * Grades controller for grades insertion.
     * @return 
     */
    public boolean RegistroNuevoController(){
        return mdlnotas.RegistrarRegistroNotas(idperfil, idalumno, con);
    }
     
    /**
     * Grades Controller for updating the Grades resource.
     * @return 
     */
    public boolean ActualizarRegistroController(){
        return mdlnotas.ActualizarRegistroNotas(ID, idperfil, idalumno, con);
    }

    /**
     * Grades Controller for the removal of the grades in the Grades.
     * @return 
     */
    public boolean EliminarRegistroController(){
        return mdlnotas.EliminarEstudianteModel(ID, con);
    }  
}
