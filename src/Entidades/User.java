/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AgusGonza
 */
public class User implements Serializable{
    
    private String userName;
    private String password;
    private int userId;
    private int coins = 0;
    private Workshop stats = new Workshop();
    private List<Vehicle> listVehicles = new ArrayList();
    private int lastLaps = 0;
    private transient Persistence <User> dataControl = new Persistence();

    public User(String userName, String password, int lastIDplus) {
        this.userName = userName;
        this.password = password;
        this.userId = lastIDplus;
    }

    public int getUserId() {
        return userId;
    }
    
    
}
