/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Entidades.Player;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juanjo y Agus
 */
public class Login extends javax.swing.JFrame {   
    
    public Login() {
        
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

        mainPanel = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        TUserName = new javax.swing.JLabel();
        TxtUserName = new javax.swing.JTextField();
        separatorUser = new javax.swing.JSeparator();
        TPassword = new javax.swing.JLabel();
        TxtPassword = new javax.swing.JPasswordField();
        separatorPass = new javax.swing.JSeparator();
        BtnLogin = new javax.swing.JButton();
        BtnRegister = new javax.swing.JButton();
        AreaImagen = new javax.swing.JPanel();
        Imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(730, 510));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setBackground(new java.awt.Color(255, 255, 255));
        Title.setFont(new java.awt.Font("DejaVu Sans Condensed", 3, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(153, 0, 0));
        Title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rueda.png"))); // NOI18N
        Title.setText("Riders On The Storm");
        mainPanel.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 460, -1));

        TUserName.setBackground(new java.awt.Color(0, 0, 0));
        TUserName.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        TUserName.setForeground(new java.awt.Color(0, 0, 0));
        TUserName.setText("User Name ");
        mainPanel.add(TUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        TxtUserName.setBackground(new java.awt.Color(255, 255, 255));
        TxtUserName.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        TxtUserName.setForeground(new java.awt.Color(0, 0, 0));
        TxtUserName.setBorder(null);
        TxtUserName.setCaretColor(new java.awt.Color(153, 153, 153));
        TxtUserName.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        mainPanel.add(TxtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 260, 40));

        separatorUser.setBackground(new java.awt.Color(0, 0, 0));
        separatorUser.setForeground(new java.awt.Color(0, 0, 0));
        mainPanel.add(separatorUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 260, 20));

        TPassword.setBackground(new java.awt.Color(0, 0, 0));
        TPassword.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        TPassword.setForeground(new java.awt.Color(0, 0, 0));
        TPassword.setText("Password");
        mainPanel.add(TPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        TxtPassword.setBackground(new java.awt.Color(255, 255, 255));
        TxtPassword.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        TxtPassword.setForeground(new java.awt.Color(0, 0, 0));
        TxtPassword.setBorder(null);
        mainPanel.add(TxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 260, 40));

        separatorPass.setBackground(new java.awt.Color(0, 0, 0));
        separatorPass.setForeground(new java.awt.Color(0, 0, 0));
        mainPanel.add(separatorPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 260, 20));

        BtnLogin.setBackground(new java.awt.Color(255, 255, 255));
        BtnLogin.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        BtnLogin.setForeground(new java.awt.Color(0, 0, 0));
        BtnLogin.setText("Login");
        BtnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnLogin.setContentAreaFilled(false);
        BtnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLogin.setFocusPainted(false);
        BtnLogin.setFocusable(false);
        BtnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnLogin.setOpaque(true);
        BtnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnLoginMouseExited(evt);
            }
        });
        mainPanel.add(BtnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 110, 50));

        BtnRegister.setBackground(new java.awt.Color(255, 255, 255));
        BtnRegister.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        BtnRegister.setForeground(new java.awt.Color(0, 0, 0));
        BtnRegister.setText("Register");
        BtnRegister.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnRegister.setContentAreaFilled(false);
        BtnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRegister.setFocusPainted(false);
        BtnRegister.setFocusable(false);
        BtnRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnRegister.setOpaque(true);
        BtnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRegisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnRegisterMouseExited(evt);
            }
        });
        mainPanel.add(BtnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 110, 50));

        AreaImagen.setBackground(new java.awt.Color(255, 255, 255));

        Imagen.setBackground(new java.awt.Color(255, 255, 255));
        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carscop.png"))); // NOI18N

        javax.swing.GroupLayout AreaImagenLayout = new javax.swing.GroupLayout(AreaImagen);
        AreaImagen.setLayout(AreaImagenLayout);
        AreaImagenLayout.setHorizontalGroup(
            AreaImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AreaImagenLayout.setVerticalGroup(
            AreaImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Imagen, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        mainPanel.add(AreaImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 370, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 746, 549);
    }// </editor-fold>//GEN-END:initComponents
    
    private Player checkUser(){
        
        Player playerTxt = new Player(TxtUserName.getText(), TxtPassword.getText());
        List<Player> listPlayer = Player.getListPlayer();
        
        if (listPlayer != null){
            
            for ( Player aux : listPlayer){
            
                if ( aux.equals(playerTxt)){
                
                    return aux;

                }
            }
            
        }
        
        return null;
    }
            
    private void BtnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLoginMouseEntered
        BtnLogin.setBackground (new Color (153,0,0));
        BtnLogin.setForeground(new Color (255,204,51));
    }//GEN-LAST:event_BtnLoginMouseEntered

    private void BtnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLoginMouseExited
        BtnLogin.setBackground(Color.WHITE);
        BtnLogin.setForeground(new Color (0,0,0));
    }//GEN-LAST:event_BtnLoginMouseExited

    private void BtnRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRegisterMouseEntered
       BtnRegister.setBackground (new Color (153,0,0));
       BtnRegister.setForeground(new Color (255,204,51));
    }//GEN-LAST:event_BtnRegisterMouseEntered

    private void BtnRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRegisterMouseExited
        BtnRegister.setBackground(Color.WHITE);
        BtnRegister.setForeground(new Color (0,0,0));
    }//GEN-LAST:event_BtnRegisterMouseExited

    private void BtnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLoginMouseClicked
        
        
        if (TxtUserName.getText().equals("") || TxtPassword.getText().equals("")){
            
            JOptionPane.showMessageDialog(null, "Please, complete the field");
            
        }else if (TxtUserName.getText().equals("Admin") && TxtPassword.getText().equals("666")){
            
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.setVisible(true);
            
         
        }else{
            
            Player actualPlayer = checkUser();
            
            if (actualPlayer != null) {
                
                UserMenu mainMenu = new UserMenu();
                mainMenu.setVisible(true);
                UserMenu.setActualUser(actualPlayer);
                this.dispose();
            }
            else{
                
                JOptionPane.showMessageDialog(null, "Incorrect user or password");
                
            }
        }
        
    }//GEN-LAST:event_BtnLoginMouseClicked

    private void BtnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRegisterMouseClicked
        
        CreateUser register = new CreateUser();
        register.setVisible(true);
        
    }//GEN-LAST:event_BtnRegisterMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AreaImagen;
    private javax.swing.JButton BtnLogin;
    private javax.swing.JButton BtnRegister;
    private javax.swing.JLabel Imagen;
    private javax.swing.JLabel TPassword;
    private javax.swing.JLabel TUserName;
    private javax.swing.JLabel Title;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JTextField TxtUserName;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JSeparator separatorPass;
    private javax.swing.JSeparator separatorUser;
    // End of variables declaration//GEN-END:variables
}