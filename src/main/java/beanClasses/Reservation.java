package beanClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table(name = "reservation")
@Entity
public class Reservation implements Cloneable{
	@Id
	private int pnr;
	@Column(name = "p_name")
	private String name;
	@Column(name = "p_id")
	private String id;
	@Column(name = "p_from")
	private String from;
	@Column(name = "p_to")
	private String to;
	private int seats;
	@Column(name = "p_date")
	private String date;
	@Column(name = "p_type")
	private String type;
	@Column(name = "fare")
	private int fare;
	@ManyToOne
	@JoinColumn(name = "rid")
	Route route;
	@ManyToOne
	@JoinColumn(name = "jid")
	Journey journey;
	public Object clone() throws CloneNotSupportedException 
	{ 
		return super.clone(); 
	} 
	public Reservation() {}
	public int getPnr() {
		return pnr;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "Reservation [pnr=" + pnr + ", name=" + name + ", id=" + id + ", from=" + from + ", to=" + to
				+ ", seats=" + seats + ", date=" + date + ", type=" + type + ", fare=" + fare + ", route=" + route
				+ ", journey=" + journey + "]";
	}
	public Journey getJourney() {
		return journey;
	}
	public void setJourney(Journey journey) {
		this.journey = journey;
	}
}