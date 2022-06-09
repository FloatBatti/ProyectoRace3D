package userInterface;

import Entidades.Vehicle;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;

import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Quad;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;
import java.util.Timer;
import java.util.TimerTask;

import main.Engine;
import statics.Constant;

/**
 *
 * @author Juanjo
 */
public class LifeBar {
    
    private Node nodeLifeBar = new Node ("life") ;
    
    private double endurance;
    
    private Node backgroundLifebar = new Node ("backGround");
    private Node heart = new Node ("heart");
  

    public LifeBar (double endurance){
        
        this.endurance = endurance;
   
    }
    
    
    public void buildLifeBar (){
     Quad quad = new Quad ((float) ((float) endurance), 39);
     
     Geometry lifebar = new Geometry("lifebar", quad);
     Material mat = new Material(Engine.getAssetManager(), 
            "Common/MatDefs/Misc/Unshaded.j3md");
     mat.setColor("Color", ColorRGBA.Green);
     
     lifebar.setMaterial(mat);
     
     nodeLifeBar.attachChild(lifebar);
     lifebar.setLocalTranslation(269, 57, 0);  
     
     
     Texture pictureBar = Engine.getAssetManager().loadTexture("Textures/lifebar.png");
     
     Geometry textureBar = new Geometry("backgroundImage", new Quad ((float)(float)endurance+29
             , pictureBar.getImage().getHeight()));
  
     Material matPictureBar = new Material(Engine.getAssetManager(), 
            "Common/MatDefs/Misc/Unshaded.j3md");
     textureBar.setMaterial(matPictureBar);
     textureBar.getMaterial().setTexture("ColorMap", pictureBar);
     textureBar.getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
     textureBar.setLocalTranslation(254, 45, 0);
     backgroundLifebar.attachChild(textureBar);
     
 
     
     Texture pictureheart = Engine.getAssetManager().loadTexture("Textures/corazon.png");
     Geometry heartgeo = new Geometry("heart", new Quad (pictureheart.getImage().getHeight()
             , pictureheart.getImage().getHeight()));
     Material matheart = new Material(Engine.getAssetManager(), 
            "Common/MatDefs/Misc/Unshaded.j3md");
     heartgeo.setMaterial(matheart);
     heartgeo.getMaterial().setTexture("ColorMap", pictureheart);
     heartgeo.getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
     heartgeo.setLocalTranslation(240, 100, 0);
     heart.attachChild(heartgeo);
     
    
     
     Engine.getLocalGuiNode().attachChild(heart);
     Engine.getLocalGuiNode().attachChild(backgroundLifebar);
     Engine.getLocalGuiNode().attachChild(nodeLifeBar);
     
     
     
   
    }
    
    
    
    public void updateLife (float eventDmg  , Vehicle player){
            
        float scale ;
            
            if (player.getEndurance() < player.getMaxEndurance()){

                 scale = (float) ((float)player.getEndurance()/player.getMaxEndurance());
                 Engine.getLocalGuiNode().getChild("lifebar").setLocalScale((float)scale, 1, 1);
                                  while (player.getEndurance()>0){
                            Engine.getLocalGuiNode().getChild("heart").scale(1,1,1);
                            Engine.getLocalGuiNode().getChild("heart").scale((float)0.5, (float)0.5,(float) 0.5);
                            
                        }
                 
                    if (player.getEndurance () <= player.getMaxEndurance()*0.5){
                       Material mat = new Material(Engine.getAssetManager(), 
                       "Common/MatDefs/Misc/Unshaded.j3md");
                       mat.setColor("Color", ColorRGBA.Yellow);
                       Engine.getLocalGuiNode().getChild("lifebar").setMaterial(mat);
                       
                 }
                 
                if (player.getEndurance () < player.getMaxEndurance()*0.3){
                        Material mat = new Material(Engine.getAssetManager(), 
                        "Common/MatDefs/Misc/Unshaded.j3md");
                        mat.setColor("Color", ColorRGBA.Red);
       
                        
                       
                     
                       
                }
                 
                 
            }

    }
    


    public Node getNodeLifeBar() {
        return nodeLifeBar;
    }
    
    
    
}