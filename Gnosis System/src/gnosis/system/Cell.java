/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gnosis.system;
import customizeObjects.ButtonRound;
import java.awt.Color;

import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author santi
 */
public class Cell extends ButtonRound{

    private Date date;
    private boolean title;
    
    public Cell(){
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
    }
     
    public void asTitle(){
        title = true;
    }
    public boolean isTitle(){
        return title;
    }
    public void setDate(Date date){
        this.date = date;
    }
    
    public void currentMonth(boolean act){
        if (act) {
            setForeground(new Color(32,32,32));
        }else{
            setForeground(new Color(180,180,180));
        }
    }
    
}
