/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Entidades.Player;
import Entidades.Vehicle;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import main.Engine;
import main.Main;

/**
 *
 * @author Juanjo y Agus
 */
public class UserMenu extends javax.swing.JFrame {

    private static Player actualUser = null;
    
    
    private static Icon IAutitoTurro= new javax.swing.ImageIcon(UserMenu.class.getResource("/imagenes/AutitoTurro.jpg"));
    private static Icon IAutitoBussines= new javax.swing.ImageIcon(UserMenu.class.getResource("/imagenes/AutitoBussines.jpg"));
    private static Icon IAutitoPolice= new javax.swing.ImageIcon(UserMenu.class.getResource("/imagenes/AutitoPolice.jpg"));
   
  
    public static void setActualUser(Player actualUser){
        
        UserMenu.actualUser = actualUser;
        initAll();
    
    }
    
    public UserMenu() {
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

        PanelGeneral = new javax.swing.JPanel();
        lPassword = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Drift = new javax.swing.JLabel();
        MaxExplosionsTxt = new javax.swing.JLabel();
        MaximunLife = new javax.swing.JLabel();
        ActualUserTxt = new javax.swing.JLabel();
        TxtCoins = new javax.swing.JLabel();
        BtnPlay = new javax.swing.JButton();
        displayUsername5 = new javax.swing.JLabel();
        DriftProgress = new javax.swing.JProgressBar();
        LifeProgress = new javax.swing.JProgressBar();
        AFProgress = new javax.swing.JProgressBar();
        BtnAddDriff = new javax.swing.JLabel();
        BtnAddLife = new javax.swing.JLabel();
        BtnAddAF = new javax.swing.JLabel();
        DriftCost = new javax.swing.JLabel();
        LifeCost = new javax.swing.JLabel();
        AFCost = new javax.swing.JLabel();
        SelectedCar = new javax.swing.JLabel();
        AutoDefault = new javax.swing.JLabel();
        AutoTurro = new javax.swing.JLabel();
        AutoBussines = new javax.swing.JLabel();
        AutoPolice = new javax.swing.JLabel();
        WorkShopTitle = new javax.swing.JLabel();
        VehicleModelTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelGeneral.setBackground(new java.awt.Color(255, 255, 255));
        PanelGeneral.setPreferredSize(new java.awt.Dimension(900, 570));
        PanelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lPassword.setBackground(new java.awt.Color(0, 0, 0));
        lPassword.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 26)); // NOI18N
        lPassword.setForeground(new java.awt.Color(0, 0, 0));
        lPassword.setText("Selected Car");
        PanelGeneral.add(lPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        PanelGeneral.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 210, 10));

        Drift.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        Drift.setForeground(new java.awt.Color(0, 0, 0));
        Drift.setText("Drift");
        PanelGeneral.add(Drift, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 170, -1));

        MaxExplosionsTxt.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        MaxExplosionsTxt.setForeground(new java.awt.Color(0, 0, 0));
        MaxExplosionsTxt.setText("Last Explosions:");
        PanelGeneral.add(MaxExplosionsTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 270, -1));

        MaximunLife.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        MaximunLife.setForeground(new java.awt.Color(0, 0, 0));
        MaximunLife.setText("Maximun Life");
        PanelGeneral.add(MaximunLife, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 140, -1));

        ActualUserTxt.setBackground(new java.awt.Color(0, 0, 0));
        ActualUserTxt.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 26)); // NOI18N
        ActualUserTxt.setForeground(new java.awt.Color(0, 0, 0));
        ActualUserTxt.setText("User Name");
        PanelGeneral.add(ActualUserTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        TxtCoins.setBackground(new java.awt.Color(0, 0, 0));
        TxtCoins.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        TxtCoins.setForeground(new java.awt.Color(0, 0, 0));
        TxtCoins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coin.png"))); // NOI18N
        TxtCoins.setText("Coins");
        PanelGeneral.add(TxtCoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, -1));

        BtnPlay.setBackground(new java.awt.Color(255, 255, 255));
        BtnPlay.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        BtnPlay.setForeground(new java.awt.Color(0, 0, 0));
        BtnPlay.setText("Play");
        BtnPlay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnPlay.setContentAreaFilled(false);
        BtnPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPlay.setFocusPainted(false);
        BtnPlay.setFocusable(false);
        BtnPlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnPlay.setOpaque(true);
        BtnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnPlayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnPlayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnPlayMouseExited(evt);
            }
        });
        PanelGeneral.add(BtnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 150, 50));

        displayUsername5.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        displayUsername5.setForeground(new java.awt.Color(0, 0, 0));
        displayUsername5.setText("Acceleration Force");
        PanelGeneral.add(displayUsername5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 170, -1));
        PanelGeneral.add(DriftProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, 20));
        PanelGeneral.add(LifeProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, 20));
        PanelGeneral.add(AFProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, 20));

        BtnAddDriff.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BtnAddDriff.setForeground(new java.awt.Color(0, 0, 0));
        BtnAddDriff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnAddDriff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/addPoint.png"))); // NOI18N
        BtnAddDriff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAddDriff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAddDriff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAddDriffMouseClicked(evt);
            }
        });
        PanelGeneral.add(BtnAddDriff, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 30, 20));

        BtnAddLife.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BtnAddLife.setForeground(new java.awt.Color(0, 0, 0));
        BtnAddLife.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnAddLife.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/addPoint.png"))); // NOI18N
        BtnAddLife.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAddLife.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAddLife.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAddLifeMouseClicked(evt);
            }
        });
        PanelGeneral.add(BtnAddLife, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 30, 20));

        BtnAddAF.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BtnAddAF.setForeground(new java.awt.Color(0, 0, 0));
        BtnAddAF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnAddAF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/addPoint.png"))); // NOI18N
        BtnAddAF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAddAF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAddAF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAddAFMouseClicked(evt);
            }
        });
        PanelGeneral.add(BtnAddAF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 30, 20));

        DriftCost.setForeground(new java.awt.Color(0, 0, 0));
        DriftCost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buyStats.png"))); // NOI18N
        DriftCost.setText("10");
        PanelGeneral.add(DriftCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, 20));

        LifeCost.setForeground(new java.awt.Color(0, 0, 0));
        LifeCost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buyStats.png"))); // NOI18N
        LifeCost.setText("10");
        PanelGeneral.add(LifeCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, 20));

        AFCost.setForeground(new java.awt.Color(0, 0, 0));
        AFCost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buyStats.png"))); // NOI18N
        AFCost.setText("10");
        PanelGeneral.add(AFCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, 20));

        SelectedCar.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        SelectedCar.setForeground(new java.awt.Color(0, 0, 0));
        SelectedCar.setText("Model: ");
        PanelGeneral.add(SelectedCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 270, -1));

        AutoDefault.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        AutoDefault.setForeground(new java.awt.Color(0, 0, 0));
        AutoDefault.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AutoDefault.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Autito.jpg"))); // NOI18N
        AutoDefault.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AutoDefault.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AutoDefault.setPreferredSize(new java.awt.Dimension(160, 150));
        AutoDefault.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AutoDefaultMouseClicked(evt);
            }
        });
        PanelGeneral.add(AutoDefault, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, -1, -1));

        AutoTurro.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        AutoTurro.setForeground(new java.awt.Color(0, 0, 0));
        AutoTurro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AutoTurro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coin.png"))); // NOI18N
        AutoTurro.setToolTipText("");
        AutoTurro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AutoTurro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AutoTurro.setPreferredSize(new java.awt.Dimension(160, 150));
        AutoTurro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AutoTurroMouseClicked(evt);
            }
        });
        PanelGeneral.add(AutoTurro, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, -1, -1));

        AutoBussines.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        AutoBussines.setForeground(new java.awt.Color(0, 0, 0));
        AutoBussines.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AutoBussines.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coin.png"))); // NOI18N
        AutoBussines.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AutoBussines.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AutoBussines.setPreferredSize(new java.awt.Dimension(160, 150));
        AutoBussines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AutoBussinesMouseClicked(evt);
            }
        });
        PanelGeneral.add(AutoBussines, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, -1, -1));

        AutoPolice.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        AutoPolice.setForeground(new java.awt.Color(0, 0, 0));
        AutoPolice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AutoPolice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coin.png"))); // NOI18N
        AutoPolice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AutoPolice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AutoPolice.setPreferredSize(new java.awt.Dimension(160, 150));
        AutoPolice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AutoPoliceMouseClicked(evt);
            }
        });
        PanelGeneral.add(AutoPolice, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, -1, -1));

        WorkShopTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        WorkShopTitle.setForeground(new java.awt.Color(0, 0, 0));
        WorkShopTitle.setText("WorkShop:");
        PanelGeneral.add(WorkShopTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 270, -1));

        VehicleModelTxt.setForeground(new java.awt.Color(255, 255, 255));
        VehicleModelTxt.setText("jLabel1");
        PanelGeneral.add(VehicleModelTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 220, -1));

        getContentPane().add(PanelGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private static void initAll(){

        ActualUserTxt.setText("Usuario actual: " + actualUser.getUserName());
        TxtCoins.setText(actualUser.getCoins().toString());
        MaxExplosionsTxt.setText("Max Explosions: " + actualUser.getMaxExplosions().toString());
        SelectedCar.setText("Model: Normal Car");
        VehicleModelTxt.setText("Models/Autito.j3o");
        initStats();
        initShopCars();
 
    }
    
    private void refreshAll(){
        
        Player.savePlayer(actualUser);
        Player.loadPlayer(actualUser);
        
        initAll();
    }
    
    private static void initShopCars(){
        
        Integer shopCarsValue = actualUser.getWorkshop().getsCarsValue();
     
         AutoBussines.setVisible(false);
         AutoPolice.setVisible(false);
         
        
        if (shopCarsValue < 2){
            
            AutoTurro.setText("100");   
        }
        
        if (shopCarsValue >= 2 && shopCarsValue < 4){
            
            AutoTurro.setText("");
            AutoTurro.setIcon(IAutitoTurro);
            AutoBussines.setText("200");
            AutoBussines.setVisible(true);      
        }   
        
        if(shopCarsValue >= 3 && shopCarsValue < 4){
                       
            AutoTurro.setText("");
            AutoTurro.setIcon(IAutitoTurro);
            AutoBussines.setText("");
            AutoBussines.setIcon(IAutitoBussines);
            AutoBussines.setVisible(true);  
            AutoPolice.setText("300");
            AutoPolice.setVisible(true);
            
        }
        
        if(shopCarsValue == 4){
            
            AutoTurro.setText("");
            AutoTurro.setIcon(IAutitoTurro);
            AutoBussines.setText("");
            AutoBussines.setIcon(IAutitoBussines);
            AutoBussines.setVisible(true);  
            AutoPolice.setText("");
            AutoPolice.setIcon(IAutitoPolice);
            AutoPolice.setVisible(true);
        }
    }
    
    private static void initStats(){
        
        
        
        Integer lifeValue = actualUser.getWorkshop().getHealtValues();
        Integer afValue = actualUser.getWorkshop().getForceValues();
        Integer driftValue = actualUser.getWorkshop().getDriftValues();

        if (lifeValue == 100){
            
            LifeProgress.setValue(lifeValue);
            LifeCost.setText("MAX.");
            LifeCost.setIcon(null);
            
        }else if (lifeValue < 100){
            
            LifeProgress.setValue(lifeValue);
            Integer cost = (lifeValue/2 + 10);
            LifeCost.setText(cost.toString());
            
        }
        
        
        if (afValue == 100){
            
            AFProgress.setValue(afValue);
            AFCost.setText("MAX.");
            AFCost.setIcon(null);
            
        }else if (afValue < 100){
            
            AFProgress.setValue(afValue);
            Integer cost = (afValue/2 + 10);
            AFCost.setText(cost.toString());
        }
        
            
        if (driftValue == 100){
            
            DriftProgress.setValue(driftValue);
            DriftCost.setText("MAX.");
            DriftCost.setIcon(null);
            
        }else if (driftValue < 100){
            
            DriftProgress.setValue(driftValue);
            Integer cost = (driftValue/2 + 10);
            DriftCost.setText(cost.toString());
        }
 
        
    }
    
    private void BtnPlayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPlayMouseExited
        
        BtnPlay.setBackground(Color.WHITE);
        BtnPlay.setForeground(new Color (0,0,0));
    }//GEN-LAST:event_BtnPlayMouseExited

    private void BtnPlayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPlayMouseEntered
        
        BtnPlay.setBackground (new Color (153,0,0));
        BtnPlay.setForeground(new Color (255,204,51));
    }//GEN-LAST:event_BtnPlayMouseEntered

    private void BtnAddLifeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddLifeMouseClicked
         
        if (LifeProgress.getValue() == 100){
            
            JOptionPane.showMessageDialog(null, "You already have the maximum stats");
            
        } 
        else if(LifeProgress.getValue() < 100){
            
            Integer lifeCost =Integer.parseInt(LifeCost.getText());
            
            if (actualUser.getCoins() >= lifeCost){
                
                actualUser.getWorkshop().incremetHealt();
                actualUser.setCoins(actualUser.getCoins() - lifeCost);
                
            }else{   
                
                JOptionPane.showMessageDialog(null, "Insufficient coins");
            }
       
        }

        refreshAll();
    }//GEN-LAST:event_BtnAddLifeMouseClicked

    private void BtnAddAFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddAFMouseClicked
       
        if (AFProgress.getValue() == 100){
            
            JOptionPane.showMessageDialog(null, "You already have the maximum stats");
            
        } 
        else if(AFProgress.getValue() < 100){
            
            Integer afCost =Integer.parseInt(AFCost.getText());
            
            if (actualUser.getCoins() >= afCost){
                
                actualUser.getWorkshop().incremetForce();
                actualUser.setCoins(actualUser.getCoins() - afCost);
                
            }else{   
                
                JOptionPane.showMessageDialog(null, "Insufficient coins");
            }
       
        }

        refreshAll();
    }//GEN-LAST:event_BtnAddAFMouseClicked

    private void BtnAddDriffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddDriffMouseClicked
        
        if (DriftProgress.getValue() == 100){
            
            JOptionPane.showMessageDialog(null, "You already have the maximum stats");
            
        } 
        else if(DriftProgress.getValue() < 100){
            
            Integer driftCost =Integer.parseInt(DriftCost.getText());
            
            if (actualUser.getCoins() >= driftCost){
                
                actualUser.getWorkshop().incremetDrift();
                actualUser.setCoins(actualUser.getCoins() - driftCost);
                
            }else{   
                
                JOptionPane.showMessageDialog(null, "Insufficient coins");
            }
       
        }

        refreshAll();
    }//GEN-LAST:event_BtnAddDriffMouseClicked

    private void BtnPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPlayMouseClicked
        
        Player.savePlayer(actualUser);
        Vehicle vehicle = new Vehicle(2 * LifeProgress.getValue(), 3 * AFProgress.getValue(), DriftProgress.getValue(), VehicleModelTxt.getText());
        Engine.setActualPlayer(actualUser);
        Engine.setVehicle(vehicle);
        Main.startEngine = 1;
        this.dispose();

    }//GEN-LAST:event_BtnPlayMouseClicked

    private void AutoTurroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoTurroMouseClicked
         
        if(AutoTurro.getText().equals("")){
            
            SelectedCar.setText("Model: Turro Car");
            VehicleModelTxt.setText("Models/AutitoTurro.j3o");
            
            AutoDefault.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            AutoTurro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
            AutoBussines.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            AutoPolice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            
        }else{
            
            Integer vehicleCost = Integer.parseInt(AutoTurro.getText());
            
            if((!AutoTurro.getText().equals("")) && actualUser.getCoins() >= vehicleCost){
            
                actualUser.getWorkshop().buyCar();
                actualUser.setCoins(actualUser.getCoins()- Integer.parseInt(AutoTurro.getText()));
                refreshAll();
                       
            
            }else if(actualUser.getCoins() < vehicleCost){
            
                JOptionPane.showMessageDialog(null, "Insufficient coins");
            }   
            
        }
          
    }//GEN-LAST:event_AutoTurroMouseClicked

    private void AutoBussinesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoBussinesMouseClicked
        
        if(AutoBussines.getText().equals("")){
            
            SelectedCar.setText("Model: Bussines Car");
            VehicleModelTxt.setText("Models/AutitoBusiness.j3o");
            
            AutoDefault.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            AutoTurro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            AutoBussines.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
            AutoPolice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            
        }else{
            
            Integer vehicleCost = Integer.parseInt(AutoBussines.getText());
            
            if((!AutoBussines.getText().equals("")) && actualUser.getCoins() >= vehicleCost){
            
                actualUser.getWorkshop().buyCar();
                actualUser.setCoins(actualUser.getCoins()- Integer.parseInt(AutoBussines.getText()));
                refreshAll();
                
            }else if(actualUser.getCoins() < vehicleCost){
            
                JOptionPane.showMessageDialog(null, "Insufficient coins");
            }   
            
        }
    }//GEN-LAST:event_AutoBussinesMouseClicked

    private void AutoPoliceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoPoliceMouseClicked
        
        if(AutoPolice.getText().equals("")){
            
            SelectedCar.setText("Model: Police Car");
            VehicleModelTxt.setText("Models/Police.j3o");

            AutoDefault.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            AutoTurro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            AutoBussines.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            AutoPolice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
            
        }else{
            
            Integer vehicleCost = Integer.parseInt(AutoPolice.getText());
            
            if((!AutoPolice.getText().equals("")) && actualUser.getCoins() >= vehicleCost){
            
                actualUser.getWorkshop().buyCar();
                actualUser.setCoins(actualUser.getCoins()- Integer.parseInt(AutoPolice.getText()));
                refreshAll();
                
            }else if(actualUser.getCoins() < vehicleCost){
            
                JOptionPane.showMessageDialog(null, "Insufficient coins");
            }   
            
        }
    }//GEN-LAST:event_AutoPoliceMouseClicked

    private void AutoDefaultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoDefaultMouseClicked
       
        SelectedCar.setText("Model: Normal Car");
        VehicleModelTxt.setText("Models/Autito.j3o");

        AutoDefault.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        AutoTurro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AutoBussines.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AutoPolice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_AutoDefaultMouseClicked

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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel AFCost;
    private static javax.swing.JProgressBar AFProgress;
    private static javax.swing.JLabel ActualUserTxt;
    private static javax.swing.JLabel AutoBussines;
    private static javax.swing.JLabel AutoDefault;
    private static javax.swing.JLabel AutoPolice;
    private static javax.swing.JLabel AutoTurro;
    private javax.swing.JLabel BtnAddAF;
    private javax.swing.JLabel BtnAddDriff;
    private javax.swing.JLabel BtnAddLife;
    private javax.swing.JButton BtnPlay;
    private javax.swing.JLabel Drift;
    private static javax.swing.JLabel DriftCost;
    private static javax.swing.JProgressBar DriftProgress;
    private static javax.swing.JLabel LifeCost;
    private static javax.swing.JProgressBar LifeProgress;
    private static javax.swing.JLabel MaxExplosionsTxt;
    private javax.swing.JLabel MaximunLife;
    private javax.swing.JPanel PanelGeneral;
    private static javax.swing.JLabel SelectedCar;
    private static javax.swing.JLabel TxtCoins;
    private static javax.swing.JLabel VehicleModelTxt;
    private javax.swing.JLabel WorkShopTitle;
    private javax.swing.JLabel displayUsername5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lPassword;
    // End of variables declaration//GEN-END:variables
}
