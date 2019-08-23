package controllerClass;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import beanClasses.Login;

@WebServlet("/indexservlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Login login = new Login(request.getParameter("username"), request.getParameter("password"));
    	Client client = ClientBuilder.newClient(new ClientConfig());
    	String apiURL = "http://localhost:8080/TravelBookingSystemNew/webapi/index";
    	WebTarget webTarget = client.target(apiURL).path("validate");
    	Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    	Response clientResponse = invocationBuilder.post(Entity.entity(login, MediaType.APPLICATION_JSON));
		String status = clientResponse.readEntity(String.class);
    	if(status.equals("accept")){
			RequestDispatcher rd=request.getRequestDispatcher("passengerdetailspage1.jsp");  
	        rd.forward(request, response);
		}
    	else {
    		RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
	        rd.forward(request, response);
		}
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
