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
    
    protected String nickName;
    protected String password;
    protected int id;
    protected int permission;
    
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getUserName() {
        return nickName;
    }

    public void setUserName(String userName) {
        this.nickName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
    
    //</editor-fold>

    


    
    
}
