/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
import com.jme3.bullet.control.VehicleControl;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import main.Engine;

/**
 *
 * @author AgusGonza
 */
public class Bots {
    
    private static int bIndex = 0;
    private int personalIndex = 0;
    private Node vehicleNode;
    private double endurance = 200;
    private VehicleControl vehicle;
    private float accelerationForce = 500.0f;
    private float deaccelerationForce = 100.0f;
    private float brakeForce = 100.0f;
    private float steeringValue = 0;
    private float accelerationValue = 0;
    private float deaccelerationValue = 0;
    private boolean destroyed = false;
    private Vector3f jumpForce = new Vector3f(0, 3000, 0);

    public Bots(){
        
        bIndex++;
        personalIndex = bIndex;
        vehicleNode = new Node("vehicleNode" + personalIndex);
    }

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public VehicleControl getVehicle() {    
        return vehicle;
    }

    public int getPersonalIndex() {
        return personalIndex;
    }

    public Node getVehicleNode() {
        return vehicleNode;
    }
    
    public double getEndurance() {
        return endurance;
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

    
     //</editor-fold>

    public void modfSteeringValue(float steeringValue) {
        this.steeringValue += steeringValue;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
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
    
    
    public void buildBot() {
        
        //load the visible part of the cart
        Spatial carsito = Engine.getAssetManager().loadModel("Models/Autito.j3o");
        Engine.getLocalRootNode().attachChild(carsito);
        Node carNode = (Node) Engine.getLocalRootNode().getChild("AutoRojo");
        vehicleNode.attachChild(carNode);
        
        //create a compound shape and attach the BoxCollisionShape for the car body at 0,1,0
        //this shifts the effective center of mass of the BoxCollisionShape to 0,-1,0
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
        
        BitmapFont guiFont = Engine.getAssetManager().loadFont("Interface/fonts/DejaVuSansLight.fnt");
        BitmapText ch = new BitmapText(guiFont, false);
        ch.setSize(30);
        ch.setText(vehicleNode.getName() + " / " + endurance); // crosshairs
        ch.setColor(new ColorRGBA(1f,0.8f,0.3f,0.8f));
        ch.setName("text" + personalIndex);
        //start up position
        vehicle.setPhysicsLocation(new Vector3f(146 + (personalIndex * 10), -100, 1 + (personalIndex * 10)));
        Engine.getRootNode().attachChild(vehicleNode);

        //i add this object to the physics enviroment
        Engine.getBulletAppState().getPhysicsSpace().add(vehicle);
    }
    
    private void attachWeels(Node vehicleNode){
        //setting suspension values for wheels, this can be a bit tricky
        //see also https://docs.google.com/Doc?docid=0AXVUZ5xw6XpKZGNuZG56a3FfMzU0Z2NyZnF4Zmo&hl=en
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

        vehicleNode.attachChild(node1);
        vehicleNode.attachChild(node2);
        vehicleNode.attachChild(node3);
        vehicleNode.attachChild(node4);
    }
}
