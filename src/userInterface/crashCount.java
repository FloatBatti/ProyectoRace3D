
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Quad;
import com.jme3.texture.Texture;
import main.Engine;

/**
 *
 * @author Juanjo
 */
public class crashCount {
    
    private Node crashNode  = new Node ("crash");
    
    
    public crashCount (){
    
    
    }
    
    public void  createCrashTexture (){
    
            
        Texture crashTexture = Engine.getAssetManager().loadTexture("Textures/crash.png");
        Geometry crashGeom = new Geometry("crash",
         new Quad(crashTexture.getImage().getWidth(), crashTexture.getImage().getHeight()));
        crashGeom.setMaterial(new Material(Engine.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md"));
        crashGeom.getMaterial().setTexture("ColorMap", crashTexture);
        crashGeom.getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);

        crashGeom.setLocalTranslation(1650, 250, 0);
        crashNode.attachChild(crashGeom);

        Engine.getLocalGuiNode().attachChild(crashNode);

    
    }
    
    
    public void upgradeCrash (){
        
    
    }
    
    
    

    
}