/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temperatura.controller;

import com.arduino.sensor.Arduino;
import com.email.Main;
import com.temperatura.ws.rest.registro.RegistroResource;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henry
 */
public class Controller {
    /**
     *Esta clase se encarga de mandar una notificación.
     *
     */
    public static void pushNotify(){
        Main maim = new Main();
        try {
            maim.createAwsCredentials();
            maim.createSimpleEmailService();
            maim.sendTestEmail();
        } catch (IOException ex) {
            Logger.getLogger(RegistroResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /**
     *Esta clase se encarga de registrar un dispositivo.
     *
     */
    public static boolean register(String Email){
        
        
        return true;
    }
     /**
     *Esta clase se encarga de obtener temperatura.
     *
     */
    public static double getTemperatura(){
        
        
        
        return Arduino.getTemp();
    }
    
}
