/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package customizeObjects;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class Pruebas extends javax.swing.JFrame {

    /**
     * Creates new form pruebamieda
     */
    Timer timerP;
    TimerTask taskP;
    int minutos;
    int segundos;
    public Pruebas() {
        initComponents();
    }

    public void Pomodoro() {
        minutos = 20;
        segundos = 0;
        timerP = new Timer();
        taskP = new TimerTask() {
            @Override
            public void run() {
                if (minutos == 0 && segundos == 0) {
                    timerP.cancel();
                    JOptionPane.showMessageDialog(null, "Descansito");
                    Descanso();
                } else {
                    if (segundos > 0) {
                        segundos--;
                    } else if (segundos == 0) {
                        minutos--;
                        segundos = 59;
                    }
                    if (minutos < 10 && segundos < 10) {
                        lblContador.setText("0" + minutos + " : 0" + segundos);
                    } else if (minutos < 10) {
                        lblContador.setText("0" + minutos + " : " + segundos);
                    } else if (segundos < 10) {
                        lblContador.setText(minutos + " : 0" + segundos);
                    } else {
                        lblContador.setText(minutos + " : " + segundos);
                    }
                }
            }
        };
        timerP.scheduleAtFixedRate(taskP, 0, 1000);
    }
    
    public void Descanso(){
        minutos = 5;
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
                        System.out.println("Adios");
                    }
                } else{ 
                    if (segundos > 0) {
                        segundos--;
                    } else if (segundos == 0) {
                        minutos--;
                        segundos = 59;
                    }
                    if (minutos < 10 && segundos < 10) {
                        lblContador.setText("0" + minutos + " : 0" + segundos);
                    } else if (minutos < 10) {
                        lblContador.setText("0" + minutos + " : " + segundos);
                    } else if (segundos < 10) {
                        lblContador.setText(minutos + " : 0" + segundos);
                    } else {
                        lblContador.setText(minutos + " : " + segundos);
                    }
                }
            }
        };
        timerP.scheduleAtFixedRate(taskP, 0, 1000);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblContador = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblContador.setText("00:00");

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Stop");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContador, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(lblContador, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Pomodoro();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        timerP.cancel();
        taskP.cancel();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pruebas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblContador;
    // End of variables declaration//GEN-END:variables
}
