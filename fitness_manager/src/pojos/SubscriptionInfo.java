package pojos;
import java.util.Date;

import javax.persistence.*;

@Embeddable
public class SubscriptionInfo {
	
	private String trainerAlloted;
	private String programName;
	private double amountPaid;
	private Date beginDate;
	private Date endDate;
	
	public SubscriptionInfo() {
		System.out.println("in vehicle constr");
	}
	
	public SubscriptionInfo(String programName, double amountPaid, Date beginDate, Date endDate) {
		super();
		this.programName = programName;
		this.amountPaid = amountPaid;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	@Column(name="trainer_alloted")
	public String getTrainerAlloted() {
		return trainerAlloted;
	}

	public void setProgramId(String trainerAlloted) {
		this.trainerAlloted = trainerAlloted;
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


	

}
