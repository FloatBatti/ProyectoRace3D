/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;

/**
 *
 * @author AgusGonza
 */
public class Workshop implements Serializable{
    
    private Integer[] fuelStats = new Integer[]{0,0,0,0,0};
    private Integer[] healtStats = new Integer[]{0,0,0,0,0};
    private Integer[] forceStats = new Integer[]{0,0,0,0,0};
    
    public void incremetFuel(){
        
        for (int i=0; i < fuelStats.length ; i++){
            
            if(fuelStats[i] == 0 ){
                
                fuelStats[i] = 1;
            }
        }
    }
    
    public void incremetHealt(){
        
        for (int i=0; i < healtStats.length ; i++){
            
            if(healtStats[i] == 0 ){
                
                healtStats[i] = 1;
            }
        }
    }
        
    public void incremetForce(){
        
        for (int i=0; i < forceStats.length ; i++){
            
            if(forceStats[i] == 0 ){
                
                forceStats[i] = 1;
            }
        }
    }
    
}
