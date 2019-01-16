package com.app.pojos;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="subscription_info")
public class SubscriptionInfo {
private GymMember gymSubscribe;
private Integer subscriptionId;
	
	private String programName;
	private double amountPaid;
	private Date beginDate;
	private Date endDate;
	//private Instructor instructor;
	private int tid;
	
	public SubscriptionInfo() {
		System.out.println("in subscription Info constr");
	}
	
	public SubscriptionInfo(String programName, double amountPaid, Date beginDate, Date endDate,int tid) {
		super();
		this.programName = programName;
		this.amountPaid = amountPaid;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.tid=tid;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subscription_id")
	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}


	@Column(name="program_name")
	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
	@Column(name="amount_paid",columnDefinition="double(7,1)")
	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="begin_date")
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@ManyToOne 
	@JoinColumn(name="gym_subscribe_id") 
	public GymMember getGymSubscribe() {
		return gymSubscribe;
	}

	public void setGymSubscribe(GymMember gymSubscribe) {
		this.gymSubscribe = gymSubscribe;
	}
/*	@ManyToOne 
	@JoinColumn(name="instructor_id") 
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
*/
	
	
	@Column(name="t_id")
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "SubscriptionInfo [gymSubscribe=" + gymSubscribe + ", subscriptionId=" + subscriptionId
				+ ", programName=" + programName + ", amountPaid=" + amountPaid + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + ", instructor="  + "]";
	}


	

}
