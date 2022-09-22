/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import Controller.CBiblioteca;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author santi1
 */
public class panBiblioteca extends javax.swing.JPanel {

    /**
     * Creates new form frmBiblioteca
     */
    customization custoObj = new customization();
    int idAlumno;
    
    public panBiblioteca() {
        initComponents();
//        custoObj.CrearRecursoBiblioteca("Clase 24 Matemáticas | Trigonometría", "PDF", "Clase", mainPanel);
        CargarRecursos();
    }
    
    public panBiblioteca(int idalumno) {
        initComponents();
        idAlumno = idalumno;
//        custoObj.CrearRecursoBiblioteca("Clase 24 Matemáticas | Trigonometría", "PDF", "Clase", mainPanel);
        CargarRecursos();
//        custoObj.CrearPostulantes("Kevin","Disponible", mainPanel);
    }
    
     final void CargarRecursosFiltro(){
        String categoria = (String) cmbOrden.getSelectedItem();
        CBiblioteca controlador = new CBiblioteca();
        ResultSet datosrecursos = controlador.CargarBusquedaFiltro(categoria);
        try {
            while (datosrecursos.next()) {                
                 custoObj.CrearRecursoBiblioteca(datosrecursos.getString(1), datosrecursos.getString(2),datosrecursos.getString(3), mainPanel, datosrecursos.getString(4));                
            }         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los recursos" + e.toString());
        }
    }
    
     final void CargarRecursosFiltroClas(){
        String categoria = (String) cmbCategoria.getSelectedItem();
        CBiblioteca controlador = new CBiblioteca();
        ResultSet datosrecursos = controlador.CargarBusquedaFiltroClas(categoria);
        try {
            while (datosrecursos.next()) {                
                 custoObj.CrearRecursoBiblioteca(datosrecursos.getString(1), datosrecursos.getString(2),datosrecursos.getString(3), mainPanel, datosrecursos.getString(4));                
            }         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los recursos" + e.toString());
        }
    }
     
    final void CargarRecursos(){
        CBiblioteca controlador = new CBiblioteca();
        ResultSet datosrecursos = controlador.CargarRecursosVista(idAlumno);
        try {
            while (datosrecursos.next()) {                
                 custoObj.CrearRecursoBiblioteca(datosrecursos.getString(1), datosrecursos.getString(2),datosrecursos.getString(3), mainPanel, datosrecursos.getString(4));                
            }         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los recursos" + e.toString());
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

        northPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbOrden = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        buttonRound1 = new customizeObjects.ButtonRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setBackground(java.awt.Color.white);
        setLayout(new java.awt.BorderLayout());

        northPanel.setBackground(java.awt.Color.white);
        northPanel.setPreferredSize(new java.awt.Dimension(806, 50));
        northPanel.setLayout(new javax.swing.BoxLayout(northPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Biblioteca");
        jPanel4.add(jLabel1, java.awt.BorderLayout.CENTER);

        northPanel.add(jPanel4);

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setPreferredSize(new java.awt.Dimension(600, 100));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(2, 10, 10);
        flowLayout1.setAlignOnBaseline(true);
        jPanel5.setLayout(flowLayout1);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Categoria:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel5.add(jLabel2);

        cmbOrden.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        cmbOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PDF", "Link" }));
        cmbOrden.setPreferredSize(new java.awt.Dimension(100, 30));
        cmbOrden.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOrdenItemStateChanged(evt);
            }
        });
        cmbOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrdenActionPerformed(evt);
            }
        });
        jPanel5.add(cmbOrden);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 32, 32));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ordenar:");
        jLabel3.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel5.add(jLabel3);

        cmbCategoria.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Presentación", "Clase", " " }));
        cmbCategoria.setPreferredSize(new java.awt.Dimension(100, 30));
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });
        jPanel5.add(cmbCategoria);

        buttonRound1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonRound1.setText("Gestionar Recursos");
        buttonRound1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        buttonRound1.setPreferredSize(new java.awt.Dimension(150, 30));
        buttonRound1.setRound(15);
        buttonRound1.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });
        jPanel5.add(buttonRound1);

        northPanel.add(jPanel5);

        add(northPanel, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBackground(java.awt.Color.white);
        jScrollPane1.setBorder(null);

        mainPanel.setBackground(java.awt.Color.white);
        mainPanel.setPreferredSize(new java.awt.Dimension(900, 950));
        mainPanel.setLayout(new java.awt.FlowLayout(0));
        jScrollPane1.setViewportView(mainPanel);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        // TODO add your handling code here:
         new frmBiblioteca().setVisible(true);
         
    }//GEN-LAST:event_buttonRound1ActionPerformed

    private void cmbOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrdenActionPerformed

    private void cmbOrdenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOrdenItemStateChanged
        // TODO add your handling code here:
        CargarRecursosFiltro();
    }//GEN-LAST:event_cmbOrdenItemStateChanged

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        // TODO add your handling code here:
        CargarRecursosFiltroClas();
    }//GEN-LAST:event_cmbCategoriaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound buttonRound1;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel northPanel;
    // End of variables declaration//GEN-END:variables
}
