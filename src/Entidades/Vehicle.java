/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
import com.jme3.bullet.control.VehicleControl;
import com.jme3.input.ChaseCamera;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import main.Engine;
import statics.Constant;

/**
 *
 * @author AgusGonza
 */
public class Vehicle {
    
    private static  Node vehicleNode = new Node("vehicleNode");
    private String vehicleModel;
    private double endurance = 200;
    private double nitroTank = 100;
    private boolean nitro = false;
    private float maxEndurance = 200;
    private int drift=0;
    private static VehicleControl vehicle;
    private float maximumSpeed = 242.0f;
    private float accelerationForce = 400.0f;
    private float deaccelerationForce = 300.0f;
    private float brakeForce = 100.0f;
    private float steeringValue = 0;
    private float accelerationValue = 0;
    private float deaccelerationValue = 0;
    private Vector3f jumpForce = new Vector3f(0, 3000, 0);
    private ChaseCamera chaseCam;
    private boolean gameOver = false;
    static final Quaternion ROTATE_RIGHT = new Quaternion().fromAngleAxis(FastMath.HALF_PI, Vector3f.UNIT_Y);
    
    public Vehicle(){}
    
    public Vehicle(int endurance, float accForce, int drift, String vehicleModel){
           
        this.endurance += endurance;
        maxEndurance = (float) (this.endurance);
        accelerationForce += accForce;
        deaccelerationForce = accelerationForce - 100;
        this.drift = drift;
        this.vehicleModel = vehicleModel;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public static Node getVehicleNode() {
        return vehicleNode;
    }

    public double getEndurance() {
        return endurance;
    }

    public static VehicleControl getVehicle() {
        return vehicle;
    }

    public float getAccelerationForce() {
        return accelerationForce;
    }

    public float getDeaccelerationForce() {
        return deaccelerationForce;
    }

    public float getBrakeForce() {
        return brakeForce;
    }

    public float getSteeringValue() {
        return steeringValue;
    }

    public float getAccelerationValue() {
        return accelerationValue;
    }

    public float getDeaccelerationValue() {
        return deaccelerationValue;
    }

    public Vector3f getJumpForce() {
        return jumpForce;
    }

    public ChaseCamera getChaseCam() {
        return chaseCam;
    }
    
     //</editor-fold>

    public void modfSteeringValue(float steeringValue) {
        this.steeringValue += steeringValue;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public float getMaximumSpeed() {
        return maximumSpeed;
    }
    
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public double getNitroTank() {
        return nitroTank;
    }

    public void setNitroTank(double nitroTank) {
        this.nitroTank = nitroTank;
    }

    public boolean isNitro() {
        return nitro;
    }

    public void setNitro(boolean nitro) {
        this.nitro = nitro;
    }
    
    public void modfDeaccelerationValue(float deaccelerationForce) {
        this.deaccelerationValue += deaccelerationForce;
    }

    public void modfAccelerationValue(float accelerationForce) {
        this.accelerationValue += accelerationForce;
    }

    public void modfEndurance(double endurance) {
        this.endurance += endurance;
    }

    public float getMaxEndurance() {
        return maxEndurance;
    }

    public void setMaxEndurance(float maxEndurance) {
        this.maxEndurance = maxEndurance;
    }
    
    public void buildVehicle() {
        
        Spatial carsito = Engine.getAssetManager().loadModel(vehicleModel);
        Engine.getLocalRootNode().attachChild(carsito);
        Node carNode = (Node) Engine.getLocalRootNode().getChild("AutoRojo");
        vehicleNode.attachChild(carNode);
        
        CompoundCollisionShape compoundShape = new CompoundCollisionShape();
        BoxCollisionShape box = new BoxCollisionShape(new Vector3f(1.1f, 0.8f, 2.8f));
        compoundShape.addChildShape(box, new Vector3f(0, 1, 0));

        //create vehicle node
        vehicle = new VehicleControl(compoundShape, 400);
        vehicleNode.addControl(vehicle);
       
        //making smoke
        Engine.getpAnimations().attachSmoke((Node) carNode.getChild("Tailpipe"));
        
        //making weels
        attachWeels(vehicleNode);
        
        //start up position
        vehicle.setPhysicsLocation(new Vector3f(Constant.SP_X, Constant.SP_Y, Constant.SP_Z));
        vehicle.setPhysicsRotation(ROTATE_RIGHT);
        Engine.getRootNode().attachChild(vehicleNode);

        //i add this object to the physics enviroment
        Engine.getBulletAppState().getPhysicsSpace().add(vehicle);
        
        //set up the camera to the just created player
        Engine.getFlyByCamera().setEnabled(false);
        chaseCam = new ChaseCamera(Engine.getCamera(), vehicleNode, Engine.getInputManager());
        chaseCam.setInvertVerticalAxis(true);
        chaseCam.setDragToRotate(false);
    }
    
    private void attachWeels(Node vehicleNode){
       
        float stiffness = 15.0f;//200=f1 car
        float compValue = .3f; //(should be lower than damp)
        float dampValue = .4f;
        vehicle.setSuspensionCompression(compValue * 2.0f * FastMath.sqrt(stiffness));
        vehicle.setSuspensionDamping(dampValue * 2.0f * FastMath.sqrt(stiffness));
        vehicle.setSuspensionStiffness(stiffness);
        vehicle.setMaxSuspensionForce(10000.0f);
   
        //Create four wheels and add them at their locations
        Vector3f wheelDirection = new Vector3f(0, -1, 0); // was 0, -1, 0
        Vector3f wheelAxle = new Vector3f(-1, 0, 0); // was -1, 0, 0
        float radius = 0.5f;
        float restLength = 0.3f;
        float yOff = 0.4f;
        float xOff = 1f;
        float zOff = 1.3f;

        //load the 3d model of the weels
        Spatial ruedita = Engine.getAssetManager().loadModel("Models/Rueditas.j3o");
        Engine.getLocalRootNode().attachChild(ruedita);
        
        
        Node node1 = new Node("wheel 1 node");
        Node weelShape1 = (Node) Engine.getLocalRootNode().getChild("Weel1");
        node1.attachChild(weelShape1);
        weelShape1.rotate(0, FastMath.HALF_PI, 0);
        vehicle.addWheel(node1, new Vector3f(-xOff, yOff, zOff),
                         wheelDirection, wheelAxle, restLength, radius, true);

        Node node2 = new Node("wheel 2 node");
        Node weelShape2 = (Node) Engine.getLocalRootNode().getChild("Weel2");
        node2.attachChild(weelShape2);
        weelShape2.rotate(0, FastMath.HALF_PI, 0);
        vehicle.addWheel(node2, new Vector3f(xOff, yOff, zOff),
                         wheelDirection, wheelAxle, restLength, radius, true);

        Node node3 = new Node("wheel 3 node");
        Node weelShape3 = (Node) Engine.getLocalRootNode().getChild("Weel3");
        node3.attachChild(weelShape3);
        weelShape3.rotate(0, FastMath.HALF_PI, 0);
        vehicle.addWheel(node3, new Vector3f(-xOff, yOff, -zOff),
                         wheelDirection, wheelAxle, restLength, radius, false);
        

        Node node4 = new Node("wheel 4 node");
        Node weelShape4 = (Node) Engine.getLocalRootNode().getChild("Weel4");
        node4.attachChild(weelShape4);
        weelShape4.rotate(0, FastMath.HALF_PI, 0);
        vehicle.addWheel(node4, new Vector3f(xOff, yOff, -zOff),
                         wheelDirection, wheelAxle, restLength, radius, false);

        //Valor Drift
        vehicle.setFrictionSlip(0, 2f + (this.drift / 100));
        vehicle.setFrictionSlip(1, 2f + (this.drift / 100));
        vehicle.setFrictionSlip(2, 1.5f + (this.drift / 100));
        vehicle.setFrictionSlip(3, 1.5f + (this.drift / 100));
        
        vehicleNode.attachChild(node1);
        vehicleNode.attachChild(node2);
        vehicleNode.attachChild(node3);
        vehicleNode.attachChild(node4);
    }
}
