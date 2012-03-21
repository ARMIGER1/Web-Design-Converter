/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WDC.ui;

import WDC.helper.Converter;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * 
 * @author ARMIGER1
 * @version 1.0
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }
    
    // Global variables
    
    /**
     * Formats a decimal to three (3) decimal places.
     */
    DecimalFormat threeDigits = new DecimalFormat("0.000");
    
    /**
     * Formats a decimal to one (1) decimal place.
     */
    DecimalFormat oneDigit = new DecimalFormat("0.0");
    
    /**
     * Signals that the process is ready to execute.
     * If true, process is ready, else process is not ready.
     */
    boolean readyFlag = false;
    
    // Graphics stuff
    
    static SplashScreen mySplash;
    
    static Rectangle2D splashTextArea, splashProgressArea;
    
    static Graphics2D splashGraphics;
    
    static Font font;
    
    Converter convert = new Converter();
    
    // Splash Screen methods
    
    /**
     * Prepare the global variables for the other splash functions.
     */
    private static void splashInit() {
        mySplash = SplashScreen.getSplashScreen();
        
        if (mySplash != null) {
            // If there are any problems displaying the splash, this will be null
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            
            // Stake out some area for status information
            splashTextArea = new Rectangle2D.Double(15.0, height*0.88, width * .45, 32.0);
            splashProgressArea = new Rectangle2D.Double(width * 0.55, height * 0.92, width * 0.04, 12);
            
            // Create the graphics environment for drawing status info
            splashGraphics = mySplash.createGraphics();
            font = new Font("Dialog", Font.PLAIN, 14);
            splashGraphics.setFont(font);
            
            // Initialize the status info
            splashText("Starting");
            splashProgress(0);
        }
    }
    
    /**
     * Display text in the status area of the splash screen.
     * @param str String The text to be displayed
     */
    private static void splashText(String str) {
        
        if (mySplash != null && mySplash.isVisible()) {
            /*
             * It's important to check here to see if there even
             * IS a splash screen to display.
             */
            
            // Erase the last status text
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashTextArea);
            
            // Draw the text
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.drawString(str, (int) (splashTextArea.getX() + 10), (int) (splashTextArea.getY() + 15));
            
            // Make SURE it's displayed
            mySplash.update();
        }
    }
    
    /**
     * Display a basic progress bar
     * @param percent int The amount of the progress bar to display from 0-100
     */
    public static void splashProgress(int percent) {
        
        if (mySplash != null && mySplash.isVisible()) {
            // Note: 3 colors are used to demonstrate steps
            
            // First off, erase old color
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.draw(splashProgressArea);
            
            // Draw an outline
            splashGraphics.setPaint(Color.BLUE);
            splashGraphics.draw(splashProgressArea);
            
            // Calculate the width corresponding to the correct percentage
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int width = (int) splashProgressArea.getWidth();
            int height = (int) splashProgressArea.getHeight();
            
            int doneWidth = Math.round(percent * width / 100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, width - 1));
            
            // Fill the done part one pixel smaller than the outline
            splashGraphics.setPaint(Color.GREEN);
            splashGraphics.fillRect(x, y + 1, doneWidth, height - 1);
            
            // Make SURE it's displayed
            mySplash.update();
        }
    }
    
    /**
     * Stub to simulate a long initialization task that updates
     * the text and progress parts of the status in the splash screen.
     */
    private static void appInit() {
        for (int i = 1; i <= 10; i++) {
            int percentDone = i * 10;
            splashText("Doing task #" + i);
            splashProgress(percentDone);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                // Ah, ignorance is bliss...
            }
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

        lbl_base_size = new javax.swing.JLabel();
        lbl_desired_size = new javax.swing.JLabel();
        lbl_result = new javax.swing.JLabel();
        tf_base_size = new javax.swing.JTextField();
        tf_desired_size = new javax.swing.JTextField();
        tf_result = new javax.swing.JTextField();
        cb_unit = new javax.swing.JComboBox();
        btn_convert = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        menu_main = new javax.swing.JMenuBar();
        mnu_file = new javax.swing.JMenu();
        mi_about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Web Design Unit Converter");
        setResizable(false);

        lbl_base_size.setText("Base Font Size (px):");

        lbl_desired_size.setText("Desired Font Size (px):");

        lbl_result.setText("Result:");

        tf_base_size.setToolTipText("Enter your base font size in pixels here.");

        tf_desired_size.setToolTipText("<html> Enter the size you want to convert to in pixels. <br /> <br /> For example, if your base font size is 10px and you want to resize it to 42px, enter '42' (without the quotes). </html>");

        tf_result.setEditable(false);
        tf_result.setToolTipText("Here's your completed conversion in the units you specified with the drop-down menu to the right.");

        cb_unit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EM", "%" }));

        btn_convert.setText("Convert!");
        btn_convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_convertActionPerformed(evt);
            }
        });

        btn_reset.setText("Reset Fields");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        mnu_file.setText("File");

        mi_about.setText("About");
        mi_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_aboutActionPerformed(evt);
            }
        });
        mnu_file.add(mi_about);

        menu_main.add(mnu_file);

        setJMenuBar(menu_main);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(btn_convert, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lbl_desired_size)
                            .add(lbl_base_size)
                            .add(lbl_result))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(tf_base_size, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(tf_desired_size, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(tf_result, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cb_unit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(btn_reset, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_base_size)
                    .add(tf_base_size, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_desired_size)
                    .add(tf_desired_size, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_result)
                    .add(tf_result, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cb_unit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btn_convert)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btn_reset)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-292)/2, (screenSize.height-223)/2, 292, 223);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_convertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_convertActionPerformed
        
        // Make sure that both fields are filled and consist ONLY of numbers and maybe a decimal.
        if (tf_base_size.getText().matches(Converter.REGEX_INT) && tf_desired_size.getText().matches(Converter.REGEX_INT) && (!"".equals(tf_base_size.getText()) && !"".equals(tf_desired_size.getText()) ) ) {
            readyFlag = true;
        } else {
            readyFlag = false;
        }
        
        if (readyFlag == true) {
            
            int base = Integer.parseInt(tf_base_size.getText());
            int target = Integer.parseInt(tf_desired_size.getText());
            double answer = 0;
            
            switch (cb_unit.getSelectedIndex()) {
                case Converter.UNIT_EM:
                    answer = convert.convert_size(base, target, Converter.UNIT_EM);
                    answer = Double.parseDouble(threeDigits.format(answer));
                    break;
                case Converter.UNIT_PERCENT:
                    answer = convert.convert_size(base, target, Converter.UNIT_PERCENT);
                    answer = Double.parseDouble(oneDigit.format(answer));
                    break;
            }
            
            tf_result.setText(Double.toString(answer));
            
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a number for your base and desired sizes.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_convertActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        tf_base_size.setText("");
        tf_desired_size.setText("");
        tf_result.setText("");
    }//GEN-LAST:event_btn_resetActionPerformed

    private void mi_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_aboutActionPerformed
        String html_message = "<html>"
                + "<h1>About Web Design Converter</h1>"
                + "<p>Author: ARMIGER1 <a href=\"https://github.com/ARMIGER1/Web-Design-Converter\">Project Homepage</a></p>"
                + "<p>License: <a href=\"http://creativecommons.org/licenses/by-nc-sa/3.0/\">Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License</a></p>"
                + "</html>";
        JOptionPane.showMessageDialog(null, html_message, "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mi_aboutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                splashInit();
                appInit();
                
                // Check if we really have a splash screen
                if (mySplash != null) {
                    mySplash.close();
                }
                
                // Begin program itself
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_convert;
    private javax.swing.JButton btn_reset;
    private javax.swing.JComboBox cb_unit;
    private javax.swing.JLabel lbl_base_size;
    private javax.swing.JLabel lbl_desired_size;
    private javax.swing.JLabel lbl_result;
    private javax.swing.JMenuBar menu_main;
    private javax.swing.JMenuItem mi_about;
    private javax.swing.JMenu mnu_file;
    private javax.swing.JTextField tf_base_size;
    private javax.swing.JTextField tf_desired_size;
    private javax.swing.JTextField tf_result;
    // End of variables declaration//GEN-END:variables
}
