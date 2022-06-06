/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Color;

/**
 *
 * @author Juanjo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        
        initComponents();
        txtUsername.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtPassword.setBackground(new java.awt.Color(0, 0, 0, 1));
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

        mainPanel = new javax.swing.JPanel();
        lUserName = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lPassword = new javax.swing.JLabel();
        separatorPass = new javax.swing.JSeparator();
        separatorUser = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        separatorTitle = new javax.swing.JSeparator();
        picture = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lUserName.setBackground(new java.awt.Color(0, 0, 0));
        lUserName.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        lUserName.setForeground(new java.awt.Color(0, 0, 0));
        lUserName.setText("Password");
        mainPanel.add(lUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        txtUsername.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setBorder(null);
        txtUsername.setCaretColor(new java.awt.Color(153, 153, 153));
        txtUsername.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        mainPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 260, 40));

        txtPassword.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setBorder(null);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        mainPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 260, 40));

        lPassword.setBackground(new java.awt.Color(0, 0, 0));
        lPassword.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        lPassword.setForeground(new java.awt.Color(0, 0, 0));
        lPassword.setText("User Name ");
        mainPanel.add(lPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        separatorPass.setBackground(new java.awt.Color(255, 255, 255));
        separatorPass.setForeground(new java.awt.Color(0, 0, 0));
        mainPanel.add(separatorPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 260, 30));

        separatorUser.setBackground(new java.awt.Color(0, 0, 0));
        separatorUser.setForeground(new java.awt.Color(0, 0, 0));
        mainPanel.add(separatorUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 260, 30));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/storm.png"))); // NOI18N
        title.setText("Riders On The Storm");
        mainPanel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 460, -1));

        separatorTitle.setBackground(new java.awt.Color(255, 255, 255));
        separatorTitle.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(separatorTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 410, 20));

        picture.setBackground(new java.awt.Color(255, 255, 255));
        picture.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carscop.png"))); // NOI18N
        picture.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        mainPanel.add(picture, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 560, 560));

        btnLogin.setBackground(new java.awt.Color(204, 204, 255));
        btnLogin.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        btnLogin.setFocusable(false);
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogin.setOpaque(true);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        mainPanel.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 110, 50));

        btnExit.setBackground(new java.awt.Color(204, 204, 255));
        btnExit.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 0, 0));
        btnExit.setText("Exit");
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setFocusPainted(false);
        btnExit.setFocusable(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setOpaque(true);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        mainPanel.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 110, 50));

        btnRegister.setBackground(new java.awt.Color(204, 204, 255));
        btnRegister.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(0, 0, 0));
        btnRegister.setText("Register");
        btnRegister.setBorder(null);
        btnRegister.setBorderPainted(false);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.setFocusPainted(false);
        btnRegister.setFocusable(false);
        btnRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegister.setOpaque(true);
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisterMouseExited(evt);
            }
        });
        mainPanel.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 110, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setBackground (Color.red);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setBackground(new Color (204,204,255));
    }//GEN-LAST:event_btnLoginMouseExited

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground (Color.red);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
         btnExit.setBackground(new Color (204,204,255));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseEntered
       btnRegister.setBackground (Color.red);
    }//GEN-LAST:event_btnRegisterMouseEntered

    private void btnRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseExited
        btnRegister.setBackground(new Color (204,204,255));
    }//GEN-LAST:event_btnRegisterMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lUserName;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel picture;
    private javax.swing.JSeparator separatorPass;
    private javax.swing.JSeparator separatorTitle;
    private javax.swing.JSeparator separatorUser;
    private javax.swing.JLabel title;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
