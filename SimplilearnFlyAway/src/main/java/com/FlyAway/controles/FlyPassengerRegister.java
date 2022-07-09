package com.FlyAway.controles;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FlyAway.dao.FlyPassengerDao;
import com.FlyAway.Data.Passenger;

/**
 * Servlet implementation class FlyPassengerRegister
 */
@WebServlet("/FlyPassengerRegisters")
public class FlyPassengerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		HttpSession oldSession = request.getSession(false);
		HttpSession newSession = null;
		if (oldSession != null) {
			Enumeration keys = oldSession.getAttributeNames();
			while(keys.hasMoreElements()) {
				String key = (String)keys.nextElement();
				map.put(key, oldSession.getAttribute(key));
				oldSession.removeAttribute(key);			
			}

			oldSession.invalidate();	
			newSession = request.getSession();
			for(Map.Entry<String , Object> m : map.entrySet()) {

				newSession.setAttribute((String)m.getKey(), m.getValue());
				map.remove(m);
			}

		}else if(oldSession == null)  {

			newSession = request.getSession();
		}

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("emailaddress");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		int PassengerId = 0;
		FlyPassengerDao cust = new FlyPassengerDao();
		Passenger passenger = new Passenger();		

		if(firstName.trim() != "" && lastName.trim() != "" && email.trim() != ""  
				&& password.trim() != "" && phone.trim() != ""  ) {
			passenger.setFirstName(firstName);
			passenger.setLastName(lastName);
			passenger.setEmailId(email);
			passenger.setPassword(password);
			passenger.setContact(phone);
			PassengerId = cust.addPassenger(passenger);
			System.out.println(PassengerId);

			if(PassengerId != 0) {
				newSession.setAttribute("PassengerId", PassengerId);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirmbooking.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("Error", "Error Occured while adding Passenger");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
				rd.forward(request, response);

			}


		}else {
			request.setAttribute("Error1", "Error Occured while adding Passenger");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
			rd.forward(request, response);

		}




		
	}

}
