/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLayeredPane;

public class PanelRedondeado extends JLayeredPane{
    private Color color1 = new Color(255,255,255);
private Color color2 = new Color(255,255,255);
private int arcw=25;
private int arch=25;

@Override
protected void paintComponent(Graphics g)
{
Graphics2D g2 = (Graphics2D) g.create();
float x=getWidth();
float y=getHeight();
g2.setPaint(new GradientPaint(0, 0, getColor1().brighter(),
0.0f, getHeight(), getColor2().brighter()));
g2.fill(new RoundRectangle2D.Double(0, 0, x, y, getArcw(),getArch()));
g2.setPaint(new GradientPaint(0, 0,getColor2(),
getWidth(), getHeight(),getColor1()));
g2.drawRoundRect(0, 0, getWidth() , getHeight(), getArcw()+2,getArch()+2);
g2.setPaint(Color.white);
}

public int getArch() {
return arch;
}

public void setArch(int arch) {
this.arch = arch;
}

public int getArcw() {
return arcw;
}

public void setArcw(int arcw) {
this.arcw = arcw;
}

//Métodos set y get que nos permiten modificar los colores

public Color getColor1() {return color1;}

public void setColor1(Color color1) {this.color1 = color1;}

public Color getColor2() {return color2;}

public void setColor2(Color color2){this.color2 = color2;}

}

