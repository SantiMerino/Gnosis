/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import Controller.CLogin;
import java.awt.*;
import javax.swing.JOptionPane;
import customizeObjects.ButtonRound;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class frmDashboardTeacher extends javax.swing.JFrame {



    /**
     * Creates new form frmDashboard
     */
    public void setNiveluser(int niveluser) {
        this.niveluser = niveluser;
    }
        public int getNiveluser() {
        return niveluser;
    }

    private int niveluser;
    int iddocente;
    String usernamelog;
       
    public customization custoObj = new customization();
    panGrades grades = new panGrades(iddocente);
    CLogin log = new CLogin();
    
    public frmDashboardTeacher() {
        customization.mainUtilities();
        initComponents();
        moodPanel.setVisible(false);
        searchbar.putClientProperty("innerFocusWidth", 0);
        searchbar.putClientProperty("focusWidth", 0);
        
    }

    public frmDashboardTeacher(ResultSet datosusuario) {
        customization.mainUtilities();
        initComponents();
        try {
            usernamelog = datosusuario.getString(3);
            niveluser = datosusuario.getInt(2);
            iddocente = datosusuario.getInt(8);
        } catch (SQLException ex) {
            Logger.getLogger(frmDashboardTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnUsers.setVisible(false);
        lblDashboard.setText(usernamelog + "'s Dashboard");
        moodPanel.setVisible(false);
        searchbar.putClientProperty("innerFocusWidth", 0);
        searchbar.putClientProperty("focusWidth", 0);
        teachersButton.setVisible(false);
        studentsButton.setVisible(false);
        if (this.niveluser == 3) {
            teachersButton.setVisible(true);
            studentsButton.setVisible(true);
            btnUsers.setVisible(true);
        }
    }   
    
    public void notificacion(String mensaje,int tipo_mensaje, String tipo_men){
        try{
            // Obtener solamente una instancia del objeto SystemTray
            SystemTray tray=SystemTray.getSystemTray();
            // Si quieres crear un icono en la bandeja del sistemas como vista previa
            Image image = Toolkit.getDefaultToolkit().createImage("some-icon.png");
            TrayIcon trayIcon=new TrayIcon(image,"Java AWT Tray Demo");
            // Deja que el sistema auto escale si es necesar
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
    
    public void cambiarColorBotonesMenu(ButtonRound btn, String icono){
        //Cambio el estado de todos los botones a deseleccionados 
        //En cada uno tiene que ir la imagen en negro :P
        homeButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custoObj.changeIcon(homeButton, "/resources/home.png");
        calendarButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custoObj.changeIcon(calendarButton, "/resources/calendar.png");
        briefcaseButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custoObj.changeIcon(briefcaseButton, "/resources/briefcase.png");
        pageButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custoObj.changeIcon(pageButton, "/resources/document-text.png");
        teachersButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custoObj.changeIcon(teachersButton, "/resources/admindocente.png");
        studentsButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custoObj.changeIcon(studentsButton, "/resources/teacher-white.png");
        medalButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custoObj.changeIcon(medalButton, "/resources/medal.png");
        bookButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custoObj.changeIcon(bookButton, "/resources/book-saved.png");
        
        //Y justo al final cambio el boton que es al estado de seleccionado :P
        btn.setStyle(ButtonRound.ButtonStyle.BLANCO);
        custoObj.changeIcon(btn, icono);
        
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
        lblDashboard = new javax.swing.JLabel();
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
        panelRound2 = new customizeObjects.PanelRound();
        jComboBox1 = new javax.swing.JComboBox<>();
        buttonRound4 = new customizeObjects.ButtonRound();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        segundaFila = new customizeObjects.PanelRound();
        protfoliosPanel = new customizeObjects.PanelRound();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        gradesPanel = new customizeObjects.PanelRound();
        panelRound12 = new customizeObjects.PanelRound();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelRound11 = new customizeObjects.PanelRound();
        primeraFila = new customizeObjects.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        calendarPanel = new customizeObjects.PanelRound();
        panelRound9 = new customizeObjects.PanelRound();
        panelRound10 = new customizeObjects.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        stadisticPanel = new customizeObjects.PanelRound();
        panelRound13 = new customizeObjects.PanelRound();
        panelRound14 = new customizeObjects.PanelRound();
        jLabel13 = new javax.swing.JLabel();
        taskPanel = new customizeObjects.PanelRound();
        panelRound3 = new customizeObjects.PanelRound();
        panelRound8 = new customizeObjects.PanelRound();
        jLabel14 = new javax.swing.JLabel();
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
        medalButton = new customizeObjects.ButtonRound();
        studentsButton = new customizeObjects.ButtonRound();
        teachersButton = new customizeObjects.ButtonRound();
        btnUsers = new customizeObjects.ButtonRound();
        moodPanel = new customizeObjects.PanelRound();
        moodPic = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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

        lblDashboard.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblDashboard.setForeground(new java.awt.Color(32, 32, 32));
        lblDashboard.setText("Santi's Dashboard");
        namePan.add(lblDashboard);

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

        panelRound2.setBackground(new java.awt.Color(32, 32, 32));
        panelRound2.setPreferredSize(new java.awt.Dimension(80, 40));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        jComboBox1.setBackground(new java.awt.Color(32, 32, 32));
        jComboBox1.setForeground(new java.awt.Color(32, 32, 32));
        jComboBox1.setToolTipText("");
        jComboBox1.setPreferredSize(new java.awt.Dimension(23, 26));
        panelRound2.add(jComboBox1);

        buttonRound4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user-square.png"))); // NOI18N
        buttonRound4.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonRound4.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
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

        jPanel3.setBackground(java.awt.Color.white);
        protfoliosPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 32, 32));
        jLabel10.setText("Portafolios");
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel4.add(jLabel10);

        protfoliosPanel.add(jPanel4, java.awt.BorderLayout.PAGE_START);

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
        panelRound12.setLayout(new javax.swing.BoxLayout(panelRound12, javax.swing.BoxLayout.Y_AXIS));

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("  Calificaciones");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel12.setPreferredSize(new java.awt.Dimension(80, 40));
        panelRound12.add(jLabel12);

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("   Periodo");
        jLabel11.setToolTipText("");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRound12.add(jLabel11);

        gradesPanel.add(panelRound12, java.awt.BorderLayout.PAGE_START);

        panelRound11.setBackground(new java.awt.Color(32, 32, 32));
        panelRound11.setRoundBottomLeft(20);
        panelRound11.setRoundBottomRight(20);
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

        panelRound9.setBackground(new java.awt.Color(32, 32, 32));
        panelRound9.setRoundBottomLeft(20);
        panelRound9.setRoundBottomRight(20);
        calendarPanel.add(panelRound9, java.awt.BorderLayout.CENTER);

        panelRound10.setBackground(new java.awt.Color(32, 32, 32));
        panelRound10.setPreferredSize(new java.awt.Dimension(100, 50));
        panelRound10.setRoundTopLeft(20);
        panelRound10.setRoundTopRight(20);

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Calendario");

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addContainerGap(326, Short.MAX_VALUE))
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        calendarPanel.add(panelRound10, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(calendarPanel, java.awt.BorderLayout.CENTER);

        stadisticPanel.setBackground(new java.awt.Color(217, 217, 217));
        stadisticPanel.setPreferredSize(new java.awt.Dimension(250, 100));
        stadisticPanel.setRoundBottomLeft(20);
        stadisticPanel.setRoundBottomRight(20);
        stadisticPanel.setRoundTopLeft(20);
        stadisticPanel.setRoundTopRight(20);
        stadisticPanel.setLayout(new java.awt.BorderLayout());

        panelRound13.setBackground(new java.awt.Color(217, 217, 217));
        panelRound13.setRoundBottomLeft(20);
        panelRound13.setRoundBottomRight(20);
        stadisticPanel.add(panelRound13, java.awt.BorderLayout.CENTER);

        panelRound14.setBackground(new java.awt.Color(217, 217, 217));
        panelRound14.setPreferredSize(new java.awt.Dimension(100, 50));
        panelRound14.setRoundTopLeft(20);
        panelRound14.setRoundTopRight(20);
        panelRound14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(32, 32, 32));
        jLabel13.setText("Estadisticas");
        jLabel13.setPreferredSize(new java.awt.Dimension(107, 30));
        panelRound14.add(jLabel13);

        stadisticPanel.add(panelRound14, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(stadisticPanel, java.awt.BorderLayout.EAST);

        primeraFila.add(jPanel2, java.awt.BorderLayout.EAST);

        taskPanel.setBackground(new java.awt.Color(217, 217, 217));
        taskPanel.setPreferredSize(new java.awt.Dimension(400, 100));
        taskPanel.setRoundBottomLeft(20);
        taskPanel.setRoundBottomRight(20);
        taskPanel.setRoundTopLeft(20);
        taskPanel.setRoundTopRight(20);
        taskPanel.setLayout(new java.awt.BorderLayout());

        panelRound3.setBackground(new java.awt.Color(217, 217, 217));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        taskPanel.add(panelRound3, java.awt.BorderLayout.CENTER);

        panelRound8.setBackground(new java.awt.Color(217, 217, 217));
        panelRound8.setPreferredSize(new java.awt.Dimension(100, 50));
        panelRound8.setRoundTopLeft(20);
        panelRound8.setRoundTopRight(20);

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(32, 32, 32));
        jLabel14.setText("Tareas");
        jLabel14.setPreferredSize(new java.awt.Dimension(120, 25));

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        taskPanel.add(panelRound8, java.awt.BorderLayout.PAGE_START);

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
        panelRound7.setRoundTopLeft(20);
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

        medalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/medal.png"))); // NOI18N
        medalButton.setPreferredSize(new java.awt.Dimension(60, 60));
        medalButton.setRound(15);
        medalButton.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        medalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medalButtonActionPerformed(evt);
            }
        });
        sideBar.add(medalButton);

        studentsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/teacher-white.png"))); // NOI18N
        studentsButton.setPreferredSize(new java.awt.Dimension(60, 60));
        studentsButton.setRound(15);
        studentsButton.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        studentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsButtonActionPerformed(evt);
            }
        });
        sideBar.add(studentsButton);

        teachersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/admindocente.png"))); // NOI18N
        teachersButton.setPreferredSize(new java.awt.Dimension(60, 60));
        teachersButton.setRound(15);
        teachersButton.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        teachersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teachersButtonActionPerformed(evt);
            }
        });
        sideBar.add(teachersButton);

        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/people-white.png"))); // NOI18N
        btnUsers.setPreferredSize(new java.awt.Dimension(60, 60));
        btnUsers.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });
        sideBar.add(btnUsers);

        moodPanel.setBackground(new java.awt.Color(120, 220, 90));
        moodPanel.setPreferredSize(new java.awt.Dimension(75, 140));
        moodPanel.setRoundBottomLeft(20);
        moodPanel.setRoundBottomRight(20);
        moodPanel.setRoundTopLeft(20);
        moodPanel.setRoundTopRight(20);
        moodPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 7));

        moodPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glasses.png"))); // NOI18N
        moodPanel.add(moodPic);

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setText("00:00:00");
        moodPanel.add(jLabel2);

        btnStopMood.setText("STOP");
        btnStopMood.setFont(new java.awt.Font("Poppins Black", 0, 12)); // NOI18N
        btnStopMood.setPreferredSize(new java.awt.Dimension(60, 30));
        btnStopMood.setRound(20);
        btnStopMood.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
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
        if(panContainer.getComponentCount()== 0) {
        //Cambio el color del boton y el icono
            cambiarColorBotonesMenu(briefcaseButton, "/resources/briefcase-black.png");
        //Agrego el panel que corresponde
            panContainer.add(new panTasks(niveluser, iddocente));
            panContainer.repaint();
            panContainer.revalidate();
        //Si el componentCount es 1 es que uno esta abierto
        } else if (panContainer.getComponentCount()== 1 ) {
            // Si el estilo/color del boton es negro significa que el panel abierto no pertenece al boton
            if (briefcaseButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
            //Remuevo el panel abierto y agrego el panel correspondiente al boton
            cambiarColorBotonesMenu(briefcaseButton, "/resources/briefcase-black.png");
            panContainer.removeAll();
            panContainer.repaint();
            panContainer.revalidate();

            panContainer.add(new panTasks(niveluser, iddocente));
            panContainer.repaint();
            panContainer.revalidate(); 
            }else {
                //Si el estilo/color del boton es blanco es porque el panel que se quiere abrir ya esta abierto
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }           
        }
    }//GEN-LAST:event_briefcaseButtonActionPerformed

    private void pageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageButtonActionPerformed
        // TODO add your handling code here:
        if(panContainer.getComponentCount()== 0) {
            cambiarColorBotonesMenu(pageButton, "/resources/document-text-black.png");
            panContainer.add(new panPortfolios());
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount()== 1 && panContainer.getComponent(0) != new panPortfolios()) {
            if (pageButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(pageButton, "/resources/document-text-black.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panPortfolios());
                panContainer.repaint();
                panContainer.revalidate(); 
            } else {
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }
  
        }
    }//GEN-LAST:event_pageButtonActionPerformed

    private void calendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarButtonActionPerformed
        // TODO add your handling code here:
        if(panContainer.getComponentCount()== 0) {
            cambiarColorBotonesMenu(calendarButton, "/resources/calendar-black.png");
            panContainer.add(new panCalendar());
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount()== 1 && panContainer.getComponent(0) != new panCalendar()) {
            if (calendarButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(calendarButton, "/resources/calendar-black.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panCalendar());
                panContainer.repaint();
                panContainer.revalidate();
            } else{ 
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }
   
        }
    }//GEN-LAST:event_calendarButtonActionPerformed

    private void studentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsButtonActionPerformed
        // TODO add your handling code here:
        if(panContainer.getComponentCount()== 0) {
            cambiarColorBotonesMenu(studentsButton, "/resources/teacher-white.png");
            panContainer.add(new panStudents());
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount()== 1 && panContainer.getComponent(0) != new panStudents()) {
            if (studentsButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(studentsButton, "/resources/teacher.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panStudents());
                panContainer.repaint();
                panContainer.revalidate();
            } else{ 
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }
     
        }
//        if (new frmTeachersCRUD()!= null ) {
//            frmStudentsCRUD frame = new frmStudentsCRUD();
//            Container c = frame.getContentPane();
//            panContainer.removeAll();
//            panContainer.repaint();
//            panContainer.revalidate();
//            panContainer.add(BorderLayout.CENTER,c);
//            panContainer.repaint();
//            panContainer.revalidate();
////            new frmTeachersCRUD().setVisible(true);
////            this.setState(JFrame.ICONIFIED);
//        } else{
//            JOptionPane.showMessageDialog(null, "Ya esta abierta esta interfazz");
//        }
          
    }//GEN-LAST:event_studentsButtonActionPerformed

    private void teachersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teachersButtonActionPerformed
        // TODO add your handling code here:
        if(panContainer.getComponentCount()== 0) {
            cambiarColorBotonesMenu(teachersButton, "/resources/admindocente.png");
            panContainer.add(new panTeachers());
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount()== 1 && panContainer.getComponent(0) != new panTeachers()) {
                    if (teachersButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(teachersButton, "/resources/admindocente-black.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panTeachers());
                panContainer.repaint();
                panContainer.revalidate();
            } else{ 
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }  
        }
//        if (new frmTeachersCRUD()!= null ) {
//            frmTeachersCRUD frame = new frmTeachersCRUD();
//            Container c = frame.getContentPane();
//            
//            panContainer.removeAll();
//            panContainer.add(BorderLayout.CENTER,c);
//            panContainer.repaint();
//            panContainer.revalidate();
////            new frmTeachersCRUD().setVisible(true);
////            this.setState(JFrame.ICONIFIED);
//        } else{
//            JOptionPane.showMessageDialog(null, "Ya esta abierta esta interfazz");
//        }
    }//GEN-LAST:event_teachersButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        if (panContainer.getComponentCount()== 0) {
            notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
        } else   {
            cambiarColorBotonesMenu(homeButton, "/resources/home-selec.png");
            
            panContainer.removeAll();
            panContainer.repaint();
            panContainer.revalidate();
            
            panContainer.add(panDashboard);
            panContainer.repaint();
            panContainer.revalidate();
        }        
    }//GEN-LAST:event_homeButtonActionPerformed

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookButtonActionPerformed
        // TODO add your handling code here:
        if (panContainer.getComponentCount() == 0) {
            cambiarColorBotonesMenu(bookButton, "/resources/book-saved-black.png");
            panContainer.add(new panBiblioteca());
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount() == 1 && panContainer.getComponent(0) != new panBiblioteca()) {
            if (bookButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(bookButton, "/resources/book-saved-black.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panBiblioteca());
                panContainer.repaint();
                panContainer.revalidate();
            } else {
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }

        }
    }//GEN-LAST:event_bookButtonActionPerformed

    private void medalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medalButtonActionPerformed
        // TODO add your handling code here:
        if (panContainer.getComponentCount() == 0) {
            cambiarColorBotonesMenu(medalButton, "/resources/medal-black.png");
            panContainer.add(new panGrades(iddocente));
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount() == 1 && panContainer.getComponent(0) != new panGrades(iddocente)) {
            if (medalButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(medalButton, "/resources/medal-black.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panGrades(iddocente));
                panContainer.repaint();
                panContainer.revalidate();
            } else {
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }
        }
    }//GEN-LAST:event_medalButtonActionPerformed

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        // TODO add your handling code here:
        new frmUsers().setVisible(true);
    }//GEN-LAST:event_btnUsersActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        customization.mainUtilities();    
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDashboardTeacher().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound bookButton;
    private customizeObjects.ButtonRound briefcaseButton;
    private customizeObjects.ButtonRound btnStopMood;
    private customizeObjects.ButtonRound btnUsers;
    private customizeObjects.ButtonRound buttonRound2;
    private customizeObjects.ButtonRound buttonRound4;
    private javax.swing.JPanel buttonsPan;
    private customizeObjects.ButtonRound calendarButton;
    private customizeObjects.PanelRound calendarPanel;
    private javax.swing.JPanel downGap;
    private customizeObjects.PanelRound gradesPanel;
    private customizeObjects.ButtonRound homeButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JPanel mainPanel;
    private customizeObjects.ButtonRound medalButton;
    private customizeObjects.PanelRound moodPanel;
    private javax.swing.JLabel moodPic;
    private javax.swing.JPanel namePan;
    private customizeObjects.ButtonRound pageButton;
    private customizeObjects.PanelRound panBlack;
    private customizeObjects.PanelRound panContainer;
    private customizeObjects.PanelRound panDashboard;
    private customizeObjects.PanelRound panWhite;
    private customizeObjects.PanelRound panelRound1;
    private customizeObjects.PanelRound panelRound10;
    private customizeObjects.PanelRound panelRound11;
    private customizeObjects.PanelRound panelRound12;
    private customizeObjects.PanelRound panelRound13;
    private customizeObjects.PanelRound panelRound14;
    private customizeObjects.PanelRound panelRound2;
    private customizeObjects.PanelRound panelRound3;
    private customizeObjects.PanelRound panelRound4;
    private customizeObjects.PanelRound panelRound5;
    private customizeObjects.PanelRound panelRound6;
    private customizeObjects.PanelRound panelRound7;
    private customizeObjects.PanelRound panelRound8;
    private customizeObjects.PanelRound panelRound9;
    private customizeObjects.PanelRound primeraFila;
    private customizeObjects.PanelRound protfoliosPanel;
    private javax.swing.JPanel rightGap;
    private javax.swing.JPanel searchPan;
    private javax.swing.JTextField searchbar;
    private customizeObjects.PanelRound segundaFila;
    private javax.swing.JPanel sideBar;
    private customizeObjects.PanelRound stadisticPanel;
    private customizeObjects.ButtonRound studentsButton;
    private customizeObjects.PanelRound taskPanel;
    private customizeObjects.ButtonRound teachersButton;
    private javax.swing.JPanel upGap;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables
}
