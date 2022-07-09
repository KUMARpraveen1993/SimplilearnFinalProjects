package com.FlyAway.controles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class FlyShowFare
 */
@WebServlet("/FlyShowFares")
public class FlyShowFare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FlyPassengerDao cust = new FlyPassengerDao();
		String flightNumberStr;
		int flightNumber = 0;
		flightNumberStr = request.getParameter("flightnumber");
		if(flightNumberStr != null && flightNumberStr != "") {
			flightNumber = Integer.parseInt(flightNumberStr);
		}
		List<Fare> fareList = new ArrayList<>();
		Flight flight = new Flight();
		HttpSession session = request.getSession(false);
		if(flightNumber != 0) {
			flight = cust.getFlight(flightNumber);
			fareList = cust.showFareList(flight.getFlightNumber());
			request.setAttribute("farelist", fareList);
			session.setAttribute("flightobject", flight);

			if(fareList.size() == 0 || fareList == null) {

				request.setAttribute("FAIL", "There are no fare list available. Cannot Book Tickets for " + flightNumber);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/flightdetails.jsp");
				rd.forward(request, response);

			}else {

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/faredetails.jsp");
				rd.forward(request, response);
			}


		}else {

			request.setAttribute("FAIL1", "Error Occurred while fetching fares");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/flightdetails.jsp");
			rd.forward(request, response);

		}

	}

}
