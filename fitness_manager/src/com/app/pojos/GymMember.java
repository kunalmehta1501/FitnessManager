package com.app.pojos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.app.pojos.SubscriptionInfo;

@Entity
@Table(name="gym_member")
public class GymMember {
	
	private Integer memberId;
	private String memberName;
	private String userName;
	private String password;
	private Date dob;
	private String memberEmail;
	private String memberPhone;
	private String address;
	private byte[] photo;
	private List<DietInfo> dietInfo=new ArrayList<>();
	private List<MeasurementInfo> measurementInfo=new ArrayList<>();
	private List<WorkoutInfo> workOutInfo=new ArrayList<>();
	

	private List<SubscriptionInfo> subscriptionInfo=new ArrayList<>();
	public GymMember() {
		System.out.println("in gymMember constr");
	}
	
	public GymMember(String memberName, String userName, String memberEmail, String memberPhone, 
			String address,String password,Date dob) {
		super();
		this.memberName = memberName;
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
	public Integer getMemberId() {
		return memberId;
	}
	
	public void setMemberId(Integer memberId) {
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
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	
	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="gymSubscribe",cascade=CascadeType.ALL/*,fetch=FetchType.EAGER*/)
	public List<SubscriptionInfo> getSubscriptionInfo() {
		return subscriptionInfo;
	}

	public void setSubscriptionInfo(List<SubscriptionInfo> subscriptionInfo) {
		this.subscriptionInfo = subscriptionInfo;
	}
	@Column(name="password",length=50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="memberId",cascade=CascadeType.ALL/*,fetch=FetchType.EAGER*/)
	public List<DietInfo> getDietInfo() {
		return dietInfo;
	}

	public void setDietInfo(List<DietInfo> dietInfo) {
		this.dietInfo = dietInfo;
	}
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="gymMember",cascade=CascadeType.ALL/*,fetch=FetchType.EAGER*/)
	public List<MeasurementInfo> getMeasurementInfo() {
		return measurementInfo;
	}

	public void setMeasurementInfo(List<MeasurementInfo> measurementInfo) {
		this.measurementInfo = measurementInfo;
	}
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="myId",cascade=CascadeType.ALL/*,fetch=FetchType.EAGER*/)
	public List<WorkoutInfo> getWorkOutInfo() {
		return workOutInfo;
	}


	public void setWorkOutInfo(List<WorkoutInfo> workOutInfo) {
		this.workOutInfo = workOutInfo;
	}

	//convi methods
	public void addSubscription(SubscriptionInfo s)
	{
		subscriptionInfo.add(s);
		s.setGymSubscribe(this);
	}
	public void removeSubscription(SubscriptionInfo s)
	{
		subscriptionInfo.remove(s);
		s.setGymSubscribe(null);
	}
	
	public void addMeasurement(MeasurementInfo m)
	{
		measurementInfo.add(m);
		m.setGymMember(this);
	}
	public void removeSubscription(MeasurementInfo m)
	{
		measurementInfo.remove(m);
		m.setGymMember(null);
	}
	public void addDiet(DietInfo d)
	{
		dietInfo.add(d);
		d.setMemberId(this);
	}
	public void removeDiet(DietInfo d)
	{
		
		dietInfo.remove(d);
		d.setMemberId(null);
	}
	public void addWorkOut(WorkoutInfo w)
	{
		workOutInfo.add(w);
		
		w.setMyId(this);
	}
	public void removeWorkOut(WorkoutInfo w)
	{
		workOutInfo.remove(w);
		w.setMyId(null);
	}
	

	@Override
	public String toString() {
		return "GymMember [memberId=" + memberId + ", memberName=" + memberName + ", userName=" + userName
				+ ", password=" + password + ", dob=" + dob + ", memberEmail=" + memberEmail + ", memberPhone="
				+ memberPhone + ", address=" + address + ", photo=" + Arrays.toString(photo) + ", dietInfo=" + dietInfo
				+ ", measurementInfo=" + measurementInfo + ", workOutInfo=" + workOutInfo + ", subscriptionInfo="
				+ subscriptionInfo + "]";
	}

	

}
