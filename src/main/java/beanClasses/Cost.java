package beanClasses;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "cost")
@Entity
public class Cost {
	@Id
	private int cid;
	@Override
	public String toString() {
		return "Cost [cid=" + cid + ", from=" + from + ", to=" + to + ", fare=" + fare + ", type=" + type + "]";
	}
	@Column(name = "p_from")
	private String from;
	@Column(name = "p_to")
	private String to;
	private int fare;
	@Column(name = "p_type")
	private String type;
	public Cost() {}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}