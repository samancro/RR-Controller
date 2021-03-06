package com.saman.rrc.app;

public class Command {
	
	int id;
	int childID;
	int code;
	String name;
	
	public Command(){}
	
	public Command( int id, int code, int childID, String name){
		this.id = id;
		this.childID=childID;
		this.code = code;
		this.name = name;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setChildID(int childID){
		this.childID = childID;
	}
	
	public int getChildID(){
		return this.childID;
	}
	
	public void setCode(int code){
		this.code = code;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

}
