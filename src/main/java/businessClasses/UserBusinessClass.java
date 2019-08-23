package businessClasses;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import beanClasses.Reservation;
import beanClasses.Route;
import repositoryClass.UserDao;
public class UserBusinessClass {
	private List<String> list;
	public UserBusinessClass(){
		list= new ArrayList<String>();
		list.add("ABCD");
		list.add("ABC");
		list.add("BCD");
	}
	public Reservation checkForSeats(Reservation reservation) {
		try {
			UserDao userDao = new UserDao();
			Reservation reservation2 = (Reservation)reservation.clone();
			for (int k = 0; k < list.size(); k++)
				if (list.get(k).contains(reservation.getFrom()) && list.get(k).contains(reservation.getTo()))
					if (list.get(k).indexOf(reservation.getFrom()) < list.get(k).indexOf(reservation.getTo())) {
						int total = 0, available = 0, tFare = 0;
						Route route =new Route();
						route.setRid(k+1);
						route=userDao.getRoute(route);
						reservation2.setRoute(route);
						for(int i = list.get(k).indexOf(reservation.getFrom()), j = i + 1; i < list.get(k).indexOf(reservation.getTo()); i++, j++) {
							total++;
							reservation2.setFrom(String.valueOf(list.get(k).charAt(i)));
							reservation2.setTo(String.valueOf(list.get(k).charAt(j)));
							if (userDao.check(reservation2) >= reservation.getSeats()) {
								available++;
								reservation.setJourney(reservation2.getJourney());
								userDao.getFare(reservation2);
								if (reservation2.getFare() > 0)
									tFare += reservation2.getFare();
								}
							}
							if (total == available) {
								reservation.setRoute(route);
								reservation.setFare(tFare);
								return reservation;
							}
					}
			}catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return reservation;
	}
	public int pnrGenerator()
	{
		Random rand = new Random();
		int number = rand.nextInt(90000) + 10000;
		return number;
	}
	public Reservation updateReservation(Reservation reservation,boolean status) {
		int k;
		UserDao userDao = new UserDao();
		if(!status)
			reservation=userDao.getRouteForCancellation(reservation);
		k=reservation.getRoute().getRid()-1;
		String route=list.get(k);
		if(userDao.updateReservation(reservation, status))
		try {
			int possible=0,total=0;	
			Reservation reservation2 = (Reservation)reservation.clone();
			for(int i = list.get(k).indexOf(reservation.getFrom()), j = i + 1; i < list.get(k).indexOf(reservation.getTo()); i++, j++) {
				reservation2.setFrom(String.valueOf(route.charAt(i)));
				reservation2.setTo(String.valueOf(route.charAt(j)));
				total++;
				if(userDao.updateSeats(reservation2, status))
					possible++;
			}
			if(status==false && total==possible)
				reservation.setPnr(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservation;
	}
}