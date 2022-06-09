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
    
    private Integer[] driftStats;
    private Integer[] healtStats;
    private Integer[] forceStats;
    private Integer[] cantVehicle;
    
    public Workshop(){
        
        driftStats = new Integer[]{0,0,0,0,0};
        healtStats = new Integer[]{0,0,0,0,0};
        forceStats = new Integer[]{0,0,0,0,0};
        cantVehicle = new Integer[]{1,0,0,0};
        
    }
    
    public void buyCar(){
        
        for (int i=0; i < cantVehicle.length ; i++){
            
            if(cantVehicle[i] == 0 ){
                
                cantVehicle[i] = 1;
                break;
            }
        }
    }
    
    public int getsCarsValue(){
        
        int value = 0;
        
        for (int i=0; i < cantVehicle.length ; i++){
            
            if(cantVehicle[i] == 1){
                
                value += 25 ;
            }
   
        }
        
        return value;
        
    }
        
    public void incremetDrift(){
        
        for (int i=0; i < driftStats.length ; i++){
            
            if(driftStats[i] == 0 ){
                
                driftStats[i] = 1;
                
                break;
            }
        }
    }
    
    public int getDriftValues(){
        
        int value = 0;
        
        for (int i=0; i < driftStats.length ; i++){
            
            if(driftStats[i] == 1 ){
                
                value += 20;
            }
            
        }
        
        return value;
    }
    
    public void incremetHealt(){
        
        for (int i=0; i < healtStats.length ; i++){
            
            
            if(healtStats[i] == 0){
                
                healtStats[i] = 1;
                
                break;
            }
            
        }
    }
    
    public int getHealtValues(){
          
        int value = 0;
        
        for (int i=0; i < healtStats.length ; i++){
            
           if (healtStats[i] == 1){
               
               value += 20;
           } 
            
        }
        
        return value;
    }
        
    public void incremetForce(){
        
        for (int i=0; i < forceStats.length ; i++){
            
            if(forceStats[i] == 0 ){
                
                forceStats[i] = 1;
                break;
            }
        }
    }
    
    public int getForceValues(){
        
        int value = 0;
        
        for (int i=0; i < forceStats.length ; i++){
            
            if(forceStats[i] == 1){
                
                value += 20;
            }
            
        }
        
        return value;
    }

    @Override
    public String toString() {
        return "Workshop{" + "driffStats=" + driftStats.toString() + ", healtStats=" + healtStats.toString() + ", forceStats=" + forceStats.toString() + '}';
    }
    
    
}
