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
 * @author panda
 */
public class Admin extends User implements Serializable{
    
    private List <Player> playerList = new ArrayList();

    public Admin() {
        
        this.setUserName("Admin");
        this.setPassword("40884962");
        this.setPermission(0);
        this.setId(0);
    }
    
    
}
