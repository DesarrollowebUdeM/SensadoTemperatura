package com.email;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;

public class EndPoint {
	
	private static AmazonSNS  sns;

	//==========================================================================================================================
//	C R E A R 		E N D    P O I N T
//==========================================================================================================================
public static String crearEndPoint(String regId, String userData, String platformEndpointArnParam){
	CreatePlatformEndpointRequest  createPlatformEndpointRequest = new CreatePlatformEndpointRequest();
	createPlatformEndpointRequest.setCustomUserData(userData);
	createPlatformEndpointRequest.setPlatformApplicationArn(platformEndpointArnParam);
	createPlatformEndpointRequest.setToken(regId);	
	CreatePlatformEndpointResult createPlatformEndpointResult= sns.createPlatformEndpoint(createPlatformEndpointRequest);
	return createPlatformEndpointResult.getEndpointArn();
}

/*public boolean eliminarEndPoint(String arn) {
	try{
	DeleteEndpointRequest deleteEndpointRequest= new DeleteEndpointRequest(); 
	deleteEndpointRequest.setEndpointArn(arn);			
	sns.deleteEndpoint(deleteEndpointRequest);
	return true;
	} catch(Exception e){
	return false;
	}
}*/
	
	
}
