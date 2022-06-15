package userInterface;

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
public class NitroBar {
    
    private Node nodeNitroBar = new Node ("nitro") ;
    
    private double endurance;
    
    private Node backgroundNitrobar = new Node ("backGround");
    private Node tank = new Node ("tank");
  

    public NitroBar (double endurance){
        
        this.endurance = endurance;
   
    }
    
    public Node getNodeLifeBar() {
        return nodeNitroBar;
    }
    
    public void buildNitroBar (){
     Quad quad = new Quad ((float) ((float) endurance), 39);
     
     Geometry tankbar = new Geometry("nitrobar", quad);
     Material mat = new Material(Engine.getAssetManager(), 
            "Common/MatDefs/Misc/Unshaded.j3md");
     mat.setColor("Color", ColorRGBA.Green);
     
     tankbar.setMaterial(mat);
     
     nodeNitroBar.attachChild(tankbar);
     tankbar.setLocalTranslation(1469, 57, 0);  
     
     
     Texture pictureBar = Engine.getAssetManager().loadTexture("Textures/lifebar.png");
     
     Geometry textureBar = new Geometry("backgroundImage", new Quad ((float)(float)endurance+29
             , pictureBar.getImage().getHeight()));
  
     Material matPictureBar = new Material(Engine.getAssetManager(), 
            "Common/MatDefs/Misc/Unshaded.j3md");
     textureBar.setMaterial(matPictureBar);
     textureBar.getMaterial().setTexture("ColorMap", pictureBar);
     textureBar.getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
     textureBar.setLocalTranslation(1454, 45, 0);
     backgroundNitrobar.attachChild(textureBar);
     
 
     
     Texture picturetank = Engine.getAssetManager().loadTexture("Textures/nitroTank.png");
     Geometry tankgeo = new Geometry("tank", new Quad (picturetank.getImage().getWidth()
             , picturetank.getImage().getHeight()));
     Material matheart = new Material(Engine.getAssetManager(), 
            "Common/MatDefs/Misc/Unshaded.j3md");
     tankgeo.setMaterial(matheart);
     tankgeo.getMaterial().setTexture("ColorMap", picturetank);
     tankgeo.getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
     tankgeo.setLocalTranslation(1400, 45, 0);
     tank.attachChild(tankgeo);
     
    
     
     Engine.getLocalGuiNode().attachChild(tank);
     Engine.getLocalGuiNode().attachChild(backgroundNitrobar);
     Engine.getLocalGuiNode().attachChild(nodeNitroBar);
     
     
     
   
    }  
    
    public void updateNitro (float endurance, float maxEndurance){
            
        float scale ;
            
            if (endurance < maxEndurance){

                 scale = (float) (endurance/maxEndurance);
                 Engine.getLocalGuiNode().getChild("nitrobar").setLocalScale((float)scale, 1, 1);
                            
                 
                    if (endurance <= (maxEndurance*0.5)){
                       Material mat = new Material(Engine.getAssetManager(), 
                       "Common/MatDefs/Misc/Unshaded.j3md");
                       mat.setColor("Color", ColorRGBA.Green);
                       Engine.getLocalGuiNode().getChild("nitrobar").setMaterial(mat);
                       
                 }
                 
                if (endurance < (maxEndurance*0.3)){
                        Material mat = new Material(Engine.getAssetManager(), 
                        "Common/MatDefs/Misc/Unshaded.j3md");
                        mat.setColor("Color", ColorRGBA.Red);
                        Engine.getLocalGuiNode().getChild("nitrobar").setMaterial(mat);
                       
                }
                 
                 
            }

    }

}