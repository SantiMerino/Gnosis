/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MLogin;

/**
 *
 * @author santi
 */
public class CLogin {
    public static String usuario;
    public String password;
    public int niveluser;
    

    public int getNiveluser() {
        return niveluser;
    }

    public void setNiveluser(int niveluser) {
        this.niveluser = niveluser;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        CLogin.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CLogin() {
    }

    public CLogin(String password) {
        this.password = password;
    }
       
    
    public int ValidarLogin(){
        return MLogin.InciarSesion(usuario, password, niveluser);
    }
}
