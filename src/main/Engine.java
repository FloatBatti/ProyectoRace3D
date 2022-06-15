/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Entidades.Bots;
import Entidades.Player;
import Entidades.Vehicle;
import Entidades.Scenario;
import animations.ParticleAnimations;
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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import sounds.Audio3D;
import statics.Constant;
import userInterface.GUI;
import userInterface.LifeBar;

import userInterface.SpeedoMeter;
import userInterface.CrashCount;
import userInterface.MiniMap;
import userInterface.NitroBar;

/**
 *
 * @author AgusGonza
 */
public class Engine extends AbstractAppState implements ActionListener, PhysicsCollisionListener, Runnable {

    
    private static AssetManager assetManager;
    private static Node rootNode;
    private static Node localRootNode = new Node("Level 1");
    private static FlyByCamera flyByCamera;
    private static Camera camera;
    private static InputManager inputManager;    
    private static BulletAppState bulletAppState = new BulletAppState();
    static public boolean start = false;
    
    private static  Audio3D audio;
    
    //Particle variables
    private static ParticleAnimations pAnimations;
    
    //GUI VARIABLES
    private static GUI GUInterface;
    private MiniMap miniMap = new MiniMap();
    private static Node localGuiNode = new Node ("interface");
    private SpeedoMeter speedoMeter = new SpeedoMeter();
    
    private CrashCount crash = new CrashCount();
    
    private static AI artificialInteligence = new AI();
    
