package userInterface;

import Entidades.Vehicle;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;

import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Quad;
import main.Engine;
import statics.Constant;

/**
 *
 * @author Juanjo
 */
public class LifeBar {
    
        private Node nodeLifeBar = new Node ("life") ;
  

    public LifeBar (){
        
   
    }
    
    
    public void buildLifeBar (){
     Quad quad = new Quad (Constant.MAX_LIFE , 40);
     Geometry lifebar = new Geometry("lifebar", quad);
 
     Material mat = new Material(Engine.getAssetManager(), 
            "Common/MatDefs/Misc/Unshaded.j3md");
     mat.setColor("Color", ColorRGBA.Green);
     lifebar.setMaterial(mat);
     
     nodeLifeBar.attachChild(lifebar);
     lifebar.setLocalTranslation(250, 35, 0);  
     Engine.getLocalGuiNode().attachChild(nodeLifeBar);
     

   
    }
    
    public void updateLife (float eventDmg  , Vehicle player){
            
        float scale ;
            
            if (player.getEndurance() < 200){

                scale = (float)player.getEndurance()/Constant.MAX_LIFE;
                 Engine.getLocalGuiNode().getChild("lifebar").setLocalScale((float)scale, 1, 1);
            }


    
    }
    


    public Node getNodeLifeBar() {
        return nodeLifeBar;
    }
    
    
    
}