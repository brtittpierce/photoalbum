package com.photoalbum.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class GalleryServiceImp implements GalleryService{	
	public Map<Long, String> findGallery(long requestedId) {
		Map<Long, String> allGalleries = new HashMap<Long, String>();
 
        try {        
        	String url = "https://jsonplaceholder.typicode.com/photos?albumId=" + requestedId;
        	  URL obj = new URL(url);
        	  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        	  int responseCode = con.getResponseCode();
        	  System.out.println("\nSending 'GET' request to URL : " + url);
        	  System.out.println("Response Code : " + responseCode);
        	  BufferedReader in =new BufferedReader(
        	  new InputStreamReader(con.getInputStream()));
        	  String inputLine;
        	  StringBuffer response = new StringBuffer();

        	   while ((inputLine = in.readLine()) != null) {
        	     response.append(inputLine);
        	   } in .close();
        	   //print in String
        	   // System.out.println(response.toString());
        	   JSONArray myresponse = new JSONArray(response.toString());
        	   for (int index = 0; index < myresponse.length(); index++) {
        		   JSONObject jsonObject = (JSONObject) myresponse.get(index);
//	        	   System.out.println("[" + jsonObject.getLong("id") + "] " + jsonObject.getString("title"));
	        	   allGalleries.put(jsonObject.getLong("id"), "Album " + jsonObject.getString("title"));
        	   }
        	   } catch(Exception e) {
        	    System.out.println(e);
        	  }
        	
         
        return allGalleries;
	}
}