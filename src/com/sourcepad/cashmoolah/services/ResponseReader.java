package com.sourcepad.cashmoolah.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

public class ResponseReader {
	
	public HttpResponse response;
	
	public ResponseReader(HttpResponse r){
		this.response = r;
	}
	
	public String read(){
		StringBuilder sb = new StringBuilder();
		try {
		
		    BufferedReader reader = 
		           new BufferedReader(new InputStreamReader(this.response.getEntity().getContent()), 65728);
		    String line = null;

		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		}
		catch (IOException e) { e.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }


		return sb.toString();
	}

}
