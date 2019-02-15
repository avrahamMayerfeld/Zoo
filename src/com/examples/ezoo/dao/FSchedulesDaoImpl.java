package com.examples.ezoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.examples.ezoo.model.Animal;
import com.examples.ezoo.model.SchedulAssignment;
import com.examples.ezoo.model.Schedule;

public class FSchedulesDaoImpl implements FeedingSchedulesDAO {



	public   List<Schedule> getAllScheds(){
		List<Schedule> schedules=new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			stmt = connection.createStatement();

			String sql = "SELECT * FROM FEEDING_SCHEDULES";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Schedule a = new Schedule();

				a.setRecurrence(rs.getString("recurrence"));
				a.setFood(rs.getString("food"));

				a.setNotes(rs.getString("notes"));
				a.setID(rs.getInt("schedule_id"));
				a.setTime(rs.getString("feeding_time"));
				
				schedules.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return schedules ;
		}
	
	public List getSchedAssignments(){
		
		List <SchedulAssignment> assignments =new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			stmt = connection.createStatement();

			String sql = "SELECT * FROM SCHEDULEASSIGNMENTS";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				SchedulAssignment a = new SchedulAssignment();

				a.setAnimalID(rs.getInt("animalid"));
				a.setScheduleID(rs.getInt("scheduleid"));

				
				assignments.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
         return assignments ;
		}
	
		
		
		
		
		
		
	
	
	

	public  void saveSched2DB(Schedule schedule) throws Exception
	{
		
		
		
		
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO FEEDING_SCHEDULES VALUES (?,?,?,?,?)";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			
			stmt.setString(1, schedule.getRecurrence());
			stmt.setString(2, schedule.getFood());
        	stmt.setString(3, schedule.getNotes());
			stmt.setInt(4, schedule.getID());
			stmt.setString(5, schedule.getTime());
	
			
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			// then update didn't occur, throw an exception
			throw new Exception("Insert schedule failed: " + schedule);
		}

	}
	
		
	
	public  void deleteSchedFromDB(int id)
	{
		
		try {
		Connection	connection = DAOUtilities.getConnection();

		PreparedStatement	stmt = connection.prepareStatement("delete from scheduleassignments where schedule_id = ?");
		stmt.setInt(1, id);
		PreparedStatement stmt2 = connection.prepareStatement("delete from feeding_schedules where schedule_id = ");
		stmt2.setInt(1, id);
		
		stmt.executeUpdate();
		stmt2.executeUpdate();
		
    
        stmt.close();
        stmt2.close();
        connection.close();	  
		
        
		} catch (SQLException e)
		{
			e.printStackTrace();
	    }
	
}
	
	
	public  Schedule getSched(int animalid)
	{
		Schedule sched = null;
		int id=animalid;
		try {
		Connection	connection = DAOUtilities.getConnection();

		PreparedStatement ps =connection.prepareStatement("select scheduleid from scheduleassignments where animalid = ?");
		ps.setInt(1, animalid);
		ResultSet rs2 = ps.executeQuery();
		int schedid=rs2.getInt(1); 
		ps.close();
		PreparedStatement	stmt = connection.prepareStatement("select * from feeding_schedules where schedule_id = ? ");
	     stmt.setInt(1,schedid);
		
		ResultSet rs= stmt.executeQuery();  
		sched = new Schedule(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
		
		stmt.close();
		connection.close();	  
			
		} catch (SQLException e)
				{
					e.printStackTrace();
			    }
			
	return sched;
	}
	
	public  void assignSched(int animalid,int scheduleid)
	{
		int schedid=scheduleid;
		int anid=animalid;
		
		
		try {
			Connection	connection = DAOUtilities.getConnection();
  	PreparedStatement	stmt = connection.prepareStatement("insert into scheduleassignments (animalid,scheduleid) values (?,?)");
		 stmt.setInt(1,anid); 
		 stmt.setInt(2,schedid);
	
		 
		 stmt.executeUpdate();		
	    
	
		stmt.close();
		connection.close();	  
			
		} catch (SQLException e)
				{
					e.printStackTrace();
			    }
		}
	
		
		public  void cancelSched(int anid,int schedid)
	{

			try {
			Connection	connection = DAOUtilities.getConnection();
PreparedStatement	stmt = connection.prepareStatement("delete from scheduleassignments where animalid = ? and schedule_id = ?");
		     stmt.setInt(1,anid);
		     stmt.setInt(2, schedid);
		     stmt.executeUpdate();
			
			
	   
	
		
		} catch (SQLException e)
				{
					e.printStackTrace();
			    }
	
	}


}



