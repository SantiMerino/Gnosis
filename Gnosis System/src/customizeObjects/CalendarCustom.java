/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package customizeObjects;

import Controller.CEvento;
import java.awt.Component;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class CalendarCustom extends javax.swing.JPanel {

    /**
     * Creates new form CalendarCustom
     */
    private int month;
    private int year;
    private String fechaseleccionada;

    public String getFechaseleccionada() {
        return fechaseleccionada;
    }

    public void setFechaseleccionada(String fechaseleccionada) {
        this.fechaseleccionada = fechaseleccionada;
    }
    
    public int daySelec;

    public CalendarCustom(String fechadeHOY) {
        this.fechaseleccionada = fechadeHOY;
    }
    
    CEvento controladorCEvento = new CEvento();
    
    
    public CalendarCustom() {
        initComponents();
        thisMonth();
        slide.show(new PanelDate( 9, 2022), PanelSlide.AnimateType.TO_RIGHT);
        showMonthYear();
        Dimension dim = getSize();
        setSize(dim);
//        DateSelecFromParent();
        
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
    }
   
    //tengo que hacer que este metodo sea el trigger del controlador que vaya al modelo y retorne un result que luego tengo que usar para crear los eventos a la par del calendario, creando un panel y un dos labels con codigo y luego ejecutandolo las veces que que el result set .next() :P
    public void SetearTexto(String fecha) throws ParseException, SQLException{
//        CrearElemntos(fecha);
        SimpleDateFormat format = new SimpleDateFormat(fecha);
        Date date1 = format.parse(fecha);
        System.out.println(date1 + "  Cambio de formato " + fecha);
        ResultSet rs = controladorCEvento.ConsultarEvento(date1);
        while (rs.next()) {            
            System.out.println("Eventos: " + rs.getString(1) + " Tipo:" + rs.getString(2));
             CrearElemntos(rs.getString(1), rs.getString(2));
        }
    }
    
    
    public void CrearElemntos(String nombre,String tipo){
        //Craer Panel
        PanelRound newpanel = new PanelRound();
        newpanel.setBackground(Color.blue);
        newpanel.setPreferredSize(new Dimension(150, 50));
        
        //Labels
        JLabel newlabel = new JLabel(nombre);
        newlabel.setForeground(Color.WHITE);
        newlabel.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel newlabel2 = new JLabel(tipo);
        newlabel2.setForeground(Color.WHITE);
        newlabel2.setHorizontalAlignment(JLabel.CENTER);
        newlabel2.setPreferredSize(new Dimension(100, 20));
        
        newpanel.add(BorderLayout.CENTER,newlabel);
        newpanel.add(BorderLayout.SOUTH,newlabel2);
        panelEventos.add(newpanel);
        panelEventos.repaint();
        panelEventos.revalidate();
        
        
    }
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        panelEventos = new javax.swing.JPanel();
        Calendario = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnNext = new customizeObjects.ButtonRound();
        btnBack = new customizeObjects.ButtonRound();
        lblMesAño = new javax.swing.JLabel();
        slide = new customizeObjects.PanelSlide();

        setBackground(java.awt.Color.white);
        setLayout(new java.awt.BorderLayout());

        panelSuperior.setBackground(new java.awt.Color(255, 255, 255));
        panelSuperior.setForeground(new java.awt.Color(255, 255, 255));
        panelSuperior.setPreferredSize(new java.awt.Dimension(100, 60));
        panelSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Calendario");
        panelSuperior.add(jLabel1);

        lblTime.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(32, 32, 32));
        lblTime.setText("TIME");
        panelSuperior.add(lblTime);

        lblType.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblType.setForeground(new java.awt.Color(32, 32, 32));
        lblType.setText("type");
        panelSuperior.add(lblType);

        lblDate.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(32, 32, 32));
        lblDate.setText("DATE");
        panelSuperior.add(lblDate);

        add(panelSuperior, java.awt.BorderLayout.PAGE_START);

        panelEventos.setBackground(new java.awt.Color(255, 255, 255));
        panelEventos.setPreferredSize(new java.awt.Dimension(300, 448));

        javax.swing.GroupLayout panelEventosLayout = new javax.swing.GroupLayout(panelEventos);
        panelEventos.setLayout(panelEventosLayout);
        panelEventosLayout.setHorizontalGroup(
            panelEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        panelEventosLayout.setVerticalGroup(
            panelEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        add(panelEventos, java.awt.BorderLayout.EAST);

        Calendario.setBackground(new java.awt.Color(32, 32, 32));
        Calendario.setPreferredSize(new java.awt.Dimension(200, 200));
        Calendario.setLayout(new java.awt.BorderLayout());

        jLayeredPane1.setBackground(new java.awt.Color(32, 32, 32));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setLayout(new java.awt.BorderLayout());

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-right-x30.png"))); // NOI18N
        btnNext.setPreferredSize(new java.awt.Dimension(35, 35));
        btnNext.setRound(15);
        btnNext.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnNext, java.awt.BorderLayout.EAST);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-let-x30.png"))); // NOI18N
        btnBack.setPreferredSize(new java.awt.Dimension(35, 35));
        btnBack.setRound(15);
        btnBack.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnBack, java.awt.BorderLayout.WEST);

        lblMesAño.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblMesAño.setForeground(new java.awt.Color(255, 255, 255));
        lblMesAño.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMesAño.setText("Mes - Año");
        lblMesAño.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMesAño.setPreferredSize(new java.awt.Dimension(129, 50));
        jLayeredPane1.add(lblMesAño, java.awt.BorderLayout.CENTER);

        Calendario.add(jLayeredPane1, java.awt.BorderLayout.NORTH);

        slide.setBackground(new java.awt.Color(32, 32, 32));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Calendario.add(slide, java.awt.BorderLayout.CENTER);

        add(Calendario, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        if (month == 1) {
            month = 12;
            year--;
        } else{
            month--;
        }
        slide.show(new PanelDate(month, year), PanelSlide.AnimateType.TO_RIGHT);
        showMonthYear();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (month == 12) {
            month = 1;
            year++;
        } else{
            month++;
        }
        slide.show(new PanelDate(month, year), PanelSlide.AnimateType.TO_LEFT);
        showMonthYear();
    }//GEN-LAST:event_btnNextActionPerformed

    private void thisMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        month = calendar.get(Calendar.MONTH) +1;
        year = calendar.get(Calendar.YEAR);
    }
    
    private void showMonthYear(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("MMMM-yyyy");
        lblMesAño.setText(df.format(calendar.getTime()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Calendario;
    private customizeObjects.ButtonRound btnBack;
    private customizeObjects.ButtonRound btnNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMesAño;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblType;
    private javax.swing.JPanel panelEventos;
    private javax.swing.JPanel panelSuperior;
    private customizeObjects.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
