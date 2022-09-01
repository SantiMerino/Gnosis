/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customizeObjects;

import customizeObjects.ButtonRound;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author santi
 */
public class Cell extends ButtonRound {

    private Date date;
    private boolean title;
    private boolean isToDay;

    public Cell() {
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
    }

    public void asTitle() {
        title = true;
    }

    public boolean isTitle() {
        return title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void currentMonth(boolean act) {
        if (act) {
            setForeground(new Color(255, 255, 255));
        } else {
            setForeground(new Color(180, 180, 180));
        }
    }

    public void setAsToDay() {
        setStyle(ButtonStyle.ROJO);
        setFont(new Font("Poppins",Font.BOLD, 12));
    }
}
