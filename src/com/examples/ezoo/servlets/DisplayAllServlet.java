package com.examples.ezoo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FeedingSchedulesDAO;
import com.examples.ezoo.model.SchedulAssignment;
import com.examples.ezoo.model.Schedule;

/**
 * Servlet implementation class DisplayAllServlet
 */
@WebServlet("/DisplayAllServlet")
public class DisplayAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("displayall.jsp").forward(request, response);
		
		List<Schedule> SchedList;
		List <SchedulAssignment> AssignmentList;
		
		FeedingSchedulesDAO dao = DAOUtilities.getFeedingSchedulesDao();
		try {
		 SchedList = dao.getAllScheds();
		 AssignmentList = dao.getSchedAssignments();
		request.setAttribute("SchedList", SchedList);
		request.setAttribute("AssignmentList", AssignmentList);
		
		request.getRequestDispatcher("displayall.jsp").forward(request, response);
		for(Schedule s: SchedList){System.out.println(s.getRecurrence()+s.getFood()+s.getNotes()+s.getID()+s.getTime());}
		
		                  	
		 }catch (Exception e){
			e.printStackTrace();
			
		
			
		 }
	
	}}
	

	



