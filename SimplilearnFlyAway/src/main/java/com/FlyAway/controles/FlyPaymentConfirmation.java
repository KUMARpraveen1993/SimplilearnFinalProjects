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
import com.FlyAway.Data.Bookings;

/**
 * Servlet implementation class FlyPaymentConfirmation
 */
@WebServlet("/FlyPaymentConfirmations")
public class FlyPaymentConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
			String cardName = request.getParameter("cardname");
			String cardNo = request.getParameter("cardno");
			String date = request.getParameter("paymentdate");

			if(session != null && (cardName != null && cardName.trim() != "") && (cardNo != null && cardNo.trim() != "" )
					&& date != null) {

				session.setAttribute("cardname", cardName);
				session.setAttribute("cardno", cardNo);
				session.setAttribute("paymentdate", date);

				Flight flight = (Flight)session.getAttribute("flightobject");
				Fare fare = (Fare)session.getAttribute("fareobject");
				String travelDate = (String)session.getAttribute("traveldate");
				int passengers = (int)session.getAttribute("passengers");
				String day = (String)session.getAttribute("day");
				int passengerId = (int)session.getAttribute("passengerId");
				int bookingId = 0;

				Bookings bookings = new Bookings();
				FlyPassengerDao cust = new FlyPassengerDao();
				double totalFare = cust.calculateFare(flight.getFlightNumber(), 
						fare.getFlightClass() , passengers);

				bookings.setFlightNumber(flight.getFlightNumber());
				bookings.setTravelClass(fare.getFlightClass());
				bookings.setTravelDate(cust.getDate(travelDate));
				bookings.setPassenger(passengers);
				bookings.setTotalFare(totalFare);
				bookings.setPassengerId(passengerId);

				bookingId = cust.addBookings(bookings);

				if(bookingId != 0) {
					session.setAttribute("bookingId", bookingId);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/bookingdetails.jsp");
					rd.forward(request, response);
				}
			}else {
				request.setAttribute("Error", "Error in processing payment please try again later");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/payment.jsp");
				rd.forward(request, response);
			}
	}

}
