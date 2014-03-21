package com.sourcepad.cashmoolah.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.sourcepad.cashmoolah.models.User;
import com.sourcepad.cashmoolah.util.Config;

public class RegistrationService {

	protected String name;
	protected String password;
	protected String email;

	public RegistrationService(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public User register(Context ctx) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(Config.REGISTRATION_URL);

		try {
			// Add your data
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("user[name]", this.name));
			nameValuePairs.add(new BasicNameValuePair("user[password]", this.password));
			nameValuePairs.add(new BasicNameValuePair("user[password_confirmation]", this.password));
			nameValuePairs.add(new BasicNameValuePair("user[email]", this.email));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			// Execute HTTP Post Request
			HttpResponse response = httpclient.execute(httppost);
			String res = new ResponseReader(response).read();
			
			JSONObject obj = new JSONObject(res);
			
			if (obj.getBoolean("success")) {
				JSONObject userJson = new JSONObject(obj.getString("user"));
				
				User u = new User(ctx, userJson.getString("id"), this.name, this.password, this.email);
				return u;
			}
			Log.v("KANTOT", res);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		} catch (JSONException e){
			Log.v("JSONException", e.getMessage());
			// TODO Blah blah
		}
		
		return null;

	}

}
