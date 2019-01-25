package com.app.pojos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="instructor")
public class Instructor {
	
	private Integer trainerId;
	private String trainerName;
	private String userName;
	private String trainerEmail;
	private String trainerPhone;
	private double salary;
	private Date availableFrom;
	private Date availableTo;
	private String password;
	private byte[] photo;
	//@JsonIgnore
	private List<SubscriptionInfo> subscriptionInfo=new ArrayList<>();
	
	
	public Instructor() {
		System.out.println("in gymtrainer constr");
	}
	
	

	public Instructor(String trainerName, String userName, String trainerEmail, String trainerPhone, double salary,
			String password, byte[] photo) {
		super();
		this.trainerName = trainerName;
		this.userName = userName;
		this.trainerEmail = trainerEmail;
		this.trainerPhone = trainerPhone;
		this.salary = salary;
		this.password = password;
		this.photo = photo;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainer_id")
	public Integer getTrainerId() {
		return trainerId;
	}
	
	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}
	

	@Column(name="tuser_name",length=50)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="tphone",length=50)
	public String getTrainerPhone() {
		return trainerPhone;
	}

	public void setTrainerPhone(String trainerPhone) {
		this.trainerPhone = trainerPhone;
	}
	
	@Lob
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	@Column(name="name",length=50)
	public String getTrainerName() {
		return trainerName;
	}



	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}


	@Column(length=50,unique=true,name="temail")
	public String getTrainerEmail() {
		return trainerEmail;
	}



	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}


	@Column(name="tsalary",columnDefinition="double(7,1)")
	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Column(name="tpassword",length=50)
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="gymSubscribe",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<SubscriptionInfo> getSubscriptionInfo() {
		return subscriptionInfo;
	}



	public void setSubscriptionInfo(List<SubscriptionInfo> subscriptionInfo) {
		this.subscriptionInfo = subscriptionInfo;
	}

  


    @Column(name="avalability_from",columnDefinition="TIMESTAMP")      
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	public Date getAvailableFrom() {
		return availableFrom;
	}



	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}



    @Column(name="avalability_to",columnDefinition="TIMESTAMP")      
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	public Date getAvailableTo() {
		return availableTo;
	}



	public void setAvailableTo(Date availableTo) {
		this.availableTo = availableTo;
	}



	@Override
	public String toString() {
		return "GymTrainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", userName=" + userName
				+ ", trainerEmail=" + trainerEmail + ", trainerPhone=" + trainerPhone + ", salary=" + salary
				+ ", password=" + password + ", photo=" + Arrays.toString(photo) + "]";
	}



	


	
	

	

}
