package beanClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "login")
@Entity
public class Login {
	@Id
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Login() {}
	@Override
	public String toString() {
		return "login [username=" + username + ", password=" + password + "]";
	}
}