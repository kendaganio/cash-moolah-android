package com.sourcepad.cashmoolah.models;

import android.content.Context;

import com.orm.SugarRecord;

public class Expense extends SugarRecord<Expense>{
	
	private String tag;
	private String name;
	private double amount;
	private long timestamp;
	
	public Expense(Context ctx){
		super(ctx);
	}
	
	public Expense(Context ctx, String tag, String name, double amount, long timestamp) {
		super(ctx);
		this.tag = tag;
		this.name = name;
		this.amount = amount;
		this.timestamp = timestamp;
	}
	
	public String getGroup() {
		return tag;
	}
	public void setGroup(String group) {
		this.tag = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
