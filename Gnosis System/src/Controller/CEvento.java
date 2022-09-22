/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MEvento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author josec
 */
public class CEvento {
    
    protected int ID;
    private String nombreevento;
    private String fechaevento;
    private String horainicioevento;
    private String fechafinalevento;
    private String horafinalizarevento;
    private int idtipoevento;
    private int idgrado;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreevento() {
        return nombreevento;
    }

    public void setNombreevento(String nombreevento) {
        this.nombreevento = nombreevento;
    }

    public String getFechaevento() {
        return fechaevento;
    }

    public void setFechaevento(String fechaevento) {
        this.fechaevento = fechaevento;
    }

    public String getHorainicioevento() {
        return horainicioevento;
    }

    public void setHorainicioevento(String horainicioevento) {
        this.horainicioevento = horainicioevento;
    }

    public String getFechafinalevento() {
        return fechafinalevento;
    }

    public void setFechafinalevento(String fechafinalevento) {
        this.fechafinalevento = fechafinalevento;
    }

    public String getHorafinalizarevento() {
        return horafinalizarevento;
    }

    public void setHorafinalizarevento(String horafinalizarevento) {
        this.horafinalizarevento = horafinalizarevento;
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

    /**
     * Controlador para la inserción de datos.
     * @param nombreevento
     * @param fechaevento
     * @param horainicioevento
     * @param fechafinalevento
     * @param horafinalizarevento
     * @param idtipoevento
     * @param idgrado 
     */
    public CEvento(String nombreevento, String fechaevento, String horainicioevento, String fechafinalevento, String horafinalizarevento, int idtipoevento, int idgrado) {
        this.nombreevento = nombreevento;
        this.fechaevento = fechaevento;
        this.horainicioevento = horainicioevento;
        this.fechafinalevento = fechafinalevento;
        this.horafinalizarevento = horafinalizarevento;
        this.idtipoevento = idtipoevento;
        this.idgrado = idgrado;
    }

    /**
     * Controlador para la actualización de datos.
     * @param ID
     * @param nombreevento
     * @param fechaevento
     * @param horainicioevento
     * @param fechafinalevento
     * @param horafinalizarevento
     * @param idtipoevento
     * @param idgrado 
     */
    public CEvento(int ID, String nombreevento, String fechaevento, String horainicioevento, String fechafinalevento, String horafinalizarevento, int idtipoevento, int idgrado) {
        this.ID = ID;
        this.nombreevento = nombreevento;
        this.fechaevento = fechaevento;
        this.horainicioevento = horainicioevento;
        this.fechafinalevento = fechafinalevento;
        this.horafinalizarevento = horafinalizarevento;
        this.idtipoevento = idtipoevento;
        this.idgrado = idgrado;
    }

    /**
     * Controlador para la eliminación de datos.
     * @param ID 
     */
    public CEvento(int ID) {
        this.ID = ID;
    }

    /**
     * Controlador Evento
     */
    public CEvento() {
    }
      
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    private MEvento mdlEvento = new MEvento();
    
    /**
     * Controlador Evento para la busqueda de eventos.
     * @param letra
     * @return 
     */
    public ResultSet Search(String letra) {
        return mdlEvento.Search(letra, con);
    }
    
    public ResultSet CargarTipoEventoResultSet() {
        return mdlEvento.CargarCmbTipoEvento(con);
    }
    
    public ResultSet CargarGradoResultSet(){
        return mdlEvento.CargaCmbGradoPerfil();
    }
    
    public ResultSet CargarEventos(){
        return mdlEvento.CargaCalendario();
    }
    
    /**
     * Controlador Evento para registrar un evento nuevo.
     * @return 
     */
    public boolean EventoNuevoResultSet(){
        return mdlEvento.RegistrarEventoModel(nombreevento, fechaevento, horainicioevento, fechafinalevento, horafinalizarevento, idtipoevento, idgrado, con);
    }
    
    /**
     * Controlador Evento para la actualización de un evento.
     * @return 
     */
    public boolean ActualizarEventoResultSet(){
        return mdlEvento.ActualizarEventoModel(ID, nombreevento, fechaevento, horainicioevento, fechafinalevento, horafinalizarevento, idtipoevento, idgrado, con);
    }
    
    /**
     * Controlador Evento para la eliminación de un evento.
     * @return 
     */
    public boolean EliminarEventoResultSet(){
        return mdlEvento.EliminarEventoModel(ID, con);
    }
    
    
    public ResultSet ConsultarEvento(String fechain, String fechafin){
        return mdlEvento.ConsultarEventosSeleccionadas(fechain, fechafin);
    }
    
    /**
     * Metodo para buscar rangos de fechas
     * @param Fecha1
     * @param Fecha2
     * @return 
     */  
    public ResultSet ConsultarEventoRango(String Fecha1, String Fecha2){
        return  mdlEvento.BuscarFechasRango(Fecha1, Fecha2);
    }
    
    /**
     * Metodo para buscar una fecha en un solo rango.
     * @param Fecha1
     * @return 
     */
    public ResultSet ConsultarFechaUnSoloRango(String Fecha1){
        return  mdlEvento.BuscarFechasUnRango(Fecha1);
    }
    
}
