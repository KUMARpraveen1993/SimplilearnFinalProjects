package com.FlyAway.controles;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FlyAway.dao.FlyPassengerDao;
import com.FlyAway.Data.Fare;
import com.FlyAway.Data.Flight;

/**
 * Servlet implementation class FlySubmit
 */
@WebServlet("/FlySubmits")
public class FlySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		FlyPassengerDao cust = new FlyPassengerDao();
		
		String travelClass = request.getParameter("travelclass");
		HttpSession session = request.getSession(false);
		Flight flight = (Flight)session.getAttribute("flightobject");
		Fare fare = cust.getFareRecord(flight.getFlightNumber(), travelClass);
		session.setAttribute("fareobject", fare);
		
		Integer customerId = (Integer)session.getAttribute("customerId");
		
		if(customerId == null) {
		rd = getServletContext().getRequestDispatcher("/register.jsp");
        rd.forward(request, response);
		}else if(customerId != null) {
			rd = getServletContext().getRequestDispatcher("/confirmbooking.jsp");
	        rd.forward(request, response);
		}
	}

}
