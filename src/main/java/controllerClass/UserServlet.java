package controllerClass;

import java.io.IOException;
import beanClasses.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

@WebServlet("/userservlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String function=(String)session.getAttribute("function");
		Client client = ClientBuilder.newClient(new ClientConfig() );
    	String apiURL = "http://localhost:8080/TravelBookingSystemNew/webapi/userRest";
		switch (function) {
		case "checkforreserve":
		{
			WebTarget webTarget = client.target(apiURL).path("check/"+request.getParameter("source")+"/"+request.getParameter("destination")+"/"+request.getParameter("seats")+"/"+request.getParameter("date")+"/"+request.getParameter("bustype"));
	    	Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	    	Reservation newReservation= invocationBuilder.get().readEntity(Reservation.class);
	    	if(newReservation.getFare()>0)
			{
				session.setAttribute("newTraveller",newReservation);
				RequestDispatcher rd=request.getRequestDispatcher("reservationpage2.jsp");  
			    rd.forward(request, response);
			}
			else{
				session.setAttribute("message","Bus/seat is not Available,please Try Another Bus/Journey-Date/Bus-Type");
				RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");  
			    rd.forward(request, response);
			}
		}break;
		case "confirmreserve":
		{
			Reservation reservation=(Reservation)session.getAttribute("newTraveller");
			reservation.setName(request.getParameter("name"));
			reservation.setId(request.getParameter("idproof"));
			WebTarget webTarget = client.target(apiURL).path("confirm");
	    	Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	    	Response clientResponse = invocationBuilder.post(Entity.entity(reservation,MediaType.APPLICATION_JSON));
	    	Reservation reservation2= clientResponse.readEntity(Reservation.class);
			if(reservation2.getPnr()>0) {
					session.setAttribute("newTraveller", reservation2);
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp");  
				    rd.forward(request, response);
			}else{
				session.setAttribute("message","Sorry For Inconvenience Internal Error");
				RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");  
		    	rd.forward(request, response);
			}
		}break;
		case "checkforcancel":
		{
			WebTarget webTarget = client.target(apiURL).path("cancel/"+request.getParameter("pid"));
	    	Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	    	Reservation result=invocationBuilder.get().readEntity(Reservation.class);
			if(result.getPnr()>0){
				session.setAttribute("newTraveller", result);
				RequestDispatcher rd=request.getRequestDispatcher("confirmcancel.jsp");  
			    rd.forward(request, response);
			}
			else {
				session.setAttribute("message","<h3>PNR Not Found</h3><br><input type=\"button\" value=\"Go to Main page\" onclick=\"window.location.href='index.jsp'\">");
				RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");  
		    	rd.forward(request, response);	
			}
		}break;
		case "confirmcancel":
		{
			Reservation reservation=(Reservation)session.getAttribute("newTraveller");
			WebTarget webTarget = client.target(apiURL).path("cancel/"+reservation.getPnr());
	    	Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	    	Reservation result=invocationBuilder.delete().readEntity(Reservation.class);
			if(result.getPnr()==0){
				RequestDispatcher rd=request.getRequestDispatcher("successcancel.jsp");  
			    rd.forward(request, response);
			}
			else {
				session.setAttribute("message","<center>Internal Error</center>");
				RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");  
		    	rd.forward(request, response);	
			}
		}break;
		case "checkforticket":
		{
			WebTarget webTarget = client.target(apiURL).path("viewticket/"+request.getParameter("pid"));
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	    	Reservation result=invocationBuilder.get().readEntity(Reservation.class);
			if(result.getPnr()>0){
				session.setAttribute("newTraveller", result);
				RequestDispatcher rd=request.getRequestDispatcher("viewticket.jsp");  
			    rd.forward(request, response);
			}
			else {
				session.setAttribute("message","<h3>PNR Not Found</h3><br><input type=\"button\" value=\"Go to Main page\" onclick=\"window.location.href='index.jsp'\">");
				RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");  
		    	rd.forward(request, response);	
			}
		}break;
		default:break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}