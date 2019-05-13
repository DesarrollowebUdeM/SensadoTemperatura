package com.email;

import java.util.HashMap;
import javax.jms.JMSException;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.CreatePlatformApplicationRequest;
import com.amazonaws.services.sns.model.CreatePlatformApplicationResult;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.util.Platform;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AmazonAWS {

//==========================================================================================================================
//								V  A  R  I  A  B  L  E  S
//==========================================================================================================================	

		private static double temperatura;
		private static String mensaje= "Alerta la temperatura supero los 35°C"
				+ " Por favor revisa tu sensor, de lo contrario"
				+ " Contactanos, Muchas Gracias";

//===============================================================================================================================================================
//							M		A		I		N
//===============================================================================================================================================================
	public static void main(String[] args) throws JMSException, JsonProcessingException {
		CrearConexion Conexion = new CrearConexion();
		Aplicacion Aplicacion = new Aplicacion();
		Cola queue  = new Cola();
		EndPoint celular = new EndPoint();
		Conexion.Conectarse();
		Aplicacion.crearAplicacion("DesarrolloWEB");
		if (temperatura >= 35.0) {
			celular.crearEndPoint("sa-east-1", "TOKEN", "GCM");
			queue.crearCola("Cola");
			queue.enviarMensajeCola(mensaje);
			Aplicacion.sendNotification(null, "", "", "", "");
		}

		//crearAplicacion("Name Aplication");
		
		//if	(temperatura>=35.0) {
			//crearEndPoint("sa-east-1","Hola","GCM");
			//crearCola("New Queue");
			//enviarMensajeCola(mensaje);
			//sendNotification(null,"Main","AKIAJROR5M2TAS6FA2JQ","TOKENCEL",mensaje);
		}//
	}
//================================================================================================================================================================

//================================================================================================================================================================
	
	

	
	




















	
	




