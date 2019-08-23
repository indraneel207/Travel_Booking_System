package com.app.TravelBookingSystemNew;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import beanClasses.Reservation;
import businessClasses.AdminBusinessClass;
import repositoryClass.AdminDao;

@Path("adminRest")
public class AdminRestClass {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("journeydetails/{source}/{destination}/{date}/{type}")
	public List<Reservation> journeyDetails(@PathParam("source")String source,@PathParam("destination")String destination,@PathParam("date")String date,@PathParam("type")String type) {
		Reservation reservation = new Reservation();
		reservation.setFrom(source);
		reservation.setTo(destination);
		reservation.setDate(date);
		reservation.setType(type);
		return (new AdminDao().getpassengerdetails(reservation));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("countbuses/{date1}/{date2}/{source}/{destination}")
	public String count(@PathParam("date1")String date1,@PathParam("date2")String date2,@PathParam("source")String source,@PathParam("destination")String destination) {
		Reservation newTraveller1 = new Reservation();
		Reservation newTraveller2 = new Reservation();
		newTraveller1.setDate(date1);
		newTraveller2.setDate(date2);
		newTraveller1.setFrom(source);
		newTraveller1.setTo(destination);
		return (new AdminBusinessClass().countBusses(newTraveller1,newTraveller2));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("incomedetails/{date}")
	public List<Reservation> incomeCalculation(@PathParam("date")String date) {
		Reservation reservation = new Reservation();
		reservation.setDate(date);
		return (new AdminBusinessClass().incomeList(reservation)); 
	}
}
