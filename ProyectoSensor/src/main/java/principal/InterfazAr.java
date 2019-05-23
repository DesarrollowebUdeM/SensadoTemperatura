/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import com.panamahitek.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;


/**
 *
 * @author Personal
 */
public class InterfazAr {
    PanamaHitek_Arduino arduinouno = new PanamaHitek_Arduino();
    int i; 
    double celsius;
    public String getCelsius() {//metodo para obtener la temperatura aunque la variable celsius tiene acceso publico
        return String.valueOf(celsius);
    }
    SerialPortEventListener listener=new SerialPortEventListener() {
        int i=0; 
        double celsius=0;
        @Override
        public void serialEvent(SerialPortEvent spe) {//evento del serial
            try {
                if (arduinouno.isMessageAvailable()==true){//Si llega un valor
                    i++;
                    celsius=(500*Float.parseFloat(arduinouno.printMessage())/1023);//transformo un string a float
                    System.out.println(celsius);
                    
                    if (celsius>30) {//aqui se da la notificación de que la temperatura es critica
                        
                        System.out.println("Temperatura ALTA"+String.valueOf(celsius));//muestra la temperatura cuando no excede el limite
                    } 
                    else{System.out.println(celsius);}//comentar si no quieren ver la temperatura en tiempo real
                    
                }
            } catch (SerialPortException ex) {//captura las excepiones del evento del serial COM3
                Logger.getLogger(InterfazAr.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ArduinoException ex) {
                Logger.getLogger(InterfazAr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

       
    };
    public InterfazAr() {
        try {
            arduinouno.arduinoRXTX("COM3", 9600, listener); //conexión con el arduino, EL COM debe coincidir con el slot USB usado por el arudino
        } catch (ArduinoException ex) {
            Logger.getLogger(InterfazAr.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
