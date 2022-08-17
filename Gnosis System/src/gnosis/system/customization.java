/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;
import com.formdev.flatlaf.intellijthemes.FlatMonocaiIJTheme;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import roundObjects.ButtonRound;
import roundObjects.PanelRound;

/**
 *
 * @author santi
 */
public class customization {
    
    public static void hoverColorPanel(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    
    public static void hoverColorButton (JButton hover, Color rand){
        hover.setBackground(rand);
    }
    
    public static void clickMenuButtons (ButtonRound h1, int numberbool){
        if (numberbool == 1) {
            h1.setBackground(Color.WHITE);
        } else {
            h1.setBackground( new Color(32,32,32));
        }
    }
    
    public static void centrarFrame(JFrame frame){
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dim = new Dimension(tool.getScreenSize());
        int height = (int) dim.getHeight();
        int width = (int) dim.getWidth();
        frame.setLocation(width/2 - frame.getWidth()/2, height/2 - frame.getHeight()/2);
        frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 20, 20));
    }
    
    public static void setUIFont (javax.swing.plaf.FontUIResource f){
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get (key);
      if (value instanceof javax.swing.plaf.FontUIResource)
        UIManager.put (key, f);
      }
    } 
    
    public static void notificacion(String mensaje,int tipo_mensaje, String tipo_men){
        try{
            // Obtener solamente una instancia del objeto SystemTray
            SystemTray tray=SystemTray.getSystemTray();
            // Si quieres crear un icono en la bandeja del sistemas como vista previa
            Image image = Toolkit.getDefaultToolkit().createImage("some-icon.png");
            TrayIcon trayIcon=new TrayIcon(image,"Java AWT Tray Demo");
            // Deja que el sistema auto escale si es necesario
            trayIcon.setImageAutoSize(true);
            // Definir texto de tooltip(descripción emergente)
            trayIcon.setToolTip("Gnosis System");
            tray.add(trayIcon);
            // Mostrar notificación de información:
            if(tipo_mensaje == 1){
                trayIcon.displayMessage(tipo_men, mensaje,TrayIcon.MessageType.INFO);
            }else if(tipo_mensaje == 2){
                trayIcon.displayMessage(tipo_men,mensaje,TrayIcon.MessageType.WARNING);
            }else{
                trayIcon.displayMessage(tipo_men,mensaje,TrayIcon.MessageType.ERROR);
            }
        }catch(Exception ex){
            System.err.print(ex);
        }
    }
    
    public void changeIcon (ButtonRound button, String resimg){
        ImageIcon aimg = new ImageIcon(getClass().getResource(resimg));
        button.setIcon(aimg);
    }
    
    public static void mainUtilities (){
        try {
            UIManager.setLookAndFeel(new FlatMonocaiIJTheme());           
        } catch (Exception e) {
            e.printStackTrace();
        }
        UIManager.put( "Component.focusWidth", 0 );
        UIManager.put( "Component.innerFocusWidth",0 );
        UIManager.put( "TextComponent.arc", 20);
        UIManager.put( "Component.arc", 20);
        UIManager.put( "ProgressBar.arc", 20);
        UIManager.put( "ScrollBar.trackArc", 999 );
        UIManager.put( "ScrollBar.thumbArc", 999 );
        UIManager.put( "ScrollBar.trackInsets", new Insets( 2, 4, 2, 4 ) );
        UIManager.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
        UIManager.put( "Component.arrowType", "chevron" );
    }
    
    
    
    //Pruba para crear un componente en otro form parte 1 xd
    public void CrearTarea(String nombre_tarea, String nombre_materia, String nombre_docente, String fecha_v, int estado, JPanel container){
    for (int i = 0; i < 5; i++) {
            //Crear labels   
        JLabel nTarea = new JLabel();
        JLabel nMateria = new JLabel();
        JLabel nDocente = new JLabel();
        JLabel nFecha = new JLabel();
        
        //Crear botones redondeados
        ButtonRound btnCarpeta = new ButtonRound();
        ButtonRound btnEstado = new ButtonRound();
        
        //Crear paneles redondeados
        PanelRound pan1 = new PanelRound();//Este panel es el contenedor de TODO
        PanelRound pan2 = new PanelRound(); // Este panel contiene los dos paneles 
        PanelRound pan3 = new PanelRound(); // Este panel solo contiene el boton de el estado de la tarea
        PanelRound pan4 = new PanelRound(); // Este panel contiene todos los labels
        PanelRound pan5 = new PanelRound(); // Este panel contiene el boton de la carpeta 
        
        //panel 4 gaps
        PanelRound leftGap = new PanelRound();
        
        //panel 1 gaps
        PanelRound p1TopGap = new PanelRound();
        PanelRound p1BottomGap = new PanelRound();
        
        //Asignar valores        
        nTarea.setText(nombre_tarea);
        nMateria.setText(nombre_materia);
        nDocente.setText(nombre_docente);
        nFecha.setText(fecha_v);
        
        //Asignar tipo de letra a cada label
        nTarea.setFont(new Font("Poppins", Font.BOLD,25));
        nMateria.setFont(new Font("Poppins", Font.PLAIN, 12));
        nDocente.setFont(new Font("Poppins", Font.PLAIN, 12));
        nFecha.setFont(new Font("Poppins", Font.PLAIN, 12));
        
        //Asignar color de letra a cada label
        nTarea.setForeground(new Color(32,32,32));
        nMateria.setForeground(new Color(32,32,32));
        nDocente.setForeground(new Color(32,32,32));
        nFecha.setForeground(new Color(32,32,32));
        
        //Se agregan los dos paneles principales al que va a contener todos o el panel contenedor en si
        pan1.setLayout(new BorderLayout(10, 0));
        Dimension dimPan1 = new Dimension(1000,80);
        pan1.setPreferredSize(dimPan1);
        pan1.add(BorderLayout.NORTH, p1TopGap );
        pan1.add(BorderLayout.SOUTH, p1BottomGap);
        
        pan1.add(BorderLayout.CENTER, pan2);
        pan1.add(BorderLayout.EAST, pan3);
        
        
        //Asignar dimensiones de los paneles adentro del contenedor
        Dimension dimPan2 = new Dimension(500, 80);
        pan2.setPreferredSize(dimPan2);
        Dimension dimPan3 = new Dimension(90, 80);
        pan3.setPreferredSize(dimPan3);
        pan3.setLayout(new BorderLayout(0, 0));
        
        //Le pongo un layout al panel 2
        pan2.setLayout(new BorderLayout(0, 5));
        
        
        //Agrego el panel 4 al 2 en la posición center
        pan2.add(BorderLayout.CENTER, pan4);
        pan2.add(BorderLayout.WEST, leftGap);
            
        
        //Pongo un layout al panel 4
        pan4.setLayout(new BorderLayout(10, 5));
        //Agrego todos los componentes segun posción
        pan4.add(BorderLayout.NORTH ,nTarea);
        nTarea.setVerticalAlignment(JLabel.CENTER);
        nTarea.setPreferredSize(new Dimension(100, 30));
        nTarea.setHorizontalAlignment(JLabel.LEFT);
        
        pan4.add(BorderLayout.WEST , nMateria);
        nMateria.setPreferredSize(new Dimension(150, 40));
        nMateria.setHorizontalAlignment(JLabel.LEFT);
        
        pan4.add(BorderLayout.EAST , nFecha);
        nFecha.setHorizontalAlignment(JLabel.LEFT);
        nFecha.setPreferredSize(new Dimension(200, 40));
        
        pan4.add(BorderLayout.CENTER , nDocente);
        nDocente.setPreferredSize(new Dimension(150, 40));
        nDocente.setHorizontalAlignment(JLabel.LEFT);
        
        //Agrego el panel 5 al 2 en la posición derecha
        pan2.add(BorderLayout.EAST,pan5);
        //Coloco sus dimensiones
        Dimension dimPan5 = new Dimension(100,90);
        pan5.setPreferredSize(dimPan5);
        pan5.setLayout(new BorderLayout(0, 0));
        //Le agrego el boton para la carpeta de la tarea
        Dimension dimBtnCarpeta = new Dimension(80,80);
        btnCarpeta.setPreferredSize(dimBtnCarpeta);
        pan5.add(BorderLayout.CENTER,btnCarpeta);
        btnCarpeta.setStyle(ButtonRound.ButtonStyle.VERDE);

        changeIcon(btnCarpeta, "/resources/folder-open-white.png");
        
        //Me paso al panel 3 y solo le agrego el boton del estado de la tarea que incluso lo puedo cambiar por un label 
        pan3.add(BorderLayout.CENTER, btnEstado);
        btnEstado.setStyle(ButtonRound.ButtonStyle.GRIS_CLARO);
        btnEstado.setSize(80,80);
        changeIcon(btnEstado, "/resources/check.png");
        
        //Asignar colores provisionalmente para ver como se comportan
        pan1.setBackground(Color.white); 
        pan2.setBackground(new Color(118,220,90)); 
        pan3.setBackground(new Color(216,216,216));
        pan4.setBackground(new Color(118,220,90));
        pan5.setBackground(new Color(118,220,90));
        
        p1BottomGap.setBackground(Color.white); 
        p1TopGap.setBackground(Color.white); 
        leftGap.setBackground(new Color(118,220,90)); 
        
        //Redondeo bordes de los paneles contenedores
        pan1.setRoundBottomLeft(20);
        pan1.setRoundBottomRight(20);
        pan1.setRoundTopLeft(20);
        pan1.setRoundTopRight(20);
        

        
        pan3.setRoundBottomLeft(20);
        pan3.setRoundBottomRight(20);
        pan3.setRoundTopLeft(20);
        pan3.setRoundTopRight(20);
        
        pan4.setRoundBottomLeft(20);
        pan4.setRoundBottomRight(20);
        pan4.setRoundTopLeft(20);
        pan4.setRoundTopRight(20);

        pan5.setRoundBottomLeft(20);
        pan5.setRoundBottomRight(20);
        pan5.setRoundTopLeft(20);
        pan5.setRoundTopRight(20);
        
        leftGap.setRoundTopLeft(20);
        leftGap.setRoundBottomLeft(20);
        
        pan2.setRoundBottomLeft(20);
        pan2.setRoundBottomRight(20);
        pan2.setRoundTopLeft(20);
        pan2.setRoundTopRight(20);
        
        //Tengo que encapsular el panel contenedor en un scroll pane y ver cuantas filas son necesarias para que cada task quede con un alto de 80 px
        
        
        //Agregando todos los elementos al panel que se pasa como paramentro para que aparezca en el jframe
        container.add(pan1);
        container.repaint();
        container.revalidate();
        
        
        //Tengo que hacer un metodo para dependiendo el id del estado se asigne un icono :3
        //Tengo que hacer que dependiendo la materia el color de los paneles vería :P
        }        
    }
    
    
    public void CrearRecursoBiblioteca( String nombre_recurso, String tipo_recurso, String categoria_recurso, JPanel mainContainer ) {
        // Crear paneles
        PanelRound secondContainer = new PanelRound();
        PanelRound thirdContainer = new PanelRound();
        PanelRound fourthContainer = new PanelRound();
        
        // Crear labels
        JLabel lblNombreRecurso = new JLabel();
        JLabel lblTipRecurso = new JLabel();
        JLabel lblCategroiaRecurso = new JLabel();
        
        // Crear botón
        ButtonRound btnOpen = new ButtonRound();
        
//        secondContainer.add(BorderLayout.NORTH, )
    }
}
