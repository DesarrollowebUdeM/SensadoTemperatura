package com.email;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.CreatePlatformApplicationRequest;
import com.amazonaws.services.sns.model.CreatePlatformApplicationResult;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.util.Platform;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Aplicacion {

	private static AmazonSNS  sns;
	private static String platformEndpointArn;
	private static CreatePlatformEndpointResult ARN;
	private static String nombre;
	private static float temperatura;

	
//==========================================================================================================================
//									C R E A R 		A P P
//==========================================================================================================================	
public static String crearAplicacion(String nombre){
		CreatePlatformApplicationRequest  createPlatformApplicationRequest= new CreatePlatformApplicationRequest();
		createPlatformApplicationRequest.setName(nombre);
		createPlatformApplicationRequest.setPlatform("GCM");
		CreatePlatformApplicationResult createPlatformApplicationResult= sns.createPlatformApplication(createPlatformApplicationRequest);
		platformEndpointArn = createPlatformApplicationResult.getPlatformApplicationArn();
		return platformEndpointArn;
	}

//==========================================================================================================================
//E N V I A R   N O T I F I C A C I Ò N
//==========================================================================================================================
public static void sendNotification(final Platform platform,
	final String principal,
	final String credential,
	final String platformToken,
	final String message) throws JsonProcessingException {
	
	//Create Platform Application. This corresponds to an app on a platform.
	CreatePlatformApplicationResult platformApplicationResult = createPlatformApplication(nombre, platform, principal);
	//Publish a push notification to an Endpoint.
	PublishResult publishResult = publish(ARN.getEndpointArn(), platform, message);
}



















private static CreatePlatformApplicationResult createPlatformApplication(String endpointArn, Platform platform, String message) {
	// TODO Auto-generated method stub
	return null;
	
}	private static PublishResult publish(String endpointArn, Platform platform, String message) {
	// TODO Auto-generated method stub
	return null;
}



}
