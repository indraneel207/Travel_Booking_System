package com.app.TravelBookingSystemNew;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import beanClasses.Reservation;
import businessClasses.UserBusinessClass;
import repositoryClass.UserDao;

@Path("userRest")
public class UserRestClass {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("check/{source}/{destination}/{seats}/{date}/{bustype}")
	public Reservation check(@PathParam("source")String source,@PathParam("destination")String destination,@PathParam("seats")String seats,@PathParam("date")String date,@PathParam("bustype")String type) {
		Reservation reservation = new Reservation();
		reservation.setFrom(source);
		reservation.setTo(destination);
		reservation.setSeats(Integer.valueOf(seats));
		reservation.setDate(date);
		reservation.setType(type);
		return (new UserBusinessClass().checkForSeats(reservation));
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("confirm")
	public Reservation confirm(Reservation reservation) {
		reservation.setPnr(new UserBusinessClass().pnrGenerator());
		return (new UserBusinessClass().updateReservation(reservation, true));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("cancel/{pid}")
	public Reservation checkForCancel(@PathParam("pid")String pid) {
		Reservation reservation = new Reservation();
		reservation.setPnr(Integer.valueOf(pid));
		return (new UserDao().getRouteForCancellation(reservation)); 
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("cancel/{pid}")
	public Reservation confirmCancel(@PathParam("pid")String pid) {
		Reservation reservation = new Reservation();
		reservation.setPnr(Integer.valueOf(pid));
		return (new UserBusinessClass().updateReservation(reservation,false)); 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("viewticket/{pid}")
	public Reservation viewticket(@PathParam("pid")String pid) {
		Reservation reservation = new Reservation();
		reservation.setPnr(Integer.valueOf(pid));
		return (new UserDao().getRouteForCancellation(reservation)); 
	}
}