package com.email;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;




/**

* Esta clase define mètodos para la conexiòn con AWS y el envio de las notificaciones por medio de correo electrònico
* cabe aclarar que no existe encapsulamiento porque es una API y sera utilizada como jar en un servidor REST
* @author: Andrès Camilo Osorio Ospina
* 		   Andrès Fernando Martinez Galvis
* 	       Giancarlo Vasquez Sepulveda
* @fecha: Mayo 22 de 2019
* @version: EmailAWSv1.0
*/

public class Main {
	
	//Definiciòn de las variables
	public Double temperatura;
    /**
     * Método que crea las credenciales de seguridad para realizar la conexiòn
     * @return las credenciales de seguridad
     * @param Clave de acceso
     * @param Clave secreta
     */
	public AWSCredentials createAwsCredentials() throws IOException{
		AWSCredentials credentials = new BasicAWSCredentials("AKIAIXKV6ORJLIHIW6ZA","r0h3eZwS6q9RT08BQtO3E9gW5kNMjXQTcTIlwZYt");
		return credentials;
	}
	
    /**
     * Método que crea la conexiòn con SES 
     * @return retorna las credenciales de seguridad e inicia la conexiòn con SES
     * @param Clave de acceso
     * @param Clave secreta
     */
	public AmazonSimpleEmailService createSimpleEmailService() throws IOException {
		return new AmazonSimpleEmailServiceClient(createAwsCredentials());		
	}
	
    /**
     * Método que envia la notificaciòn al correo electrònico siempre y cuando la temperatura sea superior a 35ªC
     * @param String withFrom Correo electònico origen de la notificaciòn
     * @param String withTo Correo electronico destino de la notificaciòn
     * @param String withSubject Tema o Asunto del correo electrònico
     * @param String withBody Cuerpo o contenido del mensaje de correo electrònico
     * @method .send() con el fin de hacer el pushNotification, envia el correo electrònico
     */
	
	public void sendTestEmail() throws IOException {
		temperatura = 35.0;
		
    	if (temperatura>=35) {
    		PostMan postMan = new AwsPostMan(createSimpleEmailService());
    		postMan.withFrom("somosinventarios@gmail.com").withTo("andres9824m@gmail.com")
    		.withSubject("ADVERTENCIA SENSOR").withBody("ADVERTENCIA!! : Su temperatura"
    				+ "es de "+ temperatura.toString() + " observe que esta pasando"
    				+ " con su sensor o de lo contrario comuniquese con nosotros, Muchas Gracias!!").send();
		}
	}
    /**
     * Método Main para ejecutar la API
     * @instance Se instancia el metodo sendTestEmail para enviar el correo electrònico
     */
	public static void main(String[] args) throws IOException {
		new Main().sendTestEmail();		
		JOptionPane.showMessageDialog(null, "El Mensaje fue enviado con exito!!!");
	}
}















