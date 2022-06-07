/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Entidades.Bots;
import Entidades.Vehicle;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.font.BitmapText;
import com.jme3.math.FastMath;
import com.jme3.math.Plane;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import java.util.ArrayList;
import statics.Constant;

/**
 *
 * @author Fran
 */
public class AI{
    
    private float speed = 1500f;
    private Vector3f vector1 = new Vector3f();
    private Vector3f vector2 = new Vector3f();
    private Vector3f vector3 = new Vector3f();
    private Vector3f vector4 = new Vector3f();
    private Vector3f pos = new Vector3f();
    private Vector3f up = new Vector3f();
    private Vector3f dir = new Vector3f();
    private Vector3f targetPos = new Vector3f();
    private Plane plane = new Plane();
    private Plane plane2 = new Plane();
    static final Quaternion ROTATE_RIGHT = new Quaternion().fromAngleAxis(FastMath.HALF_PI, Vector3f.UNIT_Y);
    
    ArrayList<Bots> AIEntity = new ArrayList<>();

    public void attachBot(Bots entity){
        AIEntity.add(entity);
    }
    
    public void checkCollision(PhysicsCollisionEvent event){
        
        for(Bots aux : AIEntity) {
            if ( event.getNodeA().getName().equals(aux.getVehicleNode().getName()) ) {
                double impactDamage = event.getAppliedImpulse() / 100;
                aux.modfEndurance(-impactDamage);
            } else if ( event.getNodeB().getName().equals(aux.getVehicleNode().getName()) ) {
                double impactDamage = event.getAppliedImpulse()  / 100;
                aux.modfEndurance(-impactDamage);
            }

            if((aux.getEndurance() <= 0) && !aux.isDestroyed()){
                Engine.getpAnimations().setOnFire((Node) aux.getVehicleNode().getChild("Engine"));
                aux.setDestroyed(true);
                aux.getVehicle().accelerate(0);
            }

        }
    }
    
    public void updateBotsText(){
        for(Bots aux : AIEntity) {
            BitmapText ch = (BitmapText) aux.getVehicleNode().getChild("text" + aux.getPersonalIndex());
            ch.setText(aux.getVehicleNode().getName() + " / " + (int)((aux.getEndurance() * 100) / Constant.MAX_LIFE));
        }
    }
    
    static double distance(Vector3f v1, Vector3f v2)
    {

        double d = Math.pow((Math.pow(v2.getX() - v1.getX(), 2) +
                             Math.pow(v2.getY() - v1.getY(), 2) +
                             Math.pow(v2.getZ() - v1.getZ(), 2) *
                                        1.0), 0.5);

        return d;
    }

    public void AIBehavior(){
        for(Bots aux : AIEntity) {
            if(!aux.isDestroyed()){
                vector1.set(aux.getVehicle().getPhysicsLocation());
                vector2.set(Vehicle.getVehicle().getPhysicsLocation());
                vector2.subtractLocal(vector1);
                vector2.normalizeLocal();

                aux.getVehicle().getForwardVector(vector3).normalizeLocal();
                vector4.set(vector3);
                ROTATE_RIGHT.multLocal(vector4);
                plane.setOriginNormal(Vehicle.getVehicleNode().getWorldTranslation(), vector4);

                float dot = 1 - vector3.dot(vector2);
                float angle = vector3.angleBetween(vector2);

                float anglemult = 1;//FastMath.PI / 4.0f;
                float speedmult = 0.3f;//0.3f;
                
                if (angle > FastMath.QUARTER_PI) {
                    angle = FastMath.QUARTER_PI;
                }
                
                //left or right
                if (plane.whichSide(Vehicle.getVehicle().getPhysicsLocation()) == Plane.Side.Negative) {
                    anglemult *= -1;
                }
                
//                //backwards
//                if (dot > 1) {
//                    speedmult *= -1;
//                    anglemult *= -1;
//                }
                
                aux.getVehicle().steer(angle * anglemult);
                aux.getVehicle().accelerate(speed * speedmult);
                aux.getVehicle().brake(0);
            }
        }
    }

    
}
