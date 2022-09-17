/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MLogin;
import java.sql.ResultSet;

/**
 *
 * @author santi
 */
public class CLogin {

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNiveluser() {
        return niveluser;
    }

    public void setNiveluser(int niveluser) {
        this.niveluser = niveluser;
    }
    private String usuario;
    private String password;
    private int niveluser;

    public CLogin(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
//        this.niveluser = niveluser;
    }

    public CLogin() {
    }
    
    public ResultSet CIniciarSesion(){
        return MLogin.InciarSesion(usuario, password);
    }
        
}
