/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package customizeObjects;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class PanelDate extends javax.swing.JPanel {

    /**
     * Creates new form PanelDate
     */
    private int month;
    private int year;
    public String fechaseleccionada;
    private int daySelec;
    

//    private Cell cell;
    public PanelDate(int month, int year) {
        initComponents();
        this.month = month;
        this.year = year;
        init();
        dateSelec();
    }

    public PanelDate() {
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void init() {
        lunes.asTitle();
        martes.asTitle();
        miercoles.asTitle();
        jueves.asTitle();
        viernes.asTitle();
        sabado.asTitle();
        domingo.asTitle();
        setDate();
    }

    private void setDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);  //  month jan as 0 so start from 0
        calendar.set(Calendar.DATE, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;  //  get day of week -1 to index
        calendar.add(Calendar.DATE, -startDay);
        ToDay toDay = getToDay();
        for (Component com : getComponents()) {
            Cell cell = (Cell) com;
            if (!cell.isTitle()) {
                cell.setText(calendar.get(Calendar.DATE) + "");
                cell.setDate(calendar.getTime());
                cell.currentMonth(calendar.get(Calendar.MONTH) == month - 1);
                if (toDay.isToDay(new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)))) {
                    cell.setAsToDay();
                }
                calendar.add(Calendar.DATE, 1); //  up 1 day
            }
        }
    }

    public void dateSelec() {
        for (Component com : getComponents()) {
            Cell cell = (Cell) com;
            cell.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (cell != domingo && cell != lunes && cell != martes && cell != miercoles && cell != jueves && cell != viernes && cell != sabado) {
                        if (cell.getStyle() == ButtonRound.ButtonStyle.VERDE) {
                            cell.setStyle(ButtonRound.ButtonStyle.GRIS_ROJO);
                        } else {
                            daySelec = Integer.parseInt(cell.getText());
                            cell.setStyle(ButtonRound.ButtonStyle.VERDE);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(Calendar.YEAR, year);
                            calendar.set(Calendar.MONTH, month - 1);
                            calendar.set(Calendar.DATE, daySelec);

                            Date dateSelec = calendar.getTime();
                            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                            fechaseleccionada = df.format(dateSelec);
                            CalendarCustom papa = new CalendarCustom();
                            try {
                                papa.SetearTexto(fechaseleccionada);
                            } catch (ParseException ex) {
                                JOptionPane.showMessageDialog(null, "Come mierda netbeans");
                            } catch (SQLException ex) {
                                Logger.getLogger(PanelDate.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            });
        }
    }

    private ToDay getToDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        domingo = new customizeObjects.Cell();
        lunes = new customizeObjects.Cell();
        martes = new customizeObjects.Cell();
        miercoles = new customizeObjects.Cell();
        jueves = new customizeObjects.Cell();
        viernes = new customizeObjects.Cell();
        sabado = new customizeObjects.Cell();
        cell8 = new customizeObjects.Cell();
        cell9 = new customizeObjects.Cell();
        cell10 = new customizeObjects.Cell();
        cell11 = new customizeObjects.Cell();
        cell12 = new customizeObjects.Cell();
        cell13 = new customizeObjects.Cell();
        cell14 = new customizeObjects.Cell();
        cell15 = new customizeObjects.Cell();
        cell16 = new customizeObjects.Cell();
        cell17 = new customizeObjects.Cell();
        cell18 = new customizeObjects.Cell();
        cell19 = new customizeObjects.Cell();
        cell20 = new customizeObjects.Cell();
        cell21 = new customizeObjects.Cell();
        cell22 = new customizeObjects.Cell();
        cell23 = new customizeObjects.Cell();
        cell24 = new customizeObjects.Cell();
        cell25 = new customizeObjects.Cell();
        cell26 = new customizeObjects.Cell();
        cell27 = new customizeObjects.Cell();
        cell28 = new customizeObjects.Cell();
        cell29 = new customizeObjects.Cell();
        cell30 = new customizeObjects.Cell();
        cell31 = new customizeObjects.Cell();
        cell32 = new customizeObjects.Cell();
        cell33 = new customizeObjects.Cell();
        cell34 = new customizeObjects.Cell();
        cell35 = new customizeObjects.Cell();
        cell36 = new customizeObjects.Cell();
        cell37 = new customizeObjects.Cell();
        cell38 = new customizeObjects.Cell();
        cell39 = new customizeObjects.Cell();
        cell40 = new customizeObjects.Cell();
        cell41 = new customizeObjects.Cell();
        cell42 = new customizeObjects.Cell();
        cell43 = new customizeObjects.Cell();
        cell44 = new customizeObjects.Cell();
        cell45 = new customizeObjects.Cell();
        cell46 = new customizeObjects.Cell();
        cell47 = new customizeObjects.Cell();
        cell48 = new customizeObjects.Cell();
        cell49 = new customizeObjects.Cell();

        setBackground(new java.awt.Color(32, 32, 32));
        setLayout(new java.awt.GridLayout(7, 7, 1, 1));

        domingo.setText("Dom");
        domingo.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        domingo.setRound(15);
        domingo.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        add(domingo);

        lunes.setText("Lun");
        lunes.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        lunes.setRound(15);
        lunes.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        add(lunes);

        martes.setText("Mar");
        martes.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        martes.setRound(15);
        martes.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        add(martes);

        miercoles.setText("Mier");
        miercoles.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        miercoles.setRound(15);
        miercoles.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        add(miercoles);

        jueves.setText("Jue");
        jueves.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jueves.setRound(15);
        jueves.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        add(jueves);

        viernes.setText("Vie");
        viernes.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        viernes.setRound(15);
        viernes.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        add(viernes);

        sabado.setText("Sab");
        sabado.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        sabado.setRound(15);
        sabado.setStyle(customizeObjects.ButtonRound.ButtonStyle.NEGRO);
        add(sabado);

        cell8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell8.setRound(15);
        cell8.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell8);

        cell9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell9.setRound(15);
        cell9.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell9);

        cell10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell10.setRound(15);
        cell10.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell10);

        cell11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell11.setRound(15);
        cell11.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell11);

        cell12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell12.setRound(15);
        cell12.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell12);

        cell13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell13.setRound(15);
        cell13.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell13);

        cell14.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell14.setRound(15);
        cell14.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell14);

        cell15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell15.setRound(15);
        cell15.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell15);

        cell16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell16.setRound(15);
        cell16.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell16);

        cell17.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell17.setRound(15);
        cell17.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell17);

        cell18.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell18.setRound(15);
        cell18.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell18);

        cell19.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell19.setRound(15);
        cell19.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell19);

        cell20.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell20.setRound(15);
        cell20.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell20);

        cell21.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell21.setRound(15);
        cell21.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell21);

        cell22.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell22.setRound(15);
        cell22.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell22);

        cell23.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell23.setRound(15);
        cell23.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell23);

        cell24.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell24.setRound(15);
        cell24.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell24);

        cell25.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell25.setRound(15);
        cell25.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell25);

        cell26.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell26.setRound(15);
        cell26.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell26);

        cell27.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell27.setRound(15);
        cell27.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell27);

        cell28.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell28.setRound(15);
        cell28.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell28);

        cell29.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell29.setRound(15);
        cell29.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell29);

        cell30.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell30.setRound(15);
        cell30.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell30);

        cell31.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell31.setRound(15);
        cell31.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell31);

        cell32.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell32.setRound(15);
        cell32.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell32);

        cell33.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell33.setRound(15);
        cell33.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell33);

        cell34.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell34.setRound(15);
        cell34.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell34);

        cell35.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell35.setRound(15);
        cell35.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell35);

        cell36.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell36.setRound(15);
        cell36.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell36);

        cell37.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell37.setRound(15);
        cell37.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell37);

        cell38.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell38.setRound(15);
        cell38.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell38);

        cell39.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell39.setRound(15);
        cell39.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell39);

        cell40.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell40.setRound(15);
        cell40.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell40);

        cell41.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell41.setRound(15);
        cell41.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell41);

        cell42.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell42.setRound(15);
        cell42.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell42);

        cell43.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell43.setRound(15);
        cell43.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell43);

        cell44.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell44.setRound(15);
        cell44.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell44);

        cell45.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell45.setRound(15);
        cell45.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell45);

        cell46.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell46.setRound(15);
        cell46.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell46);

        cell47.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell47.setRound(15);
        cell47.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell47);

        cell48.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell48.setRound(15);
        cell48.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell48);

        cell49.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cell49.setRound(15);
        cell49.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        add(cell49);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.Cell cell10;
    private customizeObjects.Cell cell11;
    private customizeObjects.Cell cell12;
    private customizeObjects.Cell cell13;
    private customizeObjects.Cell cell14;
    private customizeObjects.Cell cell15;
    private customizeObjects.Cell cell16;
    private customizeObjects.Cell cell17;
    private customizeObjects.Cell cell18;
    private customizeObjects.Cell cell19;
    private customizeObjects.Cell cell20;
    private customizeObjects.Cell cell21;
    private customizeObjects.Cell cell22;
    private customizeObjects.Cell cell23;
    private customizeObjects.Cell cell24;
    private customizeObjects.Cell cell25;
    private customizeObjects.Cell cell26;
    private customizeObjects.Cell cell27;
    private customizeObjects.Cell cell28;
    private customizeObjects.Cell cell29;
    private customizeObjects.Cell cell30;
    private customizeObjects.Cell cell31;
    private customizeObjects.Cell cell32;
    private customizeObjects.Cell cell33;
    private customizeObjects.Cell cell34;
    private customizeObjects.Cell cell35;
    private customizeObjects.Cell cell36;
    private customizeObjects.Cell cell37;
    private customizeObjects.Cell cell38;
    private customizeObjects.Cell cell39;
    private customizeObjects.Cell cell40;
    private customizeObjects.Cell cell41;
    private customizeObjects.Cell cell42;
    private customizeObjects.Cell cell43;
    private customizeObjects.Cell cell44;
    private customizeObjects.Cell cell45;
    private customizeObjects.Cell cell46;
    private customizeObjects.Cell cell47;
    private customizeObjects.Cell cell48;
    private customizeObjects.Cell cell49;
    private customizeObjects.Cell cell8;
    private customizeObjects.Cell cell9;
    private customizeObjects.Cell domingo;
    private customizeObjects.Cell jueves;
    private customizeObjects.Cell lunes;
    private customizeObjects.Cell martes;
    private customizeObjects.Cell miercoles;
    private customizeObjects.Cell sabado;
    private customizeObjects.Cell viernes;
    // End of variables declaration//GEN-END:variables
}
