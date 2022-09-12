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
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import customizeObjects.ButtonRound;
import customizeObjects.PanelRound;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

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
    
        public void changeIconlbl (JLabel lbl, String resimg){
        ImageIcon aimg = new ImageIcon(getClass().getResource(resimg));
        lbl.setIcon(aimg);
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
    public void CrearTarea(String nombre_tarea, String nombre_materia, String nombre_docente,String fecha_i ,String fecha_v, String estado, JPanel container, String materiamoduloColor){
            //Crear labels   
        JLabel nTarea = new JLabel();
        JLabel nMateria = new JLabel();
        JLabel nDocente = new JLabel();
        JLabel nFechaV = new JLabel();
        //No se usa jeje
        JLabel nFechaI = new JLabel();
        
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
        nFechaV.setText("Fecha: "+fecha_v);
        nFechaI.setText(fecha_i);
        
        //Asignar tipo de letra a cada label
        nTarea.setFont(new Font("Poppins", Font.BOLD,24));
        nMateria.setFont(new Font("Poppins", Font.PLAIN, 12));
        nDocente.setFont(new Font("Poppins", Font.PLAIN, 12));
        nFechaV.setFont(new Font("Poppins", Font.PLAIN, 12));
        nFechaI.setFont(new Font("Poppins", Font.PLAIN, 12));
        
        
        //Se agregan los dos paneles principales al que va a contener todos o el panel contenedor en si
        pan1.setLayout(new BorderLayout(10, 0));
        Dimension dimPan1 = new Dimension(1000,90);
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
        nTarea.setVerticalAlignment(JLabel.BOTTOM);
        nTarea.setPreferredSize(new Dimension(100, 40));
        nTarea.setHorizontalAlignment(JLabel.LEFT);
        
        pan4.add(BorderLayout.WEST , nMateria);
        nMateria.setPreferredSize(new Dimension(150, 40));
        nMateria.setHorizontalAlignment(JLabel.LEFT);      
        
        pan4.add(BorderLayout.EAST , nFechaV);
        nFechaV.setHorizontalAlignment(JLabel.LEFT);
        nFechaV.setPreferredSize(new Dimension(200, 40));
        
        pan4.add(BorderLayout.CENTER , nDocente);
        nDocente.setPreferredSize(new Dimension(150, 40));
        nDocente.setHorizontalAlignment(JLabel.LEFT);
        //Agrego el panel 5 al 2 en la posición derecha
        pan2.add(BorderLayout.EAST,pan5);
        
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
//        btnCarpeta.setStyle(ButtonRound.ButtonStyle.VERDE);

        
        //Me paso al panel 3 y solo le agrego el boton del estado de la tarea que incluso lo puedo cambiar por un label 
        pan3.add(BorderLayout.CENTER, btnEstado);
        btnEstado.setStyle(ButtonRound.ButtonStyle.GRIS_CLARO);
        btnEstado.setSize(80,80);
        changeIcon(btnEstado, "/resources/check.png");
        
        Color mainColor;
        Color secondColor;
        Color fontColor;
        
        switch (materiamoduloColor) {
            case "Sociales":
                mainColor = new Color(98, 148, 244);
                secondColor = new Color(149, 184, 252);
                fontColor = new Color(32,32,32);
                btnCarpeta.setStyle(ButtonRound.ButtonStyle.SOCIALES);
                changeIcon(btnCarpeta, "/resources/folder-open-white.png");
                
                break;
            case "Matemáticas":
                mainColor = new Color(255, 153, 0);
                secondColor = new Color(255, 182, 73);
                fontColor = new Color(32,32,32);
                btnCarpeta.setStyle(ButtonRound.ButtonStyle.MATE);
                changeIcon(btnCarpeta, "/resources/folder-open-white.png");
                break;
            case "Ingles":
                mainColor = new Color(255, 189, 62);
                secondColor = new Color(255, 198, 87);
                fontColor = new Color(32,32,32);
                btnCarpeta.setStyle(ButtonRound.ButtonStyle.AMARILLO);
                changeIcon(btnCarpeta, "/resources/folder-open-white.png");
            case "Ciencias":
                mainColor = new Color(127, 211, 106);
                secondColor = new Color(152, 215, 136);
                fontColor = new Color(32,32,32);
                btnCarpeta.setStyle(ButtonRound.ButtonStyle.VERDE);
                changeIcon(btnCarpeta, "/resources/folder-open-white.png");
                break;
            case "Lenguaje":
                mainColor = new Color(227, 63, 63);
                secondColor = new Color(231, 87, 87);
                fontColor = new Color(255,255,255);
                btnCarpeta.setStyle(ButtonRound.ButtonStyle.VERDE);
                changeIcon(btnCarpeta, "/resources/folder-open-white.png");
                break;
            default:
                mainColor = new Color(32,32,32);
                secondColor = new Color(90,90,90);
                fontColor = new Color(255,255,255);
                btnCarpeta.setStyle(ButtonRound.ButtonStyle.NEGRO);
                changeIcon(btnCarpeta, "/resources/folder-open.png");
                break;
        }
        
        //Asignar colores provisionalmente para ver como se comportan
        pan1.setBackground(Color.white); 
        pan2.setBackground(mainColor); 
        pan3.setBackground(new Color(216,216,216));
        pan4.setBackground(mainColor);
        pan5.setBackground(mainColor);
        btnCarpeta.setRound(20);
        
                //Asignar color de letra a cada label
        nTarea.setForeground(fontColor);
        nMateria.setForeground(fontColor);
        nDocente.setForeground(fontColor);
        nFechaV.setForeground(fontColor);
        nFechaI.setForeground(fontColor);
        
        p1BottomGap.setBackground(Color.white); 
        p1TopGap.setBackground(Color.white); 
        leftGap.setBackground(mainColor); 
        
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
    
    
    
    public void CrearRecursoBiblioteca( String nombre_recurso, String tipo_recurso, String categoria_recurso,JPanel mainContainer) {
        // Crear paneles
        PanelRound resourcesContainer = new PanelRound();
        PanelRound topGap = new PanelRound();
        PanelRound bottomGap = new PanelRound();
        PanelRound leftGap = new PanelRound();
        PanelRound rightGap = new PanelRound();
        PanelRound centerPanel = new PanelRound();
        // Tres paneles centrales
        PanelRound typePanel = new PanelRound();
        PanelRound nameResourcePanel = new PanelRound();
        PanelRound openPanel = new PanelRound();
        
        // Crear labels
        JLabel lblNombreRecurso = new JLabel();
        JLabel lblCategroiaRecurso = new JLabel();
        
        
        // Crear botón
        ButtonRound btnOpen = new ButtonRound();
        ButtonRound btnTipoDoc = new ButtonRound();
        
        
        // Dimensionar los paneles principales
        resourcesContainer.setPreferredSize(new Dimension(200,300));
        resourcesContainer.setLayout(new BorderLayout(0,0));
        
        topGap.setPreferredSize(new Dimension(100,15));
        leftGap.setPreferredSize(new Dimension(10,100));
        bottomGap.setPreferredSize(new Dimension(100,15));
        rightGap.setPreferredSize(new Dimension(10,100));
        centerPanel.setPreferredSize(new Dimension(100,100));
        
//        Dimensionar los paneles de contención
        typePanel.setPreferredSize(new Dimension(180, 40));
        nameResourcePanel.setPreferredSize(new Dimension(100,100));
        openPanel.setPreferredSize(new Dimension(180, 50));
        
        //Agregar los paneles al panel principal
        resourcesContainer.add(BorderLayout.NORTH, topGap);
        resourcesContainer.add(BorderLayout.SOUTH, bottomGap);
        resourcesContainer.add(BorderLayout.WEST, leftGap);
        resourcesContainer.add(BorderLayout.EAST, rightGap);
        resourcesContainer.add(BorderLayout.CENTER, centerPanel);
        
        //Agregar los paneles al
        centerPanel.setLayout(new BorderLayout(10, 10));
        centerPanel.add(BorderLayout.NORTH, typePanel);
        centerPanel.add(BorderLayout.SOUTH, openPanel);
        centerPanel.add(BorderLayout.CENTER, nameResourcePanel);
        
        //Agregar el layout a los paneles y los elementos
        typePanel.setLayout(new BorderLayout(0, 0));
        typePanel.add(BorderLayout.WEST, lblCategroiaRecurso);
        lblCategroiaRecurso.setPreferredSize(new Dimension(110,30));
        typePanel.add(BorderLayout.CENTER, btnTipoDoc);
        
        nameResourcePanel.setLayout(new BorderLayout(0,0));
        nameResourcePanel.add(BorderLayout.CENTER, lblNombreRecurso);
        //Crear dos labels vacías para no dejar qu el nombre toque los bordes del panel
        JLabel leftlbl = new JLabel();
        JLabel rightlbl = new JLabel();
        leftlbl.setPreferredSize(new Dimension(10,100));
        rightlbl.setPreferredSize(new Dimension(10,100));
        nameResourcePanel.add(BorderLayout.WEST, leftlbl);
        nameResourcePanel.add(BorderLayout.EAST, rightlbl);     
        openPanel.setLayout(new BorderLayout(0,0));
        openPanel.add(BorderLayout.CENTER, btnOpen);
        
        //Definir los colores, estilo y texto
        btnOpen.setStyle(ButtonRound.ButtonStyle.ROJO);
        btnOpen.setText("Abrir");
        
        btnTipoDoc.setStyle(ButtonRound.ButtonStyle.ROJO);
        changeIcon(btnTipoDoc, "/resources/folder.png");
        btnTipoDoc.setText(tipo_recurso);
        
        lblCategroiaRecurso.setText("   "+categoria_recurso);
        
        lblNombreRecurso.setText("<html><center>"+nombre_recurso+"</center></html>");
        
        //Redondear Bordes y establecer el color
        resourcesContainer.setBackground(new Color(255,255,255));
        resourcesContainer.setRoundBottomLeft(20);
        resourcesContainer.setRoundBottomRight(20);
        resourcesContainer.setRoundTopLeft(20);
        resourcesContainer.setRoundTopRight(20);
                
        topGap.setBackground(new Color(32,32,32));
        topGap.setRoundTopLeft(20);
        topGap.setRoundTopRight(20);
        
        bottomGap.setBackground(new Color(32,32,32));
        bottomGap.setRoundBottomRight(20);
        bottomGap.setRoundBottomLeft(20);
        
        leftGap.setBackground(new Color(32,32,32));
        rightGap.setBackground(new Color(32,32,32));
        
        centerPanel.setBackground(new Color(32,32,32));
        
        typePanel.setBackground(new Color(100, 100, 100));
        typePanel.setRoundBottomLeft(25);
        typePanel.setRoundBottomRight(25);
        typePanel.setRoundTopLeft(25);
        typePanel.setRoundTopRight(25);
        
        nameResourcePanel.setBackground(new Color(100, 100, 100));
        nameResourcePanel.setRoundBottomLeft(20);
        nameResourcePanel.setRoundBottomRight(20);
        nameResourcePanel.setRoundTopLeft(20);
        nameResourcePanel.setRoundTopRight(20);
        
        openPanel.setBackground(new Color(100, 100, 100));
        openPanel.setRoundBottomLeft(20);
        openPanel.setRoundBottomRight(20);
        openPanel.setRoundTopLeft(20);
        openPanel.setRoundTopRight(20);
        
        //Establece tipo de letra en los elementos
        lblCategroiaRecurso.setFont(new Font("Poppins Medium", Font.PLAIN, 12)); 
        lblNombreRecurso.setFont(new Font("Poppins", Font.BOLD, 15));
        lblNombreRecurso.setHorizontalAlignment(JLabel.CENTER);
        btnOpen.setFont(new Font("Poppins", Font.BOLD, 12));
        btnTipoDoc.setFont(new Font("Poppins", Font.BOLD, 12));
        
        //Establecer los colores de los labels
        lblCategroiaRecurso.setForeground(Color.white);
        lblNombreRecurso.setForeground(Color.white);
        btnOpen.setForeground(Color.white);
        btnTipoDoc.setForeground(Color.white);
        
        
        //Agregar todo al contenedor principal para hacer que aparezca
        mainContainer.add(resourcesContainer);
        mainContainer.repaint();
        mainContainer.revalidate();     
        
    }
    
    public void CrearPortafolio(String materiamodulo, String Grado, String docente, String contenido, JPanel contenedor ){
        //Crear paneles contenedores
        PanelRound portafolio = new PanelRound();
        PanelRound panelSuperior = new PanelRound();
        PanelRound panelInferior = new PanelRound();
        
        //Crear el botón
        ButtonRound btnAbrir = new ButtonRound();
        
        //Crear labels
        JLabel lblmateria = new JLabel();
        JLabel lbldocente = new JLabel();
        JLabel lblnumpag = new JLabel();
        JLabel lblgrado = new JLabel();
       
        
        //Definir tipo de letra
        lblmateria.setFont(new Font("Poppins Black", Font.PLAIN, 20));
        lbldocente.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblnumpag.setFont(new Font("Poppins", Font.BOLD, 14));
        lblgrado.setFont(new Font("Poppins", Font.BOLD, 18));
        btnAbrir.setFont(new Font("Poppins", Font.BOLD, 14));
        
        lblmateria.setHorizontalAlignment(JLabel.CENTER);
        lbldocente.setHorizontalAlignment(JLabel.CENTER);
        lblgrado.setHorizontalAlignment(JLabel.CENTER);
        lblnumpag.setHorizontalAlignment(JLabel.CENTER);
        
        lblmateria.setVerticalAlignment(JLabel.CENTER);
        lbldocente.setVerticalAlignment(JLabel.TOP);
        lblgrado.setVerticalAlignment(JLabel.TOP);
        lblnumpag.setVerticalAlignment(JLabel.CENTER);

        
        Color mainColor;
        Color secondColor;
        Color fontColor;
        
        switch (materiamodulo) {
            case "Sociales":
                mainColor = new Color(98, 148, 244);
                secondColor = new Color(149, 184, 252);
                fontColor = new Color(32,32,32);
                btnAbrir.setStyle(ButtonRound.ButtonStyle.NEGRO);
         
                
                break;
            case "Matemáticas":
                mainColor = new Color(255, 153, 0);
                secondColor = new Color(255, 182, 73);
                fontColor = new Color(32,32,32);
                btnAbrir.setStyle(ButtonRound.ButtonStyle.NEGRO);
               
                break;
            case "Ingles":
                mainColor = new Color(255, 189, 62);
                secondColor = new Color(255, 198, 87);
                fontColor = new Color(32,32,32);
                btnAbrir.setStyle(ButtonRound.ButtonStyle.NEGRO);
                
            case "Ciencias":
                mainColor = new Color(127, 211, 106);
                secondColor = new Color(152, 215, 136);
                fontColor = new Color(32,32,32);
                btnAbrir.setStyle(ButtonRound.ButtonStyle.NEGRO);
                
                break;
            case "Lenguaje":
                mainColor = new Color(227, 63, 63);
                secondColor = new Color(231, 87, 87);
                fontColor = new Color(255,255,255);
                btnAbrir.setStyle(ButtonRound.ButtonStyle.NEGRO);
               
                break;
                
            case "Formación Cristiana":
                mainColor = new Color(95,125,85);
                secondColor = new Color(110,125,100);
                fontColor = new Color(255,255,255);
                btnAbrir.setStyle(ButtonRound.ButtonStyle.NEGRO);
              
                break;
            case "Orientación para la vida":
                mainColor = new Color(60,80,120);
                secondColor = new Color(60,100,130);
                fontColor = new Color(255,255,255);
                btnAbrir.setStyle(ButtonRound.ButtonStyle.NEGRO);
              
                break;
            default:
                mainColor = new Color(32,32,32);
                secondColor = new Color(90,90,90);
                fontColor = new Color(255,255,255);
                btnAbrir.setStyle(ButtonRound.ButtonStyle.BLANCO);
                break;
        }    
        
        //Establecer color a la fuente
        lbldocente.setForeground(fontColor);
        lblmateria.setForeground(fontColor);
        lblnumpag.setForeground(fontColor);
        lblgrado.setForeground(fontColor);

        //Establecer color a los paneles
        portafolio.setBackground(mainColor);
        panelSuperior.setBackground(secondColor);
        panelInferior.setBackground(secondColor);
        
        
        //Establecer las dimensiones de todos los componentes y sus layouts.
        portafolio.setPreferredSize(new Dimension(250,350));
        LayoutManager layoutmain = new FlowLayout(FlowLayout.CENTER, 10, 15);
        portafolio.setRoundBottomLeft(25);
        portafolio.setRoundBottomRight(25);
        portafolio.setRoundTopLeft(25);
        portafolio.setRoundTopRight(25);
        
        
        panelSuperior.setPreferredSize(new Dimension(220, 200));
        panelSuperior.setRoundBottomLeft(25);
        panelSuperior.setRoundBottomRight(25);
        panelSuperior.setRoundTopLeft(25);
        panelSuperior.setRoundTopRight(25);
        
        panelInferior.setPreferredSize(new Dimension(220, 50));
        panelInferior.setRoundBottomLeft(25);
        panelInferior.setRoundBottomRight(25);
        panelInferior.setRoundTopLeft(25);
        panelInferior.setRoundTopRight(25);
              
        //Establecer el texto a los labels
        lbldocente.setText("<html><center>" + docente + "</center></html>" );
        lblmateria.setText("<html><center>" +materiamodulo+ "</center></html>" );
        lblnumpag.setText(contenido);
        
        lblgrado.setText("<html><center>" +Grado+ "</center></html>" );
        btnAbrir.setText("Abrir");
        
        
        //Agregar todos los componentes al panel principal
        portafolio.setLayout(layoutmain);
        portafolio.add(panelSuperior);
        portafolio.add(panelInferior);
        portafolio.add(btnAbrir);
        btnAbrir.setPreferredSize(new Dimension(220, 40));
        
        panelSuperior.add(BorderLayout.NORTH, lblmateria);
        lblmateria.setPreferredSize(new Dimension(220, 80));
        panelSuperior.add(BorderLayout.CENTER, lblgrado);
        lblgrado.setPreferredSize(new Dimension(220, 60));
        panelSuperior.add(BorderLayout.SOUTH, lbldocente);
        lbldocente.setPreferredSize(new Dimension(220, 60));
        
        panelInferior.add(BorderLayout.CENTER, lblnumpag);
        lblnumpag.setPreferredSize(new Dimension(220, 40));
       
        //Agregar actionListener
        btnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new frmDashboard(materiamodulo).setVisible(true);
                JFrame dashboardopen = (JFrame) SwingUtilities.getWindowAncestor(contenedor);
        dashboardopen.dispose();
            }
        });
        
        contenedor.add(portafolio);
        contenedor.repaint();
        contenedor.revalidate(); 
    }
    
        public void CrearComponenteEventos(String nombreevento , String tipoevento,String fechainicio, String fechafinal, JPanel main){
            //Crear panel
            PanelRound evento = new PanelRound();
            //Crear labels

            evento.setBackground(new Color(127, 211, 106));
            evento.setPreferredSize(new Dimension(100, 50));
            evento.setRoundTopLeft(20);
            evento.setRoundTopRight(20);
            evento.setRoundBottomRight(20);
            evento.setRoundBottomLeft(20);

            //Agregar recurso al panel contendedor
            main.add(evento);
            main.repaint();
            main.revalidate();
    }
}
