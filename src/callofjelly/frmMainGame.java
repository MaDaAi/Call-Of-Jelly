/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package callofjelly;

import javax.swing.JPanel;
import callofjelly.SFX.BasicSFXstuff;
import callofjelly.SFX.ReloadSFX;
import callofjelly.SFX.TitleMusic;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author Mansoor, Vedant, Zunair
 * @date Jan 5, 2026
 * @filename frmMainGame
 * @description: The main game panel to swap screens, load music, etc. 
 */
public class frmMainGame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmMainGame.class.getName());

    /**
     * Creates new form frmMainGame
     */
    public frmMainGame() {
        GameResources.registerFonts();
        this.setUndecorated(true); //removes top bar (to make full screen look better)
        initComponents();
        this.setSize(1920, 1080); // makes the game full screen
        swapScreens(new TittleScreen(this)); // start on menu

        // Loads the sound effects and music into memory
        ReloadSFX.loadSound();

        BasicSFXstuff.loadSound();

        if (TitleMusic.getMusictogglevalue() == 0) {
            TitleMusic.play();
        }
        if (TitleMusic.getMusictogglevalue() == 1) {
            TitleMusic.stop();
        }

    }
    JPanel currentPanel = new TittleScreen(this);

    // this method will swap the currently displayed panel
    // Feel free to steal it for your projects!
    public void swapScreens(JPanel newScreen) {
        this.remove(currentPanel);  // remove old panel
        currentPanel = newScreen; // assign new one
        this.add(currentPanel); // add new panel
        currentPanel.setVisible(true); // make it visible
        // set size to current size of screen
        currentPanel.setSize(this.getWidth(), this.getHeight());
        repaint(); // re draws the screen
        validate(); // ensures all components are in correct location
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                    UIManager.put("nimbusOrange", new Color(0, 102, 0));
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new frmMainGame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
