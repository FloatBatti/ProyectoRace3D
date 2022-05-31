/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Entidades.Bots;
import Entidades.Player;
import Entidades.Terreno;
import animations.particleAnimations;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import static com.jme3.bullet.PhysicsSpace.getPhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Matrix3f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import sounds.Audio3D;
import statics.Constant;
import userInterface.GUI;

/**
 *
 * @author AgusGonza
 */
public class Engine extends AbstractAppState implements ActionListener, PhysicsCollisionListener   {

    private static AssetManager assetManager;
    private static Node rootNode;
    private static Node localRootNode = new Node("Level 1");
    private static FlyByCamera flyByCamera;
    private static Camera camera;
    private static InputManager inputManager;    
    private static BulletAppState bulletAppState = new BulletAppState();
    
    private final Audio3D audio;
    
    //Particle variables
    private static particleAnimations pAnimations;
    
    //GUI VARIABLES
    private GUI GUInterface;
    
    private AI artificialInteligence = new AI();
    
    Terreno terrPrincipal;
    Player player = new Player();
    
    
    public Engine(SimpleApplication app) {
        assetManager = app.getAssetManager();
        rootNode = app.getRootNode();
        camera = app.getCamera();
        flyByCamera = app.getFlyByCamera();
        inputManager = app.getInputManager();
        audio = new Audio3D(rootNode, assetManager);
        pAnimations = new particleAnimations(assetManager);
        GUInterface = new GUI(app.getGuiNode(), assetManager);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters">
    static public AssetManager getAssetManager(){
        
        return assetManager;
    }
    
    static public Node getLocalRootNode(){
        
        return localRootNode;
    }
    
    static public Node getRootNode(){
        
        return rootNode;
    }

    public static FlyByCamera getFlyByCamera() {
        return flyByCamera;
    }

    public static Camera getCamera() {
        return camera;
    }
    
    public static InputManager getInputManager(){
        
        return inputManager;
    }

    public static BulletAppState getBulletAppState() {
        return bulletAppState;
    }

    public static particleAnimations getpAnimations() {
        return pAnimations;
    }
    
     //</editor-fold>
    
    private void setUpLight() {
        //creating 2 lights, one ambient one directional
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(1.3f));
        rootNode.addLight(al);

        DirectionalLight dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White);
        dl.setDirection(new Vector3f(2.8f, -2.8f, -2.8f).normalizeLocal());
        rootNode.addLight(dl);
      }
    
        private void setupKeys() {
        //the key mapping
        inputManager.addMapping("Lefts", new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Rights", new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Ups", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("Reverse", new KeyTrigger(KeyInput.KEY_E));
        inputManager.addMapping("Downs", new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("Space", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addMapping("Reset", new KeyTrigger(KeyInput.KEY_R));
        inputManager.addMapping("Horn", new KeyTrigger(KeyInput.KEY_H));
        inputManager.addListener(this, "Lefts");
        inputManager.addListener(this, "Rights");
        inputManager.addListener(this, "Ups");
        inputManager.addListener(this, "Reverse");
        inputManager.addListener(this, "Downs");
        inputManager.addListener(this, "Space");
        inputManager.addListener(this, "Reset");
        inputManager.addListener(this, "Horn");
    }
    
    private void initializeHud(){
        
       GUInterface.drawLife(ColorRGBA.Green, "LIFE: " + player.getEndurance(), 300, 0, 30);
       GUInterface.drawSpeed(ColorRGBA.Green, "Speed: " + (int)Player.getVehicle().getCurrentVehicleSpeedKmHour(), 500, 0, 30);
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        
        super.initialize(stateManager, app);    
        
        stateManager.attach(bulletAppState);
        bulletAppState.setDebugEnabled(false);
        getPhysicsSpace().addCollisionListener(this);
        
        terrPrincipal = new Terreno(bulletAppState, camera);
        terrPrincipal.CrearTerreno();
        
        player.buildPlayer();
        
        for(int i = 0; i < Constant.BOT_COUNT; i++){
            Bots temp = new Bots();
            temp.buildBot();
            artificialInteligence.attachBot(temp);
        }
        
        setUpLight();
        setupKeys();
        initializeHud();
            
    }
    
    
    @Override
    public void update(float tpf) {
        GUInterface.UpdateHUD(player.getEndurance(), Player.getVehicle());
        artificialInteligence.AIBehavior();
        //artificialInteligence.updateBotsText();
    }
    
    @Override
    public void collision(PhysicsCollisionEvent event) {
        if ( event.getNodeA().getName().equals("vehicleNode") ) {
            double impactDamage = event.getAppliedImpulse() / 100;
            player.modfEndurance(-impactDamage);
        } else if ( event.getNodeB().getName().equals("vehicleNode") ) {
            double impactDamage = event.getAppliedImpulse()  / 100;
            player.modfEndurance(-impactDamage);
        }
        
        if((player.getEndurance() <= 0) && !player.isGameOver()){
            pAnimations.setOnFire((Node) Player.getVehicleNode().getChild("Engine"));
            player.setGameOver(true);
            Player.getVehicle().brake(player.getBrakeForce());
        }
        
        artificialInteligence.checkCollision(event);
    }
    
    @Override
    public void onAction(String name, boolean keyPressed, float tpf) {
        
        if(!player.isGameOver()){
            if (name.equals("Lefts")) {
                if (keyPressed) {
                        player.modfSteeringValue(.5f);
                    } else {
                        player.modfSteeringValue(-.5f);
                    }
                    Player.getVehicle().steer(player.getSteeringValue());
                    
                } else if (name.equals("Rights")) {
                    if (keyPressed) {
                        player.modfSteeringValue(-.5f);
                    } else {
                        player.modfSteeringValue(.5f);
                    }
                    Player.getVehicle().steer(player.getSteeringValue());
                    
                } else if (name.equals("Ups")) {
                    if (keyPressed) {
                        player.modfAccelerationValue(player.getAccelerationForce());
                    } else {
                        player.modfAccelerationValue(- (player.getAccelerationForce()));
                    }
                    Player.getVehicle().accelerate(player.getAccelerationValue());
                    
                } else if (name.equals("Downs")) {
                    if (keyPressed) {
                        Player.getVehicle().brake(player.getBrakeForce());
                        if (Player.getVehicle().getCurrentVehicleSpeedKmHour() > 1) {audio.playBrakes();}
                    } else {
                        Player.getVehicle().brake(0f);
                        audio.stopBrakes();
                    }
                } else if (name.equals("Reverse")) {
                    if (keyPressed) {
                        player.modfDeaccelerationValue(-(player.getDeaccelerationForce()));
                    } else {
                        player.modfDeaccelerationValue(player.getDeaccelerationForce());
                    }
                    Player.getVehicle().accelerate(player.getDeaccelerationValue());
                    
                } else if (name.equals("Horn")) {
                    if (keyPressed) {
                        audio.playHorn();
                    }
   
                } else if (name.equals("Space")) {
                    if (keyPressed) {
                        Player.getVehicle().applyImpulse(player.getJumpForce(), Vector3f.ZERO);
                    }
                } else if (name.equals("Reset")) {
                    if (keyPressed) {
                        System.out.println("Reset");

                        Player.getVehicle().setPhysicsLocation(new Vector3f(Constant.SP_X, Constant.SP_Y, Constant.SP_Z));
                        Player.getVehicle().setPhysicsRotation(new Matrix3f());
                        Player.getVehicle().setLinearVelocity(Vector3f.ZERO);
                        Player.getVehicle().setAngularVelocity(Vector3f.ZERO);
                        Player.getVehicle().resetSuspension();
                    } else {
                }
            }
        }
    }   
}
