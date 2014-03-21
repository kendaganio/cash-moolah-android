package com.sourcepad.cashmoolah.models;

import android.content.Context;

import com.orm.SugarRecord;

public class User extends SugarRecord<User>{
	
	private String name;
	private String password;
	private String email;
	private String uuid;
	
	public User(Context ctx){
		super(ctx);
	}
	
	public User(Context ctx, String uuid, String name, String password, String email) {
		super(ctx);
		this.uuid = uuid;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public String getUuid() {
		return this.uuid;
	}
	
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
