/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.terrain.geomipmap.TerrainLodControl;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.geomipmap.lodcalc.DistanceLodCalculator;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;
import com.jme3.texture.Texture;
import com.jme3.util.SkyFactory;
import main.Engine;

/**
 *
 * @author AgusGonza
 */
public class Scenario {
    
    private static TerrainQuad terrain;
    private Material matRock;
    private Material matWire;
    private final boolean wireframe = false;
    private final boolean triPlanar = false;
    private final float grassScale = 64;
    private final float dirtScale = 16;
    private final float rockScale = 128; 
    private BulletAppState bulletAppState;
    private Camera camera;
    Material mat_terrain;

    public Scenario(BulletAppState bulletAppState) {
        this.bulletAppState = bulletAppState;
    }
    
    
    public void CargarEscenario(){
        // We load the scene from the zip file and adjust its size.
        Spatial sceneModel = Engine.getAssetManager().loadModel("Scenes/town/main.j3o");
        sceneModel.setLocalScale(2f);

        // We set up collision detection for the scene by creating a
        // compound collision shape and a static RigidBodyControl with mass zero.
        CollisionShape sceneShape =
        CollisionShapeFactory.createMeshShape(sceneModel);
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        sceneModel.addControl(landscape);
        
        //create sky
        Engine.getRootNode().attachChild(SkyFactory.createSky(Engine.getAssetManager(), "Textures/BrightSky.dds", SkyFactory.EnvMapType.CubeMap));
        
        
        /**
         * We set up collision detection for the player by creating
         * a capsule collision shape and a CharacterControl.
         * The CharacterControl offers extra settings for
         * size, stepheight, jumping, falling, and gravity.
         * We also put the player in its starting position.
         */
        CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);

        // We attach the scene and the player to the rootnode and the physics space,
        // to make them appear in the game world.
        Engine.getRootNode().attachChild(sceneModel);
        bulletAppState.getPhysicsSpace().add(landscape);
    } 
}
