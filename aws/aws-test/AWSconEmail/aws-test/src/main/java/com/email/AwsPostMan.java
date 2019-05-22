package com.email;


import java.util.Arrays;
import java.util.List;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

/**
* Esta clase define metodos get y set para ser utilizados en el main, tambien define algunos metodos para crear y enviar la notificacion por correo electronico
*  @author: Andrès Camilo Osorio Ospina
* 		   Andrès Fernando Martinez Galvis
* 	       Giancarlo Vasquez Sepulveda
* @fecha: Mayo 22 de 2019
* @version: EmailAWSv1.0
*/

public class AwsPostMan implements PostMan {
	//Definiciòn de variables para la creaciòn del metodo createMessage y send
	private String from, to, subject, body;
	private AmazonSimpleEmailService simpleEmailService;
	    
	    /**
	     * Constructor para inicializar el servicio SES
	     * @param Variable de tipo SES con el fin de inicar el servicio
	     */
	    public AwsPostMan(AmazonSimpleEmailService simpleEmailService){
	        this.simpleEmailService = simpleEmailService;
	    
	    }
	    
	    /**
	     * Mètodos getters y setters
	     * @param 
	     */
	    
	    
	    public void setFrom(String from) {
	        this.from = from;
	    }

	    public void setTo(String to) {
	        this.to = to;
	    }

	    public void setSubject(String subject) {
	        this.subject = subject;
	    }

	    public void setBody(String body) {
	        this.body = body;
	    }
	    
	    public PostMan withFrom(String from) {
	       this.from = from;
	       return this;
	    }

	    public PostMan withTo(String to) {
	        this.to = to;
	        return this;
	    }

	    public PostMan withSubject(String subject) {
	         this.subject = subject;
	         return this;
	    }

	    public PostMan withBody(String body) {
	        this.body = body;
	        return this;
	    }
	    
	    private List<String> getToAsList(){
	    	return Arrays.asList(to.split(","));
	    }


	    /**
	     * Método para hacer el pushNotification o enviar la notifiacion por correo electrònico
	     * @return las credenciales de seguridad
	     * @method SendEmailRequest recibe como parametro el origen del parametro, el correo de destino, e implementa la creaciòn del mensaje
	     * @method sendEmail metodo que recibe como parametro la solicitud anteriormente creada en el metodo SendEmailRequest
	     */
	    public void send() {

	        Destination destination = new Destination(getToAsList());
	        SendEmailRequest request = new SendEmailRequest(from, destination, createMessage());
	        simpleEmailService.sendEmail(request);
	    }

	    /**
	     * Método que crea el mensaje que se va a enviar por correo electrònico
	     * @param Body amazonBody, es una variable que crea el cuerpo o contenido del correo electrònico
	     * @method Body, metodo que  crea un contenido y recibe como parametro el cuerpo del e-mail
	     * @method Message crea como tal todo el correo electrònico, contiene tanto el asunto como el contenido anteriormente creado
	     * @return retorna el mensaje que se enviara al correo electrònico
	     */
		private Message createMessage() {
			Body amazonBody = new Body(new Content(body));
			Message message = new Message(new Content(subject),amazonBody);
			return message;
		}


}
