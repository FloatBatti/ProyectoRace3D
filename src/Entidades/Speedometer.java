/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.control.VehicleControl;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.ViewPort;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Quad;
import com.jme3.texture.FrameBuffer;
import com.jme3.texture.Image;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;
import com.jme3.ui.Picture;
import com.simsilica.lemur.Label;
import java.awt.Color;
import jdk.jfr.Enabled;
import main.Engine;



/**
 *
 * @author Juanjo
 */
public class Speedometer {
    
    private static Node node = new Node("speedo");
    private Node Nodeaguja ;
    private Player player ;
    private float speedVehicle;
    private Node speedoNeedleNode;
    private Label speedLabel;
    private Label gearLabel;
    
   public Speedometer (){
   
   }


    public Node getNodeaguja() {
        return Nodeaguja;
    }

    public static Node getNode() {
        return node;
    }
    

    public void createSpeedoGeom() {


        Texture speedoBgTex = Engine.getAssetManager().loadTexture("Textures/velocimetro.png");
        

        Geometry speedoBgGeom = new Geometry("Speedometer Background Geometry",
                new Quad(speedoBgTex.getImage().getWidth(), speedoBgTex.getImage().getHeight()));

        speedoBgGeom.setMaterial(new Material(Engine.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md"));
        speedoBgGeom.getMaterial().setTexture("ColorMap", speedoBgTex);
        speedoBgGeom.getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        
        
        
        Texture speedoNeedleTex = Engine.getAssetManager().loadTexture("Textures/speedo_needle_2.png");
        Geometry speedoNeedleGeom = new Geometry("Speedometer Needle Geometry",
                new Quad(speedoNeedleTex.getImage().getWidth(), speedoNeedleTex.getImage().getHeight()));

        speedoNeedleGeom.setMaterial(new Material(Engine.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md"));
        speedoNeedleGeom.getMaterial().setTexture("ColorMap", speedoNeedleTex);
        speedoNeedleGeom.getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);


        
        Engine.getLocalGuiNode().attachChild(speedoBgGeom);
        

      
        speedoBgGeom.setLocalTranslation(550, 0, 0);
        //speedoNeedleGeom.setLocalTranslation(620, 57, 0);
        
        
        
        node.attachChild(speedoBgGeom);
      //  node.attachChild(speedoNeedleGeom);
        

        Engine.getGuiNode().attachChild(node);
     
  
        
    }
    
   
}
    
    
 

   
    

