/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gnosis.system;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import customizeObjects.PanelRound;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.UIManager;

/**
 *
 * @author santi
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class panCalendar extends javax.swing.JPanel {

    /**
     * Creates new form panCalendar
     */
    
    public String fechainicio;
    public String fechafinal;
    
    customization custo = new customization();
    
    
    public panCalendar() {
        initComponents();
        dtpFechaFinal.setVisible(false);
//        custo.CrearComponenteEventos(ContenedorEventos);


         new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd/MMMM/yyyy");
                    String time = tf.format(date);
                    lblTime.setText(time.split(" ")[0]);
                    lblType.setText(time.split(" ")[1]);
                    lblDate.setText(df.format(date));
                }                  
            }
        }).start();
        
        
        try {
            UIManager.setLookAndFeel(new FlatArcIJTheme());           
        } catch (Exception e) {
            e.printStackTrace();
        }
        UIManager.put( "Component.focusWidth", 0 );
        UIManager.put( "Component.innerFocusWidth",0 );
        UIManager.put( "TextComponent.arc", 15);
        UIManager.put( "Component.arc", 15);
        UIManager.put( "ProgressBar.arc", 20);
        UIManager.put( "ScrollBar.trackArc", 999 );
        UIManager.put( "ScrollBar.thumbArc", 999 );
        UIManager.put( "ScrollBar.trackInsets", new Insets( 2, 4, 2, 4 ) );
        UIManager.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
        UIManager.put( "Component.arrowType", "chevron" );     
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonRound2 = new customizeObjects.ButtonRound();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        calendarCustom2 = new customizeObjects.CalendarCustom();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dtpFechaInicio = new com.github.lgooddatepicker.components.DateTimePicker();
        buttonRound1 = new customizeObjects.ButtonRound();
        btnBuscar = new customizeObjects.ButtonRound();
        dtpFechaFinal = new com.github.lgooddatepicker.components.DateTimePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        ContenedorEventos = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Calendario");
        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));

        buttonRound2.setText("Gestionar Eventos");
        buttonRound2.setRound(20);
        buttonRound2.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_ROJO);
        buttonRound2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
                .addComponent(buttonRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setLayout(new java.awt.BorderLayout(10, 0));

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(32, 32, 32));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 150));

        lblDate.setText("jLabel2");
        lblDate.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));

        lblType.setText("jLabel3");
        lblType.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        lblType.setForeground(new java.awt.Color(255, 255, 255));

        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("jLabel4");
        lblTime.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(lblDate))
                .addGap(28, 28, 28)
                .addComponent(lblTime)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel4.add(calendarCustom2, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4, java.awt.BorderLayout.EAST);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout(0, 10));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Rango de fechas de:");
        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 32, 32));

        dtpFechaInicio.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        buttonRound1.setText("Rango de Fechas");
        buttonRound1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        buttonRound1.setPreferredSize(new java.awt.Dimension(150, 30));
        buttonRound1.setRound(20);
        buttonRound1.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnBuscar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnBuscar.setRound(20);
        btnBuscar.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        dtpFechaFinal.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtpFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtpFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        ContenedorEventos.setBackground(java.awt.Color.white);
        ContenedorEventos.setPreferredSize(new java.awt.Dimension(100, 700));
        ContenedorEventos.setLayout(new java.awt.GridLayout(10, 1, 10, 10));
        jScrollPane1.setViewportView(ContenedorEventos);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        fechainicio = dtpFechaInicio.getDatePicker().toString();
        fechafinal = dtpFechaFinal.getDatePicker().toString();
        System.out.println(fechainicio + " - " + fechafinal);
        if (fechainicio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha para buscar los eventos de la misma");
        }
        custo.CrearComponenteEventos(fechainicio, fechafinal, fechainicio, fechafinal, ContenedorEventos);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void buttonRound2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound2ActionPerformed
        // TODO add your handling code here:
        new frmEvento().setVisible(true);
    }//GEN-LAST:event_buttonRound2ActionPerformed

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        // TODO add your handling code here:
        dtpFechaFinal.setVisible(true);
    }//GEN-LAST:event_buttonRound1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContenedorEventos;
    private customizeObjects.ButtonRound btnBuscar;
    private customizeObjects.ButtonRound buttonRound1;
    private customizeObjects.ButtonRound buttonRound2;
    private customizeObjects.CalendarCustom calendarCustom2;
    private com.github.lgooddatepicker.components.DateTimePicker dtpFechaFinal;
    private com.github.lgooddatepicker.components.DateTimePicker dtpFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblType;
    // End of variables declaration//GEN-END:variables
}
