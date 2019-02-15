package com.examples.ezoo.model;

public class Schedule {
 private String recurrence;
 private String food;
 private String notes;
 private int scheduleID;
 private String feedingTime;
   public Schedule(){}
 
 public Schedule(String re,String fo,String no,int id,String ft)
{
 recurrence = re;                   	
 food = fo;
 notes = no;
 scheduleID = id;
 feedingTime = ft;
		
}

     public void setRecurrence(String s){recurrence=s;}
     public void setFood(String s){food=s;}
     public void setNotes(String s){notes=s;}
     public void setID(int i){scheduleID=i;}
     public void setTime(String s){feedingTime=s;}
 
 public String getRecurrence(){return recurrence;}
 public String getFood(){return food;}
 public String getNotes(){return notes;}
 public int getID(){return scheduleID;}
 public String getTime(){return feedingTime;}

public String toString()
{
	return("ScheduleID: "+scheduleID+"; food: "+food+"; time: "+feedingTime+"; recurrence: "+recurrence+"; notes: "+notes);
}
}

	


