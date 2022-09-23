/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MCalendar;
import Model.MConnection;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * This class contains everything from the resource library
 * @author devro
 */
public class CCalendar {
    
    private MCalendar mdlAsp = new MCalendar();
    private Connection con = MConnection.getConnectionWithoutParameters();

 
    public ResultSet CargarTipoEventoResultSet(){
        return mdlAsp.CargarComboTipoEvento(con);
    }
    
    public ResultSet CargarGradoResultSet(){
        return mdlAsp.CargarComboGrado(con);
    }
    
    public ResultSet CargarSeccionResultSet(){
        return mdlAsp.CargarComboSeccion(con);
    }
    
    
    
    public int ID;
    public String NombreEvento;
    public String FechaEvento;
    public String HoraInicioEvento;
    public String FechaFinalEvento;
    public String HoraFinalizarEvento;
    public int idtipoevento;
    public int idgrado;
    public int idseccion;

    public MCalendar getMdlAsp() {
        return mdlAsp;
    }

    public void setMdlAsp(MCalendar mdlAsp) {
        this.mdlAsp = mdlAsp;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreEvento() {
        return NombreEvento;
    }

    public void setNombreEvento(String NombreEvento) {
        this.NombreEvento = NombreEvento;
    }

    public String getFechaEvento() {
        return FechaEvento;
    }

    public void setFechaEvento(String FechaEvento) {
        this.FechaEvento = FechaEvento;
    }

    public String getHoraInicioEvento() {
        return HoraInicioEvento;
    }

    public void setHoraInicioEvento(String HoraInicioEvento) {
        this.HoraInicioEvento = HoraInicioEvento;
    }

    public String getFechaFinalEvento() {
        return FechaFinalEvento;
    }

    public void setFechaFinalEvento(String FechaFinalEvento) {
        this.FechaFinalEvento = FechaFinalEvento;
    }

    public String getHoraFinalizarEvento() {
        return HoraFinalizarEvento;
    }

    public void setHoraFinalizarEvento(String HoraFinalizarEvento) {
        this.HoraFinalizarEvento = HoraFinalizarEvento;
    }

    public int getIdtipoevento() {
        return idtipoevento;
    }

    public void setIdtipoevento(int idtipoevento) {
        this.idtipoevento = idtipoevento;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public int getIdseccion() {
        return idseccion;
    }

    public void setIdseccion(int idseccion) {
        this.idseccion = idseccion;
    }

    /**
     * Controlador para la inserción de datos.
     * @param nombreevento
     * @param fechaevento
     * @param horainicioevento
     * @param fechafinalevento
     * @param horafinalizarevento
     * @param idtipoevento
     * @param idgrado
     * @param idseccion 
     */
    public CCalendar(String nombreevento, String fechaevento, String horainicioevento, String fechafinalevento, String horafinalizarevento, int idtipoevento, int idgrado, int idseccion) {
        this.NombreEvento = nombreevento;
        this.FechaEvento = fechaevento;
        this.HoraInicioEvento = horainicioevento;
        this.FechaFinalEvento = fechafinalevento;
        this.HoraFinalizarEvento = horafinalizarevento;
        this.idtipoevento = idtipoevento;
        this.idgrado = idgrado;
        this.idseccion = idseccion;
    }
    
    /**
     * Controlador para la actualizacion de datos.
     * @param idevento
     * @param nombreevento
     * @param fechaevento
     * @param horainicioevento
     * @param fechafinalevento
     * @param horafinalizarevento
     * @param idtipoevento
     * @param idgrado
     * @param idseccion 
     */
    public CCalendar(int idevento, String nombreevento, String fechaevento, String horainicioevento, String fechafinalevento, String horafinalizarevento, int idtipoevento, int idgrado, int idseccion) {
        this.ID = ID;
        this.NombreEvento = nombreevento;
        this.FechaEvento = fechaevento;
        this.HoraInicioEvento = horainicioevento;
        this.FechaFinalEvento = fechafinalevento;
        this.HoraFinalizarEvento = horafinalizarevento;
        this.idtipoevento = idtipoevento;
        this.idgrado = idgrado;
        this.idseccion = idseccion;
    }
    
    /**
     * Controller for data deletion.
     * @param ID 
     */
    public CCalendar(int ID) {
        this.ID = ID;
    }
    
    /**
     * Calendar Controller.
     */
    public CCalendar() {
    }
    
    /**
     * Calendar controller for data insertion.
     * @return 
     */
    public boolean EventoNuevoControladorResultset(){
        return mdlAsp.RegistrarEvento(NombreEvento, FechaEvento, HoraInicioEvento, FechaFinalEvento, HoraFinalizarEvento, idtipoevento, idgrado, idseccion);
    }
    
    /**
     * Calendar controller for updating an event.
     * @return 
     */
    public boolean ActualizarEvento() {
        return mdlAsp.ActualizarEventoModelo(ID, NombreEvento, FechaEvento, HoraInicioEvento, FechaFinalEvento, HoraFinalizarEvento, idtipoevento, idgrado, idseccion, con);
    }
    
    /**
     * Calendar controller for the elimination of an event.
     * @return 
     */
    public boolean EliminarEventoController(){
        return mdlAsp.EliminarEventoModelo(ID, con);
    }
    
    public ResultSet CargarCalendarioResultSet() {
        return mdlAsp.CargarTablaCalendario();
    }
}
