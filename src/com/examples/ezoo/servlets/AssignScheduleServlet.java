package com.examples.ezoo.servlets;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.AnimalDAO;
import com.examples.ezoo.dao.AnimalDaoImpl;
import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FSchedulesDaoImpl;
import com.examples.ezoo.dao.FeedingSchedulesDAO;
import com.examples.ezoo.model.Schedule;

/**
 * Servlet implementation class AssignScheduleServlet
 */
@WebServlet("/AssignSchedule")
public class AssignScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("assignSchedule.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int anid = Integer.parseInt(request.getParameter("animalid"));
        	int schedid= Integer.parseInt(request.getParameter("scheduleid"));
		
		 FeedingSchedulesDAO dao = DAOUtilities.getFeedingSchedulesDao();
		 try {
			dao.assignSched(anid,schedid);
		
		 }catch (Exception e){
			e.printStackTrace();
			
			request.getRequestDispatcher("assignSchedule.jsp").forward(request, response);

		}
	}

}

