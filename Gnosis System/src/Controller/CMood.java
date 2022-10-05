/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MEvento;
import Model.MMood;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Controller of of Methods insertion and reading data on Mood. This class contains everything from the resource Mood.
 * 
 * @author PC
 */
public class CMood {
    protected int ID;
    private String enfoque;
    private String Tiempo;
    private int idmateria;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEnfoque() {
        return enfoque;
    }

    public void setEnfoque(String enfoque) {
        this.enfoque = enfoque;
    }

    public String getTiempo() {
        return Tiempo;
    }

    public void setTiempo(String Tiempo) {
        this.Tiempo = Tiempo;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }
    
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    private MMood mdlMood = new MMood();
    
    public boolean RegistrarMood(String tiempo, int enfoque, int idmateria){
        return mdlMood.RegistrarEventoModel(tiempo, enfoque, idmateria, con);
    }

    public CMood(String enfoque, String Tiempo, int idmateria) {
        this.enfoque = enfoque;
        this.Tiempo = Tiempo;
        this.idmateria = idmateria;
    }

    public ResultSet CcargarMaterias(){
        return mdlMood.MCargarMaterias(con);
    }
    
    public ResultSet CargarUltimaEstadistica(int idalumno){
        return mdlMood.UltimaEstadistica(idalumno, con);
    }
    
    public CMood(){
    }
    
}
