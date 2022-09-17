/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import Controller.CTasks;
import java.awt.event.ItemEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class panTasks extends javax.swing.JPanel {

    /**
     * Creates new form frmprueba
     */
    customization custo = new customization();

    public panTasks() {
        initComponents();
        CargarTareas();
    }
    
    final void CargarTareas(){
        CTasks controller = new CTasks();
        ResultSet datos = controller.CargarTareasPreview();
        try {
            while (datos.next()) {  
                //Forma de corroborar si es una materia o un modulo :3
                String materiamodulo;
                String cadena = datos.getString(4);     
                String[] palabras = cadena.split(" ", 2);
                if (palabras[0].equals("Ninguno")) {
                    materiamodulo = palabras[1];
                } else {
                    materiamodulo = cadena.substring(0, cadena.lastIndexOf(" "));
                }               
                custo.CrearTarea(datos.getString(1), materiamodulo, datos.getString(5), datos.getString(2), datos.getString(3), datos.getString(6), mainPan, materiamodulo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar las tareas cerote feo");
        }
        
    }

    //Constructor para habilitar los botones de agregar tareas
    public panTasks(int nivel) {
        initComponents();
        if (nivel == 1) {
            CargarTareas();
            btnAgregarTarea.setVisible(false);
        } else if (nivel == 2) {
            btnAgregarTarea.setVisible(true);
            CargarTareas();
        } else if (nivel == 3){
            btnAgregarTarea.setVisible(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        mainPan = new javax.swing.JPanel();
        upperPan = new javax.swing.JPanel();
        namePan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filtersPan = new javax.swing.JPanel();
        btnAgregarTarea = new customizeObjects.ButtonRound();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);

        mainPan.setBackground(new java.awt.Color(255, 255, 255));
        mainPan.setMaximumSize(new java.awt.Dimension(1500, 10));
        mainPan.setMinimumSize(new java.awt.Dimension(1000, 10));
        mainPan.setLayout(new java.awt.GridLayout(20, 0));
        jScrollPane1.setViewportView(mainPan);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        upperPan.setBackground(java.awt.Color.white);
        upperPan.setPreferredSize(new java.awt.Dimension(1000, 50));
        upperPan.setLayout(new java.awt.BorderLayout());

        namePan.setBackground(new java.awt.Color(255, 255, 255));
        namePan.setPreferredSize(new java.awt.Dimension(200, 50));
        namePan.setLayout(new javax.swing.BoxLayout(namePan, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Tareas");
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 50));
        namePan.add(jLabel1);

        upperPan.add(namePan, java.awt.BorderLayout.WEST);

        filtersPan.setBackground(java.awt.Color.white);
        filtersPan.setPreferredSize(new java.awt.Dimension(500, 50));
        filtersPan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 10));

        btnAgregarTarea.setText("Agregar Tareas");
        btnAgregarTarea.setRound(15);
        btnAgregarTarea.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);
        btnAgregarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTareaActionPerformed(evt);
            }
        });
        filtersPan.add(btnAgregarTarea);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setText("Ordenar:");
        filtersPan.add(jLabel2);

        jComboBox1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jComboBox1.setForeground(java.awt.Color.white);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(100, 30));
        filtersPan.add(jComboBox1);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 32, 32));
        jLabel3.setText("Filtrar:");
        filtersPan.add(jLabel3);

        jComboBox2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jComboBox2.setForeground(java.awt.Color.white);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(100, 30));
        filtersPan.add(jComboBox2);

        upperPan.add(filtersPan, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(32, 32, 32));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Estado:");
        jLabel4.setAlignmentY(0.0F);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel4, java.awt.BorderLayout.CENTER);

        upperPan.add(jPanel1, java.awt.BorderLayout.EAST);

        add(upperPan, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTareaActionPerformed
        // TODO add your handling code here:
        frmTasks task = new frmTasks();
        task.setVisible(true);
    }//GEN-LAST:event_btnAgregarTareaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound btnAgregarTarea;
    private javax.swing.JPanel filtersPan;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPan;
    private javax.swing.JPanel namePan;
    private javax.swing.JPanel upperPan;
    // End of variables declaration//GEN-END:variables
}
