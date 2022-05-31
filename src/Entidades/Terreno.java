/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
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
public class Terreno {
    
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

    public Terreno(BulletAppState bulletAppState, Camera camara) {
        this.bulletAppState = bulletAppState;
        this.camera = camara;
    }

    public static TerrainQuad getTerrain() {
        return terrain;
    }
    
    
    public void CrearTerreno(){
                //i create a material for all terrains
        matRock = new Material(Engine.getAssetManager(), "Common/MatDefs/Terrain/Terrain.j3md");
        matRock.setBoolean("useTriPlanarMapping", false);

        //load alpha and heighmap
        matRock.setTexture("Alpha", Engine.getAssetManager().loadTexture("Textures/Terrain/raceAlpha.png"));
        Texture heightMapImage = Engine.getAssetManager().loadTexture("Textures/Terrain/race.png");

        //grass dirt and rock
        Texture grass = Engine.getAssetManager().loadTexture("Textures/Terrain/grass.jpg");
        grass.setWrap(Texture.WrapMode.Repeat);
        matRock.setTexture("Tex1", grass);
        matRock.setFloat("Tex1Scale", grassScale);
        Texture dirt = Engine.getAssetManager().loadTexture("Textures/Terrain/dirt.jpg");
        dirt.setWrap(Texture.WrapMode.Repeat);
        matRock.setTexture("Tex2", dirt);
        matRock.setFloat("Tex2Scale", dirtScale);
        Texture rock = Engine.getAssetManager().loadTexture("Textures/Terrain/road.jpg");
        rock.setWrap(Texture.WrapMode.Repeat);
        matRock.setTexture("Tex3", rock);
        matRock.setFloat("Tex3Scale", rockScale);

        // wireframe of the material
        matWire = new Material(Engine.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        matWire.getAdditionalRenderState().setWireframe(true);
        matWire.setColor("Color", ColorRGBA.Green);

        // CREATE HEIGHTMAP
        AbstractHeightMap heightmap = null;
        try {
            heightmap = new ImageBasedHeightMap(heightMapImage.getImage(), 1f);
            heightmap.load();

        } catch (Exception e) {
            e.printStackTrace();
        }

        terrain = new TerrainQuad("terrain", 65, 513, heightmap.getHeightMap());
        TerrainLodControl control = new TerrainLodControl(terrain, camera);
        control.setLodCalculator( new DistanceLodCalculator(65, 2.7f) ); // patch size, and a multiplier
        terrain.addControl(control);
        terrain.setMaterial(matRock);
        terrain.setLocalTranslation(0, -100, 0);
        terrain.setLocalScale(2f, 0.5f, 2f);
        /** 6. Add physics: */
        terrain.addControl(new RigidBodyControl(0));
        bulletAppState.getPhysicsSpace().add(terrain);
        
        //create sky
        Engine.getRootNode().attachChild(SkyFactory.createSky(Engine.getAssetManager(), "Textures/BrightSky.dds", SkyFactory.EnvMapType.CubeMap));
        
        //ensamble
        Engine.getRootNode().attachChild(terrain);

        
    } 
}
