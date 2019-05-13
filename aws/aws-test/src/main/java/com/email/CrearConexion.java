package com.email;

import javax.jms.JMSException;

import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

public class CrearConexion {

	private static AmazonSQS sqs;
	
//==========================================================================================================================
//										CONEXION AWS Y A SQS
//==========================================================================================================================
public static  void Conectarse() throws JMSException {
			SQSConnection connection = null;
			final AWSCredentials credentials = new BasicAWSCredentials("AKIAJROR5M2TAS6FA2JQ","gIddFR4+d3cFOu84u2nEts8Q/WP7xdReEdiWM4tL");
			
			connection = new SQSConnectionFactory.Builder(com.amazonaws.regions.Region.getRegion(Regions.SA_EAST_1)).build().createConnection(credentials);
			connection.start();
			System.out.print("Conectadooo");
			
			ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
			sqs = AmazonSQSClientBuilder.standard()
			       .withCredentials(credentialsProvider)
			       .withRegion(Regions.US_WEST_2)
			       .build();
}
	
	
	
}
