/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MTasks;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *Controller to create, delete, modify and read data methods of takss
 * @author santi
 */
public class CTasks {

    protected int ID;
    private String nombretarea;
    private String fechadeinicio;
    private String fechavencimiento;
    private int idperfil;
    private String rubrica;
    private int idtipotarea;

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
    
     public ResultSet Search(String letra){
        return mdlTask.Search(letra, con);
    }
    
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
    
    public boolean ActualizarTareaController(){
        return mdlTask.ActualizarTareasModel(ID, nombretarea, fechadeinicio, fechavencimiento, idperfil, rubrica, idtipotarea, con);
    }
    
    public boolean EliminarTareaController() {
        return mdlTask.EliminarTareaModel(ID, con);
    }
    
    public ResultSet CargarTareasPreview(){
        return mdlTask.CargarTareasPrev();
    }
    
    public ResultSet CargarTareasPreviewDocente(int id){
        return mdlTask.CargarTareasPrevDocente(id);
    }
    
    public ResultSet CargarTareasFull(int id){
        return mdlTask.CargarTareasFull(id);
    }
    
    public ResultSet CargarTareasTablaCalificar(int iddocente, int idtarea){
        return mdlTask.BuscarTareasEstudiantes(iddocente,idtarea, con);
    }
    
    
    //Controlador para subir la tarea - Estudiante
    
    public boolean UploadTaskStudents(int idtarea, int idalumno ,String pdf, String link){
        return mdlTask.UploadTaskStudent(link, pdf, idalumno, idtarea, con);
    }
    
    public ResultSet CargarTareasFiltro(String tipoperfil, int iddocente){
        return mdlTask.BuscarTipoPerfil(tipoperfil, iddocente,con);
    } 
    
    
    public ResultSet CargarTareasFiltroEstado(String tipoperfil, int iddocente){
        return mdlTask.Estado(tipoperfil, iddocente,con);
    }
    
}
