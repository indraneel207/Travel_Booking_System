package beanClasses;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "bus")
@Entity
public class Bus {
	@Id
	private int bid;
	@Column(name = "p_type")
	private String type;
	public Bus() {}
	public int getBid() {
		return bid;
	}
	@Override
	public String toString() {
		return "Bus [bid=" + bid + ", type=" + type + "]";
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}