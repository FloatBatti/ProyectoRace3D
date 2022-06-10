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
public class Player extends User implements Serializable, Comparable<Player>{
    
    private Integer coins = 0;
    private Workshop workshop = new Workshop();
    private Integer maxExplosions = 0;
    private static transient Persistence <Player> dataControl = new Persistence();

    public Player(){
    
        this.setPermission(1);
    }
    
    public Player(String nickName, String password) {
        
        this.setUserName(nickName);
        this.setPassword(password);
        this.setPermission(1);
        this.setId(getLastIDplus());
        this.condition = true;
 
    }
    
    static public List<Player> getListPlayer (){
            
        List<Player> listPlayer = dataControl.loadList("src/data/userData.json", Player.class); 
        
        if (listPlayer != null){
            
            return listPlayer;
            
        }
        
        return listPlayer;     
    }
    
    public static void savePlayer (Player player) {  
        
        List<Player> listPlayer = getListPlayer();
        
        if (listPlayer!= null){
            
            for (Player aux : listPlayer){
            
                if (aux.equals(player)){
                
                    aux.setCoins(player.getCoins());
                    aux.setWorkshop(player.getWorkshop());
                    aux.setMaxExplosions(player.getMaxExplosions());

                    dataControl.saveList(listPlayer, "src/data/userData.json");
                    
                    break;
                }
            }
        
            
            
        }
        
    }
    
    public static void modifyPlayer(Player newModel){
  
        List<Player> listPlayer = getListPlayer();
        
        if (listPlayer != null){
            
            for (Player aux : listPlayer){
            
                if (aux.getId() == newModel.getId()){
                
                    aux.setUserName(newModel.getUserName());
                    aux.setPassword(newModel.getPassword());
                    aux.setCoins(newModel.getCoins());
                    aux.setWorkshop(newModel.getWorkshop());
                    aux.setMaxExplosions(newModel.getMaxExplosions());
                    aux.setCondition(newModel.isCondition());
                    
                    dataControl.saveList(listPlayer, "src/data/userData.json");

                    break;
                }
            } 
            
        }
        
    }
    
    public static void loadPlayer (Player player) {
        
        List<Player> listPlayer = getListPlayer();
        
        if (listPlayer != null){
    
            
            for (Player aux : listPlayer){
            
                if (aux.getId() == player.getId()){

                    player.setCoins(aux.getCoins());
                    player.setWorkshop(aux.getWorkshop());
                    player.setMaxExplosions(aux.getMaxExplosions());

                    break;
                }
            } 
            
        }
 
    }
    
    public static void createPlayer (String userName, String password){
        
        Player newPlayer = new Player(userName, password);
        List<Player> listPlayer = getListPlayer();
        
        if(listPlayer != null){

            
            listPlayer.add(newPlayer);
            dataControl.saveList(listPlayer, "src/data/userData.json");
            
        }else{
            
            listPlayer = new ArrayList();
            listPlayer.add(newPlayer);
            dataControl.saveList(listPlayer, "src/data/userData.json");
        }
         
        
    }
    
    public static void removePlayer(int idPlayer){
       
        List<Player> listPlayer = getListPlayer();
        
        if(listPlayer != null){
            
            for (Player aux : listPlayer){
            
                if (aux.getId() == idPlayer){

                    listPlayer.remove(aux);
                    
                    dataControl.saveList(listPlayer, "src/data/userData.json");

                    break;
                }
            }
            
        }

    }
    private int getLastIDplus(){
        
        int lastId = 0;
        List<Player> listPlayer = getListPlayer();
       
        if (listPlayer != null){
            
            for (Player aux : listPlayer){
            
                lastId = aux.getId();
            
            }
    
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

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }
    
    
    
    //</editor-fold>

    
    @Override
    public String toString() {
        return "Player{" + "coins=" + coins + ", stats=" + workshop + ", maxExplosions=" + maxExplosions + '}';
    }

    @Override
    public int compareTo(Player p) {
        
        int result = 0;
        
        if (this.getMaxExplosions() < p.getMaxExplosions()){
            
            result = 1;
            
        }else if(this.getMaxExplosions() > p.getMaxExplosions()){
            
            return -1;
        }
        
        return result;
    }
   
    
}

