/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Entidades.Vehicle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
class countDown extends Thread {
         long minPrime;
         countDown(long minPrime) {
             this.minPrime = minPrime;
         }

         @Override
         public void run() {
             try {
                 TimeUnit.SECONDS.sleep(2);
             } catch (InterruptedException ex) {
                 Logger.getLogger(countDown.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             Engine.setStart(true);
             Vehicle.getVehicle().accelerate(500.0f);
         }
}
