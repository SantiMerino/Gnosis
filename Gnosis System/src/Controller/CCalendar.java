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
 *
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

    

    

    public CCalendar() {
    }

    public CCalendar(String NombreEvento, String FechaEvento, String HoraInicioEvento, String FechaFinalEvento, String HoraFinalizarEvento, int idtipoevento, int idgrado, int idseccion) {
        this.NombreEvento = NombreEvento;
        this.FechaEvento = FechaEvento;
        this.HoraInicioEvento = HoraInicioEvento;
        this.FechaFinalEvento = FechaFinalEvento;
        this.HoraFinalizarEvento = HoraFinalizarEvento;
        this.idtipoevento = idtipoevento;
        this.idgrado = idgrado;
        this.idseccion = idseccion;
    }
    
    public CCalendar(int idevento, String NombreEvento, String FechaEvento, String HoraInicioEvento, String FechaFinalEvento, String HoraFinalizarEvento, int idtipoevento, int idgrado, int idseccion) {
        this.ID = ID;
        this.NombreEvento = NombreEvento;
        this.FechaEvento = FechaEvento;
        this.HoraInicioEvento = HoraInicioEvento;
        this.FechaFinalEvento = FechaFinalEvento;
        this.HoraFinalizarEvento = HoraFinalizarEvento;
        this.idtipoevento = idtipoevento;
        this.idgrado = idgrado;
        this.idseccion = idseccion;
    }
       
    public boolean EventoNuevoControladorResultset(){
        return mdlAsp.RegistrarEvento(NombreEvento, FechaEvento, HoraInicioEvento, FechaFinalEvento, HoraFinalizarEvento, idtipoevento, idgrado, idseccion);
    }
    
    public ResultSet CargarCalendarioResultSet() {
        return mdlAsp.CargarTablaCalendario();
    }
    
    public boolean EliminarEventoController(){
        return mdlAsp.EliminarEventoModelo(ID, con);
    }
    
    public boolean ActualizarEvento(){
        return mdlAsp.ActualizarEventoModelo(ID, NombreEvento, FechaEvento, HoraInicioEvento, FechaFinalEvento, HoraFinalizarEvento, idtipoevento, idgrado, idseccion, con);
    }

    public CCalendar(int ID) {
        this.ID = ID;
    }
}
