/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package callofjelly;

import callofjelly.SFX.BasicSFXstuff;

/**
 *
 * @author vedant, Mansoor, Zunair
 * @date Jan 5, 2026
 * @filename DiedScreen
 * @description: A seperate death screen when player dies to a different object
 */
public class DiedScreen extends javax.swing.JPanel {

  
    frmMainGame mainPage; //this is the main screen

    public DiedScreen(frmMainGame main) {
        initComponents();

        mainPage = main; // assign the main page
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RetryButton = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        MainMenuButton = new javax.swing.JButton();
        youdiedscreenimagelbl = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RetryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/RetryButton.png"))); // NOI18N
        RetryButton.setToolTipText("");
        RetryButton.setBorderPainted(false);
        RetryButton.setContentAreaFilled(false);
        RetryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        RetryButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/RetryDARK.png"))); // NOI18N
        RetryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetryButtonActionPerformed(evt);
            }
        });
        add(RetryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 650, 200, 50));

        btnQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/quitBTNsmallertxt.png"))); // NOI18N
        btnQuit.setBorderPainted(false);
        btnQuit.setContentAreaFilled(false);
        btnQuit.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        btnQuit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/quitBTNsmallertxtDARK.png"))); // NOI18N
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        add(btnQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 810, 200, 50));

        MainMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/MainMenuButton.png"))); // NOI18N
        MainMenuButton.setBorderPainted(false);
        MainMenuButton.setContentAreaFilled(false);
        MainMenuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        MainMenuButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/MainMenuButtonDARK.png"))); // NOI18N
        MainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuButtonActionPerformed(evt);
            }
        });
        add(MainMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 730, 200, 50));

        youdiedscreenimagelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/you died screen.png"))); // NOI18N
        add(youdiedscreenimagelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void RetryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetryButtonActionPerformed
        // TODO add your handling code here:
        BasicSFXstuff.play();
        //        mainPage.swapScreens(new TittleScreen(mainPage));
        mainPage.swapScreens(new MoonMap(mainPage));
    }//GEN-LAST:event_RetryButtonActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:

        BasicSFXstuff.play();
        System.exit(0);//ends the game//https://www.youtube.com/watch?v=OwhvydQydVw
    }//GEN-LAST:event_btnQuitActionPerformed

    private void MainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuButtonActionPerformed
        // TODO add your handling code here:

        BasicSFXstuff.play();
        mainPage.swapScreens(new TittleScreen(mainPage));

    }//GEN-LAST:event_MainMenuButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MainMenuButton;
    private javax.swing.JButton RetryButton;
    private javax.swing.JButton btnQuit;
    private javax.swing.JLabel youdiedscreenimagelbl;
    // End of variables declaration//GEN-END:variables
}
