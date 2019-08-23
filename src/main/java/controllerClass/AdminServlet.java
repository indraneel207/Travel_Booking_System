package controllerClass;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import beanClasses.*;

@WebServlet("/adminservlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String function = (String) session.getAttribute("function");
		Client client = ClientBuilder.newClient(new ClientConfig());
		String apiURL = "http://localhost:8080/TravelBookingSystemNew/webapi/adminRest";
		switch (function) {
		case "journeydetails": {
			GenericType<List<Reservation>> genericType = new GenericType<List<Reservation>>(){};
			WebTarget webTarget = client.target(apiURL).path("journeydetails/"+request.getParameter("source")+"/"+request.getParameter("destination")+"/"+request.getParameter("date")+"/"+request.getParameter("bustype"));
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			List<Reservation> newReservation = invocationBuilder.get().readEntity(genericType);
			if (newReservation.size() > 0) {
				session.setAttribute("Travellers", newReservation);
				RequestDispatcher rd = request.getRequestDispatcher("passengerdetailspage2.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("message",
						"Bus/seat is not Available,please Try Another Bus/Journey-Date/Bus-Type");
				RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
				rd.forward(request, response);
			}
		}
			break;
		case "countbuses": {
			WebTarget webTarget = client.target(apiURL).path("countbuses/"+request.getParameter("date1")+"/"+request.getParameter("date2")+"/"+request.getParameter("source")+"/"+request.getParameter("destination"));
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			String newReservation = invocationBuilder.get().readEntity(String.class);
			int count = Integer.parseInt(newReservation);
			if (count > 0) {
				session.setAttribute("count", count);
				RequestDispatcher rd = request.getRequestDispatcher("buscountpage2.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("message",
						"Bus/seat is not Available,please Try Another Bus/Journey-Date/Bus-Type");
				RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
				rd.forward(request, response);
			}
		}
			break;
		case "incomedetails": {
			WebTarget webTarget = client.target(apiURL).path("incomedetails/"+request.getParameter("date"));
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			GenericType<List<Reservation>> genericType = new GenericType<List<Reservation>>() {};
			List<Reservation> list = invocationBuilder.get().readEntity(genericType);
			if (list.size() > 0) {
				session.setAttribute("Travellers", list);
				RequestDispatcher rd = request.getRequestDispatcher("incomedetailspage2.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("message",
						"Buses are not Available on that Date,please Try Another Bus/Journey-Date/Bus-Type");
				RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
				rd.forward(request, response);
			}
		}
			break;
		default: {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
