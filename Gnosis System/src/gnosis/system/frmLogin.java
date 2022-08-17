/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JOptionPane;
import Controller.CConnection;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author santi
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    int xMouse;
    int yMouse;
    
    customization objCusto = new customization();
    
    public frmLogin() {
        initComponents();
        returnLogin.setVisible(false);
        returnConfig.setVisible(false);
        customization.centrarFrame(this);  
      
    }
    
    public void retornarPantallaPrincipal(){
        
        if (panConfig.retornarLogin() == true) {
            loginWhitePan.removeAll();
            loginWhitePan.repaint();
            loginWhitePan.revalidate();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainJPanel = new roundObjects.PanelRound();
        container = new roundObjects.PanelRound();
        LoginPanel = new roundObjects.PanelRound();
        bContainer = new roundObjects.PanelRound();
        btnLogin = new roundObjects.ButtonRound();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        buttonRound5 = new roundObjects.ButtonRound();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonRound4 = new roundObjects.ButtonRound();
        wContainer = new roundObjects.PanelRound();
        loginWhitePan = new roundObjects.PanelRound();
        topGap = new roundObjects.PanelRound();
        returnConfig = new roundObjects.ButtonRound();
        rightWGap = new roundObjects.PanelRound();
        leftWGap = new roundObjects.PanelRound();
        northGap = new roundObjects.PanelRound();
        menuBarPanel = new roundObjects.PanelRound();
        btnConnection = new roundObjects.ButtonRound();
        btnConfig = new roundObjects.ButtonRound();
        returnLogin = new roundObjects.ButtonRound();
        controlsPanel = new roundObjects.PanelRound();
        buttonRound1 = new roundObjects.ButtonRound();
        buttonRound3 = new roundObjects.ButtonRound();
        buttonRound2 = new roundObjects.ButtonRound();
        southGap = new roundObjects.PanelRound();
        rightGap = new roundObjects.PanelRound();
        leftGap = new roundObjects.PanelRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainJPanel.setBackground(new java.awt.Color(32, 32, 32));
        mainJPanel.setPreferredSize(new java.awt.Dimension(900, 600));
        mainJPanel.setRoundBottomLeft(25);
        mainJPanel.setRoundBottomRight(25);
        mainJPanel.setRoundTopLeft(25);
        mainJPanel.setRoundTopRight(25);
        mainJPanel.setLayout(new java.awt.BorderLayout());

        container.setBackground(new java.awt.Color(51, 204, 0));
        container.setLayout(new java.awt.CardLayout());

        LoginPanel.setBackground(new java.awt.Color(32, 32, 32));
        LoginPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING, 0, 5));

        bContainer.setBackground(new java.awt.Color(32, 32, 32));
        bContainer.setPreferredSize(new java.awt.Dimension(440, 550));
        bContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setText("Iniciar sesión");
        btnLogin.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        bContainer.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 131, 48));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Username:");
        bContainer.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        jTextField1.setPreferredSize(new java.awt.Dimension(150, 30));
        bContainer.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 228, -1));

        buttonRound5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/eye.png"))); // NOI18N
        buttonRound5.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound5.setRound(15);
        buttonRound5.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        buttonRound5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonRound5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonRound5MouseExited(evt);
            }
        });
        bContainer.add(buttonRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        txtPassword.setPreferredSize(new java.awt.Dimension(150, 30));
        bContainer.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 228, -1));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Password:");
        bContainer.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Poppins Black", 0, 48)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("GNOSIS");
        bContainer.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/brainLogin.png"))); // NOI18N
        bContainer.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        buttonRound4.setText("Olvidaste tu contraseña?");
        buttonRound4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        buttonRound4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonRound4.setRound(15);
        buttonRound4.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        buttonRound4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound4ActionPerformed(evt);
            }
        });
        bContainer.add(buttonRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 170, 30));

        LoginPanel.add(bContainer);

        wContainer.setBackground(new java.awt.Color(255, 255, 255));
        wContainer.setPreferredSize(new java.awt.Dimension(437, 550));
        wContainer.setRoundBottomLeft(25);
        wContainer.setRoundBottomRight(25);
        wContainer.setRoundTopLeft(25);
        wContainer.setRoundTopRight(25);
        wContainer.setLayout(new java.awt.BorderLayout());

        loginWhitePan.setBackground(new java.awt.Color(255, 255, 255));
        loginWhitePan.setToolTipText("");
        loginWhitePan.setPreferredSize(new java.awt.Dimension(420, 430));
        loginWhitePan.setLayout(new java.awt.CardLayout());
        wContainer.add(loginWhitePan, java.awt.BorderLayout.CENTER);

        topGap.setBackground(new java.awt.Color(255, 255, 255));
        topGap.setPreferredSize(new java.awt.Dimension(437, 40));
        topGap.setRoundTopLeft(10);
        topGap.setRoundTopRight(10);
        topGap.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        returnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-right.png"))); // NOI18N
        returnConfig.setPreferredSize(new java.awt.Dimension(30, 30));
        returnConfig.setRound(15);
        returnConfig.setStyle(roundObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        returnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnConfigActionPerformed(evt);
            }
        });
        topGap.add(returnConfig);

        wContainer.add(topGap, java.awt.BorderLayout.NORTH);

        rightWGap.setBackground(java.awt.Color.white);
        rightWGap.setPreferredSize(new java.awt.Dimension(10, 550));
        rightWGap.setRoundBottomRight(25);

        javax.swing.GroupLayout rightWGapLayout = new javax.swing.GroupLayout(rightWGap);
        rightWGap.setLayout(rightWGapLayout);
        rightWGapLayout.setHorizontalGroup(
            rightWGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        rightWGapLayout.setVerticalGroup(
            rightWGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        wContainer.add(rightWGap, java.awt.BorderLayout.EAST);

        leftWGap.setBackground(java.awt.Color.white);
        leftWGap.setPreferredSize(new java.awt.Dimension(10, 550));
        leftWGap.setRoundBottomLeft(25);

        javax.swing.GroupLayout leftWGapLayout = new javax.swing.GroupLayout(leftWGap);
        leftWGap.setLayout(leftWGapLayout);
        leftWGapLayout.setHorizontalGroup(
            leftWGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        leftWGapLayout.setVerticalGroup(
            leftWGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        wContainer.add(leftWGap, java.awt.BorderLayout.WEST);

        LoginPanel.add(wContainer);

        container.add(LoginPanel, "card2");

        mainJPanel.add(container, java.awt.BorderLayout.CENTER);

        northGap.setBackground(new java.awt.Color(32, 32, 32));
        northGap.setPreferredSize(new java.awt.Dimension(100, 25));
        northGap.setRoundTopLeft(25);
        northGap.setRoundTopRight(25);
        northGap.setLayout(new javax.swing.BoxLayout(northGap, javax.swing.BoxLayout.LINE_AXIS));

        menuBarPanel.setBackground(new java.awt.Color(32, 32, 32));
        menuBarPanel.setPreferredSize(new java.awt.Dimension(700, 20));
        menuBarPanel.setRoundTopLeft(15);
        menuBarPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuBarPanelMouseDragged(evt);
            }
        });
        menuBarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuBarPanelMousePressed(evt);
            }
        });
        menuBarPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 3));

        btnConnection.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnConnection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wifi-square-white.png"))); // NOI18N
        btnConnection.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnConnection.setPreferredSize(new java.awt.Dimension(30, 20));
        btnConnection.setRound(10);
        btnConnection.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        btnConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectionActionPerformed(evt);
            }
        });
        menuBarPanel.add(btnConnection);

        btnConfig.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/setting20x20-white.png"))); // NOI18N
        btnConfig.setToolTipText("Conexión");
        btnConfig.setMaximumSize(new java.awt.Dimension(95, 20));
        btnConfig.setMinimumSize(new java.awt.Dimension(95, 20));
        btnConfig.setPreferredSize(new java.awt.Dimension(30, 20));
        btnConfig.setRound(10);
        btnConfig.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });
        menuBarPanel.add(btnConfig);

        returnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-left.png"))); // NOI18N
        returnLogin.setText("Login");
        returnLogin.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        returnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        returnLogin.setIconTextGap(10);
        returnLogin.setPreferredSize(new java.awt.Dimension(100, 20));
        returnLogin.setRound(10);
        returnLogin.setStyle(roundObjects.ButtonRound.ButtonStyle.NEGRO);
        returnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnLoginActionPerformed(evt);
            }
        });
        menuBarPanel.add(returnLogin);

        northGap.add(menuBarPanel);

        controlsPanel.setBackground(new java.awt.Color(32, 32, 32));
        controlsPanel.setRoundBottomRight(15);
        controlsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        buttonRound1.setPreferredSize(new java.awt.Dimension(10, 10));
        buttonRound1.setRound(20);
        buttonRound1.setStyle(roundObjects.ButtonRound.ButtonStyle.VERDE);
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });
        controlsPanel.add(buttonRound1);

        buttonRound3.setPreferredSize(new java.awt.Dimension(10, 10));
        buttonRound3.setRound(20);
        buttonRound3.setStyle(roundObjects.ButtonRound.ButtonStyle.AMARILLO);
        buttonRound3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound3ActionPerformed(evt);
            }
        });
        controlsPanel.add(buttonRound3);

        buttonRound2.setPreferredSize(new java.awt.Dimension(10, 10));
        buttonRound2.setRound(20);
        buttonRound2.setStyle(roundObjects.ButtonRound.ButtonStyle.ROJO);
        buttonRound2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound2ActionPerformed(evt);
            }
        });
        controlsPanel.add(buttonRound2);

        northGap.add(controlsPanel);

        mainJPanel.add(northGap, java.awt.BorderLayout.PAGE_START);

        southGap.setBackground(new java.awt.Color(32, 32, 32));
        southGap.setPreferredSize(new java.awt.Dimension(100, 10));
        southGap.setRoundBottomLeft(25);
        southGap.setRoundBottomRight(25);

        javax.swing.GroupLayout southGapLayout = new javax.swing.GroupLayout(southGap);
        southGap.setLayout(southGapLayout);
        southGapLayout.setHorizontalGroup(
            southGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        southGapLayout.setVerticalGroup(
            southGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        mainJPanel.add(southGap, java.awt.BorderLayout.PAGE_END);

        rightGap.setBackground(new java.awt.Color(32, 32, 32));
        rightGap.setPreferredSize(new java.awt.Dimension(10, 100));

        javax.swing.GroupLayout rightGapLayout = new javax.swing.GroupLayout(rightGap);
        rightGap.setLayout(rightGapLayout);
        rightGapLayout.setHorizontalGroup(
            rightGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        rightGapLayout.setVerticalGroup(
            rightGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        mainJPanel.add(rightGap, java.awt.BorderLayout.LINE_END);

        leftGap.setBackground(new java.awt.Color(32, 32, 32));
        leftGap.setPreferredSize(new java.awt.Dimension(10, 100));

        javax.swing.GroupLayout leftGapLayout = new javax.swing.GroupLayout(leftGap);
        leftGap.setLayout(leftGapLayout);
        leftGapLayout.setHorizontalGroup(
            leftGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        leftGapLayout.setVerticalGroup(
            leftGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        mainJPanel.add(leftGap, java.awt.BorderLayout.LINE_START);

        getContentPane().add(mainJPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        // TODO add your handling code here:
        loginWhitePan.removeAll();
        loginWhitePan.repaint();
        loginWhitePan.revalidate();

        loginWhitePan.add(new panConfig());
        loginWhitePan.repaint();
        loginWhitePan.revalidate(); 
        returnConfig.setVisible(true);
    }//GEN-LAST:event_btnConfigActionPerformed

    private void buttonRound2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_buttonRound2ActionPerformed

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        // TODO add your handling code here:
        this.setState(frmLogin.ICONIFIED);
    }//GEN-LAST:event_buttonRound1ActionPerformed

    private void menuBarPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBarPanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_menuBarPanelMouseDragged

    private void menuBarPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBarPanelMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
        
    }//GEN-LAST:event_menuBarPanelMousePressed

    private void buttonRound3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound3ActionPerformed
        // TODO add your handling code here:
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }//GEN-LAST:event_buttonRound3ActionPerformed

    private void returnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnConfigActionPerformed
        // TODO add your handling code here:
        loginWhitePan.removeAll();
        loginWhitePan.repaint();
        loginWhitePan.revalidate();
        returnConfig.setVisible(false);
    }//GEN-LAST:event_returnConfigActionPerformed

    private void btnConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectionActionPerformed
//         TODO add your handling code here:
        if (CConnection.getConnectionControllerWithoutParameters() == null) {
            JOptionPane.showMessageDialog(null, "Cagaste");
        }else{
            customization.notificacion("Conexión establecida exitosamente", 1, "Conexión");
        }
        

    }//GEN-LAST:event_btnConnectionActionPerformed

    private void buttonRound5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRound5MouseEntered
        // TODO add your handling code here:
        txtPassword.setEchoChar((char)0);  
    }//GEN-LAST:event_buttonRound5MouseEntered

    private void buttonRound5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRound5MouseExited
        // TODO add your handling code here:
        txtPassword.setEchoChar('*');
    }//GEN-LAST:event_buttonRound5MouseExited

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        new frmDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void buttonRound4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound4ActionPerformed
        // TODO add your handling code here:
        LoginPanel.removeAll();
        LoginPanel.add(new panPasswordRecover());
        LoginPanel.repaint();
        LoginPanel.revalidate();
        btnConfig.setVisible(false);
        btnConnection.setVisible(false);
        returnLogin.setVisible(true);
        northGap.setSize(100, 40);

    }//GEN-LAST:event_buttonRound4ActionPerformed

    private void returnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnLoginActionPerformed
        // TODO add your handling code here:
        LoginPanel.removeAll();
        LoginPanel.repaint();
        LoginPanel.revalidate();
        
        LoginPanel.add(bContainer);
        LoginPanel.add(wContainer);
        
        btnConfig.setVisible(true);
        btnConnection.setVisible(true);
        returnLogin.setVisible(false);
        
    }//GEN-LAST:event_returnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        customization.mainUtilities();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private roundObjects.PanelRound LoginPanel;
    private roundObjects.PanelRound bContainer;
    private roundObjects.ButtonRound btnConfig;
    private roundObjects.ButtonRound btnConnection;
    private roundObjects.ButtonRound btnLogin;
    private roundObjects.ButtonRound buttonRound1;
    private roundObjects.ButtonRound buttonRound2;
    private roundObjects.ButtonRound buttonRound3;
    private roundObjects.ButtonRound buttonRound4;
    private roundObjects.ButtonRound buttonRound5;
    private roundObjects.PanelRound container;
    private roundObjects.PanelRound controlsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private roundObjects.PanelRound leftGap;
    private roundObjects.PanelRound leftWGap;
    private roundObjects.PanelRound loginWhitePan;
    private roundObjects.PanelRound mainJPanel;
    private roundObjects.PanelRound menuBarPanel;
    private roundObjects.PanelRound northGap;
    private roundObjects.ButtonRound returnConfig;
    private roundObjects.ButtonRound returnLogin;
    private roundObjects.PanelRound rightGap;
    private roundObjects.PanelRound rightWGap;
    private roundObjects.PanelRound southGap;
    private roundObjects.PanelRound topGap;
    private javax.swing.JPasswordField txtPassword;
    private roundObjects.PanelRound wContainer;
    // End of variables declaration//GEN-END:variables
}
