/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package callofjelly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;
import callofjelly.SFX.BasicSFXstuff;

/**
 *
 * @author vedant, Mansoor, Zunair
 * @date Jan 5, 2026
 * @filename TitleScreen
 * @description: The title screen where the user can press play to jump into the
 * game
 */
public class TittleScreen extends javax.swing.JPanel {

    frmMainGame mainPage;

    public TittleScreen(frmMainGame main) {
        initComponents();

        mainPage = main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSettings = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        buttonPlay = new javax.swing.JButton();
        lblTIttleText = new javax.swing.JLabel();
        lblTittleScreenBackground = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/Settings button2.png"))); // NOI18N
        btnSettings.setBorderPainted(false);
        btnSettings.setContentAreaFilled(false);
        btnSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSettings.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/settings button highlighted.png"))); // NOI18N
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });
        add(btnSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 920, 310, 80));

        btnQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/QuitButton4.png"))); // NOI18N
        btnQuit.setBorderPainted(false);
        btnQuit.setContentAreaFilled(false);
        btnQuit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/quitbutton3selected.png"))); // NOI18N
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        add(btnQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1000, 210, 60));

        buttonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/PlayButton5.png"))); // NOI18N
        buttonPlay.setBorderPainted(false);
        buttonPlay.setContentAreaFilled(false);
        buttonPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonPlay.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/play button highlighted2.png"))); // NOI18N
        buttonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlayActionPerformed(evt);
            }
        });
        add(buttonPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 820, 400, 100));

        lblTIttleText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/tittle text.png"))); // NOI18N
        add(lblTIttleText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 760, 190));

        lblTittleScreenBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/titlemainscreenupdated2.png"))); // NOI18N
        add(lblTittleScreenBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlayActionPerformed
        // TODO add your handling code here:
        BasicSFXstuff.play();
        mainPage.swapScreens(new LevelSelect(mainPage));

    }//GEN-LAST:event_buttonPlayActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:

        BasicSFXstuff.play();
        System.exit(0);//ends the game//https://www.youtube.com/watch?v=OwhvydQydVw


    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        // TODO add your handling code here:

        BasicSFXstuff.play();
        mainPage.swapScreens(new Settings(mainPage));
    }//GEN-LAST:event_btnSettingsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JLabel lblTIttleText;
    private javax.swing.JLabel lblTittleScreenBackground;
    // End of variables declaration//GEN-END:variables
}
