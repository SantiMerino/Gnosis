/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import Controller.CBiblioteca;
import Controller.CEstudents;
import Controller.CEvento;
import java.awt.*;
import customizeObjects.ButtonRound;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Controller.CMood;
import Controller.CPortfolios;
import Controller.CTasks;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author santi
 */
public class frmDashboard extends javax.swing.JFrame {
    
    //Variables para los modo de concentración
    Timer timerP;
    TimerTask taskP;
    int pomodoros;
    int minutos;
    int segundos;
    int horas;
    private int mood = 0;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM");  
    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd");
    DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now;
    
    //Objeto de la clase customization
    customization custo = new customization();

    //Variables de inicio de sesión de alumno loggeado
    int iduserlog;
    String usernamelog;
    ResultSet datosAlumnoLog;
    String nombreAlumno;
    int nivelusuario;
    String fechahoy;
    
    //id de la tarea
    int tareaidOpen;

    /**
     * Constructor without parameters with the UI initialize 
     */
    public frmDashboard() {
        initComponents();
        now = LocalDateTime.now();
        lblMes.setText(dtf.format(now));
        lblFecha.setText(dtf2.format(now));
        customization.mainUtilities();
        moodPanel.setVisible(false);
        searchbar.putClientProperty("innerFocusWidth", 0);
        searchbar.putClientProperty("focusWidth", 0);
    }
    /**
     * Constructor with the student data from a ResultSet obtained previously in the Login
     * @param datosusuario 
     */
    public frmDashboard(ResultSet datosusuario) {
        customization.mainUtilities();
        initComponents();     
        LocalDateTime now = LocalDateTime.now();
        lblMes.setText(dtf.format(now));
        lblFecha.setText(dtf2.format(now));
        fechahoy = dtf3.format(now);
        System.out.println(fechahoy);
        datosAlumnoLog = datosusuario;
        moodPanel.setVisible(false);
        searchbar.putClientProperty("innerFocusWidth", 0);
        searchbar.putClientProperty("focusWidth", 0);
        CargarDatosAlumnoDashboard();
        ObtenerDatosAlumnoLoggeado(iduserlog);
        CargarPortafolios();
        CargarTareasAlumnos();
        CargarRecursos();
        CargarEventosDia();
        CargarUltimaEstadistica();
    }
    
    public void CargarDatosAlumnoDashboard(){
            try {
            usernamelog = datosAlumnoLog.getString(3);
            //Es el id del estudiante :P
            iduserlog = datosAlumnoLog.getInt(7);
            nivelusuario = datosAlumnoLog.getInt(2);
            lblnamedashboard.setText(usernamelog + "'s Dashboard");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No fue posible conseguir los datos del usuario", "Conflicto de datos", JOptionPane.ERROR);
        }
    }
    
    final void CargarRecursos(){
        CBiblioteca controlador = new CBiblioteca();
        ResultSet datosrecursos = controlador.CargarRecursosVista(iduserlog);
        try {
            while (datosrecursos.next()) {                
                 custo.CrearRecursoBibliotecaDashboard(datosrecursos.getString(1), datosrecursos.getString(2),datosrecursos.getString(3), recursosContainer, datosrecursos.getString(4), datosrecursos.getString(5));                
            }         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los recursos" + e.toString());
        }
    }
    
