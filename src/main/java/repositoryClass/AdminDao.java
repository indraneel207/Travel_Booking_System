package repositoryClass;
import beanClasses.Journey;
import beanClasses.Reservation;
import beanClasses.Route;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdminDao {
	private static final String PERSISTENCE_UNIT_NAME = "TravelBookingSystemNew";
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entitymanager = factory.createEntityManager();
	
	public List<Reservation> getpassengerdetails(Reservation reservation){
		entitymanager.getTransaction().begin();
		String getUser_query = "select * from reservation r where r.p_type='"+reservation.getType()+"' and r.p_from='"+reservation.getFrom()+"' and r.p_to='"+reservation.getTo()+"' and r.p_date='"+reservation.getDate()+"';";
		@SuppressWarnings("unchecked")
		List<Reservation> list = (List<Reservation>)entitymanager.createNativeQuery( getUser_query ,Reservation.class).getResultList();
		entitymanager.getTransaction().commit();
		return list;
	}
	public Route getRoute(Route route)
	 {
		 route=entitymanager.find(Route.class, route.getRid()); 
		 return route;
	 }
	public int getCount(Reservation reservation1, Reservation reservation2) {
		entitymanager.getTransaction().begin();
		String getUser_query = "SELECT * FROM journey where p_date>='"+reservation1.getDate()+"' and p_date<='"+reservation2.getDate()+"' and rid='"+reservation1.getRoute().getRid()+"';";
		@SuppressWarnings("unchecked")
		List<Journey> list = (List<Journey>)entitymanager.createNativeQuery( getUser_query ,Journey.class).getResultList();
		entitymanager.getTransaction().commit();
		return list.size();
	}
	public List<Reservation> getIncome(Reservation reservation) {
		entitymanager.getTransaction().begin();
		String getUser_query = "SELECT * FROM reservation where p_date='"+reservation.getDate()+"';";
		@SuppressWarnings("unchecked")
		List<Reservation> list = (List<Reservation>)entitymanager.createNativeQuery( getUser_query ,Reservation.class).getResultList();
		entitymanager.getTransaction().commit();
		return list;
	}
	public List<Journey> getJourney(Reservation reservation) {
		entitymanager.getTransaction().begin();
		String getUser_query = "SELECT * FROM journey where p_date='"+reservation.getDate()+"';";
		@SuppressWarnings("unchecked")
		List<Journey> list = (List<Journey>)entitymanager.createNativeQuery( getUser_query ,Journey.class).getResultList();
		entitymanager.getTransaction().commit();
		return list;
	}
}