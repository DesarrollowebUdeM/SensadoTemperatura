/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arduino.sensor;

/**
 *
 * @author ASUS
 */
public class Arduino{

    private static InterfazAr intAr;
    public Arduino() {
  
        intAr = new InterfazAr();
        
    }
    
    public static double getTemp() {
       
        return intAr.getCelsius();
    }

}
