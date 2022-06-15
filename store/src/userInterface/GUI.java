/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.control.VehicleControl;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;


/**
 *
 * @author Fran
 */
public class GUI{
    
    private Node GUInterface;
    
    private BitmapFont myFont;
    private BitmapText crashCount;
    private BitmapText guiSpeed;
    private BitmapText guiCountDown;
    private final AssetManager assetManager;
    private BitmapText kmh;
    

    public BitmapText getGuiCountDown() {
        return guiCountDown;
    }
        
    
    
    public GUI(Node guiNode, AssetManager asset){
        GUInterface = guiNode;
        assetManager = asset;
        
        loadFonts();
    }
    
    private void  loadFonts(){
        
        myFont = (BitmapFont) assetManager.loadFont("Interface/fonts/DejaVuSansLight.fnt");
        
        crashCount = new BitmapText(myFont, false);
        guiSpeed = new BitmapText(myFont, false);
        guiCountDown = new BitmapText(myFont, false);
        kmh = new BitmapText(myFont, false);
    }
    
    public void drawCrash(ColorRGBA color, String text, int X, int Y, int size){
        crashCount.setSize(size);
        crashCount.setColor(color);                                        // font color
        crashCount.setText(text);                                          // the text
        crashCount.setLocalTranslation(X,Y,0);
        GUInterface.attachChild(crashCount);
    }
    
    public void drawCountDown(ColorRGBA color, String text, int X, int Y, int size){
        guiCountDown.setSize(size);
        guiCountDown.setColor(color);                                        // font color
        guiCountDown.setText(text);                                          // the text
        guiCountDown.setLocalTranslation(X, guiCountDown.getLineHeight(), Y);     // position
        GUInterface.attachChild(guiCountDown);
    }
    
    public void drawSpeed(ColorRGBA color, String text, int X, int Y, int size){
        guiSpeed.setSize(size);
        guiSpeed.setColor(color);                                        // font color
        guiSpeed.setText(text);                                          // the text
        guiSpeed.setLocalTranslation(X, Y, guiSpeed.getLineHeight());     // position
        GUInterface.attachChild(guiSpeed);
    }
    
    public void drawkmh(ColorRGBA color, String text, int X, int Y, int size){
        kmh.setSize(size);
        kmh.setColor(color);                                        // font color
        kmh.setText(text);                                          // the text
        kmh.setLocalTranslation(X, Y, 0);                           // position
        GUInterface.attachChild(kmh);
    }
    
    public void UpdateHUD(double endurance, VehicleControl vehicle){
        //GUI UPDATES
        
        crashCount.setText(CrashCount.crashCount + "!");
        
        if (vehicle.getCurrentVehicleSpeedKmHour()<100 && vehicle.getCurrentVehicleSpeedKmHour()>0){
            guiSpeed.setText("0" +(int) vehicle.getCurrentVehicleSpeedKmHour()); 
        }
        else {
            if (vehicle.getCurrentVehicleSpeedKmHour()>0)
           guiSpeed.setText("" +(int) vehicle.getCurrentVehicleSpeedKmHour()); 
        }
    }
    
    
    
   
        
}
 

