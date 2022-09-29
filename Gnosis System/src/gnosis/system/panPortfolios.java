/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import Controller.CPortfolios;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author santi
 */
public class panPortfolios extends javax.swing.JPanel {

    /**
     * Creates new form frmBlocNotas
     */
    
    CPortfolios controlador = new CPortfolios();
    
    customization custo = new customization();
    public panPortfolios() {
        customization.mainUtilities();
        initComponents();
        CargarPortafolios();
    }
    
    final void CargarPortafolios(){
        CPortfolios controlador = new CPortfolios();
        ResultSet datos = controlador.CargarPortafolios();
        try {
            while (datos.next()) {                
                String materiamodulo;
                String cadena = datos.getString(6);
                String[] palabras = cadena.split(" ", 2);
                if (palabras[0].equals("Ninguno")) {
                    materiamodulo = palabras[1];
                } else {
                    materiamodulo = cadena.substring(0, cadena.lastIndexOf(" "));
                }
                custo.CrearPortafolio(materiamodulo, datos.getString(3), datos.getString(5), "44 páginas", contenendorPortafolios);
            }
        } catch (Exception e) {
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

        upperPan = new javax.swing.JPanel();
        namePan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filtersPan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        mainPan = new javax.swing.JPanel();
        scrollPortfolios = new javax.swing.JScrollPane();
        contenendorPortafolios = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        upperPan.setBackground(new java.awt.Color(255, 255, 255));
        upperPan.setPreferredSize(new java.awt.Dimension(766, 50));
        upperPan.setLayout(new javax.swing.BoxLayout(upperPan, javax.swing.BoxLayout.LINE_AXIS));

        namePan.setBackground(java.awt.Color.white);
        namePan.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Portafolio");
        namePan.add(jLabel1, java.awt.BorderLayout.CENTER);

        upperPan.add(namePan);

        filtersPan.setBackground(new java.awt.Color(255, 255, 255));
        filtersPan.setForeground(new java.awt.Color(32, 32, 32));
        filtersPan.setPreferredSize(new java.awt.Dimension(555, 50));
        filtersPan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 5));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setText(" Categoria:");
        filtersPan.add(jLabel2);

        jComboBox1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jComboBox1.setForeground(java.awt.Color.white);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(100, 30));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        filtersPan.add(jComboBox1);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 32, 32));
        jLabel3.setText("Ordenar:");
        filtersPan.add(jLabel3);

        jComboBox2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jComboBox2.setForeground(java.awt.Color.white);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox2.setPreferredSize(new java.awt.Dimension(100, 30));
        filtersPan.add(jComboBox2);

        upperPan.add(filtersPan);

        add(upperPan, java.awt.BorderLayout.NORTH);

        mainPan.setBackground(new java.awt.Color(255, 255, 255));
        mainPan.setPreferredSize(new java.awt.Dimension(800, 506));
        mainPan.setLayout(new java.awt.CardLayout());

        scrollPortfolios.setBackground(new java.awt.Color(217, 217, 217));
        scrollPortfolios.setBorder(null);
        scrollPortfolios.setForeground(new java.awt.Color(217, 217, 217));

        contenendorPortafolios.setBackground(java.awt.Color.white);
        contenendorPortafolios.setPreferredSize(new java.awt.Dimension(500, 900));
        contenendorPortafolios.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        scrollPortfolios.setViewportView(contenendorPortafolios);

        mainPan.add(scrollPortfolios, "card2");

        add(mainPan, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenendorPortafolios;
    private javax.swing.JPanel filtersPan;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel mainPan;
    private javax.swing.JPanel namePan;
    private javax.swing.JScrollPane scrollPortfolios;
    private javax.swing.JPanel upperPan;
    // End of variables declaration//GEN-END:variables
}
