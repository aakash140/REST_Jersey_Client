package com.java.ws.rest.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class CalculatorApp {
	public static final String BASE_URI="http://localhost:8081/REST_Jersey_Server";
	public static final String SQUARE_ROOT="/calculator/sqrt/";
	public static final String POWER="/calculator/pow/";
	public static void main(String[] args) {
		ClientConfig clientConfig=new DefaultClientConfig();
		Client client=Client.create(clientConfig);
		WebResource webService=client.resource(BASE_URI);

		WebResource squareRootService= webService.path("rest").path(SQUARE_ROOT+100);
		WebResource powerService= webService.path("rest").path(POWER+5+"/"+4);

		//----------Square       Root---------------
		System.out.println("Response for Square Root: "+ squareRootService.
				accept(MediaType.APPLICATION_XML).
				get(ClientResponse.class));
		System.out.println();
		System.out.println("XML for Square Root: "+ squareRootService.accept(MediaType.APPLICATION_XML).get(String.class));
		System.out.println();

		//----------Power-------------
		System.out.println("Response for Power: "+ powerService.
				accept(MediaType.TEXT_PLAIN).
				get(ClientResponse.class));
		System.out.println();
		System.out.println("XML for Power: "+ powerService.accept(MediaType.TEXT_PLAIN).get(String.class));
	}
}