/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author AgusGonza
 */
public class Usuario implements Serializable{
    
    private String userName;
    private String password;
    private static int id = 0;
    private int userId;
    private int coins;
    private String timeRecord;
    private List <Racer> racers = new ArrayList();

    public Usuario(String userName, String password, int userId, int coins, String timeRecord) {
        this.userName = userName;
        this.password = password;
        this.userId = createID();
        this.coins = coins;
        this.timeRecord = timeRecord;
    }
    
    private int createID(){
    
        return ++id;
    }
    
    
}
