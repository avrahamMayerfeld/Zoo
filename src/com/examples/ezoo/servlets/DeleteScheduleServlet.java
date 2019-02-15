package com.examples.ezoo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FeedingSchedulesDAO;

/**
 * Servlet implementation class DeleteScheduleServlet
 */
@WebServlet("/DeleteScheduleServlet")
public class DeleteScheduleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("displayall.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
        FeedingSchedulesDAO dao = DAOUtilities.getFeedingSchedulesDao();
		try {
			dao.deleteSchedFromDB(id);
	}catch (Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("displayall.jsp").forward(request, response);

		}
	}
}
