package pojos;
import javax.persistence.*;

@Embeddable
public class ContactInfo {
	private String regNo;
	private double price;
	public ContactInfo() {
		System.out.println("in vehicle constr");
	}
	public ContactInfo(String regNo, double price) {
		super();// TODO Auto-generated constructor stub
		this.regNo = regNo;
		this.price = price;
	}
	@Column(unique=true,name="reg_no")
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
