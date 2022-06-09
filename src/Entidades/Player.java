/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author panda
 */
public class Player extends User implements Serializable{
    
    private Integer coins = 0;
    private Workshop workshop = new Workshop();
    private Integer maxExplosions = 0;
    private static transient Persistence <Player> dataControl = new Persistence();

    public Player(String nickName, String password) {
        
        this.setUserName(nickName);
        this.setPassword(password);
        this.setPermission(1);
        this.setId(getLastIDplus());
 
    }
    
    static public List<Player> getListPlayer (){
            
        return dataControl.loadList("src/data/userData.json", Player.class);       
    }
    
    public static void savePlayer (Player player) {
        
        List<Player> listPlayer = getListPlayer();
        
        for (Player aux : listPlayer){
            
            if (aux.getId() == player.getId()){
                
                aux.setCoins(player.getCoins());
                aux.setWorkshop(player.getWorkshop());
                aux.setMaxExplosions(player.getMaxExplosions());

                break;
            }
        }
        
        dataControl.saveList(listPlayer, "src/data/userData.json");
    }
    
    public static void loadPlayer (Player player) {
        
        List<Player> listPlayer = getListPlayer();
        
        for (Player aux : listPlayer){
            
            if (aux.getId() == player.getId()){
                
                player.setCoins(aux.getCoins());
                player.setWorkshop(aux.getWorkshop());
                player.setMaxExplosions(aux.getMaxExplosions());

                break;
            }
        }
        
    }
    
    public static void createPlayer (String userName, String password){
        
        Player newPlayer = new Player(userName, password);
        List<Player> listPlayer = getListPlayer();
        
        listPlayer.add(newPlayer);
        
        dataControl.saveList(listPlayer, "src/data/userData.json");
        
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

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop stats) {
        this.workshop = stats;
    }

    public Integer getMaxExplosions() {
        return maxExplosions;
    }

    public void setMaxExplosions(int lastLaps) {
        this.maxExplosions = lastLaps;
    }
    
    
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Player{" + "coins=" + coins + ", stats=" + workshop + ", maxExplosions=" + maxExplosions + '}';
    }
   
    
}

