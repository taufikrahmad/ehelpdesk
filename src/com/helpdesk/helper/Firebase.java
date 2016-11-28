package com.helpdesk.helper;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Firebase {

	public final static String AUTH_KEY_FCM = "AIzaSyB_YaTJ1fO9h8WwMrzhwGSVa5FIDMgxrAM";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	private static void Message(String deviceID,String title,String body) throws IOException, JSONException{
		URL url = new URL(API_URL_FCM);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization","key="+AUTH_KEY_FCM);
		conn.setRequestProperty("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("to",deviceID.trim());
		
		// setting message //
		JSONObject info = new JSONObject();
		info.put("title", title);   // Notification title
		info.put("body", body); // Notification body
		json.put("notification", info);
		
		// setting atribut //
		JSONObject attr = new JSONObject();
		attr.put("vibrate", 1);
		attr.put("sound", 1);
		json.put("data", attr);
		
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(json.toString());
		wr.flush();
		conn.getInputStream();
	}
	
	public static int pushFCMNotification(String[] userDeviceIdKey,String title,String body) throws Exception{
		int status = 1;
		for(int i=0;i<userDeviceIdKey.length ; i++){
			Message(userDeviceIdKey[i],title,body);
		}
		return status;
	}
	
}
