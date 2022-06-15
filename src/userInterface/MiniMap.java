/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Entidades.Vehicle;
import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import main.Engine;
import com.jme3.renderer.ViewPort;
import com.jme3.renderer.Camera;
public class MiniMap {

   private Camera cam = new Camera();
   private Camera cam2 = new Camera();


   public MiniMap(){


   }

    public void buildMinimap(SimpleApplication app) {


        cam = Engine.getCamera();
        cam2 = cam.clone();
        ViewPort view;
        cam2.setViewPort(.4f, .6f, 0.8f, 1f);

        cam2.setRotation(new Quaternion(-0.07f, 0.92f, -0.25f, -0.27f));
        cam2.setParallelProjection(true);

        view =app.getRenderManager().createMainView("miniMap", cam2);
        view.setBackgroundColor(ColorRGBA.Black);
        view.setClearFlags(true, true, true);
        view.attachScene(Engine.getRootNode());

        zoom(cam2, 350);

    }

    public static void zoom(Camera camera, float factor) {
        
        float bottom = camera.getFrustumBottom();
        camera.setFrustumBottom(bottom * factor);
        float left = camera.getFrustumLeft();
        camera.setFrustumLeft(left * factor);
        float right = camera.getFrustumRight();
        camera.setFrustumRight(right * factor);
        float top = camera.getFrustumTop();
        camera.setFrustumTop(top * factor);
            
        }

    public float [] vectorCoords (Vector3f vector){
        
          float [] coordenadas = new float[2]  ;
           coordenadas[0] = vector.getX();
           coordenadas[1]= vector.getY();

           return coordenadas;


      }

    public void updateCam (Vehicle player){
        
        float[] currLocation = new float[2];

        currLocation=vectorCoords(player.getVehicle().getPhysicsLocation());

        cam2.setLocation(new Vector3f(currLocation[0], 94, currLocation[1]));

      }

}

