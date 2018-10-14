package View;

import Controller.Controller;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControlPanel extends javax.swing.JFrame {
    private Controller controller;
    private int x,y;

    public ControlPanel(Controller controller) {
        initComponents();
        this.controller = controller;
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //Se pone el ícono del programa
        setIconImage(new ImageIcon(getClass().getResource("/images/logo.png")).getImage());
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolsPanel = new javax.swing.JPanel();
        minimizeIcon = new javax.swing.JLabel();
        closeIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        hireScreenProd = new javax.swing.JButton();
        fireScreenProd = new javax.swing.JButton();
        fireCableProd = new javax.swing.JButton();
        hireCableProd = new javax.swing.JButton();
        fireBatteryProd = new javax.swing.JButton();
        hireBatteryProd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        barCantScreenProd = new javax.swing.JProgressBar();
        barCantCableProd = new javax.swing.JProgressBar();
        barCantBatteryProd = new javax.swing.JProgressBar();
        cantBatteryProd = new javax.swing.JLabel();
        cantScreenProd = new javax.swing.JLabel();
        cantCableProd = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cantBatteries = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cantScreens = new javax.swing.JLabel();
        cantCables = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        hireAssambler = new javax.swing.JButton();
        fireAssambler = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cantAssamblers = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        timerState = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        managerState = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        daysToDelivery = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        phonesToDeliver = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 450));
        setUndecorated(true);
        setSize(new java.awt.Dimension(700, 450));

        toolsPanel.setBackground(new java.awt.Color(70, 24, 30));
        toolsPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                toolsPanelMouseDragged(evt);
            }
        });
        toolsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toolsPanelMousePressed(evt);
            }
        });

        minimizeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MinimizarBlanca.png"))); // NOI18N
        minimizeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeIconMouseClicked(evt);
            }
        });

        closeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EquisBlanca.png"))); // NOI18N
        closeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeIconMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/name.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N

        javax.swing.GroupLayout toolsPanelLayout = new javax.swing.GroupLayout(toolsPanel);
        toolsPanel.setLayout(toolsPanelLayout);
        toolsPanelLayout.setHorizontalGroup(
            toolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolsPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeIcon)
                .addGap(14, 14, 14))
        );
        toolsPanelLayout.setVerticalGroup(
            toolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(toolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimizeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        contentPanel.setBackground(new java.awt.Color(65, 65, 65));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hireScreenProd.setBackground(new java.awt.Color(70, 24, 30));
        hireScreenProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hireScreenProd.setForeground(new java.awt.Color(255, 255, 255));
        hireScreenProd.setText("Hire Screen Producer");
        hireScreenProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hireScreenProd.setFocusPainted(false);
        hireScreenProd.setFocusable(false);
        hireScreenProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hireScreenProdActionPerformed(evt);
            }
        });
        contentPanel.add(hireScreenProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 175, 32));

        fireScreenProd.setBackground(new java.awt.Color(70, 24, 30));
        fireScreenProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fireScreenProd.setForeground(new java.awt.Color(255, 255, 255));
        fireScreenProd.setText("Fire Screen Producer");
        fireScreenProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fireScreenProd.setFocusPainted(false);
        fireScreenProd.setFocusable(false);
        fireScreenProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fireScreenProdActionPerformed(evt);
            }
        });
        contentPanel.add(fireScreenProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 175, 32));

        fireCableProd.setBackground(new java.awt.Color(70, 24, 30));
        fireCableProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fireCableProd.setForeground(new java.awt.Color(255, 255, 255));
        fireCableProd.setText("Fire Cable Producer");
        fireCableProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fireCableProd.setFocusPainted(false);
        fireCableProd.setFocusable(false);
        fireCableProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fireCableProdActionPerformed(evt);
            }
        });
        contentPanel.add(fireCableProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 175, 32));

        hireCableProd.setBackground(new java.awt.Color(70, 24, 30));
        hireCableProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hireCableProd.setForeground(new java.awt.Color(255, 255, 255));
        hireCableProd.setText("Hire Cable Producer");
        hireCableProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hireCableProd.setFocusPainted(false);
        hireCableProd.setFocusable(false);
        hireCableProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hireCableProdActionPerformed(evt);
            }
        });
        contentPanel.add(hireCableProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 175, 32));

        fireBatteryProd.setBackground(new java.awt.Color(70, 24, 30));
        fireBatteryProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fireBatteryProd.setForeground(new java.awt.Color(255, 255, 255));
        fireBatteryProd.setText("Fire Battery Producer");
        fireBatteryProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fireBatteryProd.setFocusPainted(false);
        fireBatteryProd.setFocusable(false);
        fireBatteryProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fireBatteryProdActionPerformed(evt);
            }
        });
        contentPanel.add(fireBatteryProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 175, 32));

        hireBatteryProd.setBackground(new java.awt.Color(70, 24, 30));
        hireBatteryProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hireBatteryProd.setForeground(new java.awt.Color(255, 255, 255));
        hireBatteryProd.setText("Hire Battery Producer");
        hireBatteryProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hireBatteryProd.setFocusPainted(false);
        hireBatteryProd.setFocusable(false);
        hireBatteryProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hireBatteryProdActionPerformed(evt);
            }
        });
        contentPanel.add(hireBatteryProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 175, 32));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 3));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 3));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 3));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        contentPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 680, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(3, 32767));
        jPanel2.setMinimumSize(new java.awt.Dimension(3, 100));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        contentPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 16, -1, 200));

        barCantScreenProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barCantScreenProd.setForeground(new java.awt.Color(70, 24, 30));
        barCantScreenProd.setBorderPainted(false);
        barCantScreenProd.setStringPainted(true);
        contentPanel.add(barCantScreenProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 175, -1));

        barCantCableProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barCantCableProd.setForeground(new java.awt.Color(70, 24, 30));
        barCantCableProd.setBorderPainted(false);
        barCantCableProd.setStringPainted(true);
        contentPanel.add(barCantCableProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 175, -1));

        barCantBatteryProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barCantBatteryProd.setForeground(new java.awt.Color(70, 24, 30));
        barCantBatteryProd.setBorderPainted(false);
        barCantBatteryProd.setStringPainted(true);
        contentPanel.add(barCantBatteryProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 175, -1));

        cantBatteryProd.setForeground(new java.awt.Color(255, 255, 255));
        cantBatteryProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantBatteryProd.setText("jLabel1");
        contentPanel.add(cantBatteryProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 50, -1));

        cantScreenProd.setForeground(new java.awt.Color(255, 255, 255));
        cantScreenProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantScreenProd.setText("jLabel1");
        contentPanel.add(cantScreenProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 50, -1));

        cantCableProd.setForeground(new java.awt.Color(255, 255, 255));
        cantCableProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantCableProd.setText("jLabel1");
        contentPanel.add(cantCableProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 50, -1));

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Battery Productor");
        contentPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Productors:");
        contentPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Assembler of Cellphones");
        contentPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        cantBatteries.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        cantBatteries.setForeground(new java.awt.Color(255, 255, 255));
        cantBatteries.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantBatteries.setText("num");
        contentPanel.add(cantBatteries, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 40, -1));

        jLabel9.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cables:");
        contentPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Screens:");
        contentPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        cantScreens.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        cantScreens.setForeground(new java.awt.Color(255, 255, 255));
        cantScreens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantScreens.setText("num");
        contentPanel.add(cantScreens, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 40, -1));

        cantCables.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        cantCables.setForeground(new java.awt.Color(255, 255, 255));
        cantCables.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantCables.setText("num");
        contentPanel.add(cantCables, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 40, -1));

        jLabel8.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cable Productor");
        contentPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(3, 32767));
        jPanel3.setMinimumSize(new java.awt.Dimension(3, 100));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        contentPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 16, -1, 220));

        hireAssambler.setBackground(new java.awt.Color(70, 24, 30));
        hireAssambler.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hireAssambler.setForeground(new java.awt.Color(255, 255, 255));
        hireAssambler.setText("Hire Assembler");
        hireAssambler.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hireAssambler.setFocusPainted(false);
        hireAssambler.setFocusable(false);
        hireAssambler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hireAssamblerActionPerformed(evt);
            }
        });
        contentPanel.add(hireAssambler, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 110, 32));

        fireAssambler.setBackground(new java.awt.Color(70, 24, 30));
        fireAssambler.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fireAssambler.setForeground(new java.awt.Color(255, 255, 255));
        fireAssambler.setText("Fire Assembler");
        fireAssambler.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fireAssambler.setFocusPainted(false);
        fireAssambler.setFocusable(false);
        fireAssambler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fireAssamblerActionPerformed(evt);
            }
        });
        contentPanel.add(fireAssambler, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 110, 32));

        jLabel6.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Batteries:");
        contentPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, -1));

        jLabel11.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Productors:");
        contentPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel12.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Productors:");
        contentPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        jLabel13.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Screen Productor");
        contentPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Assemblers:");
        contentPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        cantAssamblers.setForeground(new java.awt.Color(255, 255, 255));
        cantAssamblers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantAssamblers.setText("jLabel1");
        contentPanel.add(cantAssamblers, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 50, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 40, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 50, 10));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 40, 10));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 50, 10));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 50, 10));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 50, 10));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 40, 10));

        jLabel15.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Timer:");
        contentPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, -1));

        timerState.setForeground(new java.awt.Color(255, 255, 255));
        timerState.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerState.setText("jLabel1");
        contentPanel.add(timerState, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 80, -1));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 80, 10));

        jLabel16.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Manager:");
        contentPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, -1, -1));

        managerState.setForeground(new java.awt.Color(255, 255, 255));
        managerState.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        managerState.setText("jLabel1");
        contentPanel.add(managerState, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 80, -1));

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 80, 10));

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 70, 10));

        jLabel17.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Days To Delivery:");
        contentPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, -1, -1));

        daysToDelivery.setForeground(new java.awt.Color(255, 255, 255));
        daysToDelivery.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        daysToDelivery.setText("jLabel1");
        contentPanel.add(daysToDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 70, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(3, 32767));
        jPanel4.setMinimumSize(new java.awt.Dimension(3, 100));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        contentPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, -1, 110));

        jSeparator11.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 80, 10));

        phonesToDeliver.setForeground(new java.awt.Color(255, 255, 255));
        phonesToDeliver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phonesToDeliver.setText("jLabel1");
        contentPanel.add(phonesToDeliver, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 80, -1));

        jLabel18.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Phones To Deliver:");
        contentPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(3, 32767));
        jPanel5.setMinimumSize(new java.awt.Dimension(3, 100));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        contentPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N
        info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoMouseClicked(evt);
            }
        });
        contentPanel.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 350, 30, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toolsPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolsPanelMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_toolsPanelMousePressed

    private void toolsPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolsPanelMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_toolsPanelMouseDragged

    private void minimizeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeIconMouseClicked
        controller.minimize(this);
    }//GEN-LAST:event_minimizeIconMouseClicked

    private void closeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeIconMouseClicked
        controller.close(this);
    }//GEN-LAST:event_closeIconMouseClicked

    private void hireScreenProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hireScreenProdActionPerformed
        this.controller.factory.hireScreensProd();
    }//GEN-LAST:event_hireScreenProdActionPerformed

    private void fireScreenProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fireScreenProdActionPerformed
        this.controller.factory.fireScreenProducer();
    }//GEN-LAST:event_fireScreenProdActionPerformed

    private void fireCableProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fireCableProdActionPerformed
        this.controller.factory.fireCableProducer();
    }//GEN-LAST:event_fireCableProdActionPerformed

    private void hireCableProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hireCableProdActionPerformed
        this.controller.factory.hireCablesProd();
    }//GEN-LAST:event_hireCableProdActionPerformed

    private void fireBatteryProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fireBatteryProdActionPerformed
        this.controller.factory.fireBatteryProducer();
    }//GEN-LAST:event_fireBatteryProdActionPerformed

    private void hireBatteryProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hireBatteryProdActionPerformed
        this.controller.factory.hireBatteriesProd();
    }//GEN-LAST:event_hireBatteryProdActionPerformed

    private void hireAssamblerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hireAssamblerActionPerformed
        this.controller.factory.hireAssembler();
    }//GEN-LAST:event_hireAssamblerActionPerformed

    private void fireAssamblerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fireAssamblerActionPerformed
        this.controller.factory.fireAssembler();
    }//GEN-LAST:event_fireAssamblerActionPerformed

    private void infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseClicked
        Icon icono = new ImageIcon(getClass().getResource("../images/logoCFRQ.png"));
        JOptionPane.showMessageDialog(this, "Software elaborado por Carlos Fontes y Rafael Quintero\n "
            + "       Proyecto N° 1 - Sistemas Operativos - UNIMET\n                       ©CF&RQ - FontquinCell\n "
            + "                      23 de Octubre de 2018", "Información", JOptionPane.INFORMATION_MESSAGE, icono);
    }//GEN-LAST:event_infoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JProgressBar barCantBatteryProd;
    public javax.swing.JProgressBar barCantCableProd;
    public javax.swing.JProgressBar barCantScreenProd;
    public javax.swing.JLabel cantAssamblers;
    public javax.swing.JLabel cantBatteries;
    public javax.swing.JLabel cantBatteryProd;
    public javax.swing.JLabel cantCableProd;
    public javax.swing.JLabel cantCables;
    public javax.swing.JLabel cantScreenProd;
    public javax.swing.JLabel cantScreens;
    private javax.swing.JLabel closeIcon;
    private javax.swing.JPanel contentPanel;
    public javax.swing.JLabel daysToDelivery;
    private javax.swing.JButton fireAssambler;
    private javax.swing.JButton fireBatteryProd;
    private javax.swing.JButton fireCableProd;
    private javax.swing.JButton fireScreenProd;
    private javax.swing.JButton hireAssambler;
    private javax.swing.JButton hireBatteryProd;
    private javax.swing.JButton hireCableProd;
    private javax.swing.JButton hireScreenProd;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JLabel managerState;
    private javax.swing.JLabel minimizeIcon;
    public javax.swing.JLabel phonesToDeliver;
    public javax.swing.JLabel timerState;
    private javax.swing.JPanel toolsPanel;
    // End of variables declaration//GEN-END:variables
}
