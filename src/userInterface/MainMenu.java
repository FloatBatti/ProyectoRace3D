/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Color;
import main.Main;

/**
 *
 * @author Juanjo
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        lPassword = new javax.swing.JLabel();
        lpoints = new javax.swing.JLabel();
        showAF = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Drift = new javax.swing.JLabel();
        displayUsername3 = new javax.swing.JLabel();
        displayUsername4 = new javax.swing.JLabel();
        showLife = new javax.swing.JLabel();
        MaximunLife = new javax.swing.JLabel();
        showCarmodel = new javax.swing.JLabel();
        lPassword2 = new javax.swing.JLabel();
        showUpgradepoints = new javax.swing.JLabel();
        lPassword3 = new javax.swing.JLabel();
        showCoins1 = new javax.swing.JLabel();
        btnBuycard = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnChangecar = new javax.swing.JButton();
        btnUpgradecar = new javax.swing.JButton();
        displayUsername5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lPassword.setBackground(new java.awt.Color(0, 0, 0));
        lPassword.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 26)); // NOI18N
        lPassword.setForeground(new java.awt.Color(0, 0, 0));
        lPassword.setText("Selected Car");
        jPanel1.add(lPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        lpoints.setBackground(new java.awt.Color(0, 0, 0));
        lpoints.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        lpoints.setForeground(new java.awt.Color(0, 0, 0));
        lpoints.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        lpoints.setText("Upgrade Points");
        jPanel1.add(lpoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 170, -1));

        showAF.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        showAF.setForeground(new java.awt.Color(0, 0, 0));
        showAF.setText("showAF");
        jPanel1.add(showAF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 80, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 210, 10));

        Drift.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        Drift.setForeground(new java.awt.Color(0, 0, 0));
        Drift.setText("Drift");
        jPanel1.add(Drift, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 170, -1));

        displayUsername3.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        displayUsername3.setForeground(new java.awt.Color(0, 0, 0));
        displayUsername3.setText("displayUsername");
        jPanel1.add(displayUsername3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 170, 20));

        displayUsername4.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        displayUsername4.setForeground(new java.awt.Color(0, 0, 0));
        displayUsername4.setText("Car Model");
        jPanel1.add(displayUsername4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 170, -1));

        showLife.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        showLife.setForeground(new java.awt.Color(0, 0, 0));
        showLife.setText("showLife");
        jPanel1.add(showLife, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 80, -1));

        MaximunLife.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        MaximunLife.setForeground(new java.awt.Color(0, 0, 0));
        MaximunLife.setText("Maximun Life");
        jPanel1.add(MaximunLife, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 140, -1));

        showCarmodel.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        showCarmodel.setForeground(new java.awt.Color(0, 0, 0));
        showCarmodel.setText("showCarmodel");
        jPanel1.add(showCarmodel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, -1));

        lPassword2.setBackground(new java.awt.Color(0, 0, 0));
        lPassword2.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 26)); // NOI18N
        lPassword2.setForeground(new java.awt.Color(0, 0, 0));
        lPassword2.setText("User Name");
        jPanel1.add(lPassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        showUpgradepoints.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        showUpgradepoints.setForeground(new java.awt.Color(0, 0, 0));
        showUpgradepoints.setText("showPoints");
        jPanel1.add(showUpgradepoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 90, 20));

        lPassword3.setBackground(new java.awt.Color(0, 0, 0));
        lPassword3.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        lPassword3.setForeground(new java.awt.Color(0, 0, 0));
        lPassword3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coin.png"))); // NOI18N
        lPassword3.setText(" Coins");
        jPanel1.add(lPassword3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 120, -1));

        showCoins1.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        showCoins1.setForeground(new java.awt.Color(0, 0, 0));
        showCoins1.setText("showCoins");
        jPanel1.add(showCoins1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 140, 30));

        btnBuycard.setBackground(new java.awt.Color(204, 204, 255));
        btnBuycard.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        btnBuycard.setForeground(new java.awt.Color(0, 0, 0));
        btnBuycard.setText("Buy Car");
        btnBuycard.setBorder(null);
        btnBuycard.setBorderPainted(false);
        btnBuycard.setContentAreaFilled(false);
        btnBuycard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuycard.setFocusPainted(false);
        btnBuycard.setFocusable(false);
        btnBuycard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuycard.setOpaque(true);
        btnBuycard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuycardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuycardMouseExited(evt);
            }
        });
        jPanel1.add(btnBuycard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 150, 50));

        btnPlay.setBackground(new java.awt.Color(204, 204, 255));
        btnPlay.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(0, 0, 0));
        btnPlay.setText("Play");
        btnPlay.setBorder(null);
        btnPlay.setBorderPainted(false);
        btnPlay.setContentAreaFilled(false);
        btnPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlay.setFocusPainted(false);
        btnPlay.setFocusable(false);
        btnPlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlay.setOpaque(true);
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayMouseExited(evt);
            }
        });
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 150, 50));

        btnChangecar.setBackground(new java.awt.Color(204, 204, 255));
        btnChangecar.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        btnChangecar.setForeground(new java.awt.Color(0, 0, 0));
        btnChangecar.setText("Change Car");
        btnChangecar.setBorder(null);
        btnChangecar.setBorderPainted(false);
        btnChangecar.setContentAreaFilled(false);
        btnChangecar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChangecar.setFocusPainted(false);
        btnChangecar.setFocusable(false);
        btnChangecar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChangecar.setOpaque(true);
        btnChangecar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnChangecarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChangecarMouseExited(evt);
            }
        });
        jPanel1.add(btnChangecar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 150, 50));

        btnUpgradecar.setBackground(new java.awt.Color(204, 204, 255));
        btnUpgradecar.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        btnUpgradecar.setForeground(new java.awt.Color(0, 0, 0));
        btnUpgradecar.setText("Upgrade Car");
        btnUpgradecar.setBorder(null);
        btnUpgradecar.setBorderPainted(false);
        btnUpgradecar.setContentAreaFilled(false);
        btnUpgradecar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpgradecar.setFocusPainted(false);
        btnUpgradecar.setFocusable(false);
        btnUpgradecar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpgradecar.setOpaque(true);
        btnUpgradecar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpgradecarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpgradecarMouseExited(evt);
            }
        });
        jPanel1.add(btnUpgradecar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 150, 50));

        displayUsername5.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        displayUsername5.setForeground(new java.awt.Color(0, 0, 0));
        displayUsername5.setText("Acceleration Force");
        jPanel1.add(displayUsername5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 972, 652));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseExited
        
        btnPlay.setBackground(new Color (204,204,255));
    }//GEN-LAST:event_btnPlayMouseExited

    private void btnPlayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseEntered
        btnPlay.setBackground(Color.red);
    }//GEN-LAST:event_btnPlayMouseEntered

    private void btnBuycardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuycardMouseExited
        btnBuycard.setBackground(new Color (204,204,255));
    }//GEN-LAST:event_btnBuycardMouseExited

    private void btnBuycardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuycardMouseEntered
        btnBuycard.setBackground (Color.red);
    }//GEN-LAST:event_btnBuycardMouseEntered

    private void btnChangecarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangecarMouseEntered
        btnChangecar.setBackground (Color.red);
    }//GEN-LAST:event_btnChangecarMouseEntered

    private void btnChangecarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangecarMouseExited
        
         btnChangecar.setBackground(new Color (204,204,255));
    }//GEN-LAST:event_btnChangecarMouseExited

    private void btnUpgradecarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpgradecarMouseEntered
        btnUpgradecar.setBackground(Color.red);
    }//GEN-LAST:event_btnUpgradecarMouseEntered

    private void btnUpgradecarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpgradecarMouseExited
        btnUpgradecar.setBackground(new Color (204,204,255));
    }//GEN-LAST:event_btnUpgradecarMouseExited

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
       
    }//GEN-LAST:event_btnPlayActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Drift;
    private javax.swing.JLabel MaximunLife;
    private javax.swing.JButton btnBuycard;
    private javax.swing.JButton btnChangecar;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnUpgradecar;
    private javax.swing.JLabel displayUsername3;
    private javax.swing.JLabel displayUsername4;
    private javax.swing.JLabel displayUsername5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lPassword2;
    private javax.swing.JLabel lPassword3;
    private javax.swing.JLabel lpoints;
    private javax.swing.JLabel showAF;
    private javax.swing.JLabel showCarmodel;
    private javax.swing.JLabel showCoins1;
    private javax.swing.JLabel showLife;
    private javax.swing.JLabel showUpgradepoints;
    // End of variables declaration//GEN-END:variables
}
