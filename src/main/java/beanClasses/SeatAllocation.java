package beanClasses;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table(name = "seatallocation")
@Entity
public class SeatAllocation {
	@Id
	private int sid;
	@Column(name = "p_from")
	private String from;
	@Column(name = "p_to")
	private String to;
	@ManyToOne
	@JoinColumn(name = "jid")
	private Journey journey;
	private int seats;
	public SeatAllocation() {}
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
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Journey getJourney() {
		return journey;
	}
	public void setJourney(Journey journey) {
		this.journey = journey;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "SeatAllocation [sid=" + sid + ", from=" + from + ", to=" + to + ", journey=" + journey + ", seats="
				+ seats + "]";
	}
}