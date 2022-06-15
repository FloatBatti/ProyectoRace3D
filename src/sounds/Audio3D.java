/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sounds;

import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioData;
import com.jme3.audio.AudioNode;
import com.jme3.scene.Node;

/**
 *
 * @author Fran
 */
public class Audio3D {
    private AudioNode audio_brakes;
    private AudioNode audio_explosion;
    private AudioNode audio_nature;
    private AudioNode audio_engineGurgle;
    private AudioNode audio_horn;
    private AudioNode audio_siren;
    private AudioNode audio_wasted;
    private AudioNode audio_crash;
    private final Node rootNode;
    private final AssetManager assetManager;
    
    public Audio3D(Node root, AssetManager asset){
        
        rootNode = root;
        assetManager = asset;
        
        initAudio();
    }
    
    private void initAudio(){
        /** We create two audio nodes. */
        audio_brakes = new AudioNode(assetManager, "Sounds/brakes.wav", AudioData.DataType.Buffer);
        audio_brakes.setPositional(false);
        audio_brakes.setLooping(false);
        audio_brakes.setVolume(2);
        rootNode.attachChild(audio_brakes);
        
        audio_explosion = new AudioNode(assetManager, "Sounds/Explosion.wav", AudioData.DataType.Buffer);
        audio_explosion.setPositional(false);
        audio_explosion.setLooping(false);
        audio_explosion.setVolume(2);
        rootNode.attachChild(audio_explosion);
        
        audio_horn = new AudioNode(assetManager, "Sounds/sf_horn_21.wav", AudioData.DataType.Buffer);
        audio_horn.setPositional(false);
        audio_horn.setLooping(false);
        audio_horn.setVolume(2);
        rootNode.attachChild(audio_horn);
        
        audio_wasted = new AudioNode(assetManager, "Sounds/detenido.ogg", AudioData.DataType.Buffer);
        audio_wasted.setPositional(false);
        audio_wasted.setLooping(false);
        audio_wasted.setVolume(3);
        rootNode.attachChild(audio_wasted);
        
        audio_crash = new AudioNode(assetManager, "Sounds/crash.ogg", AudioData.DataType.Buffer);
        audio_crash.setPositional(false);
        audio_crash.setLooping(false);
        audio_crash.setVolume(0.5f);
        rootNode.attachChild(audio_crash);


        audio_nature = new AudioNode(assetManager, "Sounds/forest.ogg", AudioData.DataType.Stream);
        audio_nature.setLooping(true);  // activate continuous playing
        audio_nature.setPositional(false);
        audio_nature.setVolume(3);
        rootNode.attachChild(audio_nature);
        audio_nature.play(); // play continuously!
        

        audio_siren = new AudioNode(assetManager, "Sounds/sirenas.ogg", AudioData.DataType.Stream);
        audio_siren.setLooping(true);  // activate continuous playing
        audio_siren.setPositional(false);
        audio_siren.setVolume(1);
        rootNode.attachChild(audio_siren);
        audio_siren.play(); // play continuously! 
        

        audio_engineGurgle = new AudioNode(assetManager, "Sounds/engine_gurgle.ogg", AudioData.DataType.Stream);
        audio_engineGurgle.setLooping(true);  // activate continuous playing
        audio_engineGurgle.setPositional(false);
        audio_engineGurgle.setVolume(0.2f);
        rootNode.attachChild(audio_engineGurgle);
        audio_engineGurgle.play(); // play continuously! 
    }
    
    public void playBrakes(){
        audio_brakes.play();
    }
    
    public void stopBrakes(){
        audio_brakes.stop();
    }
    
    public void playExplosion(){
        audio_explosion.play();
    }
    
    public void stopExplosion(){
        audio_explosion.stop();
    }
        
    public void playHorn(){
        audio_horn.play();
    }
    
    public void stopHorn(){
        audio_horn.stop();
    }
    
    public void playWasted(){
        audio_wasted.play();
    }
    
    public void stopWasted(){
        audio_wasted.stop();
    }
    
    public void playCash(){
        audio_crash.play();
    }
    
    public void stopCrash(){
        audio_crash.stop();
    }
     
    public void stopSiren(){
        audio_siren.stop();
    }
    
    public void playSiren(){
        audio_siren.play();
    }
  
    public void stopEngineGurgle(){
        audio_engineGurgle.stop();
    }
}
