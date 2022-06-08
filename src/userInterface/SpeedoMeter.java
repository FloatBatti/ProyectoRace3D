package userInterface;

import Entidades.Vehicle;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Quad;
import com.jme3.texture.Texture;
import main.Engine;

/**
 *
 * @author Juanjo
 */
public class SpeedoMeter {
    
    private  Node node = new Node("speedo");
    private Node Nodeaguja ;
    private Vehicle player ;
    private float speedVehicle;

   public SpeedoMeter (){
   
   }


    public Node getNodeaguja() {
        return Nodeaguja;
    }

    public  Node getNode() {
        return node;
    }
    

    public void createSpeedoGeom() {


        Texture speedoBgTex = Engine.getAssetManager().loadTexture("Textures/velocimetro.png");
        Geometry speedoBgGeom = new Geometry("Speedometer",
                new Quad(speedoBgTex.getImage().getWidth(), speedoBgTex.getImage().getHeight()));
        speedoBgGeom.setMaterial(new Material(Engine.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md"));
        speedoBgGeom.getMaterial().setTexture("ColorMap", speedoBgTex);
        speedoBgGeom.getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        
       
        
        Texture centerSpeedo = Engine.getAssetManager().loadTexture("Textures/circulo.png");
        Geometry center = new Geometry("center", new Quad(centerSpeedo.getImage().getWidth(), centerSpeedo.getImage().getHeight()));
        Material mat = new Material(Engine.getAssetManager(),"Common/MatDefs/Misc/Unshaded.j3md");
        center.setMaterial(mat);
        center.getMaterial().setTexture("ColorMap", centerSpeedo);
        center.getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
  
        Texture arrow = Engine.getAssetManager().loadTexture("Textures/flecha.png");
        Geometry arrowMid = new Geometry("arrow", new Quad(arrow.getImage().getWidth(), arrow.getImage().getHeight()));
        Material mat1 = new Material(Engine.getAssetManager(),"Common/MatDefs/Misc/Unshaded.j3md");
        arrowMid.setMaterial(mat1);
        arrowMid.getMaterial().setTexture("ColorMap", arrow);
        arrowMid.getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        
        Node auxliarArrow = new Node ("auxiliar");
        Node AuxliarCenter = new Node ("auxCenter");

        speedoBgGeom.setLocalTranslation(1600, 10, 0);
        arrowMid.setLocalTranslation(1725, 95, 0);
        center.setLocalTranslation(1696, 70, 0);
        
        node.attachChild(speedoBgGeom);
        auxliarArrow.attachChild(arrowMid);
        AuxliarCenter.attachChild(center);
      

        Engine.getLocalGuiNode().attachChild(node);
        Engine.getLocalGuiNode().attachChild(auxliarArrow);
        Engine.getLocalGuiNode().attachChild(AuxliarCenter);
        

    }
    
    public void updateArrow (double endurance , Vehicle player){
        
        Quaternion speedoRot = new Quaternion();
        float[] speedoAngles = new float[3];
        
        float startStopAngle = 140;
       

        float speed = player.getVehicle().getCurrentVehicleSpeedKmHour();
        System.out.println(speed);
        float speedUnit = speed / 240;

        float rot = startStopAngle - ((startStopAngle * 2 ) * speedUnit);
        rot = FastMath.clamp(rot, -startStopAngle, startStopAngle);
        rot = rot * FastMath.DEG_TO_RAD;
       

        speedoAngles[2] = rot;
        speedoRot.fromAngles(speedoAngles);
        Engine.getLocalGuiNode().getChild("arrow").setLocalRotation(speedoRot); 
        
    
    }
    
    
}