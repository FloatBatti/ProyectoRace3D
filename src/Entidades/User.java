package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author AgusGonza
 */
public class User implements Serializable{
    
    protected String nickName;
    protected String password;
    protected int id;
    protected int permission;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.nickName, other.nickName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    
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

    @Override
    public String toString() {
        return "User{" + "nickName=" + nickName + ", password=" + password + ", id=" + id + ", permission=" + permission + '}';
    }

    


    
    
}