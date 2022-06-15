package main;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;
import userInterface.Login;
import userInterface.Music;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    static public int startEngine = 0;
    
    public static void main(String[] args) {
 
        Music music = new Music();
        Main app = new Main();
        
        Login login = new Login();
        login.setVisible(true); 

        while(true){
            
            System.out.println("");
    
            if (startEngine == 1){

                app.start();
                break;
            }
        }
    }
    
    @Override
    public void simpleInitApp() {
        stateManager.attach(new Engine(this));
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
