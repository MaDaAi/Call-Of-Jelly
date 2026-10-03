/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package callofjelly;

import callofjelly.SFX.BasicSFXstuff;

/**
 *
 * @author Mansoor, Vedant, Zunair
 * @filename LevelSelect
 * @date Jan 2 2026
 * @description: To allow the user to choose what level they would like to
 * play(however there are no plans for another map)
 */
public class LevelSelect extends javax.swing.JPanel {

    frmMainGame mainPage; //this is the main screen

    public LevelSelect(frmMainGame main) {
        initComponents();
        lblbackgroundmoonselected.setVisible(false);
        btnLoadGame.setVisible(false);//making the play button for moonmap invisible

        mainPage = main; // assign the main page
    }
    private int levelMap = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoadGame = new javax.swing.JButton();
        TogMoonMap = new javax.swing.JToggleButton();
        BackBtn = new javax.swing.JButton();
        lblbackgroundmoonselected = new javax.swing.JLabel();
        lblImageBackground = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLoadGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/loadgame.png"))); // NOI18N
        btnLoadGame.setContentAreaFilled(false);
        btnLoadGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoadGame.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/loadgameDARK.png"))); // NOI18N
        btnLoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadGameActionPerformed(evt);
            }
        });
        add(btnLoadGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 870, 500, -1));

        TogMoonMap.setBorderPainted(false);
        TogMoonMap.setContentAreaFilled(false);
        TogMoonMap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TogMoonMap.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/highlighted.png"))); // NOI18N
        TogMoonMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TogMoonMapActionPerformed(evt);
            }
        });
        add(TogMoonMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 197, 630, 515));

        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/Back image.png"))); // NOI18N
        BackBtn.setBorderPainted(false);
        BackBtn.setContentAreaFilled(false);
        BackBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/backbutton highlighted.png"))); // NOI18N
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 920, 120, 100));

        lblbackgroundmoonselected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/moonselectedmapselector2.png"))); // NOI18N
        add(lblbackgroundmoonselected, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        lblImageBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/normal version map selector2.png"))); // NOI18N
        add(lblImageBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        BasicSFXstuff.play();
        mainPage.swapScreens(new TittleScreen(mainPage));

//        TMusic.stop();//Stops the music
    }//GEN-LAST:event_BackBtnActionPerformed

    private void TogMoonMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TogMoonMapActionPerformed
        // TODO add your handling code here:
        BasicSFXstuff.play();
        if (TogMoonMap.isSelected()) {
            lblbackgroundmoonselected.setVisible(true);//turnning off buttons
            btnLoadGame.setVisible(true);//making the play button for moonmap visible
            setLevelMap(1);//selected moon map

        } else {
            lblbackgroundmoonselected.setVisible(false);//turnning off buttons
            btnLoadGame.setVisible(false);//making the play button for moonmap invisible
            setLevelMap(0);//nothing selected
        }


    }//GEN-LAST:event_TogMoonMapActionPerformed

    private void btnLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadGameActionPerformed
        // TODO add your handling code here:
        BasicSFXstuff.play();
        if (getLevelMap() == 1) {//selected moon map
            mainPage.swapScreens(new MoonMap(mainPage));
        }

    }//GEN-LAST:event_btnLoadGameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JToggleButton TogMoonMap;
    private javax.swing.JButton btnLoadGame;
    private javax.swing.JLabel lblImageBackground;
    private javax.swing.JLabel lblbackgroundmoonselected;
    // End of variables declaration//GEN-END:variables

    //getters
    public int getLevelMap() {
        return levelMap;
    }

    //setters
    public void setLevelMap(int levelMap) {
        this.levelMap = levelMap;
    }

}
