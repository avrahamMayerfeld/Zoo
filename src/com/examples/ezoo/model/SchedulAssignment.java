package com.examples.ezoo.model;

public class SchedulAssignment 
{
	private int animalID;
	private int scheduleID;
		 
		   
	public SchedulAssignment(int anid,int schedid)
	{
		animalID=anid;
		scheduleID=schedid;
	}

		     
		
	public SchedulAssignment() {
		// TODO Auto-generated constructor stub
	}



	public int getAnimalID() {
		return animalID;
	}



	public void setAnimalID(int animalID) {
		this.animalID = animalID;
	}



	public int getScheduleID() {
		return scheduleID;
	}



	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}



		
	public String toString()
	{
		return("AnimalID: "+animalID+" ScheduleID: "+scheduleID);
	}
}

			





