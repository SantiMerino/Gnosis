/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;;

/**
 *
 * @author josec
 */
public class frmNotePad extends javax.swing.JFrame {
   
    //Default Font Size for text
    int fsize = 17;

    private JTextArea area;
    private JScrollPane scpane;
    String text = "";

    //Creating Frame and setting up the title
    JFrame f = new JFrame("DataFlair's Notepad");

    JTextField title;
    Font newFont;
    JPanel bottomPanel;
    JLabel detailsOfFile;
    JList fontFamilyList, fontStyleList, fontSizeList;
    JScrollPane sb;
    JMenuBar menuBar;
    JMenu file, edit, format;
    JMenuItem newdoc, open, save, print, exit, copy, paste, cut, selectall, fontfamily, fontstyle, fontsize;
    //Defining List of Fonts for Text
    String fontFamilyValues[] = {"Agency FB", "Antiqua", "Architect", "Arial", "Calibri", "Comic Sans", "Courier", "Cursive", "Impact", "Serif"};
    //Defining List of Font Size for Text
    String fontSizeValues[] = {"5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70"};
    int[] stylevalue = {Font.PLAIN, Font.BOLD, Font.ITALIC};
    //Defining List of Font Styles for Text
    String[] fontStyleValues = {"PLAIN", "BOLD", "ITALIC"};
    String fontFamily, fontSize, fontStyle;
    int fstyle;
    int cl;
    int linecount;
    JScrollPane sp;
    
    /**
     * Creates new form frmNotePad
     */
    public frmNotePad() {
        initComponents();      
        //Calling initUI() method to initiliaze UI
        initUI();
        //Calling addActionEvents() method to add events
        addActionEvents();
    }
    
    public void actionPerformed(ActionEvent ae) {
        //if new option is choosen
        if (ae.getActionCommand().equals("New")) {
            //Setting Text as empty by default
            area.setText("");
        } //if open option is chosen
        else if (ae.getActionCommand().equals("Open")) {
            //Setting current by default directory "C" folder
            JFileChooser chooser = new JFileChooser("C:/");
            chooser.setAcceptAllFileFilterUsed(false);
            //Allowing only text (.txt) files extension to open
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
            chooser.addChoosableFileFilter(restrict);

            int result = chooser.showOpenDialog(f);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    //Reading the file
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);
                    area.read(br, null);
                    //Closing the file after reading
                    //Clearing the memory
                    br.close();
                    area.requestFocus();
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        } //if save option is choosen
        else if (ae.getActionCommand().equals("Save")) {
            final JFileChooser SaveAs = new JFileChooser();
            SaveAs.setApproveButtonText("Save");
            //Opening the dialog and asking from user where to save the file.
            int actionDialog = SaveAs.showOpenDialog(f);
            if (actionDialog != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File fileName = new File(SaveAs.getSelectedFile() + ".txt");
            BufferedWriter outFile = null;
            try {
                outFile = new BufferedWriter(new FileWriter(fileName));
                area.write(outFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } //if print option is choosen
        else if (ae.getActionCommand().equals("Print")) {
            try {
                //printer dialog will open
                area.print();
            } catch (Exception e) {
            }
        } //if exit option is choosen
        else if (ae.getActionCommand().equals("Exit")) {
            //Destroying/Closing the frame/window
            f.dispose();
        } //if copy option is choosen
        else if (ae.getActionCommand().equals("Copy")) {
            //Getting Selected Selected Text
            text = area.getSelectedText();
        } //if paste option is choosen
        else if (ae.getActionCommand().equals("Paste")) {
            area.insert(text, area.getCaretPosition());
        } //if cut option is choosen
        else if (ae.getActionCommand().equals("Cut")) {
            text = area.getSelectedText();
            area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
        } //if select all option is choosen
        else if (ae.getActionCommand().equals("Select All")) {
            //Selecting all text
            area.selectAll();
        } //if font family change option is choosen
        else if (ae.getActionCommand().equals("Font Family")) {
            //Setting up Font Family
            JOptionPane.showConfirmDialog(null, fontFamilyList, "Choose Font Family", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            fontFamily = String.valueOf(fontFamilyList.getSelectedValue());
            newFont = new Font(fontFamily, fstyle, fsize);
            area.setFont(newFont);
        } //if font style change option is choosen
        else if (ae.getActionCommand().equals("Font Style")) {
            //Setting up Font Style
            JOptionPane.showConfirmDialog(null, fontStyleList, "Choose Font Style", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            fstyle = stylevalue[fontStyleList.getSelectedIndex()];
            newFont = new Font(fontFamily, fstyle, fsize);
            area.setFont(newFont);
        } //if font size change option is choosen
        else if (ae.getActionCommand().equals("Font Size")) {
            //Setting up Font Size
            JOptionPane.showConfirmDialog(null, fontSizeList, "Choose Font Size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            fontSize = String.valueOf(fontSizeList.getSelectedValue());
            fsize = Integer.parseInt(fontSize);
            newFont = new Font(fontFamily, fstyle, fsize);
            area.setFont(newFont);
        }
    }
    
    public void keyTyped(KeyEvent ke) {
        //Calculating length and count of words
        cl = area.getText().length();
        linecount = area.getLineCount();
        detailsOfFile.setText("Length: " + cl + " Line: " + linecount);
    }
    
    public void initUI() {
        detailsOfFile = new JLabel();

        bottomPanel = new JPanel();

        //Creating Menubar
        menuBar = new JMenuBar();

        //Creating Menu "File"
        file = new JMenu("File");

        //Creating MenuItem "New"
        newdoc = new JMenuItem("New");

        //Assigning shortcut "Cntrl + N" for "New" Menu Item
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        //Creating MenuItem "Open"
        open = new JMenuItem("Open");

        //Assigning shortcut "Cntrl + O" for "Open" Menu Item
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        //Creating MenuItem "Save"
        save = new JMenuItem("Save");

        //Assigning shortcut "Cntrl + S" for "Save" Menu Item
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        //Creating MenuItem "Print"
        print = new JMenuItem("Print");

        //Assigning shortcut "Cntl + P" for "Print" Menu Item
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        //Creating MenuItem "Exit"
        exit = new JMenuItem("Exit");

        //Assigning shortcut "ESC" for "Exit" Menu Item
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));

        //Creating Menu "Edit"
        edit = new JMenu("Edit");

        //Creating MenuItem "Copy"
        copy = new JMenuItem("Copy");

        //Assigning shortcut "Cntrl + C" for "Copy" Menu Item
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        //Creating MenuItem "Paste"
        paste = new JMenuItem("Paste");

        //Assigning shortcut "Cntrl + V" for "Paste" Menu Item
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        //Creating MenuItem "Cut"
        cut = new JMenuItem("Cut");

        //Assigning shortcut "Cntrl + X" for "Cut" Menu Item
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        //Creating MenuItem "Select All"
        selectall = new JMenuItem("Select All");

        //Assigning shortcut "Cntrl + A" for "Select All" Menu Item
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        //Creating Menu "Format"
        format = new JMenu("Format");

        //Creating MenuItem "Font Family"
        fontfamily = new JMenuItem("Font Family");

        //Creating MenuItem "Font Style"
        fontstyle = new JMenuItem("Font Style");

        //Creating MenuItem "Font Size"
        fontsize = new JMenuItem("Font Size");

        //Creating List of Font Family and assigning the list values
        fontFamilyList = new JList(fontFamilyValues);

        //Creating List of Font Styles and assigning the list values
        fontStyleList = new JList(fontStyleValues);

        //Creating List of Font Size and assigning the list values
        fontSizeList = new JList(fontSizeValues);

        //Allowing user to select only one option
        fontFamilyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontStyleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontSizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //TextArea / Editor of Notepad
        area = new JTextArea();

        //Default font will be sam_serif and default font style will be plain and default style will be 20. 
        area.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));

        //Sets the line-wrapping policy of the text area
        area.setLineWrap(true);

        //Sets the word-wrapping policy of the text area
        area.setWrapStyleWord(true);

        //Creating Scrollables around textarea
        scpane = new JScrollPane(area);

        //Creating border for scrollpane
        scpane.setBorder(BorderFactory.createEmptyBorder());

        //Adding menubar in frame
        f.setJMenuBar(menuBar);

        //Adding all menus in menubars
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(format);

        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);

        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectall);

