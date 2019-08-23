package beanClasses;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "route")
@Entity
public class Route {
	@Id
	private int rid;
	@Column(name = "p_from")
	private String from;
	@Column(name = "p_to")
	private String to;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Route() {
		super();
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
	@Override
	public String toString() {
		return "Route [rid=" + rid + ", from=" + from + ", to=" + to + "]";
	}
}