package com.examples.ezoo.servlets;

import java.io.IOException;
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
 * Servlet implementation class AddScheduleServlet
 */
@WebServlet("/addschedule")
public class AddScheduleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addschedule.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Parameters
	//request.getRequestDispatcher("addschedule.jsp").forward(request, response);
	
		
		String recurrence = request.getParameter("recurrence");

		String food= request.getParameter("food");
		String notes = request.getParameter("notes");
		int id = Integer.parseInt(request.getParameter("id"));
		String time = request.getParameter("time");
	
		 
		Schedule SchedToSave = new Schedule(recurrence,food,notes,id,time);
		
		//Call DAO method
		FeedingSchedulesDAO dao = DAOUtilities.getFeedingSchedulesDao();
		try {
			dao.saveSched2DB(SchedToSave);
		
	
			request.getSession().setAttribute("message", "Schedule successfully created");
			request.getSession().setAttribute("messageClass", "alert-success");
			

		}catch(SQLIntegrityConstraintViolationException e){
			e.printStackTrace();

			//change the message
			request.getSession().setAttribute("message", "Id of " + SchedToSave.getID() + " is already in use");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("addschedule.jsp").forward(request, response);
			
		}catch (Exception e){
			e.printStackTrace();
			
			//change the message
			request.getSession().setAttribute("message", "There was a problem creating the schedule at this time");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("addschedule.jsp").forward(request, response);

		}
	}

}

