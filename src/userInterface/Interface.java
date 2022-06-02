/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Entidades.Persistence;
import Entidades.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AgusGonza
 */
public class Interface {
    
    List<User> userList = new ArrayList();
    Persistence <List> dataListControl = new Persistence();
    
    public void loadUsers(String rute){
             
        dataListControl.load(userList, rute);
    }
    
    public void saveUser(String rute){
        
       dataListControl.save(userList, rute);
    }
    
    public void createUser(String userName, String password, int lastIDplus){
        
        User newUser = new User(userName, password, lastIDplus);
        userList.add(newUser);
    }
    
    private int ruturnLastIDplus(){
        
        int cont = 0;
        
        for (User aux: userList){
            
            cont++;
        }
        
        return cont+1;    
    }
}

