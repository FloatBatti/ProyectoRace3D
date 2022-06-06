/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author panda
 */
public class Player extends User implements Serializable{
    
    private int coins = 0;
    private Workshop stats = new Workshop();
    private int lastLaps = 0;
    private static transient Persistence <Player> dataControl = new Persistence();

    public Player(String nickName, String password) {
        
        this.setUserName(nickName);
        this.setPassword(password);
        this.setPermission(1);
        this.setId(getLastIDplus());  
    }
    
    static public List<Player> getListPlayer (){
            
        return dataControl.loadList("userData.json", Player.class);       
    }

    private int getLastIDplus(){
        
       int lastId = 0;
       
        List <Player> playerList = Player.getListPlayer();
       
        for (Player aux : playerList){
            
            lastId = aux.getId();
            
        }
        
        return ++lastId;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Workshop getStats() {
        return stats;
    }

    public void setStats(Workshop stats) {
        this.stats = stats;
    }

    public int getLastLaps() {
        return lastLaps;
    }

    public void setLastLaps(int lastLaps) {
        this.lastLaps = lastLaps;
    }
    
    //</editor-fold>
   
}

