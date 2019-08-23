package beanClasses;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "journey")
public class Journey {
	@Id
	private int jid;
	@ManyToOne
	@JoinColumn(name = "bid")
	Bus bus;
	@ManyToOne
	@JoinColumn(name = "rid")
	Route route;
	@Column(name = "p_date")
	private String date;
	public Journey() {}
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Journey [jid=" + jid + ", bus=" + bus + ", route=" + route + ", date=" + date + "]";
	}	
}