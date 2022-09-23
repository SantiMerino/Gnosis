/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.MRecuperacionContra;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *Controller to create, delete, modify and read data methods of RecoveryAgainst
 * @author santi
 */
public class CRecuperacionContra {
    MRecuperacionContra MRecu = new MRecuperacionContra();
    
    public String correo;
    public String clave;
    
    public String correoADMIN;
    public String claveADMIN;
    public int pin;
    Connection con = CConnection.getConnectionControllerWithoutParameters();
      
    
    public boolean recu(){
        String clavemd5 = CValidaciones.getMD5(clave);
        return MRecu.RecuperarContraseña(correo, clavemd5, con);
    }
    
    public boolean recuPIN(){
        return MRecu.ConsultarPINporCorreo(correo, pin, con);
    }
    
    public ResultSet recuADMIN(){
        String clavemd5 = CValidaciones.getMD5(claveADMIN);
        return MRecu.ConsultarADMIN(correoADMIN, clavemd5, con);
    }
}
