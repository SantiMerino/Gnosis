/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author santi
 */
public class Notepad extends JFrame implements ActionListener {//  like it can use all the
    private JTextArea txt = new JTextArea(); // basically i had to make it local so that it could be used in more than 1 method yh i see thnx for explaining :d

    private JMenuBar newMenubar() {
        JMenuBar menubar = new JMenuBar(); //Sets up the menubar
        String[] titles = {"File", "test"};    // leave lol ok
        String[][] elements = {{"New", "Open", "Save"}, {"LOL"}};   //allready there lol ok go :d k lol
        for(int i = 0; i < titles.length; i++) { // basically loops through the menu titles
            String title = titles[i]; // selects the titles from the loop
            String[] elems = elements[i];//basically finds the menuitems for the menu
            menubar.add(newMenu(title, elems)); // adds a new menu with the title and elements, u understand? lhl yes ;d
            //Okay now we add the menu to the frame and we will boot it up

        }
        return menubar;//Returns the menubar ok
    }

    /**
     *
     * @param title The title like "File"
     * @param elements  The elements like "New", "Load", "Save"
     * @return  returns the JMenu that you make o
     */
    private JMenu newMenu(String title, String[] elements) {
        JMenu menu = new JMenu(title); //Creates a new JMenu with the title ik
        for(String element : elements) { //u understand?yes :d
            JMenuItem menuitem = new JMenuItem(element);//already told you about this :Pok
            menu.add(menuitem); // uses the add method in the JMenu class for our menu to add them menuitems yh ok :d
            menuitem.addActionListener(this);//makes it so that the menuitems respond to the actionlistenerok
        }
        return menu;
    }

    private Notepad() {
        setTitle("untitled - Notepad");  //Wanna add the title thing now? k we'll do it now
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  //basically gives it the system themeik
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setSize(800, 600); // straight forward lol
        setJMenuBar(newMenubar());
        JScrollPane scroller = new JScrollPane(txt);//it has the txt(JTextArea) in it to select what its the container fork
        add(scroller); // adds the scroller which has the text area in it.ok
        //Now this is where we have to make a menubar for files, i'll show you a nice way to do menus.ok
        //what else was i going to add?scrollbar oh yeah
    }
    
