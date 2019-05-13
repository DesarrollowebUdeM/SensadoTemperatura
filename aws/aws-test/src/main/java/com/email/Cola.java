package com.email;

import java.util.HashMap;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class Cola {
	private static String myQueueUrl;
	private static AmazonSQS sqs;
	//==========================================================================================================================
//	Q	U 	E	U	E
//==========================================================================================================================
public static void crearCola(String name){
		// Create a queue
		HashMap<String, String> attributeParams = new HashMap<String, String>();
		CreateQueueRequest createQueueRequest = new CreateQueueRequest(name);
		createQueueRequest.setAttributes(attributeParams);
		myQueueUrl = sqs.createQueue(createQueueRequest).getQueueUrl();
		}
		
		public static String enviarMensajeCola(String Mensaje) {	
		sqs.sendMessage(new SendMessageRequest(myQueueUrl,Mensaje));
		return Mensaje;
		}
	

}
