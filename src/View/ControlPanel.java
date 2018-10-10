package View;

import Controller.Controller;

public class ControlPanel extends javax.swing.JFrame {
    private Controller controller;
    private int x,y;

    public ControlPanel(Controller controller) {
        initComponents();
        this.controller = controller;
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolsPanel = new javax.swing.JPanel();
        minimizeIcon = new javax.swing.JLabel();
        closeIcon = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 450));
        setMinimumSize(new java.awt.Dimension(700, 450));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(700, 450));
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

        javax.swing.GroupLayout toolsPanelLayout = new javax.swing.GroupLayout(toolsPanel);
        toolsPanel.setLayout(toolsPanelLayout);
        toolsPanelLayout.setHorizontalGroup(
            toolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolsPanelLayout.createSequentialGroup()
                .addContainerGap(616, Short.MAX_VALUE)
                .addComponent(minimizeIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeIcon)
                .addGap(14, 14, 14))
        );
        toolsPanelLayout.setVerticalGroup(
            toolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolsPanelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(toolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(minimizeIcon))
                .addGap(16, 16, 16))
        );

        contentPanel.setBackground(new java.awt.Color(65, 65, 65));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeIcon;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel minimizeIcon;
    private javax.swing.JPanel toolsPanel;
    // End of variables declaration//GEN-END:variables
}