    //This shit here is for later to make the buttons and shit work. i know :d fk don't delete this class sent over msn soon :d
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand(); // basically retrieves what you've clickedok
        if(cmd.equals("Save")) { // If the button pressed has the text "Save" on it do something inside.
            //Forgot file chooser
            JFileChooser chooser = new JFileChooser(); // sets up the file choosing dialog. ok
            int option = chooser.showSaveDialog(this); // Shows the save dialog and is the option for what you've clicked
            if(option == JFileChooser.APPROVE_OPTION) {   //if you've pressed the ok or save button or w/e do somethingok
                 //also stop pressing o when i press control, it's frustrating l0lklol
                try {
                    BufferedWriter buf = new BufferedWriter(new FileWriter(chooser.getSelectedFile().getAbsolutePath()));
                    //^ Basically the bufferedwriter is something used for writing to a file along with filewriter
                    // yeah and the chooser.getSelectedFile().getAbsolutePath() basically finds the place in the filechooserik
                    //and writes to it.
                    buf.write(txt.getText()); // basically this gets the text in the text area and writes it to the file
                    setTitle(chooser.getSelectedFile().getName()); //this basically gets the file name in the chooser. rofl thisi s easy lol :d thnx, i told you it wasnt hard :Pyh
                    buf.close(); // closes the stream for memory purposesk, now we can run it
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if(cmd.equals("Open")) {
            JFileChooser chooser = new JFileChooser(); // filechooser object
            chooser.setFileFilter(new Filter());
            int option = chooser.showOpenDialog(this); // same as before but with open this time. ok w8
            if(option == JFileChooser.APPROVE_OPTION) {
                try {
                    Scanner scanner = new Scanner(chooser.getSelectedFile()); // gets the selected file from chooser
                    while(scanner.hasNext()) { // When the scanner still has stuff to read, do something
                        String data = scanner.nextLine(); // Read lines inside the scanner
                        txt.setText(data); // Puts the data it read from the file into the text area.k
                    }
                    setTitle(chooser.getSelectedFile().getName());
                    //Problem is i havent used file filter in a while so i mite do something wrong. ok
                    scanner.close(); // close the scanner for memory purposes.
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    class Filter extends javax.swing.filechooser.FileFilter implements FileFilter {

        public boolean accept(File file) {
            return file.getName().endsWith(".txt") || file.getName().endsWith(".java");
        }

        @Override
        public String getDescription() {
            return "Text File (.txt)";  
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        panelRound2 = new customizeObjects.PanelRound();
        buttonRound1 = new customizeObjects.ButtonRound();
        buttonRound2 = new customizeObjects.ButtonRound();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        buttonRound3 = new customizeObjects.ButtonRound();
        buttonRound4 = new customizeObjects.ButtonRound();
        buttonRound5 = new customizeObjects.ButtonRound();
        buttonRound6 = new customizeObjects.ButtonRound();
        buttonRound7 = new customizeObjects.ButtonRound();
        buttonRound8 = new customizeObjects.ButtonRound();
        buttonRound9 = new customizeObjects.ButtonRound();
        buttonRound10 = new customizeObjects.ButtonRound();
        buttonRound11 = new customizeObjects.ButtonRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonRound13 = new customizeObjects.ButtonRound();
        buttonRound14 = new customizeObjects.ButtonRound();
        buttonRound15 = new customizeObjects.ButtonRound();
        buttonRound16 = new customizeObjects.ButtonRound();
        buttonRound17 = new customizeObjects.ButtonRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonRound12 = new customizeObjects.ButtonRound();
        buttonRound18 = new customizeObjects.ButtonRound();
        buttonRound19 = new customizeObjects.ButtonRound();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        panelRound1 = new customizeObjects.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 32, 32));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(32, 32, 32));
        jPanel2.setPreferredSize(new java.awt.Dimension(775, 50));
        jPanel2.setLayout(new java.awt.BorderLayout(0, 10));

        jPanel4.setBackground(new java.awt.Color(32, 32, 32));
        jPanel4.setPreferredSize(new java.awt.Dimension(775, 40));

        panelRound2.setBackground(new java.awt.Color(90, 90, 90));
        panelRound2.setRoundBottomLeft(25);
        panelRound2.setRoundBottomRight(25);
        panelRound2.setRoundTopLeft(25);
        panelRound2.setRoundTopRight(25);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        buttonRound1.setText("buttonRound1");

        buttonRound2.setBackground(java.awt.Color.white);
        buttonRound2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-left.png"))); // NOI18N
        buttonRound2.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound2.setRound(20);
        buttonRound2.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        buttonRound2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(buttonRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(32, 32, 32));
        jPanel5.setPreferredSize(new java.awt.Dimension(10, 405));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.WEST);

        jPanel6.setBackground(new java.awt.Color(32, 32, 32));
        jPanel6.setPreferredSize(new java.awt.Dimension(160, 395));
        jPanel6.setRequestFocusEnabled(false);

        buttonRound3.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound3.setRound(20);
        buttonRound3.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound4.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound4.setRound(20);
        buttonRound4.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound5.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound5.setRound(20);
        buttonRound5.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound6.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound6.setRound(20);
        buttonRound6.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound7.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound7.setRound(20);
        buttonRound7.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound8.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound8.setRound(20);
        buttonRound8.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound9.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound9.setRound(20);
        buttonRound9.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound10.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound10.setRound(20);
        buttonRound10.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound11.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound11.setRound(20);
        buttonRound11.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Text.");

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Headings.");

        buttonRound13.setRound(20);
        buttonRound13.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound14.setRound(20);
        buttonRound14.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound15.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound15.setRound(20);
        buttonRound15.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/receive-square-white.png"))); // NOI18N
        buttonRound16.setPreferredSize(new java.awt.Dimension(114, 35));
        buttonRound16.setRound(20);
        buttonRound16.setStyle(customizeObjects.ButtonRound.ButtonStyle.ROJO);

        buttonRound17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/receive-square.png"))); // NOI18N
        buttonRound17.setPreferredSize(new java.awt.Dimension(114, 35));
        buttonRound17.setRound(20);
        buttonRound17.setStyle(customizeObjects.ButtonRound.ButtonStyle.SOCIALES);

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Exportar en .PDF");

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Exportar en .DOCX");

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Theme.");

        buttonRound12.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound12.setRound(20);
        buttonRound12.setStyle(customizeObjects.ButtonRound.ButtonStyle.SOCIALES);

        buttonRound18.setToolTipText("");
        buttonRound18.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonRound18.setRound(20);
        buttonRound18.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        buttonRound19.setRound(20);
        buttonRound19.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Guardar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(buttonRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buttonRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buttonRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(buttonRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buttonRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buttonRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(buttonRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buttonRound10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buttonRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(buttonRound13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRound14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buttonRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(buttonRound12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buttonRound18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(buttonRound16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonRound17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonRound19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonRound13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonRound12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRound19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(buttonRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(buttonRound17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.EAST);

        jPanel7.setBackground(new java.awt.Color(32, 32, 32));
        jPanel7.setPreferredSize(new java.awt.Dimension(780, 10));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        panelRound1.setBackground(java.awt.Color.white);
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(243, 1000));

        jTextArea2.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(32, 32, 32));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(100);
        jTextArea2.setTabSize(3);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(null);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelRound1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRound2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRound2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        customization.mainUtilities();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notepad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound buttonRound1;
    private customizeObjects.ButtonRound buttonRound10;
    private customizeObjects.ButtonRound buttonRound11;
    private customizeObjects.ButtonRound buttonRound12;
    private customizeObjects.ButtonRound buttonRound13;
    private customizeObjects.ButtonRound buttonRound14;
    private customizeObjects.ButtonRound buttonRound15;
    private customizeObjects.ButtonRound buttonRound16;
    private customizeObjects.ButtonRound buttonRound17;
    private customizeObjects.ButtonRound buttonRound18;
    private customizeObjects.ButtonRound buttonRound19;
    private customizeObjects.ButtonRound buttonRound2;
    private customizeObjects.ButtonRound buttonRound3;
    private customizeObjects.ButtonRound buttonRound4;
    private customizeObjects.ButtonRound buttonRound5;
    private customizeObjects.ButtonRound buttonRound6;
    private customizeObjects.ButtonRound buttonRound7;
    private customizeObjects.ButtonRound buttonRound8;
    private customizeObjects.ButtonRound buttonRound9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private customizeObjects.PanelRound panelRound1;
    private customizeObjects.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
