/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package callofjelly;

//imports
import callofjelly.SFX.BasicSFXstuff;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Mansoor, Vedant, Zunair
 * @date Dec 27, 2025
 * @filename MoonMap
 * @description: This is our main game panel where all game play occurs
 *
 */
public class MoonMap extends javax.swing.JPanel {

    frmMainGame mainPage; //this is the main screen

    private int PlayerHealthBarnumber;//stores value of player health from progress bar
    private int BaseHealthBarnumber;//stores value of base health from progress bar
    //creating objects from the currentlevelclass
    private Level currentLevel = new Level();
    private Player player = currentLevel.getPlayer();
    private Weapon currentWeapon = currentLevel.getWeapon();

    public MoonMap(frmMainGame main) {
        initComponents();
        panBuyStation.setVisible(false);//sets buystation as non visible so we cant see it
        panelPaused.setVisible(false);//setting the pausedmenu as non visible so we cant see it
        blurbackgroundLBL.setVisible(false);//setting the blue as non visible so we cant see it
        statsPanel.setVisible(false);//setting the stats panel as non visible so we cant see it
        timer.start();// starts the timer
        player.setState(player.getIdle());//set player state idle
        background = GameResources.readImage("/callofjelly/images/background.png");

        mainPage = main; // assign the main page
    }// end of constructor

