package com.example.model;

public class Task {
	 private int id;
	    private String name;
	    private String status;
	    //private int  timeRequired;
	    public Task(int id, String name, String status) {
	        this.id = id;
	        this.name = name;
	        this.status = status;
	        //this.timeRequired=timeRequired;
	        
	    }
	    // Getters
	    public int getId() { return id; }
	    public String getName() { return name; }
	    public String getStatus() { return status; }
	    //public int getTimeRequired() {return timeRequired;}
}
