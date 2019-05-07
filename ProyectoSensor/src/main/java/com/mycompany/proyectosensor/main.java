/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosensor;

import clases.conexionFB;
import clases.sensor;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Pablo
 */
public class main {
       public static void main (String [ ] args) {
           BasicConfigurator.configure();//esta linea es vital para el log4j que se encarga de unas transacciones en el codigo
           conexionFB fb =  new conexionFB();//INSTANCIA DE LA CLASE conexionFB para usar el metodo update(Object o, String Referencia)
           fb.update(new sensor("30°"), "sensor");//requiere un objeto y la referencia  del campo en firebase 
        }
}
