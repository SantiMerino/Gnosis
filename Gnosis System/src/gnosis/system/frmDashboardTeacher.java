/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import java.awt.*;
import roundObjects.ButtonRound;

/**
 *
 * @author santi
 */
public class frmDashboardTeacher extends javax.swing.JFrame {

    /**
     * Creates new form frmDashboard
     */
    public customization custoObj = new customization();
    panGrades grades = new panGrades();
    
    public frmDashboardTeacher() {
        initComponents();
        moodPanel.setVisible(false);
        searchbar.putClientProperty("innerFocusWidth", 0);
        searchbar.putClientProperty("focusWidth", 0);
        
    }
    
    public void notificacion(String mensaje,int tipo_mensaje, String tipo_men){
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

        panBlack = new roundObjects.PanelRound();
        panWhite = new roundObjects.PanelRound();
        panContainer = new roundObjects.PanelRound();
        panDashboard = new roundObjects.PanelRound();
        mainPanel = new javax.swing.JPanel();
        upperPanel = new javax.swing.JPanel();
        namePan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchPan = new javax.swing.JPanel();
        panelRound1 = new roundObjects.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        buttonsPan = new javax.swing.JPanel();
        buttonRound2 = new roundObjects.ButtonRound();
        btnMood = new roundObjects.ButtonRound();
        panelRound2 = new roundObjects.PanelRound();
        jComboBox1 = new javax.swing.JComboBox<>();
        buttonRound4 = new roundObjects.ButtonRound();
        panelRound4 = new roundObjects.PanelRound();
        panelRound5 = new roundObjects.PanelRound();
        panelRound6 = new roundObjects.PanelRound();
        panelRound7 = new roundObjects.PanelRound();
        upGap = new javax.swing.JPanel();
        downGap = new javax.swing.JPanel();
        rightGap = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        homeButton = new roundObjects.ButtonRound();
        briefcaseButton = new roundObjects.ButtonRound();
        pageButton = new roundObjects.ButtonRound();
        calendarButton = new roundObjects.ButtonRound();
        studentsButton = new roundObjects.ButtonRound();
        teachersButton = new roundObjects.ButtonRound();
        moodPanel = new roundObjects.PanelRound();
        moodPic = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnStopMood = new roundObjects.ButtonRound();
        buttonRound1 = new roundObjects.ButtonRound();

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

        mainPanel.setBackground(java.awt.Color.white);
        panDashboard.add(mainPanel, java.awt.BorderLayout.CENTER);

        upperPanel.setBackground(java.awt.Color.white);
        upperPanel.setPreferredSize(new java.awt.Dimension(100, 50));
        upperPanel.setLayout(new java.awt.BorderLayout());

        namePan.setBackground(new java.awt.Color(255, 255, 255));
        namePan.setPreferredSize(new java.awt.Dimension(300, 100));
        namePan.setLayout(new javax.swing.BoxLayout(namePan, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Santi's Dashboard");
        namePan.add(jLabel1);

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
        buttonRound2.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        buttonsPan.add(buttonRound2);

        btnMood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N
        btnMood.setPreferredSize(new java.awt.Dimension(40, 40));
        btnMood.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
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
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(23, 26));
        panelRound2.add(jComboBox1);

        buttonRound4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user-square.png"))); // NOI18N
        buttonRound4.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonRound4.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        panelRound2.add(buttonRound4);

        buttonsPan.add(panelRound2);

        upperPanel.add(buttonsPan, java.awt.BorderLayout.EAST);

        panDashboard.add(upperPanel, java.awt.BorderLayout.NORTH);

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
        briefcaseButton.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        briefcaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                briefcaseButtonActionPerformed(evt);
            }
        });
        sideBar.add(briefcaseButton);

        pageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/document-text.png"))); // NOI18N
        pageButton.setPreferredSize(new java.awt.Dimension(60, 60));
        pageButton.setRound(15);
        pageButton.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        pageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageButtonActionPerformed(evt);
            }
        });
        sideBar.add(pageButton);

        calendarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/calendar.png"))); // NOI18N
        calendarButton.setPreferredSize(new java.awt.Dimension(60, 60));
        calendarButton.setRound(15);
        calendarButton.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        calendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarButtonActionPerformed(evt);
            }
        });
        sideBar.add(calendarButton);

        studentsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/teacher-white.png"))); // NOI18N
        studentsButton.setPreferredSize(new java.awt.Dimension(60, 60));
        studentsButton.setRound(15);
        studentsButton.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        studentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsButtonActionPerformed(evt);
            }
        });
        sideBar.add(studentsButton);

        teachersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/admindocente.png"))); // NOI18N
        teachersButton.setPreferredSize(new java.awt.Dimension(60, 60));
        teachersButton.setRound(15);
        teachersButton.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        teachersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teachersButtonActionPerformed(evt);
            }
        });
        sideBar.add(teachersButton);

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
        btnStopMood.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        moodPanel.add(btnStopMood);

        sideBar.add(moodPanel);

        buttonRound1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/setting-2.png"))); // NOI18N
        buttonRound1.setPreferredSize(new java.awt.Dimension(60, 60));
        buttonRound1.setRound(15);
        buttonRound1.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
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
            cambiarColorBotonesMenu(briefcaseButton, "/resources/home-selec.png");
        //Agrego el panel que corresponde
            panContainer.add(new panTasks());
            panContainer.repaint();
            panContainer.revalidate();
        //Si el componentCount es 1 es que uno esta abierto
        } else if (panContainer.getComponentCount()== 1 ) {
            // Si el estilo/color del boton es negro significa que el panel abierto no pertenece al boton
            if (briefcaseButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
            //Remuevo el panel abierto y agrego el panel correspondiente al boton
            cambiarColorBotonesMenu(briefcaseButton, "/resources/home-selec.png");
            panContainer.removeAll();
            panContainer.repaint();
            panContainer.revalidate();

            panContainer.add(new panTasks());
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
            cambiarColorBotonesMenu(pageButton, "/resources/home-selec.png");
            panContainer.add(new panBlocNotas());
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount()== 1 && panContainer.getComponent(0) != new panBlocNotas()) {
            if (pageButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(pageButton, "/resources/home-selec.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panBlocNotas());
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
            cambiarColorBotonesMenu(calendarButton, "/resources/home-selec.png");
            panContainer.add(new panCalendar());
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount()== 1 && panContainer.getComponent(0) != new panCalendar()) {
            if (calendarButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(calendarButton, "/resources/home-selec.png");
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
            panContainer.add(new frmStudentsCRUD());
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount()== 1 && panContainer.getComponent(0) != new frmStudentsCRUD()) {
            if (studentsButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(studentsButton, "/resources/teacher.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new frmStudentsCRUD());
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
            panContainer.add(new panGrades());
            panContainer.repaint();
            panContainer.revalidate();
        } else if (panContainer.getComponentCount()== 1 && panContainer.getComponent(0) != new panGrades()) {
                    if (teachersButton.getStyle() == ButtonRound.ButtonStyle.NEGRO) {
                cambiarColorBotonesMenu(teachersButton, "/resources/admindocente-black.png");
                panContainer.removeAll();
                panContainer.repaint();
                panContainer.revalidate();

                panContainer.add(new panGrades());
                panContainer.repaint();
                panContainer.revalidate();
            } else{ 
                notificacion("Ya tienes abierta esta ventana", 2, "Menu abierto");
            }  
        }
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

    private void btnMoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoodActionPerformed
        // TODO add your handling code here:
        frmMood mood = new frmMood();
        mood.setVisible(true);
        this.setState(Frame.ICONIFIED);  
        frmMood objmood = new frmMood();
    }//GEN-LAST:event_btnMoodActionPerformed

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
    private roundObjects.ButtonRound briefcaseButton;
    private roundObjects.ButtonRound btnMood;
    private roundObjects.ButtonRound btnStopMood;
    private roundObjects.ButtonRound buttonRound1;
    private roundObjects.ButtonRound buttonRound2;
    private roundObjects.ButtonRound buttonRound4;
    private javax.swing.JPanel buttonsPan;
    private roundObjects.ButtonRound calendarButton;
    private javax.swing.JPanel downGap;
    private roundObjects.ButtonRound homeButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel mainPanel;
    private roundObjects.PanelRound moodPanel;
    private javax.swing.JLabel moodPic;
    private javax.swing.JPanel namePan;
    private roundObjects.ButtonRound pageButton;
    private roundObjects.PanelRound panBlack;
    private roundObjects.PanelRound panContainer;
    private roundObjects.PanelRound panDashboard;
    private roundObjects.PanelRound panWhite;
    private roundObjects.PanelRound panelRound1;
    private roundObjects.PanelRound panelRound2;
    private roundObjects.PanelRound panelRound4;
    private roundObjects.PanelRound panelRound5;
    private roundObjects.PanelRound panelRound6;
    private roundObjects.PanelRound panelRound7;
    private javax.swing.JPanel rightGap;
    private javax.swing.JPanel searchPan;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel sideBar;
    private roundObjects.ButtonRound studentsButton;
    private roundObjects.ButtonRound teachersButton;
    private javax.swing.JPanel upGap;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables
}
