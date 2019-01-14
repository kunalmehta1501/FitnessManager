package pojos;

import java.util.ArrayList;
import java.util.Arrays;

import pojos.SubscriptionInfo;
import java.util.List;
import javax.persistence.*;



@Entity
@Table(name="gym_member")
public class GymMember {
	
	private String memberId;
	private String membername;
	private String userName;
	private String password;
	private String dob;
	private String memberEmail;
	private String memberPhone;
	private String address;
	private byte[] photo;	
	private List<SubscriptionInfo> subscriptionInfo=new ArrayList<>();
	
	public GymMember() {
		System.out.println("in gymMember constr");
	}
	
	public GymMember(String membername, String userName, String memberEmail, String memberPhone, 
			String address,String password,String dob) {
		super();
		this.membername = membername;
		this.userName = userName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.address = address;
		this.dob = dob;
		this.password = password;
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_id")
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Column(length=50,unique=true,name="email")
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	@Column(name="name",length=50)
	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}
	@Column(name="user_name",length=50)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="phone",length=50)
	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	@Column(name="address",length=50)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Lob
	public byte[] getPhoto() {
		return photo;
	}

	@Column(name="password",length=50)
	public String getPassWord() {
		return password;
	}

	public void setPassWord(String passWord) {
		this.password = passWord;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@ElementCollection 
	@CollectionTable(name="subscription_info",joinColumns=@JoinColumn(name="m_id"))
	public List<SubscriptionInfo> getSubscriptionInfo() {
		return subscriptionInfo;
	}

	public void setSubscriptionInfo(List<SubscriptionInfo> subscriptionInfo) {
		this.subscriptionInfo = subscriptionInfo;
	}

	@Override
	public String toString() {
		return "GymMember [memberId=" + memberId + ", membername=" + membername + ", userName=" + userName
				+ ", password=" + password + ", dob=" + dob + ", memberEmail=" + memberEmail + ", memberPhone="
				+ memberPhone + ", address=" + address + ", photo=" + Arrays.toString(photo) + ", subscriptionInfo="
				+ subscriptionInfo + "]";
	}

	
	
	

	

}