    private static Vehicle playerVehicle = null;
    private static Player actualPlayer = null;
    private LifeBar lifebar = new LifeBar(playerVehicle.getMaxEndurance()*1.5);
    private NitroBar nitrobar = new NitroBar(100);
    
    
    public Engine(SimpleApplication app) {
        
        assetManager = app.getAssetManager();
        rootNode = app.getRootNode();
        camera = app.getCamera();
        flyByCamera = app.getFlyByCamera();
        inputManager = app.getInputManager();
        audio = new Audio3D(rootNode, assetManager);
        pAnimations = new ParticleAnimations(assetManager);
        GUInterface = new GUI(app.getGuiNode(), assetManager);
        localGuiNode = app.getGuiNode();
        miniMap.buildMinimap(app);
     
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public static void setVehicle(Vehicle player){
        
        Engine.playerVehicle = player;
    }
    
    public static void setActualPlayer(Player actualPlayer){
        
        Engine.actualPlayer = actualPlayer;
    }
    
    static public AssetManager getAssetManager(){
        
        return assetManager;
    }

    public static GUI getGUInterface() {
        return GUInterface;
    }
    
    static public boolean isStart() {
        return start;
    }

    static public void setStart(boolean start) {
        Engine.start = start;
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

    public static ParticleAnimations getpAnimations() {
        return pAnimations;
    }

    public static Node getLocalGuiNode() {
        return localGuiNode;
    }
    
    public static Player getActualPlayer(){
        
       return Engine.actualPlayer;
    }
    
    public static Audio3D getAudio3D(){
        
        return audio;
    }
    
     //</editor-fold>
    
    public static void pauseOneSecond(){
        
         try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createBots(int cant){
        for(int i = 0; i < cant; i++){
            Bots temp = new Bots();
            temp.buildBot();
            artificialInteligence.attachBot(temp);
        }
    }
    
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
        inputManager.addMapping("Shift", new KeyTrigger(KeyInput.KEY_LSHIFT));

        inputManager.addListener(this, "Lefts");
        inputManager.addListener(this, "Rights");
        inputManager.addListener(this, "Ups");
        inputManager.addListener(this, "Reverse");
        inputManager.addListener(this, "Downs");
        inputManager.addListener(this, "Space");
        inputManager.addListener(this, "Reset");
        inputManager.addListener(this, "Horn");
        inputManager.addListener(this, "Shift");

    }
    
    private void initializeHud(){
       GUInterface.drawCrash(ColorRGBA.Black, CrashCount.crashCount + "!", 1730, 285, 30);
       GUInterface.drawSpeed(ColorRGBA.Black, "0" + (int)Vehicle.getVehicle().getCurrentVehicleSpeedKmHour(), 1699, 174, 30);
       GUInterface.drawkmh(ColorRGBA.Black, "km/h", 1702, 60, 30);
       speedoMeter.createSpeedoGeom();
       lifebar.buildLifeBar();
       nitrobar.buildNitroBar();
       crash.createCrashTexture();
    }
    
    private void crashSound (PhysicsCollisionEvent event){

        if ( event.getNodeA().getName().equals("vehicleNode") ) {
            
            double impactDamage = event.getAppliedImpulse() / 100;
        
            if(impactDamage > 40){
                
                Engine.getAudio3D().playCash();
            }

    } else if ( event.getNodeB().getName().equals("vehicleNode") ) {
       
        double impactDamage = event.getAppliedImpulse()  / 100;
        
        if(impactDamage>40){
            Engine.getAudio3D().playCash();
        }
    }
}
    
    private void saveReward(){
      
        int crashes = CrashCount.crashCount;
        int playerCrashes = Engine.getActualPlayer().getMaxExplosions();
        int playerCoins = Engine.getActualPlayer().getCoins();
        int earnedCoins = 5 * crashes;

        if (crashes > playerCrashes){
            
            Engine.getActualPlayer().setMaxExplosions(crashes);
        }
        
        Engine.getActualPlayer().setCoins(earnedCoins + playerCoins);

        Player.savePlayer(Engine.getActualPlayer());

    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        
        super.initialize(stateManager, app);    
        
        stateManager.attach(bulletAppState);
        bulletAppState.setDebugEnabled(false);
        getPhysicsSpace().addCollisionListener(this);
        
        Scenario scenarioCity = new Scenario(bulletAppState);
        scenarioCity.CargarEscenario();
        
        //Mapa viejo
//        terrPrincipal = new Terreno(bulletAppState, camera);
//        terrPrincipal.CrearTerreno();
      
        playerVehicle.buildVehicle();
        
        createBots(Constant.BOT_COUNT);
        
        setUpLight();
        setupKeys();
        initializeHud();
        

        pauseOneSecond();
        Thread countDown = new Thread(this);
        countDown.start(); 
        
            
    }
    
    @Override
    public void update(float tpf) {
        
        GUInterface.UpdateHUD(playerVehicle.getEndurance(), Vehicle.getVehicle());
        artificialInteligence.AIBehavior();
        speedoMeter.updateArrow(playerVehicle.getEndurance(), playerVehicle);
        lifebar.updateLife((float) playerVehicle.getEndurance(), (float) playerVehicle.getMaxEndurance());
        
        if (playerVehicle!=null){
             miniMap.updateCam(playerVehicle);
        }
        
        if (Vehicle.getVehicle().getCurrentVehicleSpeedKmHour()>=playerVehicle.getMaximumSpeed()){
            Vehicle.getVehicle().accelerate(0);
        }
        
        if(playerVehicle.isNitro()) {
            if(playerVehicle.getNitroTank() > 0){
                playerVehicle.setNitroTank(playerVehicle.getNitroTank() - 1);
            }else{
                playerVehicle.setNitro(false);
            }
        }else{
            if(playerVehicle.getNitroTank() < 100){
                playerVehicle.setNitroTank(playerVehicle.getNitroTank() + 0.3);
            }
        }
        
        nitrobar.updateNitro((float) playerVehicle.getNitroTank(), (float) 100);
    }
    
    @Override
    public void collision(PhysicsCollisionEvent event) {
        
        if ( event.getNodeA().getName().equals("vehicleNode") ) {
            double impactDamage = event.getAppliedImpulse() / 100;
            if(impactDamage>40){
                playerVehicle.modfEndurance(-impactDamage);
            }
            playerVehicle.modfEndurance(-impactDamage);
        } else if ( event.getNodeB().getName().equals("vehicleNode") ) {
            double impactDamage = event.getAppliedImpulse()  / 100;
            if(impactDamage>40){
                playerVehicle.modfEndurance(-impactDamage);
            }
        }
        
        crashSound(event);
        
        if((playerVehicle.getEndurance() <= 0) && !playerVehicle.isGameOver()){
            Engine.getAudio3D().playExplosion();
            Engine.getAudio3D().stopEngineGurgle();
            Engine.getAudio3D().playWasted();
            saveReward();
            pAnimations.setOnFire((Node) Vehicle.getVehicleNode().getChild("Engine"));
            playerVehicle.setGameOver(true);
            Vehicle.getVehicle().accelerate(0);
        }
        
        artificialInteligence.checkCollision(event);
    }
    
    @Override
    public void onAction(String name, boolean keyPressed, float tpf) {
        
        if(!playerVehicle.isGameOver() && start==true){
            if (name.equals("Lefts")) {
                if (keyPressed) {
                        playerVehicle.modfSteeringValue(.5f);
                    } else {
                        playerVehicle.modfSteeringValue(-.5f);
                    }
                    Vehicle.getVehicle().steer(playerVehicle.getSteeringValue());
                    
                } else if (name.equals("Rights")) {
                    if (keyPressed) {
                        playerVehicle.modfSteeringValue(-.5f);
                    } else {
                        playerVehicle.modfSteeringValue(.5f);
                    }
                    Vehicle.getVehicle().steer(playerVehicle.getSteeringValue());
                    
                } else if (name.equals("Ups")) {
                    if (keyPressed && (!(Vehicle.getVehicle().getCurrentVehicleSpeedKmHour()>=playerVehicle.getMaximumSpeed()))) {
                        playerVehicle.modfAccelerationValue(playerVehicle.getAccelerationForce());
                    } else {
                        playerVehicle.modfAccelerationValue(- (playerVehicle.getAccelerationForce()));
                    }
                    
                    if(playerVehicle.isNitro()){
                        Vehicle.getVehicle().accelerate(playerVehicle.getAccelerationValue() * 4);
                    }else{
                        Vehicle.getVehicle().accelerate(playerVehicle.getAccelerationValue());
                    }
                    
                    
                } else if (name.equals("Downs")) {
                    if (keyPressed) {
                        Vehicle.getVehicle().brake(playerVehicle.getBrakeForce());
                        if (Vehicle.getVehicle().getCurrentVehicleSpeedKmHour() > 1) {audio.playBrakes();}
                    } else {
                        Vehicle.getVehicle().brake(0f);
                        audio.stopBrakes();
                    }
                } else if (name.equals("Reverse")) {
                    if (keyPressed) {
                        playerVehicle.modfDeaccelerationValue(-(playerVehicle.getDeaccelerationForce()));
                    } else {
                        playerVehicle.modfDeaccelerationValue(playerVehicle.getDeaccelerationForce());
                    }
                    Vehicle.getVehicle().accelerate(playerVehicle.getDeaccelerationValue());
                    
                } else if (name.equals("Horn")) {
                    if (keyPressed) {
                        audio.playHorn();
                    }
   
                } else if (name.equals("Space")) {
                    if (keyPressed) {
                        Vehicle.getVehicle().applyImpulse(playerVehicle.getJumpForce(), Vector3f.ZERO);
                    }
                } else if (name.equals("Shift")) {
                    if (keyPressed) {
                        playerVehicle.setNitro(true);
                    }else{
                        playerVehicle.setNitro(false);
                    }
                } else if (name.equals("Reset")) {
                    if (keyPressed) {                     

                        Vehicle.getVehicle().setPhysicsLocation(new Vector3f(Constant.SP_X, Constant.SP_Y, Constant.SP_Z));
                        Vehicle.getVehicle().setPhysicsRotation(new Matrix3f());
                        Vehicle.getVehicle().setLinearVelocity(Vector3f.ZERO);
                        Vehicle.getVehicle().setAngularVelocity(Vector3f.ZERO);
                        Vehicle.getVehicle().resetSuspension();
                    }
                }
        }
    }   
         
    @Override
    public void run() {
        
      Vehicle.getVehicle().accelerate(500.0f);
      Engine.getGUInterface().drawCountDown(ColorRGBA.Black, "3!", 1000, 600, 140);

      for(int i = 0; i <= 3; i++){
          try {
              TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException ex) {
              Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
          }
          
             Engine.getGUInterface().getGuiCountDown().setText((3 - i) + "!");
         }
      
      
        Engine.getGUInterface().getGuiCountDown().setText("");

        Engine.setStart(true);
        Vehicle.getVehicle().accelerate(-500.0f);
    }
    
}
