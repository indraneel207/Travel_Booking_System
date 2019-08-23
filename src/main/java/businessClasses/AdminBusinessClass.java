package businessClasses;
import java.util.ArrayList;
import java.util.List;
import beanClasses.Journey;
import beanClasses.Reservation;
import beanClasses.Route;
import repositoryClass.AdminDao;
public class AdminBusinessClass {
	private List<String> list;
	public AdminBusinessClass(){
		list= new ArrayList<String>();
		list.add("ABCD");
		list.add("ABC");
		list.add("BCD");
	}
	public String countBusses(Reservation reservation1,Reservation reservation2) {
			int count=0;
			AdminDao adminDao = new AdminDao();
			for (int k = 0; k < list.size(); k++)
				if (list.get(k).contains(reservation1.getFrom()) && list.get(k).contains(reservation1.getTo()))
					if (list.get(k).indexOf(reservation1.getFrom()) < list.get(k).indexOf(reservation1.getTo())) {
						Route route = new Route();
						route.setRid(k+1);
						route=adminDao.getRoute(route);
						reservation1.setRoute(route);
						count+= adminDao.getCount(reservation1,reservation2);
					}
			return String.valueOf(count);
	}
	public List<Reservation> incomeList(Reservation reservation)
	{
		List<Reservation> list =new ArrayList<Reservation>();
		List<Reservation> passengerList = new AdminDao().getIncome(reservation);
		List<Journey> journeyList = new AdminDao().getJourney(reservation);
		for (int i = 0; i < journeyList.size(); i++) {
			Journey journey = journeyList.get(i);
			int totalseats = 0,totalfare = 0;
			for (int j = 0; j < passengerList.size(); j++) {
				Reservation reservation2 = passengerList.get(j);
				if(reservation2.getJourney().getJid()==journey.getJid())
				{
					totalseats+=reservation2.getSeats();
					totalfare+=(reservation2.getFare()*reservation2.getSeats());
				}
			}
			Reservation busDetails = new Reservation();
			busDetails.setFare(totalfare);
			busDetails.setSeats(totalseats);
			busDetails.setDate(journey.getDate());
			busDetails.setRoute(journey.getRoute());
			busDetails.setFrom(journey.getRoute().getFrom());
			busDetails.setTo(journey.getRoute().getTo());
			busDetails.setJourney(journey);
			list.add(busDetails);
		}
		return list;
	}
}