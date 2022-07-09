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

import com.FlyAway.controles.FlyPassengerLogin;
import com.FlyAway.dao.FlyPassengerDao;
import com.FlyAway.Data.Flight;

/**
 * Servlet implementation class FlyPassengerLogin
 */
@WebServlet("/FlyPassengerLogins")
public class FlyPassengerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("emailaddress");
		String password = request.getParameter("password");

		RequestDispatcher rd;
		FlyPassengerDao cust = new FlyPassengerDao();
		if((email != null && email.trim() != "") && (password != null && password.trim() != "")) {
			int customerId = cust.PassengerLogin(email, password);
			if(customerId != 0) {

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
}
				else if(oldSession == null)  {

					newSession = request.getSession();
				}

				Flight flight = (Flight)newSession.getAttribute("flightobject");
				if (flight == null) {

					newSession.setAttribute("customerId", customerId);
					rd = getServletContext().getRequestDispatcher("/customerdetails.jsp");
					rd.forward(request, response);

				}else {
					newSession.setAttribute("customerId", customerId);
					rd = getServletContext().getRequestDispatcher("/confirmbooking.jsp");
					rd.forward(request, response);

				}
}
			else {
				request.setAttribute("loginerr", "Incorrect email or Password");
				rd = getServletContext().getRequestDispatcher("/login.jsp");
				rd.forward(request, response);

			}
	}
		else {

			request.setAttribute("loginerr1", "Error Occured while login in");
			rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);

		}
	}

}
