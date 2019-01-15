package pojos;

import javax.persistence.*;

@Entity
@Table(name="login_table")
public class Login {
	private String userName;
	private String password;
	private String role;
	public Login()
	{
		System.out.println("in login table constructor");
	}
	@Id
	@Column(length=50,name="user_name")
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(length=50,name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=10,name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
