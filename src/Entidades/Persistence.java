/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AgusGonza
 */
public class Persistence < T > {
    
//    Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
//    
//   
//    public void save(T object, String rute){
//        
//        File file = new File(rute);
//        try {
//            
//            bufferedWriter  = new BufferedWriter(new FileWriter(file));
//            gson.toJson(Object, Object.getClass(), bufferedWriter);
//            
//        } catch (IOException ex) {
//            
//            Logger.getLogger(Persistence.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally{
//            
//         if (bufferedWriter != null){
//
//                try {
//                    bufferedWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }  
//        }   
//    }
//    
//    public void loadObject(T object, String rute){
//    
//        File file = new File(rute);
//        
//        try {
//            
//            object = (T) JSON_MAPPER.readValue(file, object.getClass());
//            
//        }
//        catch (IOException e){
//
//            e.printStackTrace();
//        }
//
// 
//    }
//    
}
