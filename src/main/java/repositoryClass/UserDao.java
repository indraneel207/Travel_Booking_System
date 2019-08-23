package repositoryClass;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import beanClasses.*;
import beanClasses.Reservation;
public class UserDao {
	
	private static final String PERSISTENCE_UNIT_NAME = "TravelBookingSystemNew";
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entitymanager = factory.createEntityManager();
	
	public int check(Reservation reservation)
	{
    		int seats=-1;
    		entitymanager.getTransaction().begin();
    		String getUser_query = "select * from journey j,seatallocation s,bus b where b.p_type='"+reservation.getType()+"' and j.rid='"+reservation.getRoute().getRid()+"' and j.p_date='"+reservation.getDate()+"' and s.p_from='"+reservation.getFrom()+"' and s.p_to='"+reservation.getTo()+"' and j.jid=s.jid and b.bid=j.bid;";
    		@SuppressWarnings("unchecked")
			List<SeatAllocation> list =entitymanager.createNativeQuery( getUser_query ,SeatAllocation.class).getResultList();
    		if (!list.isEmpty()) {
    			seats=list.get(0).getSeats();
    			reservation.setJourney((list.get(0).getJourney()));
    		}
    		entitymanager.getTransaction().commit();
    		return seats;
    } 
    
	public void getFare(Reservation reservation)
    {
		entitymanager.getTransaction().begin();
		String getUser_query = "select * from cost C where C.p_from='"+reservation.getFrom()+"' and C.p_to='"+reservation.getTo()+"' and C.p_type='"+reservation.getType()+"';";
		@SuppressWarnings("unchecked")
		List<Cost> list = entitymanager.createNativeQuery( getUser_query,Cost.class ).getResultList();
		if (!list.isEmpty()) 
		{
			reservation.setFare(list.get(0).getFare());
		}
		entitymanager.getTransaction().commit();
    }
	 public boolean updateReservation(Reservation reservation,boolean status)
	 {
		 try {
			 entitymanager.getTransaction().begin();
			 if(status==true) {
				 entitymanager.persist(reservation);
			 } else {
				 reservation = entitymanager.find(Reservation.class, reservation.getPnr());
				 entitymanager.remove(reservation);
			 }
			 entitymanager.getTransaction().commit();
			 if (status)
				 System.out.println("Reservation Done");
			 else
				 System.out.println("Cancellation Done");
			 return true;
		} catch (Exception e) {
			System.out.println("Exception Caused "+e);
			entitymanager.getTransaction().rollback();
			return false;
		}
	 }
	 public boolean updateSeats(Reservation reservation,boolean Status)
	 {
		 boolean result = false;
		 entitymanager.getTransaction().begin();
		 String getUser_query = "select * from seatallocation s where s.p_from='"+reservation.getFrom()+"' and s.p_to='"+reservation.getTo()+"' and s.jid='"+reservation.getJourney().getJid()+"';";
		 @SuppressWarnings("unchecked")
		 List<SeatAllocation> list = entitymanager.createNativeQuery( getUser_query,SeatAllocation.class ).getResultList();
		 SeatAllocation seatAllocation=list.get(0);
		 if (!list.isEmpty()){
			if(Status==true) {
				seatAllocation.setSeats(seatAllocation.getSeats()-reservation.getSeats());
			}else {
				seatAllocation.setSeats(seatAllocation.getSeats()+reservation.getSeats());
			}
				result=true;
		 }
		 entitymanager.getTransaction().commit();
		 return result;
	 }
	 public Route getRoute(Route route)
	 {
		 route=entitymanager.find(Route.class, route.getRid()); 
		 return route;
	 }
	 public Reservation getRouteForCancellation(Reservation reservation)
	 {
		 return entitymanager.find(Reservation.class, reservation.getPnr()); 
	 }
}