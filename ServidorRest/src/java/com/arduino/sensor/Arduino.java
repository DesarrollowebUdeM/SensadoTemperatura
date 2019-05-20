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

    private static double temp;
    private boolean estado;
    public Arduino() {
        temp = 25;
        estado = true;
        
    }

    public void iniciarsensado() {

        while (estado==true) {
            temp = sensar();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                
                estado = false;
            }
        }

    }

    public double sensar() {

        temp = (Math.random() * 30) + 1;
        System.out.println("La temperatura es:" + temp);
        return temp;

    }
    

    public static double getTemp() {
        return temp;
    }


}