    //Creates a timer that is used to update the game every frame
    public Timer timer = new Timer(1000 / 60, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            panDraw.repaint(); //redraws our scene
            updateGame();//calls game update
        }
    });

    // fields
    private boolean isSelfReviveActive = false; // self res is not active till bought

    // if keys are being pressed 
    private boolean aKey;//boolean meant to repressent A key
    private boolean dKey;//boolean meant to repressent D key

    // background
    private Image background;//stores the loaded background image

    // Creating objects
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panDraw = new javax.swing.JPanel(){

            //paintComponent happens on object creation and when
            //any changes occur to the frame (size change, new objects added.
                // etc.)
            @Override // this means that we are replacing the old
            //method that is prebuilt with a new one.
            public void paintComponent(Graphics g) {
                super.paintComponent(g); //calls the old paintComponent method
                draw(g);//calls the draw method
            }
        };
        pauseBTN = new javax.swing.JToggleButton();
        PanelPerks = new javax.swing.JPanel();
        lblPerkSlot1 = new javax.swing.JLabel();
        lblPerkSlot5 = new javax.swing.JLabel();
        lblPerkSlot2 = new javax.swing.JLabel();
        lblPerkSlot3 = new javax.swing.JLabel();
        lblPerkSlot4 = new javax.swing.JLabel();
        lblperkBackground = new javax.swing.JLabel();
        panBuyStation = new javax.swing.JPanel();
        lblBuyStation = new javax.swing.JLabel();
        btnBulletDmg = new javax.swing.JButton();
        btnMagUpgd = new javax.swing.JButton();
        btnReloadUpgrade = new javax.swing.JButton();
        btnSelfRevive = new javax.swing.JButton();
        btnPlayerHealth = new javax.swing.JButton();
        btnJugg = new javax.swing.JButton();
        lbl25Health = new javax.swing.JLabel();
        lblJugg = new javax.swing.JLabel();
        lblReloadSpeed = new javax.swing.JLabel();
        lblMagSizeUpdg = new javax.swing.JLabel();
        lblSelfRevive = new javax.swing.JLabel();
        lblBulletDamage = new javax.swing.JLabel();
        lblBuyStationBackground = new javax.swing.JLabel();
        panelPaused = new javax.swing.JPanel();
        btnQuit = new javax.swing.JButton();
        MainMenuButton = new javax.swing.JButton();
        RetryButton = new javax.swing.JButton();
        pausedbackgroundLBL = new javax.swing.JLabel();
        GUIPanel = new javax.swing.JPanel();
        BaseHealthProgressBar = new javax.swing.JProgressBar();
        playerIconlbl = new javax.swing.JLabel();
        BaseIconlbl = new javax.swing.JLabel();
        PlayerHealthProgressBar = new javax.swing.JProgressBar();
        lblWave = new javax.swing.JLabel();
        lblPoint = new javax.swing.JLabel();
        lblAmmo = new javax.swing.JLabel();
        lblSTATS = new javax.swing.JLabel();
        statsTOGGLEBUTTON = new javax.swing.JToggleButton();
        statsPanel = new javax.swing.JPanel();
        lblAlienKill = new javax.swing.JLabel();
        lblBruteKill = new javax.swing.JLabel();
        lblZombieKill = new javax.swing.JLabel();
        lblStatsBackground = new javax.swing.JLabel();
        blurbackgroundLBL = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panDraw.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        panDraw.setPreferredSize(new java.awt.Dimension(1920, 1080));
        panDraw.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panDrawMouseMoved(evt);
            }
        });
        panDraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panDrawMousePressed(evt);
            }
        });
        panDraw.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pauseBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/PauseButton.png"))); // NOI18N
        pauseBTN.setBorderPainted(false);
        pauseBTN.setContentAreaFilled(false);
        pauseBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pauseBTN.setFocusable(false);
        pauseBTN.setPreferredSize(new java.awt.Dimension(100, 100));
        pauseBTN.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/PauseButtonDARK.png"))); // NOI18N
        pauseBTN.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/resumebuttonDARK.png"))); // NOI18N
        pauseBTN.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/resumebutton.png"))); // NOI18N
        pauseBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBTNActionPerformed(evt);
            }
        });
        panDraw.add(pauseBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, 100));

        PanelPerks.setOpaque(false);
        PanelPerks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPerkSlot1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/DoubleTap100x.png"))); // NOI18N
        lblPerkSlot1.setEnabled(false);
        PanelPerks.add(lblPerkSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, 100, 100));

        lblPerkSlot5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/Jugg100x.png"))); // NOI18N
        lblPerkSlot5.setEnabled(false);
        PanelPerks.add(lblPerkSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 17, 100, 100));

        lblPerkSlot2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/MuleKick100x.png"))); // NOI18N
        lblPerkSlot2.setEnabled(false);
        PanelPerks.add(lblPerkSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 17, 100, 100));

        lblPerkSlot3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/SpeedCola100x.png"))); // NOI18N
        lblPerkSlot3.setEnabled(false);
        PanelPerks.add(lblPerkSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 17, 100, 100));

        lblPerkSlot4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/SelfRevive100x.png"))); // NOI18N
        lblPerkSlot4.setEnabled(false);
        PanelPerks.add(lblPerkSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 17, 100, 100));

        lblperkBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/perkbackgroundp2.png"))); // NOI18N
        PanelPerks.add(lblperkBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 130));

        panDraw.add(PanelPerks, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 940, -1, 130));

        panBuyStation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBuyStation.setFont(new java.awt.Font("Road Rage", 0, 26)
        );
        lblBuyStation.setForeground(new java.awt.Color(0, 255, 51));
        lblBuyStation.setText("BUY STATION");
        panBuyStation.add(lblBuyStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        btnBulletDmg.setBackground(new java.awt.Color(0, 0, 0));
        btnBulletDmg.setForeground(new java.awt.Color(0, 0, 0));
        btnBulletDmg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/DoubleTap80x.png"))); // NOI18N
        btnBulletDmg.setToolTipText("2x Bullet Damage");
        btnBulletDmg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBulletDmg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBulletDmg.setMaximumSize(new java.awt.Dimension(100, 100));
        btnBulletDmg.setMinimumSize(new java.awt.Dimension(100, 100));
        btnBulletDmg.setPreferredSize(new java.awt.Dimension(100, 100));
        btnBulletDmg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBulletDmgActionPerformed(evt);
            }
        });
        panBuyStation.add(btnBulletDmg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 80, 80));

        btnMagUpgd.setBackground(new java.awt.Color(0, 0, 0));
        btnMagUpgd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/MuleKick80x.png"))); // NOI18N
        btnMagUpgd.setToolTipText("Mule Kick - 2x Magazine");
        btnMagUpgd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMagUpgd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMagUpgd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMagUpgdActionPerformed(evt);
            }
        });
        panBuyStation.add(btnMagUpgd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 80, 80));

        btnReloadUpgrade.setBackground(new java.awt.Color(0, 0, 0));
        btnReloadUpgrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/SpeedCola80x.png"))); // NOI18N
        btnReloadUpgrade.setToolTipText("Speed Cola - 2x Faster Reload Speed");
        btnReloadUpgrade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReloadUpgrade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReloadUpgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadUpgradeActionPerformed(evt);
            }
        });
        panBuyStation.add(btnReloadUpgrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 80, 80));

        btnSelfRevive.setBackground(new java.awt.Color(0, 0, 0));
        btnSelfRevive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/SelfRevive80x.png"))); // NOI18N
        btnSelfRevive.setToolTipText("Self Revive - Extra Life");
        btnSelfRevive.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSelfRevive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelfRevive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelfReviveActionPerformed(evt);
            }
        });
        panBuyStation.add(btnSelfRevive, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 80, 80));

        btnPlayerHealth.setBackground(new java.awt.Color(0, 0, 0));
        btnPlayerHealth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/pixil-frame-0 (25).png"))); // NOI18N
        btnPlayerHealth.setToolTipText("+25 Player Heal");
        btnPlayerHealth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPlayerHealth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlayerHealth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerHealthActionPerformed(evt);
            }
        });
        panBuyStation.add(btnPlayerHealth, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 80, 80));

        btnJugg.setBackground(new java.awt.Color(0, 0, 0));
        btnJugg.setForeground(new java.awt.Color(0, 0, 0));
        btnJugg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/Jugg80x.png"))); // NOI18N
        btnJugg.setToolTipText("Juggernaut - 2x Max Health + Heal to max");
        btnJugg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJugg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuggActionPerformed(evt);
            }
        });
        panBuyStation.add(btnJugg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 80, 80));

        lbl25Health.setFont(new java.awt.Font("Road Rage", 0, 24)); // NOI18N
        lbl25Health.setForeground(new java.awt.Color(102, 0, 0));
        lbl25Health.setText("$20");
        panBuyStation.add(lbl25Health, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 150, 50, 20));

        lblJugg.setFont(new java.awt.Font("Road Rage", 0, 24)); // NOI18N
        lblJugg.setForeground(new java.awt.Color(102, 0, 0));
        lblJugg.setText("$250");
        panBuyStation.add(lblJugg, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 150, 60, 20));

        lblReloadSpeed.setFont(new java.awt.Font("Road Rage", 0, 24)); // NOI18N
        lblReloadSpeed.setForeground(new java.awt.Color(0, 153, 0));
        lblReloadSpeed.setText("$80");
        panBuyStation.add(lblReloadSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 270, 30, 20));

        lblMagSizeUpdg.setFont(new java.awt.Font("Road Rage", 0, 24)); // NOI18N
        lblMagSizeUpdg.setForeground(new java.awt.Color(0, 153, 0));
        lblMagSizeUpdg.setText("$100");
        panBuyStation.add(lblMagSizeUpdg, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 270, 60, 20));

        lblSelfRevive.setFont(new java.awt.Font("Road Rage", 0, 24)); // NOI18N
        lblSelfRevive.setForeground(new java.awt.Color(0, 102, 102));
        lblSelfRevive.setText("$300");
        panBuyStation.add(lblSelfRevive, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 390, 60, 20));

        lblBulletDamage.setFont(new java.awt.Font("Road Rage", 0, 24)); // NOI18N
        lblBulletDamage.setForeground(new java.awt.Color(0, 153, 0));
        lblBulletDamage.setText("$150");
        panBuyStation.add(lblBulletDamage, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 390, 60, 20));

        lblBuyStationBackground.setForeground(new java.awt.Color(0, 255, 51));
        lblBuyStationBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/buystationbackground.png"))); // NOI18N
        panBuyStation.add(lblBuyStationBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));

        panDraw.add(panBuyStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, 400, 600));

        panelPaused.setBackground(new java.awt.Color(255, 102, 0));
        panelPaused.setOpaque(false);
        panelPaused.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/quitBTNsmallertxt.png"))); // NOI18N
        btnQuit.setBorderPainted(false);
        btnQuit.setContentAreaFilled(false);
        btnQuit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/quitBTNsmallertxtDARK.png"))); // NOI18N
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        panelPaused.add(btnQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 200, 50));

        MainMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/MainMenuButton.png"))); // NOI18N
        MainMenuButton.setBorderPainted(false);
        MainMenuButton.setContentAreaFilled(false);
        MainMenuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MainMenuButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/MainMenuButtonDARK.png"))); // NOI18N
        MainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuButtonActionPerformed(evt);
            }
        });
        panelPaused.add(MainMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 200, 50));

        RetryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/RetryButton.png"))); // NOI18N
        RetryButton.setToolTipText("");
        RetryButton.setBorderPainted(false);
        RetryButton.setContentAreaFilled(false);
        RetryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RetryButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/RetryDARK.png"))); // NOI18N
        RetryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetryButtonActionPerformed(evt);
            }
        });
        panelPaused.add(RetryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 200, 50));

        pausedbackgroundLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/pausedbackground.png"))); // NOI18N
        panelPaused.add(pausedbackgroundLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        panDraw.add(panelPaused, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 600, 400));

        GUIPanel.setFocusable(false);
        GUIPanel.setOpaque(false);
        GUIPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BaseHealthProgressBar.setBackground(new java.awt.Color(102, 0, 0));
        BaseHealthProgressBar.setForeground(new java.awt.Color(0, 102, 0));
        BaseHealthProgressBar.setMaximum(200);
        BaseHealthProgressBar.setValue(200);
        BaseHealthProgressBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BaseHealthProgressBarStateChanged(evt);
            }
        });
        GUIPanel.add(BaseHealthProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 350, 20));

        playerIconlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/PlayerICON1.png"))); // NOI18N
        GUIPanel.add(playerIconlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 74, 74));

        BaseIconlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/JellyICON1.png"))); // NOI18N
        GUIPanel.add(BaseIconlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 74, 74));

        PlayerHealthProgressBar.setBackground(new java.awt.Color(102, 0, 0));
        PlayerHealthProgressBar.setForeground(new java.awt.Color(0, 102, 0));
        PlayerHealthProgressBar.setValue(100);
        PlayerHealthProgressBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PlayerHealthProgressBarStateChanged(evt);
            }
        });
        GUIPanel.add(PlayerHealthProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 350, 20));

        lblWave.setFont(new java.awt.Font("Help Me", 0, 48)); // NOI18N
        lblWave.setForeground(new java.awt.Color(255, 0, 51));
        lblWave.setText("Wave: 1");
        GUIPanel.add(lblWave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1000, 730, 50));

        lblPoint.setFont(new java.awt.Font("Help Me", 0, 36)); // NOI18N
        lblPoint.setForeground(new java.awt.Color(255, 51, 0));
        lblPoint.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPoint.setText("$0");
        GUIPanel.add(lblPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 800, 140));

        lblAmmo.setFont(new java.awt.Font("Help Me", 0, 100)); // NOI18N
        lblAmmo.setForeground(new java.awt.Color(255, 0, 51));
        lblAmmo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmmo.setText("30/30");
        lblAmmo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblAmmo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        lblAmmo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblAmmo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        GUIPanel.add(lblAmmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 980, 700, 100));

        lblSTATS.setFont(new java.awt.Font("Help Me", 0, 24)); // NOI18N
        lblSTATS.setForeground(new java.awt.Color(0, 0, 0));
        lblSTATS.setText("STATS:");
        lblSTATS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GUIPanel.add(lblSTATS, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 130, 30));

        statsTOGGLEBUTTON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/ScrollTOP.png"))); // NOI18N
        statsTOGGLEBUTTON.setToolTipText("SUPERSECRETSTATSPAGE");
        statsTOGGLEBUTTON.setBorderPainted(false);
        statsTOGGLEBUTTON.setContentAreaFilled(false);
        statsTOGGLEBUTTON.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        statsTOGGLEBUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsTOGGLEBUTTONActionPerformed(evt);
            }
        });
        GUIPanel.add(statsTOGGLEBUTTON, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 264, 50));

        statsPanel.setOpaque(false);
        statsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAlienKill.setFont(new java.awt.Font("Help Me", 0, 16)); // NOI18N
        lblAlienKill.setForeground(new java.awt.Color(255, 51, 51));
        lblAlienKill.setText("Alien Kills: 0");
        statsPanel.add(lblAlienKill, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 650, 50));

        lblBruteKill.setFont(new java.awt.Font("Help Me", 0, 16)); // NOI18N
        lblBruteKill.setForeground(new java.awt.Color(255, 0, 0));
        lblBruteKill.setText("Brute Kills: 0");
        statsPanel.add(lblBruteKill, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 690, 50));

        lblZombieKill.setFont(new java.awt.Font("Help Me", 0, 16)); // NOI18N
        lblZombieKill.setForeground(new java.awt.Color(255, 0, 51));
        lblZombieKill.setText("Zombie Kills: Enough(1B)");
        statsPanel.add(lblZombieKill, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 710, 50));

        lblStatsBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/Scroll2.png"))); // NOI18N
        statsPanel.add(lblStatsBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 290));

        GUIPanel.add(statsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 264, 290));

        blurbackgroundLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/callofjelly/images/blurbackground.png"))); // NOI18N
        blurbackgroundLBL.setText("jLabel1");
        GUIPanel.add(blurbackgroundLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        panDraw.add(GUIPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        add(panDraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        int keyCode = evt.getKeyCode(); // get keycode
//        System.out.println(keyCode); // print keycode 

        if (timer.isRunning()) { // only if the timer is on. Prevents from doing anything when game is paused 
            currentLevel.interacting(keyCode);
//            if (!pausedbackgroundLBL.isVisible()) {
            if (player.getHitbox().intersects(currentLevel.getBase().getHitBox()) && keyCode == 66 && !panelPaused.isVisible()) {// if the player is at the base and presses b
                timer.stop();//pauses game
                panBuyStation.setVisible(true);//buystation sets to visible
                statsTOGGLEBUTTON.setVisible(false);
                pauseBTN.setVisible(false);//pxuse btn sets to non visible
                blurbackgroundLBL.setVisible(true);//setting the blur as  visible so we can see it
            }// end of B
        } else {
            if (keyCode == 66 && !panelPaused.isVisible()) { // you can click B to resume 
                timer.start();//resumes game
                panBuyStation.setVisible(false);//buystation sets to non visible
                statsTOGGLEBUTTON.setVisible(true);
                pauseBTN.setVisible(true);//pause btn sets to visible
                blurbackgroundLBL.setVisible(false);//setting the blue as  visible so we can see it
            }
//            }

        }// end of if running


    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

        int keyCode = evt.getKeyCode();//get keycode
        if (keyCode == 65 || keyCode == 68) {//if key realeased is a or d
            currentLevel.setCameraDir(0);//set cameradir to 0
            player.setXDirection(0);//set xdirection 0
            aKey = false;//not using it/released
            dKey = false;//not using it/released
            player.setState(player.getIdle());//set the players state to idle
        }


    }//GEN-LAST:event_formKeyReleased


    private void panDrawMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panDrawMousePressed

        // if the mouse button = 1 which is left click (only able to shoot with left click) 
        if (timer.isRunning() && evt.getButton() == 1) { // if the timer is running THEN only shoot (this makes it so that player can't prefire bullets when game is paused)
            int mouseX = evt.getX() + currentLevel.getCameraX(); // Add cameraX to get world coordinates
            int mouseY = evt.getY();//mouse y position(screen cords)
            currentLevel.shoot(mouseX, mouseY);//fire gun toward where we clicked
        }
    }//GEN-LAST:event_panDrawMousePressed

    private void panDrawMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panDrawMouseMoved

    }//GEN-LAST:event_panDrawMouseMoved

    private void PlayerHealthProgressBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PlayerHealthProgressBarStateChanged

        PlayerHealthBarnumber = PlayerHealthProgressBar.getValue();//get the current health value
        if (PlayerHealthBarnumber <= 0) {//player has died
            if (isSelfReviveActive == true) { // if the self revive is active
                setPlayerHealthMax(); // make player max health again
                isSelfReviveActive = false; // self res is not active anymore
                lblPerkSlot4.setEnabled(false);//making it visible now(perk slot)

                //Reset the player State so that his animations keep working after the self res
                player.setState(player.getIdle()); // reset player state back to idle
                player.getIdle().setCurrentFrame(0); // reset current frame back to 0
                player.setCurrentTime(0); // eset the animation timer back 0

                player.setFacingRight(true); // should spawn facing right
                player.setWidthPlayer(117);//set proper width for facing right
            } else {
                timer.stop();// stops the timer just incase
                mainPage.swapScreens(new DiedScreen(mainPage));//switch to the death screen
            }// end of self revive if
        }// end of if
    }//GEN-LAST:event_PlayerHealthProgressBarStateChanged

    private void BaseHealthProgressBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BaseHealthProgressBarStateChanged
        // TODO add your handling code here:
        BaseHealthBarnumber = BaseHealthProgressBar.getValue();//get current base health
        if (BaseHealthBarnumber <= 0) {//base has been destroyed
            timer.stop();// stops the timer just incase
            mainPage.swapScreens(new BaseFallenScreen(mainPage));//switch to bas fallen screen
        }
    }//GEN-LAST:event_BaseHealthProgressBarStateChanged


    private void btnJuggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuggActionPerformed
        if (currentLevel.getPointCount() >= 250) { // needs 250 points
            player.setMaxHealth(player.getMaxHealth() + 100); // add extra max health
            PlayerHealthProgressBar.setMaximum(player.getMaxHealth()); // add the extra health into the health bar
            setPlayerHealthMax(); // set the player health to max as well
            currentLevel.setPointCount(currentLevel.getPointCount() - 250); // deduct point count
            lblPoint.setText("$" + currentLevel.formatPoints()); // visually set the points
            btnJugg.setVisible(false); // make it non usable as its only a one time upgrade
            lblJugg.setVisible(false); // set the lable invisble as well
            lblPerkSlot5.setEnabled(true);//making it visible now(perk slot)

        }
        this.requestFocus();//return focus to game panel(doesnt keep you stuck)
    }//GEN-LAST:event_btnJuggActionPerformed

    private void btnPlayerHealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerHealthActionPerformed
        if (currentLevel.getPointCount() >= 20 && player.getCurrentHealth() < player.getMaxHealth()) {//check if player has enough points and isnt at full health
            player.setCurrentHealth(player.getCurrentHealth() + 25); // do this first so then it actually saves the change after exiting buystation
            PlayerHealthProgressBar.setValue(player.getCurrentHealth()); // visually set it
            currentLevel.setPointCount(currentLevel.getPointCount() - 20);// deduct point count
            lblPoint.setText("$" + currentLevel.formatPoints()); // visually set the points
            if (player.getCurrentHealth() > player.getMaxHealth()) { // if the player has 90 health and their health goes to 115 after button
                player.setCurrentHealth(player.getMaxHealth()); // set it back to max
                PlayerHealthProgressBar.setValue(player.getCurrentHealth()); // visually as well
            }
        }
        this.requestFocus();//return focus to game panel(doesnt keep you stuck)
    }//GEN-LAST:event_btnPlayerHealthActionPerformed

    private void btnSelfReviveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelfReviveActionPerformed
        if (currentLevel.getPointCount() >= 300) {//check if player has enough points
            isSelfReviveActive = true; // self revive is active
            currentLevel.setPointCount(currentLevel.getPointCount() - 300); // deduct point count
           lblPoint.setText("$" + currentLevel.formatPoints()); // visually set the points
            btnSelfRevive.setVisible(false); // make it non usable as its only a one time upgrade
            lblSelfRevive.setVisible(false); // set the lable invisble as well
            lblPerkSlot4.setEnabled(true);//making it visible now(perk slot)

        }
        this.requestFocus();//return focus to game panel(doesnt keep you stuck)
    }//GEN-LAST:event_btnSelfReviveActionPerformed

    private void btnReloadUpgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadUpgradeActionPerformed
        if (currentLevel.getPointCount() >= 80) {//check if player has enough points(greater than or equal to 80)
            currentWeapon.setReloadTime(currentWeapon.getReloadTime() / 2);// Half the reload time
            currentLevel.setPointCount(currentLevel.getPointCount() - 80); // deduct point count
            lblPoint.setText("$" + currentLevel.formatPoints()); // visually set the points
            btnReloadUpgrade.setVisible(false); // make it non usable as its only a one time upgrade
            lblReloadSpeed.setVisible(false); // set the lable invisble as well
            lblPerkSlot3.setEnabled(true);//making it visible now(perk slot)

        }
        this.requestFocus();//return focus to game panel(doesnt keep you stuck)
    }//GEN-LAST:event_btnReloadUpgradeActionPerformed

    private void btnMagUpgdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMagUpgdActionPerformed

        if (currentLevel.getPointCount() >= 100) {//check if player has enough points(greater than or equal to 100)
            currentWeapon.setMagSize(currentWeapon.getMagSize() + 30);// add 30 extra 30 ammunition
            currentLevel.setPointCount(currentLevel.getPointCount() - 100); // deduct point count
            lblPoint.setText("$" + currentLevel.formatPoints()); // visually set the points
            lblAmmo.setText(currentWeapon.ammoDisplay()); // visually set the ammo display
            btnMagUpgd.setVisible(false); // make it non usable as its only a one time upgrade
            lblMagSizeUpdg.setVisible(false); // set the lable invisble as well
            lblPerkSlot2.setEnabled(true);//making it visible now(perk slot)

        }
        this.requestFocus();//return focus to game panel(doesnt keep you stuck)
    }//GEN-LAST:event_btnMagUpgdActionPerformed

    private void btnBulletDmgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBulletDmgActionPerformed
        if (currentLevel.getPointCount() >= 150) {//check if player has enough points(greater than or equal to 150)
            currentLevel.bulletDamage(); // update the point counter
           lblPoint.setText("$" + currentLevel.formatPoints()); // visually set the points
            btnBulletDmg.setVisible(false); // make it non usable as its only a one time upgrade
            lblBulletDamage.setVisible(false); // set the lable invisble as well
            lblPerkSlot1.setEnabled(true);//making it visible now(perk slot)
        }
        this.requestFocus();//return focus to game panel(doesnt keep you stuck)
    }//GEN-LAST:event_btnBulletDmgActionPerformed

    private void RetryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetryButtonActionPerformed

        BasicSFXstuff.play();//play click basicclicksoundeffect

        timer.stop();// stops the timer just incase
        mainPage.swapScreens(new MoonMap(mainPage));//restart(create a new instance)
    }//GEN-LAST:event_RetryButtonActionPerformed

    private void MainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuButtonActionPerformed
        // TODO add your handling code here:

        BasicSFXstuff.play();//play click basicclicksoundeffect

        timer.stop();// stops the timer just incase
        mainPage.swapScreens(new TittleScreen(mainPage));//restart(create a new instance)

    }//GEN-LAST:event_MainMenuButtonActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:

        BasicSFXstuff.play();//play click basicclicksoundeffect
        System.exit(0);//ends the game//https://www.youtube.com/watch?v=OwhvydQydVw
    }//GEN-LAST:event_btnQuitActionPerformed

    private void pauseBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBTNActionPerformed

        BasicSFXstuff.play(); // play sound
        if (pauseBTN.isSelected()) {
            timer.stop(); // stop timer
            panelPaused.setVisible(true); // make pause gui visible
            blurbackgroundLBL.setVisible(true);//setting the blue as  visible so we can see it
        } else {
            timer.start(); // resume the timer
            panelPaused.setVisible(false); // disable pause gui
            blurbackgroundLBL.setVisible(false);//setting the blue as non visible so we cant see it
        }
    }//GEN-LAST:event_pauseBTNActionPerformed

    private void statsTOGGLEBUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsTOGGLEBUTTONActionPerformed

        BasicSFXstuff.play();
        if (statsTOGGLEBUTTON.isSelected()) {//if the stats toggle is toggled
            statsPanel.setVisible(true);//sets stats panel visible
        } else {
            statsPanel.setVisible(false);//sets stats panel non visible
        }
    }//GEN-LAST:event_statsTOGGLEBUTTONActionPerformed

    private void setPlayerHealthMax() {
        player.setCurrentHealth(player.getMaxHealth()); // make player max health again
        PlayerHealthProgressBar.setValue(player.getMaxHealth());//update health bar
    }

    public void updateGame() { // method to update game 
        currentLevel.updateProjectile(panDraw.getWidth(), panDraw.getHeight()); // update the projectiles

        currentLevel.updateCamera(); // update the camera first
        currentLevel.updatePlayer(aKey, dKey); // then updating the player

        // change labels after updating player
        if (currentWeapon.isIsReloading()) { // if weapon is reloading
            lblAmmo.setText("RELOADING"); // set text to show its reloading
        } else {
            lblAmmo.setText(currentWeapon.ammoDisplay()); // set it back to show amount of ammo
        }
        PlayerHealthProgressBar.setValue(player.getCurrentHealth()); // update the player health bar

        currentLevel.updateEnemy(); // update the enemy
        // change labels after updating
        pointsUpdate();//update points and kill counters
        PlayerHealthProgressBar.setValue(player.getCurrentHealth());//update player progress bar(health bar)
        BaseHealthProgressBar.setValue(currentLevel.getBase().getCurrentHealth());//update base progress bar(health bar)

        //update waves
        currentLevel.updateWaves();
        // update labels
        if (currentLevel.getWaveTimer() > 0) { // When the wave time is greater than 0
            lblWave.setText("Next wave in: " + currentLevel.getWaveTimer() / 60 + " seconds");
        } else {
            lblWave.setText("Wave : " + currentLevel.getWaves().getWaveNumber()); // Wave number
        }

        panDraw.repaint(); //redraws our scene
        this.requestFocus();//return focus to game panel(doesnt keep you stuck)

    }//end of gameupdate

    private void pointsUpdate() { // method to display the points 
        lblPoint.setText("$" + currentLevel.formatPoints()); //update money display
        lblZombieKill.setText("Zombie Kills: " + currentLevel.formatZombieKills());//update zombie kills
        lblBruteKill.setText("Brute Kills: " + currentLevel.formatBruteKills());//update brute kills
        lblAlienKill.setText("Alien Kills: " + currentLevel.formatAlienKills());//update alien kills

    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // Draw background (scrolls using cameraX)
        if (background != null) {
            g2.drawImage(background, -currentLevel.getCameraX(), 0, null);//the world moves opposite to the camera so use negative
        }

        currentLevel.drawEnemy(g2);//draw all enemies
        currentLevel.drawProjectile(g2);//draw all bullets
        player.draw(g2);//draw player
        currentLevel.getBase().draw(g2, currentLevel.getCameraX());//draw base

    }// end of draw


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BaseHealthProgressBar;
    private javax.swing.JLabel BaseIconlbl;
    private javax.swing.JPanel GUIPanel;
    private javax.swing.JButton MainMenuButton;
    private javax.swing.JPanel PanelPerks;
    private javax.swing.JProgressBar PlayerHealthProgressBar;
    private javax.swing.JButton RetryButton;
    private javax.swing.JLabel blurbackgroundLBL;
    private javax.swing.JButton btnBulletDmg;
    private javax.swing.JButton btnJugg;
    private javax.swing.JButton btnMagUpgd;
    private javax.swing.JButton btnPlayerHealth;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnReloadUpgrade;
    private javax.swing.JButton btnSelfRevive;
    private javax.swing.JLabel lbl25Health;
    private javax.swing.JLabel lblAlienKill;
    private javax.swing.JLabel lblAmmo;
    private javax.swing.JLabel lblBruteKill;
    private javax.swing.JLabel lblBulletDamage;
    private javax.swing.JLabel lblBuyStation;
    private javax.swing.JLabel lblBuyStationBackground;
    private javax.swing.JLabel lblJugg;
    private javax.swing.JLabel lblMagSizeUpdg;
    private javax.swing.JLabel lblPerkSlot1;
    private javax.swing.JLabel lblPerkSlot2;
    private javax.swing.JLabel lblPerkSlot3;
    private javax.swing.JLabel lblPerkSlot4;
    private javax.swing.JLabel lblPerkSlot5;
    private javax.swing.JLabel lblPoint;
    private javax.swing.JLabel lblReloadSpeed;
    private javax.swing.JLabel lblSTATS;
    private javax.swing.JLabel lblSelfRevive;
    private javax.swing.JLabel lblStatsBackground;
    private javax.swing.JLabel lblWave;
    private javax.swing.JLabel lblZombieKill;
    private javax.swing.JLabel lblperkBackground;
    private javax.swing.JPanel panBuyStation;
    private javax.swing.JPanel panDraw;
    private javax.swing.JPanel panelPaused;
    private javax.swing.JToggleButton pauseBTN;
    private javax.swing.JLabel pausedbackgroundLBL;
    private javax.swing.JLabel playerIconlbl;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JToggleButton statsTOGGLEBUTTON;
    // End of variables declaration//GEN-END:variables
}
