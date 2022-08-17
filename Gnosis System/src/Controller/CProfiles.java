/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MConnection;
import Model.MProfiles;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author santi
 */
public class CProfiles {
    MProfiles mdlPerfil = new MProfiles();
    private Connection con = MConnection.getConnectionWithoutParameters();
    
    public ResultSet CargarTipoPerfilResultSet() {
        return mdlPerfil.CargaCmbTipoPerfil();
    }
    
    public ResultSet CargarGradoPerfilResultSet() {
        return mdlPerfil.CargaCmbGradoPerfil();
    }
    
    public ResultSet CargarSeccionesPefilResultSet() {
        return mdlPerfil.CargaCmbSeccionesPerfil();
    }
    
    public ResultSet CargarPerfilResultSet() {
        return mdlPerfil.mostrarPerfiles(con);
    }
}
