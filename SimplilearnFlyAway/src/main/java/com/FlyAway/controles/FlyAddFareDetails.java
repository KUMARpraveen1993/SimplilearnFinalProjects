package com.FlyAway.controles;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FlyAway.Data.Admin;
import com.FlyAway.dao.FlyAdminDao;
import com.FlyAway.Data.Fare;

/**
 * Servlet implementation class AddFareDetails
 */
@WebServlet("/addfaredetails")
public class FlyAddFareDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @param FlightClass 
     * @see HttpServlet#dopost(HttpServletRequest request , HttpServletResponce responce )
     */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response, String FlightClass) throws ServletException, IOException {
		
		RequestDispatcher rd ;
		boolean flag = false;
		HttpSession session = request.getSession(false); 
		String flightnumber = (String)session.getAttribute("flightNumber");
		Integer conFlightNumber = 0;
		String travelClass = request.getParameter("travelClass");	
		String fare = request.getParameter("fare");
		Fare fr = new Fare();
		Admin adm = new Admin();
		String status = "";
		double classFare = 0.00;
		try {
			conFlightNumber = Integer.parseInt(flightnumber);
			classFare = Double.parseDouble(fare);

		}catch(Exception e) {
			flag = true;
		}


		if((conFlightNumber != 0 && conFlightNumber != null) && 
				(travelClass != null && travelClass.trim() != "") &&
				(classFare != 0.00) && (flag == false)) {

			fr.setFlightNumber(conFlightNumber);
			fr.setFlightClass(FlightClass);
			fr.setFare(classFare);

			status = adm.addFare(fr);
			if(status == "SUCCESS") {

				request.setAttribute("SUCCESS", "Fare Added Successfully");
				rd = getServletContext().getRequestDispatcher("/admindetails.jsp");
				rd.forward(request, response);

			}else if(status == "FAIL") {

				request.setAttribute("FAIL", "ERROR Occured while adding Fare");
				rd = getServletContext().getRequestDispatcher("/admindetails.jsp");
				rd.forward(request, response);


			}

		}else {

			request.setAttribute("FAIL", "ERROR Occured while adding Fare");
			rd = getServletContext().getRequestDispatcher("/admindetails.jsp");
			rd.forward(request, response);
		}

		}
}