        format.add(fontfamily);
        format.add(fontstyle);
        format.add(fontsize);

        bottomPanel.add(detailsOfFile);

        //Setting up the size of frame
        f.setSize(980, 480);

        //Setting up the layout of frame
        f.setLayout(new BorderLayout());

        //Adding panels in frame
        f.add(scpane, BorderLayout.CENTER);
        f.add(bottomPanel, BorderLayout.SOUTH);
        //Setting Frame visible to user
        f.setVisible(true);
    }

    public void addActionEvents() {
        //registering action listener to buttons
        newdoc.addActionListener((ActionListener)this);
        save.addActionListener((ActionListener)this);
        print.addActionListener((ActionListener)this);
        exit.addActionListener((ActionListener) this);
        copy.addActionListener((ActionListener) this);
        paste.addActionListener((ActionListener)this);
        cut.addActionListener((ActionListener)this);
        selectall.addActionListener((ActionListener)this);
        open.addActionListener((ActionListener)this);
        fontfamily.addActionListener((ActionListener)this);
        fontsize.addActionListener((ActionListener)this);
        fontstyle.addActionListener((ActionListener)this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogColor = new javax.swing.JDialog();
        colorChooser = new javax.swing.JColorChooser();

        javax.swing.GroupLayout dialogColorLayout = new javax.swing.GroupLayout(dialogColor.getContentPane());
        dialogColor.getContentPane().setLayout(dialogColorLayout);
        dialogColorLayout.setHorizontalGroup(
            dialogColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                .addContainerGap())
        );
        dialogColorLayout.setVerticalGroup(
            dialogColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colorChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(frmNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNotePad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JDialog dialogColor;
    // End of variables declaration//GEN-END:variables

}
