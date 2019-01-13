package pojos;

import java.util.ArrayList;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="gym_member")
public class GymMember {
	private String memberId;
	private String membername;
	private String userName;
	private String memberPhone;
	private String address;
	private byte[] photo;
	private List<Vehicle> vehicles=new ArrayList<>();
	private List<ContactInfo> contact=new ArrayList<>();
	public GymMember() {
		System.out.println("in gymMember constr");
	}
	

	

}
