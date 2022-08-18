/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MTasks;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author santi
 */
public class CTasks {

    public int ID;
    public String nombretarea;
    public String fechadeinicio;
    public String fechavencimiento;
    public int idperfil;
    public String rubrica;
    public int idtipotarea;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombretarea() {
        return nombretarea;
    }

    public void setNombretarea(String nombretarea) {
        this.nombretarea = nombretarea;
    }

    public String getFechadeinicio() {
        return fechadeinicio;
    }

    public void setFechadeinicio(String fechadeinicio) {
        this.fechadeinicio = fechadeinicio;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public String getRubrica() {
        return rubrica;
    }

    public void setRubrica(String rubrica) {
        this.rubrica = rubrica;
    }

    public int getIdtipotarea() {
        return idtipotarea;
    }

    public void setIdtipotarea(int idtipotarea) {
        this.idtipotarea = idtipotarea;
    }

    public CTasks(String nombretarea, String fechadeinicio, String fechavencimiento, int idperfil, String rubrica, int idtipotarea) {
        this.nombretarea = nombretarea;
        this.fechadeinicio = fechadeinicio;
        this.fechavencimiento = fechavencimiento;
        this.idperfil = idperfil;
        this.rubrica = rubrica;
        this.idtipotarea = idtipotarea;
    }

    public CTasks(int ID, String nombretarea, String fechadeinicio, String fechavencimiento, int idperfil, String rubrica, int idtipotarea) {
        this.ID = ID;
        this.nombretarea = nombretarea;
        this.fechadeinicio = fechadeinicio;
        this.fechavencimiento = fechavencimiento;
        this.idperfil = idperfil;
        this.rubrica = rubrica;
        this.idtipotarea = idtipotarea;
    }

    public CTasks(int ID) {
        this.ID = ID;
    }

    public CTasks() {
    }
    
    MTasks mdlTask = new MTasks();
    private Connection con = CConnection.getConnectionControllerWithoutParameters();
    
    public ResultSet CargarTipoPerfilResultSet() {
        return mdlTask.CargaCmbTipoPerfil();
    }
    
    public ResultSet CargarTipoTaraeResultSet() {
        return mdlTask.CargaCmbTipoTarea();
    }
    
    public ResultSet CCargarTareas(){
        return mdlTask.mostrarTareas(con);
    }
    
    public boolean TareaNuevaResultSet(){
        return mdlTask.SubirTareasModel(nombretarea, fechadeinicio, fechavencimiento, idperfil, rubrica, idtipotarea, con);
    }
    
    public boolean ActualizarTarea() {
       return mdlTask.ActualizarTareasModel(ID, nombretarea, nombretarea, fechadeinicio, fechavencimiento, idperfil, rubrica, idtipotarea, con);
    }
    
    public boolean EliminarTareaController() {
        return mdlTask.EliminarTareaModel(ID, con);
    }
}
