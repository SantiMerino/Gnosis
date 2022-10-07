/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import Controller.CLogin;
import Controller.CTasks;
import java.awt.*;
import customizeObjects.ButtonRound;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    int iduserlog;
    String usernamelog;
       
    public customization custo = new customization();
    panGrades grades = new panGrades(iddocente);
    CLogin log = new CLogin();
    
    public frmDashboardTeacher() {
        customization.mainUtilities();
        initComponents();
        moodPanel.setVisible(false);
        
    }

    public frmDashboardTeacher(ResultSet datosusuario) {
        customization.mainUtilities();
        initComponents();
        
        try {
            iduserlog = datosusuario.getInt(1);
            usernamelog = datosusuario.getString(3);
            niveluser = datosusuario.getInt(2);
            iddocente = datosusuario.getInt(8);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos del docente " + ex.toString());
        }
       
        btnUsers.setVisible(false);
        lblDashboard.setText(usernamelog + "'s Dashboard");
        moodPanel.setVisible(false);
        teachersButton.setVisible(false);
        studentsButton.setVisible(false);
        if (this.niveluser == 3) {
            teachersButton.setVisible(true);
            studentsButton.setVisible(true);
            medalButton.setVisible(false);
            pageButton.setVisible(false);
            briefcaseButton.setVisible(false);
            calendarButton.setVisible(false);
            bookButton.setVisible(false);
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
        custo.changeIcon(homeButton, "/resources/home.png");
        calendarButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(calendarButton, "/resources/calendar.png");
        briefcaseButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(briefcaseButton, "/resources/briefcase.png");
        pageButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(pageButton, "/resources/document-text.png");
        teachersButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(teachersButton, "/resources/admindocente.png");
        studentsButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(studentsButton, "/resources/teacher-white.png");
        medalButton.setStyle(ButtonRound.ButtonStyle.NEGRO);
        custo.changeIcon(medalButton, "/resources/medal.png");
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
        lblDashboard = new javax.swing.JLabel();
        buttonsPan = new javax.swing.JPanel();
        buttonRound2 = new customizeObjects.ButtonRound();
        mainPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        buttonRound1 = new customizeObjects.ButtonRound();

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

        buttonsPan.setBackground(new java.awt.Color(255, 255, 255));
        buttonsPan.setPreferredSize(new java.awt.Dimension(300, 100));
        buttonsPan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 7, 5));

        buttonRound2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/calculator.png"))); // NOI18N
        buttonRound2.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonRound2.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        buttonsPan.add(buttonRound2);

        upperPanel.add(buttonsPan, java.awt.BorderLayout.EAST);

        panDashboard.add(upperPanel, java.awt.BorderLayout.NORTH);

        mainPanel.setBackground(java.awt.Color.white);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/brainLogin.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Poppins Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido!");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(437, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(292, Short.MAX_VALUE))
        );

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

        buttonRound1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logout.png"))); // NOI18N
        buttonRound1.setPreferredSize(new java.awt.Dimension(60, 60));
        buttonRound1.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });
        sideBar.add(buttonRound1);

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
        new frmUsers(iduserlog).setVisible(true);
    }//GEN-LAST:event_btnUsersActionPerformed

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        // TODO add your handling code here:
        frmLogin login = new frmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonRound1ActionPerformed

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
    private customizeObjects.ButtonRound buttonRound1;
    private customizeObjects.ButtonRound buttonRound2;
    private javax.swing.JPanel buttonsPan;
    private customizeObjects.ButtonRound calendarButton;
    private javax.swing.JPanel downGap;
    private customizeObjects.ButtonRound homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
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
    private customizeObjects.PanelRound panelRound4;
    private customizeObjects.PanelRound panelRound5;
    private customizeObjects.PanelRound panelRound6;
    private customizeObjects.PanelRound panelRound7;
    private javax.swing.JPanel rightGap;
    private javax.swing.JPanel sideBar;
    private customizeObjects.ButtonRound studentsButton;
    private customizeObjects.ButtonRound teachersButton;
    private javax.swing.JPanel upGap;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables
}
