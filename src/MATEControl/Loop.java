/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MATEControl;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class Loop {
    public static void main(){
        new Thread(){
            public void run(){
                Math.math();
                
                try {
                    Thread.sleep(Main.arduino.getLoopRate());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Loop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }
    
}