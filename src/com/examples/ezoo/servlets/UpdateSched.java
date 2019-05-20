package com.examples.ezoo.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FSchedulesDaoImpl;
import com.examples.ezoo.dao.FeedingSchedulesDAO;
import com.examples.ezoo.model.Schedule;

/**
 * 
 */
@WebServlet("/updatesched")
public class UpdateSched extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("updatesched.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	//FeedingSchedulesDAO dao = DAOUtilities.getFeedingSchedulesDao();
		try {
			
			String recurrence = request.getParameter("recurrence");
            		String food= request.getParameter("food");
			String notes = request.getParameter("notes");
			int id = Integer.parseInt(request.getParameter("id"));
			String time = request.getParameter("time");
			
			Connection c = DAOUtilities.getConnection();
	      
			if (!recurrence.equals("")){
				
				String sql = "UPDATE FEEDING_SCHEDULES SET RECURRENCE = (?) WHERE schedule_id = (?)";		
				PreparedStatement stmt1 = c.prepareStatement(sql);
                		stmt1.setString(1,recurrence);
				stmt1.setInt(2,id);
				stmt1.execute();
				stmt1.close();
			}
           		if (!food.equals("")){
        		
        	   		String sql = "UPDATE FEEDING_SCHEDULES SET food = (?) WHERE schedule_id = (?)";		
				PreparedStatement stmt2 = c.prepareStatement(sql);
                		stmt2.setString(1,food);
				stmt2.setInt(2,id);
				stmt2.execute();
				 stmt2.close();
           		}
          		if (!notes.equals("")){
        	   
        			String sql = "UPDATE FEEDING_SCHEDULES SET notes = (?) WHERE schedule_id = (?)";		
				PreparedStatement stmt3 = c.prepareStatement(sql);
                		stmt3.setString(1,notes);
				stmt3.setInt(2,id);
				stmt3.execute();
				stmt3.close();
           		}
           		if(!time.equals("")){
        	   
        			String sql = "UPDATE FEEDING_SCHEDULES SET feeding_time = (?) WHERE schedule_id = (?)";		
				PreparedStatement stmt4 = c.prepareStatement(sql);
                		stmt4.setString(1,time);
				stmt4.setInt(2,id);
				stmt4.execute();
				stmt4.close();
           		}
                  
           		c.close();
           
		}catch(Exception e){
			e.printStackTrace();
		
		}
		request.getRequestDispatcher("updatesched.jsp").forward(request, response);
		
	}
}