    final void CargarPortafolios(){
        CPortfolios controlador = new CPortfolios();
        ResultSet datos = controlador.CargarPortafolios(nombreAlumno);
        try {
            while (datos.next()) {                
                String materiamodulo;
                String cadena = datos.getString(5);
                String[] palabras = cadena.split(" ", 2);
                if (palabras[0].equals("Ninguno")) {
                    materiamodulo = palabras[1];
                } else {
                    materiamodulo = cadena.substring(0, cadena.lastIndexOf(" "));
                }
                custo.CrearPortafolioDashboard(materiamodulo, datos.getString(2), datos.getString(4), datos.getString(1), portafoliosContain, iduserlog, datos.getInt(6));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
        final void CargarTareasAlumnos(){
        CTasks controller = new CTasks();
        ResultSet datos = controller.CargarTareasPreview();
        try {
            while (datos.next()) {  
                //Forma de corroborar si es una materia o un modulo :3
                int fila = datos.getRow();
                
                String materiamodulo;
                String cadena = datos.getString(4);     
                String[] palabras = cadena.split(" ", 2);
                if (palabras[0].equals("Ninguno")) {
                    materiamodulo = palabras[1];
                } else {
                    materiamodulo = cadena.substring(0, cadena.lastIndexOf(" "));
                }    
                tareaidOpen = datos.getInt(10);
                custo.CrearTareaDashboard(datos.getString(1), materiamodulo, datos.getString(5), datos.getString(2), datos.getString(3), datos.getString(6), tareasContainer, materiamodulo, tareaidOpen, 1, 0, iduserlog);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar las tareas " + e.toString());
        }
        
    }
    
    
    void ObtenerDatosAlumnoLoggeado(int id){
        CEstudents controller = new CEstudents();
        datosAlumnoLog = controller.DatosAlumnoLog(id);
        try {
            while (datosAlumnoLog.next()) {                
                nombreAlumno = datosAlumnoLog.getString(3) + " " + datosAlumnoLog.getString(2);
                lblNombreEstadistica.setText(datosAlumnoLog.getString(3));
                lblApellidos.setText(datosAlumnoLog.getString(2));
//                System.out.println(nombreAlumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo para recargar la interfaz de portafolios de manera externa
    public void abrirMenuPortafolios() {
        panContainer.removeAll();
        panContainer.repaint();
        panContainer.revalidate();

        panContainer.add(new panPortfolios());
        panContainer.repaint();
        panContainer.revalidate();
        cambiarColorBotonesMenu(pageButton, "/resources/home-selec.png");
    }

    //Arreglar este metodo
    void GuardarRegistroMood(){
        int variable1 = 2;
        CMood obj = new CMood();
        boolean respuesta;
        if (moodPanel.getBackground() == Color.red) {
            variable1 = 1;
            respuesta = obj.RegistrarMood("00:"+lblmood.getText(), variable1, iduserlog);
            notificacion("Se han ingresado tus datos de enfoque exitosamente", 1, "Confirmación");
        } else {
            respuesta = obj.RegistrarMood(lblmood.getText(), variable1, iduserlog);
            notificacion("Se han ingresado tus datos de enfoque exitosamente", 1, "Confirmación");
        }
    }
    
    //Constructor para ver el mood de concetración
    public frmDashboard(int moodstate, ResultSet datosAlumno) {
        initComponents();
        custo.mainUtilities();
        datosAlumnoLog = datosAlumno;
        moodPanel.setVisible(false);
        searchbar.putClientProperty("innerFocusWidth", 0);
        searchbar.putClientProperty("focusWidth", 0);
        CargarDatosAlumnoDashboard();
        CargarPortafolios();
        CargarTareasAlumnos();
        CargarRecursos();
        mood = moodstate;
        if (mood == 1) {
            moodPanel.setVisible(true);
            EstudioLibre();
        }else if (mood == 2){
            moodPanel.setVisible(true);
            moodPanel.setBackground(Color.red);
            custo.changeIconlbl(moodPic, "/resources/Tomato-white.png");
            lblmood.setForeground(Color.white);
            btnStopMood.setStyle(ButtonRound.ButtonStyle.NEGRO);
            Pomodoro();
        }
    }
    
    
    public void Pomodoro() {
        minutos = 2;
        segundos = 0;
        timerP = new Timer();
        taskP = new TimerTask() {
            @Override
            public void run() {
                if (minutos == 0 && segundos == 0) {
                    timerP.cancel();
                    pomodoros++;
                    notificacion("Muy buen trabajo, te mereces 5 minutos de descanso", 1, "Descanso");
                    Descanso();
                } else {
                    if (segundos > 0) {
                        segundos--;
                    } else if (segundos == 0) {
                        minutos--;
                        segundos = 59;
                    }
                    if (minutos < 10 && segundos < 10) {
                        lblmood.setText("0" + minutos + " : 0" + segundos);
                    } else if (minutos < 10) {
                        lblmood.setText("0" + minutos + " : " + segundos);
                    } else if (segundos < 10) {
                        lblmood.setText(minutos + " : 0" + segundos);
                    } else {
                        lblmood.setText(minutos + " : " + segundos);
                    }
                }
            }
        };
        timerP.scheduleAtFixedRate(taskP, 0, 100);
    }
    
    
    public void Descanso(){
        minutos = 2;
        segundos = 0;
        timerP = new Timer();
        taskP = new TimerTask() {
            @Override
            public void run() {
                if (minutos == 0 && segundos == 0) {
                    if (JOptionPane.showConfirmDialog(null, "De vuelta a trabajar") == JOptionPane.OK_OPTION) {
                        timerP.cancel();
                        Pomodoro();
                    } else{
                        timerP.cancel();
                        double tiempo = pomodoros * 25;
                        String tiempojeje = String.valueOf(tiempo);
                        GuardarRegistroMood();
                        notificacion("Buen trabajo! Has logrado " + pomodoros + " pomodoros en esta sesión", 1, "Pomodoros");
                    }
                } else{ 
                    if (segundos > 0) {
                        segundos--;
                    } else if (segundos == 0) {
                        minutos--;
                        segundos = 59;
                    }
                    if (minutos < 10 && segundos < 10) {
                        lblmood.setText("0" + minutos + " : 0" + segundos);
                    } else if (minutos < 10) {
                        lblmood.setText("0" + minutos + " : " + segundos);
                    } else if (segundos < 10) {
                        lblmood.setText(minutos + " : 0" + segundos);
                    } else {
                        lblmood.setText(minutos + " : " + segundos);
                    }
                }
            }
        };
        timerP.scheduleAtFixedRate(taskP, 0, 100);
    }
    
    public void EstudioLibre(){
        minutos = 0;
        segundos = 0;
        horas = 0;
        timerP = new Timer();
        taskP = new TimerTask() {
            @Override
            public void run() {
                if (segundos < 60) {
                    segundos++;
                } else if (segundos == 60) {
                    minutos++;
                    segundos = 0;
                } else if (minutos == 60)  {
                    minutos = 0;
                    horas++;
                }              
                if (horas < 10 && minutos < 10 && segundos < 10) {
                    lblmood.setText("0" + horas +" : 0" + minutos + " : 0" + segundos);
                } else if(horas < 10 && minutos < 10){
                    lblmood.setText("0" + horas +" : 0" + minutos + " : " + segundos);
                } else if(horas < 10 && segundos < 10){
                    lblmood.setText("0" + horas +" : " + minutos + " : 0" + segundos);
                } else if(horas < 10){
                     lblmood.setText("0" + horas +" : " + minutos + " : " + segundos);
                } else if (minutos < 10 && segundos < 10) {
                    lblmood.setText(horas + " : 0" + minutos + " : 0" + segundos);
                } else if (minutos < 10) {
                    lblmood.setText(horas + " : 0" + minutos + " : " + segundos);
                } else if (segundos < 10) {
                    lblmood.setText(horas + " : " + minutos + " : 0" + segundos);
                } else {
                    lblmood.setText(horas + " : " + minutos + " : " + segundos);
                }
            }
        };
        timerP.scheduleAtFixedRate(taskP, 0, 100);
    }


    public void notificacion(String mensaje, int tipo_mensaje, String tipo_men) {
        try {
            // Obtener solamente una instancia del objeto SystemTray
            SystemTray tray = SystemTray.getSystemTray();
            // Si quieres crear un icono en la bandeja del sistemas como vista previa
            Image image = Toolkit.getDefaultToolkit().createImage("some-icon.png");
            TrayIcon trayIcon = new TrayIcon(image, "Java AWT Tray Demo");
            // Deja que el sistema auto escale si es necesario
            trayIcon.setImageAutoSize(true);
            // Definir texto de tooltip(descripción emergente)
            trayIcon.setToolTip("Gnosis System");
            tray.add(trayIcon);
            // Mostrar notificación de información:
            if (tipo_mensaje == 1) {
                trayIcon.displayMessage(tipo_men, mensaje, TrayIcon.MessageType.INFO);
            } else if (tipo_mensaje == 2) {
                trayIcon.displayMessage(tipo_men, mensaje, TrayIcon.MessageType.WARNING);
            } else {
                trayIcon.displayMessage(tipo_men, mensaje, TrayIcon.MessageType.ERROR);
            }
        } catch (Exception ex) {
            System.err.print(ex);
        }
    }
    
    final void CargarEventosDia() {
        CEvento controller = new CEvento(); 

        ResultSet datos = controller.ConsultarEventoHoy(fechahoy);
        int contador = 0;
        try {
            while (datos.next()) {
                contador++;
            }
            numEventos.setText(String.valueOf(contador));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los eventos de el día de hoy");
        }

    }
    
    final void CargarUltimaEstadistica(){
        CMood controllermood = new CMood();
        ResultSet stdst = controllermood.CargarUltimaEstadistica(iduserlog);
        try {
            while (stdst.next()) {              
                String tiempo = stdst.getString(2);
                lblTiempoUltimoEnfoque.setText("Tiempo: " + tiempo.substring(0, 8));
                if (stdst.getInt(3) == 1 ) {
                    lblModoEnfoqueEst.setText("Enfoque Pomodoro");
                    custo.changeIconlbl(lblIconoEnfoque, "/resources/Tomato.png");
                } else{
                    lblModoEnfoqueEst.setText("Enfoque Libre");
                }
            }
        } catch (Exception e) {
        }
    }
//    

    public void cambiarColorBotonesMenu(ButtonRound btn, String icono) {
        //Cambio el estado de todos los botones a deseleccionados 
        //En cada uno tiene que ir la imagen en negro :P
        homeButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(homeButton, "/resources/home.png");
        calendarButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(calendarButton, "/resources/calendar.png");
        briefcaseButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(briefcaseButton, "/resources/briefcase.png");
        pageButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(pageButton, "/resources/document-text.png");
//        medalButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
//        custo.changeIcon(medalButton, "/resources/medal.png");
        bookButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(bookButton, "/resources/book-saved.png");

        //Y justo al final cambio el boton que es al estado de seleccionado :P
        btn.setStyle(ButtonRound.ButtonStyle.BLANCO);
        custo.changeIcon(btn, icono);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panBlack = new customizeObjects.PanelRound();
        panWhite = new customizeObjects.PanelRound();
        panContainer = new customizeObjects.PanelRound();
        panDashboard = new customizeObjects.PanelRound();
        upperPanel = new javax.swing.JPanel();
        namePan = new javax.swing.JPanel();
        lblnamedashboard = new javax.swing.JLabel();
        searchPan = new javax.swing.JPanel();
        panelRound1 = new customizeObjects.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        buttonsPan = new javax.swing.JPanel();
        buttonRound2 = new customizeObjects.ButtonRound();
        btnMood = new customizeObjects.ButtonRound();
        panelRound2 = new customizeObjects.PanelRound();
        jComboBox1 = new javax.swing.JComboBox<>();
        buttonRound4 = new customizeObjects.ButtonRound();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        segundaFila = new customizeObjects.PanelRound();
        protfoliosPanel = new customizeObjects.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        portafoliosContain = new javax.swing.JPanel();
        titlePortfolios = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        BtnVolverAcargar = new customizeObjects.ButtonRound();
        gradesPanel = new customizeObjects.PanelRound();
        panelRound12 = new customizeObjects.PanelRound();
        jLabel12 = new javax.swing.JLabel();
        panelRound11 = new customizeObjects.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        panEventToday2 = new customizeObjects.PanelRound();
        numEventos = new javax.swing.JLabel();
        panEventToday1 = new customizeObjects.PanelRound();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        primeraFila = new customizeObjects.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        calendarPanel = new customizeObjects.PanelRound();
        panelRound10 = new customizeObjects.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        buttonRound5 = new customizeObjects.ButtonRound();
        jScrollPane3 = new javax.swing.JScrollPane();
        recursosContainer = new customizeObjects.PanelRound();
        stadisticPanel = new customizeObjects.PanelRound();
        panelRound14 = new customizeObjects.PanelRound();
        jLabel13 = new javax.swing.JLabel();
        buttonRound3 = new customizeObjects.ButtonRound();
        lblIconoEnfoque = new javax.swing.JLabel();
        lblTiempoUltimoEnfoque = new javax.swing.JLabel();
        lblNombreEstadistica = new javax.swing.JLabel();
        lblModoEnfoqueEst = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        taskPanel = new customizeObjects.PanelRound();
        panelRound8 = new customizeObjects.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        btnRecargar = new customizeObjects.ButtonRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        tareasContainer = new customizeObjects.PanelRound();
        panelRound4 = new customizeObjects.PanelRound();
        panelRound5 = new customizeObjects.PanelRound();
        panelRound6 = new customizeObjects.PanelRound();
        panelRound7 = new customizeObjects.PanelRound();
        upGap = new javax.swing.JPanel();
        downGap = new javax.swing.JPanel();
        rightGap = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        homeButton = new customizeObjects.ButtonRound();
        briefcaseButton = new customizeObjects.ButtonRound();
        pageButton = new customizeObjects.ButtonRound();
        calendarButton = new customizeObjects.ButtonRound();
        bookButton = new customizeObjects.ButtonRound();
        moodPanel = new customizeObjects.PanelRound();
        moodPic = new javax.swing.JLabel();
        lblmood = new javax.swing.JLabel();
        btnStopMood = new customizeObjects.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panBlack.setBackground(new java.awt.Color(32, 32, 32));
        panBlack.setMinimumSize(new java.awt.Dimension(900, 600));
        panBlack.setPreferredSize(new java.awt.Dimension(1200, 700));
        panBlack.setRoundBottomLeft(20);
        panBlack.setRoundBottomRight(20);
        panBlack.setRoundTopLeft(20);
        panBlack.setRoundTopRight(20);
        panBlack.setLayout(new java.awt.BorderLayout());

        panWhite.setBackground(new java.awt.Color(255, 255, 255));
        panWhite.setPreferredSize(new java.awt.Dimension(1000, 500));
        panWhite.setRoundBottomLeft(20);
        panWhite.setRoundBottomRight(20);
        panWhite.setRoundTopLeft(20);
        panWhite.setRoundTopRight(20);
        panWhite.setLayout(new java.awt.BorderLayout());

        panContainer.setBackground(new java.awt.Color(255, 255, 255));
        panContainer.setRoundBottomLeft(20);
        panContainer.setRoundBottomRight(20);
        panContainer.setRoundTopLeft(20);
        panContainer.setRoundTopRight(20);
        panContainer.setLayout(new java.awt.CardLayout());

        panDashboard.setBackground(new java.awt.Color(255, 255, 255));
        panDashboard.setLayout(new java.awt.BorderLayout());

        upperPanel.setBackground(java.awt.Color.white);
        upperPanel.setPreferredSize(new java.awt.Dimension(100, 50));
        upperPanel.setLayout(new java.awt.BorderLayout());

        namePan.setBackground(new java.awt.Color(255, 255, 255));
        namePan.setPreferredSize(new java.awt.Dimension(300, 100));
        namePan.setLayout(new javax.swing.BoxLayout(namePan, javax.swing.BoxLayout.LINE_AXIS));

        lblnamedashboard.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblnamedashboard.setForeground(new java.awt.Color(32, 32, 32));
        lblnamedashboard.setText("Santi's Dashboard");
        namePan.add(lblnamedashboard);

        upperPanel.add(namePan, java.awt.BorderLayout.WEST);

        searchPan.setBackground(java.awt.Color.white);
        searchPan.setLayout(new java.awt.BorderLayout());

        panelRound1.setBackground(new java.awt.Color(32, 32, 32));
        panelRound1.setPreferredSize(new java.awt.Dimension(300, 30));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);
        panelRound1.setLayout(new javax.swing.BoxLayout(panelRound1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel8.setPreferredSize(new java.awt.Dimension(10, 0));
        panelRound1.add(jLabel8);

        searchbar.setBackground(new java.awt.Color(32, 32, 32));
        searchbar.setForeground(new java.awt.Color(200, 200, 200));
        searchbar.setBorder(null);
        panelRound1.add(searchbar);

        jLabel3.setBackground(new java.awt.Color(32, 32, 32));
        jLabel3.setForeground(new java.awt.Color(60, 63, 65));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search-normal.png"))); // NOI18N
        jLabel3.setText("i");
        jLabel3.setToolTipText("");
        panelRound1.add(jLabel3);

        searchPan.add(panelRound1, java.awt.BorderLayout.CENTER);

        jLabel4.setPreferredSize(new java.awt.Dimension(0, 10));
        searchPan.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jLabel5.setPreferredSize(new java.awt.Dimension(0, 10));
        searchPan.add(jLabel5, java.awt.BorderLayout.PAGE_END);

        jLabel6.setPreferredSize(new java.awt.Dimension(20, 0));
        searchPan.add(jLabel6, java.awt.BorderLayout.LINE_END);

        jLabel7.setPreferredSize(new java.awt.Dimension(20, 0));
        searchPan.add(jLabel7, java.awt.BorderLayout.LINE_START);

        upperPanel.add(searchPan, java.awt.BorderLayout.CENTER);

        buttonsPan.setBackground(new java.awt.Color(255, 255, 255));
        buttonsPan.setPreferredSize(new java.awt.Dimension(300, 100));
        buttonsPan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 7, 5));

        buttonRound2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/calculator.png"))); // NOI18N
        buttonRound2.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonRound2.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        buttonsPan.add(buttonRound2);

        btnMood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N
        btnMood.setPreferredSize(new java.awt.Dimension(40, 40));
        btnMood.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        btnMood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoodActionPerformed(evt);
            }
        });
        buttonsPan.add(btnMood);

        panelRound2.setBackground(new java.awt.Color(32, 32, 32));
        panelRound2.setPreferredSize(new java.awt.Dimension(80, 40));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        jComboBox1.setBackground(new java.awt.Color(32, 32, 32));
        jComboBox1.setForeground(new java.awt.Color(32, 32, 32));
        jComboBox1.setPreferredSize(new java.awt.Dimension(23, 26));
        panelRound2.add(jComboBox1);

        buttonRound4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user-square.png"))); // NOI18N
        buttonRound4.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonRound4.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        buttonRound4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound4ActionPerformed(evt);
            }
        });
        panelRound2.add(buttonRound4);

        buttonsPan.add(panelRound2);

        upperPanel.add(buttonsPan, java.awt.BorderLayout.EAST);

        panDashboard.add(upperPanel, java.awt.BorderLayout.NORTH);

        mainPanel.setBackground(java.awt.Color.white);
        mainPanel.setLayout(new java.awt.BorderLayout(0, 10));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 20));
        mainPanel.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        segundaFila.setBackground(java.awt.Color.white);
        segundaFila.setPreferredSize(new java.awt.Dimension(100, 280));
        segundaFila.setLayout(new java.awt.BorderLayout(10, 0));

        protfoliosPanel.setBackground(java.awt.Color.white);
        protfoliosPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(217, 217, 217));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        portafoliosContain.setBackground(java.awt.Color.white);
        portafoliosContain.setLayout(new java.awt.GridLayout(1, 10, 10, 5));
        jScrollPane1.setViewportView(portafoliosContain);

        protfoliosPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        titlePortfolios.setBackground(java.awt.Color.white);
        titlePortfolios.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 32, 32));
        jLabel10.setText("Portafolios");
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 30));

        BtnVolverAcargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh-square-2.png"))); // NOI18N
        BtnVolverAcargar.setPreferredSize(new java.awt.Dimension(40, 40));
        BtnVolverAcargar.setRound(20);
        BtnVolverAcargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverAcargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titlePortfoliosLayout = new javax.swing.GroupLayout(titlePortfolios);
        titlePortfolios.setLayout(titlePortfoliosLayout);
        titlePortfoliosLayout.setHorizontalGroup(
            titlePortfoliosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePortfoliosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 495, Short.MAX_VALUE)
                .addComponent(BtnVolverAcargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        titlePortfoliosLayout.setVerticalGroup(
            titlePortfoliosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePortfoliosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(titlePortfoliosLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(BtnVolverAcargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        protfoliosPanel.add(titlePortfolios, java.awt.BorderLayout.PAGE_START);

        segundaFila.add(protfoliosPanel, java.awt.BorderLayout.CENTER);

        gradesPanel.setBackground(new java.awt.Color(32, 32, 32));
        gradesPanel.setPreferredSize(new java.awt.Dimension(400, 100));
        gradesPanel.setRoundBottomLeft(20);
        gradesPanel.setRoundBottomRight(20);
        gradesPanel.setRoundTopLeft(20);
        gradesPanel.setRoundTopRight(20);
        gradesPanel.setLayout(new java.awt.BorderLayout());

        panelRound12.setBackground(new java.awt.Color(32, 32, 32));
        panelRound12.setPreferredSize(new java.awt.Dimension(100, 60));
        panelRound12.setRoundTopLeft(20);
        panelRound12.setRoundTopRight(20);
        panelRound12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("  Calendario");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel12.setPreferredSize(new java.awt.Dimension(150, 40));
        panelRound12.add(jLabel12);

        gradesPanel.add(panelRound12, java.awt.BorderLayout.PAGE_START);

        panelRound11.setBackground(new java.awt.Color(32, 32, 32));
        panelRound11.setRoundBottomLeft(20);
        panelRound11.setRoundBottomRight(20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/calendar-dashboard.png"))); // NOI18N

        lblFecha.setFont(new java.awt.Font("Poppins", 1, 48)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("00");

        lblMes.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblMes.setForeground(java.awt.Color.white);
        lblMes.setText(" Hoy: ");
        lblMes.setToolTipText("");
        lblMes.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        panEventToday2.setBackground(new java.awt.Color(255, 255, 255));
        panEventToday2.setToolTipText("");
        panEventToday2.setPreferredSize(new java.awt.Dimension(60, 60));
        panEventToday2.setRoundBottomLeft(20);
        panEventToday2.setRoundBottomRight(20);
        panEventToday2.setRoundTopLeft(20);
        panEventToday2.setRoundTopRight(20);
        panEventToday2.setLayout(new java.awt.BorderLayout());

        numEventos.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        numEventos.setForeground(new java.awt.Color(32, 32, 32));
        numEventos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numEventos.setText("00");
        numEventos.setPreferredSize(new java.awt.Dimension(20, 20));
        numEventos.setRequestFocusEnabled(false);
        panEventToday2.add(numEventos, java.awt.BorderLayout.CENTER);

        panEventToday1.setBackground(new java.awt.Color(255, 255, 255));
        panEventToday1.setToolTipText("");
        panEventToday1.setPreferredSize(new java.awt.Dimension(60, 60));
        panEventToday1.setRoundBottomLeft(20);
        panEventToday1.setRoundBottomRight(20);
        panEventToday1.setRoundTopLeft(20);
        panEventToday1.setRoundTopRight(20);
        panEventToday1.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(32, 32, 32));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("00");
        jLabel14.setPreferredSize(new java.awt.Dimension(20, 20));
        jLabel14.setRequestFocusEnabled(false);
        panEventToday1.add(jLabel14, java.awt.BorderLayout.CENTER);

        jLabel15.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Hoy tienes programados:");

        jLabel16.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Para mañana, tienes programados:");

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Eventos o actividades");

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Eventos o actividades");

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMes)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addComponent(panEventToday1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18))
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addComponent(panEventToday2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17))
                    .addComponent(jLabel15))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panEventToday2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound11Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound11Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panEventToday1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound11Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel18)))))
                .addGap(27, 27, 27))
        );

        gradesPanel.add(panelRound11, java.awt.BorderLayout.CENTER);

        segundaFila.add(gradesPanel, java.awt.BorderLayout.EAST);

        mainPanel.add(segundaFila, java.awt.BorderLayout.SOUTH);

        primeraFila.setBackground(java.awt.Color.white);
        primeraFila.setPreferredSize(new java.awt.Dimension(100, 300));
        primeraFila.setLayout(new java.awt.BorderLayout(10, 0));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 100));
        jPanel2.setLayout(new java.awt.BorderLayout(10, 0));

        calendarPanel.setPreferredSize(new java.awt.Dimension(200, 100));
        calendarPanel.setRoundBottomLeft(20);
        calendarPanel.setRoundBottomRight(20);
        calendarPanel.setRoundTopLeft(20);
        calendarPanel.setRoundTopRight(20);
        calendarPanel.setLayout(new java.awt.BorderLayout());

        panelRound10.setBackground(new java.awt.Color(32, 32, 32));
        panelRound10.setPreferredSize(new java.awt.Dimension(100, 50));
        panelRound10.setRoundTopLeft(20);
        panelRound10.setRoundTopRight(20);

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Recursos");

        buttonRound5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh-square-2.png"))); // NOI18N
        buttonRound5.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonRound5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addContainerGap(345, Short.MAX_VALUE))
            .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound10Layout.createSequentialGroup()
                    .addContainerGap(396, Short.MAX_VALUE)
                    .addComponent(buttonRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)))
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addGap(12, 12, 12))
            .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(buttonRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        calendarPanel.add(panelRound10, java.awt.BorderLayout.PAGE_START);

        jScrollPane3.setBackground(new java.awt.Color(32, 32, 32));
        jScrollPane3.setBorder(null);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        recursosContainer.setBackground(new java.awt.Color(32, 32, 32));
        recursosContainer.setPreferredSize(new java.awt.Dimension(2000, 227));
        recursosContainer.setRoundBottomLeft(25);
        recursosContainer.setRoundBottomRight(25);
        recursosContainer.setLayout(new java.awt.GridLayout(1, 20, 5, 0));
        jScrollPane3.setViewportView(recursosContainer);

        calendarPanel.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel2.add(calendarPanel, java.awt.BorderLayout.CENTER);

        stadisticPanel.setBackground(new java.awt.Color(217, 217, 217));
        stadisticPanel.setPreferredSize(new java.awt.Dimension(250, 100));
        stadisticPanel.setRoundBottomLeft(20);
        stadisticPanel.setRoundBottomRight(20);
        stadisticPanel.setRoundTopLeft(20);
        stadisticPanel.setRoundTopRight(20);

        panelRound14.setBackground(new java.awt.Color(217, 217, 217));
        panelRound14.setPreferredSize(new java.awt.Dimension(100, 50));
        panelRound14.setRoundTopLeft(20);
        panelRound14.setRoundTopRight(20);

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(32, 32, 32));
        jLabel13.setText("Estadistícas");
        jLabel13.setPreferredSize(new java.awt.Dimension(107, 30));

        buttonRound3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh-square-2.png"))); // NOI18N
        buttonRound3.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonRound3.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        buttonRound3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound14Layout = new javax.swing.GroupLayout(panelRound14);
        panelRound14.setLayout(panelRound14Layout);
        panelRound14Layout.setHorizontalGroup(
            panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound14Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(buttonRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelRound14Layout.setVerticalGroup(
            panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        lblIconoEnfoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glasses.png"))); // NOI18N

        lblTiempoUltimoEnfoque.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        lblTiempoUltimoEnfoque.setForeground(new java.awt.Color(32, 32, 32));
        lblTiempoUltimoEnfoque.setText("Tiempo");

        lblNombreEstadistica.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblNombreEstadistica.setForeground(new java.awt.Color(32, 32, 32));
        lblNombreEstadistica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreEstadistica.setText("jLabel19");

        lblModoEnfoqueEst.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        lblModoEnfoqueEst.setForeground(new java.awt.Color(32, 32, 32));
        lblModoEnfoqueEst.setText("Modo de enfoque:");

        lblApellidos.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(32, 32, 32));
        lblApellidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellidos.setText("jLabel11");

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(32, 32, 32));
        jLabel11.setText("Tu ultimo enfoque:");

        javax.swing.GroupLayout stadisticPanelLayout = new javax.swing.GroupLayout(stadisticPanel);
        stadisticPanel.setLayout(stadisticPanelLayout);
        stadisticPanelLayout.setHorizontalGroup(
            stadisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stadisticPanelLayout.createSequentialGroup()
                .addGroup(stadisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound14, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(stadisticPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(stadisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblModoEnfoqueEst, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTiempoUltimoEnfoque, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(stadisticPanelLayout.createSequentialGroup()
                                .addComponent(lblIconoEnfoque)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(stadisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombreEstadistica, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(lblApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(132, 132, 132))
        );
        stadisticPanelLayout.setVerticalGroup(
            stadisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stadisticPanelLayout.createSequentialGroup()
                .addComponent(panelRound14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGroup(stadisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stadisticPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblIconoEnfoque, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(stadisticPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblNombreEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lblTiempoUltimoEnfoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblModoEnfoqueEst)
                .addContainerGap())
        );

        jPanel2.add(stadisticPanel, java.awt.BorderLayout.EAST);

        primeraFila.add(jPanel2, java.awt.BorderLayout.EAST);

        taskPanel.setBackground(new java.awt.Color(217, 217, 217));
        taskPanel.setPreferredSize(new java.awt.Dimension(400, 100));
        taskPanel.setRoundBottomLeft(20);
        taskPanel.setRoundBottomRight(20);
        taskPanel.setRoundTopLeft(20);
        taskPanel.setRoundTopRight(20);
        taskPanel.setLayout(new java.awt.BorderLayout());

        panelRound8.setBackground(new java.awt.Color(217, 217, 217));
        panelRound8.setPreferredSize(new java.awt.Dimension(100, 50));
        panelRound8.setRoundTopLeft(20);
        panelRound8.setRoundTopRight(20);

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setText("Tareas");
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 25));

        btnRecargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh-square-2.png"))); // NOI18N
        btnRecargar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnRecargar.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        taskPanel.add(panelRound8, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setBackground(new java.awt.Color(217, 217, 217));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tareasContainer.setBackground(new java.awt.Color(217, 217, 217));
        tareasContainer.setOpaque(true);
        tareasContainer.setPreferredSize(new java.awt.Dimension(349, 1500));
        tareasContainer.setRoundBottomLeft(25);
        tareasContainer.setRoundBottomRight(25);
        tareasContainer.setLayout(new java.awt.GridLayout(15, 1, 5, 0));
        jScrollPane2.setViewportView(tareasContainer);

        taskPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        primeraFila.add(taskPanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(primeraFila, java.awt.BorderLayout.CENTER);

        panDashboard.add(mainPanel, java.awt.BorderLayout.CENTER);

        panContainer.add(panDashboard, "card2");

        panWhite.add(panContainer, java.awt.BorderLayout.CENTER);

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setPreferredSize(new java.awt.Dimension(100, 15));
        panelRound4.setRoundTopLeft(25);
        panelRound4.setRoundTopRight(25);
        panWhite.add(panelRound4, java.awt.BorderLayout.PAGE_START);

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));
        panelRound5.setPreferredSize(new java.awt.Dimension(100, 15));
        panelRound5.setRoundBottomLeft(25);
        panelRound5.setRoundBottomRight(25);
        panWhite.add(panelRound5, java.awt.BorderLayout.PAGE_END);

        panelRound6.setBackground(new java.awt.Color(255, 255, 255));
        panelRound6.setPreferredSize(new java.awt.Dimension(15, 100));
        panWhite.add(panelRound6, java.awt.BorderLayout.LINE_END);

        panelRound7.setBackground(new java.awt.Color(255, 255, 255));
        panelRound7.setPreferredSize(new java.awt.Dimension(15, 100));
        panWhite.add(panelRound7, java.awt.BorderLayout.LINE_START);

        panBlack.add(panWhite, java.awt.BorderLayout.CENTER);

        upGap.setBackground(new java.awt.Color(32, 32, 32));
        panBlack.add(upGap, java.awt.BorderLayout.PAGE_START);

        downGap.setBackground(new java.awt.Color(32, 32, 32));
        panBlack.add(downGap, java.awt.BorderLayout.PAGE_END);

        rightGap.setBackground(new java.awt.Color(32, 32, 32));
        panBlack.add(rightGap, java.awt.BorderLayout.LINE_END);

        sideBar.setBackground(new java.awt.Color(32, 32, 32));
        sideBar.setPreferredSize(new java.awt.Dimension(99, 100));
        sideBar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-selec.png"))); // NOI18N
        homeButton.setPreferredSize(new java.awt.Dimension(60, 60));
        homeButton.setRound(15);
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                homeButtonMouseReleased(evt);
            }
        });
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        sideBar.add(homeButton);

        briefcaseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/briefcase.png"))); // NOI18N
        briefcaseButton.setPreferredSize(new java.awt.Dimension(60, 60));
        briefcaseButton.setRound(15);
        briefcaseButton.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        briefcaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                briefcaseButtonActionPerformed(evt);
            }
        });
        sideBar.add(briefcaseButton);

        pageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/document-text.png"))); // NOI18N
        pageButton.setPreferredSize(new java.awt.Dimension(60, 60));
        pageButton.setRound(15);
        pageButton.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        pageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageButtonActionPerformed(evt);
            }
        });
        sideBar.add(pageButton);

        calendarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/calendar.png"))); // NOI18N
        calendarButton.setPreferredSize(new java.awt.Dimension(60, 60));
        calendarButton.setRound(15);
        calendarButton.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        calendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarButtonActionPerformed(evt);
            }
        });
        sideBar.add(calendarButton);

        bookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/book-saved.png"))); // NOI18N
        bookButton.setPreferredSize(new java.awt.Dimension(60, 60));
        bookButton.setRound(15);
        bookButton.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookButtonActionPerformed(evt);
            }
        });
        sideBar.add(bookButton);

        moodPanel.setBackground(new java.awt.Color(120, 220, 90));
        moodPanel.setPreferredSize(new java.awt.Dimension(75, 140));
        moodPanel.setRoundBottomLeft(20);
        moodPanel.setRoundBottomRight(20);
        moodPanel.setRoundTopLeft(20);
        moodPanel.setRoundTopRight(20);
        moodPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 7));

        moodPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glasses.png"))); // NOI18N
        moodPanel.add(moodPic);

        lblmood.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lblmood.setForeground(new java.awt.Color(32, 32, 32));
        lblmood.setText("00 : 00 : 00");
        moodPanel.add(lblmood);

        btnStopMood.setText("STOP");
        btnStopMood.setFont(new java.awt.Font("Poppins Black", 0, 12)); // NOI18N
        btnStopMood.setPreferredSize(new java.awt.Dimension(60, 30));
        btnStopMood.setRound(20);
        btnStopMood.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        btnStopMood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopMoodActionPerformed(evt);
            }
        });
        moodPanel.add(btnStopMood);

        sideBar.add(moodPanel);

        panBlack.add(sideBar, java.awt.BorderLayout.WEST);

        getContentPane().add(panBlack, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calenderButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_calenderButtonMouseClicked

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        // TODO add your handling code here:     

    }//GEN-LAST:event_homeButtonMouseClicked

    private void homeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_homeButtonMouseReleased

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_homeButtonMouseExited

    //Action Performed de los botones del sidebar

    private void briefcaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_briefcaseButtonActionPerformed
        // TODO add your handling code here:  
        //Si componentcount es 0 significa que esta en el dashboard
        if (panContainer.getComponentCount() == 0) {
            //Cambio el color del boton y el icono
            cambiarColorBotonesMenu(briefcaseButton, "/resources/briefcase-black.png");
            //Agrego el panel que corresponde
            panContainer.add(new panTasks(1, iduserlog));
            panContainer.repaint();
            panContainer.revalidate();
            //Si el componentCount es 1 es que uno esta abierto
        } else if (panContainer.getComponentCount() == 1) {
            // Si el estilo/color del boton es negro significa que el panel abierto no pertenece al boton
            if (briefcaseButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                //Remuevo el panel abierto y agrego el panel correspondiente al boton
                cambiarColorBotonesMenu(briefcaseButton, "/resources/briefcase-black.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panTasks(1, iduserlog));
                panContainer.repaint();
                panContainer.revalidate();
            } else {
                //Si el estilo/color del boton es blanco es porque el panel que se quiere abrir ya esta abierto
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }
        }
    }//GEN-LAST:event_briefcaseButtonActionPerformed

    private void pageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageButtonActionPerformed
        // TODO add your handling code here:
        if (panContainer.getComponentCount() == 0) {
            cambiarColorBotonesMenu(pageButton, "/resources/document-text-black.png");
            panContainer.add(new panPortfolios(iduserlog, nombreAlumno));
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount() == 1 && panContainer.getComponent(0) != new panPortfolios(iduserlog, nombreAlumno)) {
            if (pageButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(pageButton, "/resources/document-text-black.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panPortfolios(iduserlog, nombreAlumno));
                panContainer.repaint();
                panContainer.revalidate();
            } else {
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }

        }
    }//GEN-LAST:event_pageButtonActionPerformed

    private void calendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarButtonActionPerformed
        // TODO add your handling code here:
        if (panContainer.getComponentCount() == 0) {
            cambiarColorBotonesMenu(calendarButton, "/resources/calendar-black.png");
            panContainer.add(new panCalendar());
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount() == 1 && panContainer.getComponent(0) != new panCalendar()) {
            if (calendarButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(calendarButton, "/resources/calendar-black.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panCalendar());
                panContainer.repaint();
                panContainer.revalidate();
            } else {
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }
        }
    }//GEN-LAST:event_calendarButtonActionPerformed

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookButtonActionPerformed
        // TODO add your handling code here:
        if (panContainer.getComponentCount() == 0) {
            cambiarColorBotonesMenu(bookButton, "/resources/book-saved-black.png");
            panContainer.add(new panBiblioteca(iduserlog));
            System.out.println(iduserlog);
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount() == 1 && panContainer.getComponent(0) != new panBiblioteca()) {
            if (bookButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(bookButton, "/resources/book-saved-black.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panBiblioteca(iduserlog));
                System.out.println(iduserlog);
                panContainer.repaint();
                panContainer.revalidate();
            } else {
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }

        }
    }//GEN-LAST:event_bookButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        if (panContainer.getComponentCount() == 0) {
            notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
        } else {
            cambiarColorBotonesMenu(homeButton, "/resources/home-selec.png");

            panContainer.removeAll();
            panContainer.repaint();
            panContainer.revalidate();

            panContainer.add(panDashboard);
            panContainer.repaint();
            panContainer.revalidate();
        }
    }//GEN-LAST:event_homeButtonActionPerformed

    private void btnMoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoodActionPerformed
        // TODO add your handling code here:
        
        new frmMood(datosAlumnoLog).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMoodActionPerformed

    private void buttonRound4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRound4ActionPerformed

    private void btnStopMoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopMoodActionPerformed
        // TODO add your handling code here:
        timerP.cancel();
        taskP.cancel();
        if (mood == 1) {
            notificacion("Buen trabajo! Has logrado " + pomodoros + " pomodoros en esta sesión", 1, "Pomodoros");
            GuardarRegistroMood();
            moodPanel.setVisible(false);
        } else{
            GuardarRegistroMood();
            moodPanel.setVisible(false);
        }
        lblmood.setText("00"+" : "+"00"+" : "+"00");
        
    }//GEN-LAST:event_btnStopMoodActionPerformed

    private void BtnVolverAcargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverAcargarActionPerformed
        // TODO add your handling code here:
        portafoliosContain.removeAll();
        portafoliosContain.repaint();
        portafoliosContain.revalidate();
        CargarPortafolios();
    }//GEN-LAST:event_BtnVolverAcargarActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        // TODO add your handling code here:
        tareasContainer.removeAll();
        tareasContainer.repaint();
        tareasContainer.revalidate();
            CargarTareasAlumnos();
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void buttonRound3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound3ActionPerformed
        // TODO add your handling code here:
        recursosContainer.removeAll();
        recursosContainer.repaint();
        recursosContainer.revalidate();
        CargarUltimaEstadistica();
    }//GEN-LAST:event_buttonRound3ActionPerformed

    private void buttonRound5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRound5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        customization.mainUtilities();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDashboard().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound BtnVolverAcargar;
    private customizeObjects.ButtonRound bookButton;
    private customizeObjects.ButtonRound briefcaseButton;
    private customizeObjects.ButtonRound btnMood;
    private customizeObjects.ButtonRound btnRecargar;
    private customizeObjects.ButtonRound btnStopMood;
    private customizeObjects.ButtonRound buttonRound2;
    private customizeObjects.ButtonRound buttonRound3;
    private customizeObjects.ButtonRound buttonRound4;
    private customizeObjects.ButtonRound buttonRound5;
    private javax.swing.JPanel buttonsPan;
    private customizeObjects.ButtonRound calendarButton;
    private customizeObjects.PanelRound calendarPanel;
    private javax.swing.JPanel downGap;
    private customizeObjects.PanelRound gradesPanel;
    private customizeObjects.ButtonRound homeButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIconoEnfoque;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblModoEnfoqueEst;
    private javax.swing.JLabel lblNombreEstadistica;
    private javax.swing.JLabel lblTiempoUltimoEnfoque;
    private javax.swing.JLabel lblmood;
    private javax.swing.JLabel lblnamedashboard;
    private javax.swing.JPanel mainPanel;
    private customizeObjects.PanelRound moodPanel;
    private javax.swing.JLabel moodPic;
    private javax.swing.JPanel namePan;
    private javax.swing.JLabel numEventos;
    private customizeObjects.ButtonRound pageButton;
    private customizeObjects.PanelRound panBlack;
    private customizeObjects.PanelRound panContainer;
    private customizeObjects.PanelRound panDashboard;
    private customizeObjects.PanelRound panEventToday1;
    private customizeObjects.PanelRound panEventToday2;
    private customizeObjects.PanelRound panWhite;
    private customizeObjects.PanelRound panelRound1;
    private customizeObjects.PanelRound panelRound10;
    private customizeObjects.PanelRound panelRound11;
    private customizeObjects.PanelRound panelRound12;
    private customizeObjects.PanelRound panelRound14;
    private customizeObjects.PanelRound panelRound2;
    private customizeObjects.PanelRound panelRound4;
    private customizeObjects.PanelRound panelRound5;
    private customizeObjects.PanelRound panelRound6;
    private customizeObjects.PanelRound panelRound7;
    private customizeObjects.PanelRound panelRound8;
    private javax.swing.JPanel portafoliosContain;
    private customizeObjects.PanelRound primeraFila;
    private customizeObjects.PanelRound protfoliosPanel;
    private customizeObjects.PanelRound recursosContainer;
    private javax.swing.JPanel rightGap;
    private javax.swing.JPanel searchPan;
    private javax.swing.JTextField searchbar;
    private customizeObjects.PanelRound segundaFila;
    private javax.swing.JPanel sideBar;
    private customizeObjects.PanelRound stadisticPanel;
    private customizeObjects.PanelRound tareasContainer;
    private customizeObjects.PanelRound taskPanel;
    private javax.swing.JPanel titlePortfolios;
    private javax.swing.JPanel upGap;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables
}
