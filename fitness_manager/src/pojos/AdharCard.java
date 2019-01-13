package pojos;

import java.util.Date;
import javax.persistence.*;

@Embeddable //mandatory
public class AdharCard {
	private String adharNumber;
	private Date creationDate;
	public AdharCard() {
		System.out.println("in adhar card constr");
	}
	
	public AdharCard(String adharNumber, Date creationDate) {
		super();
		this.adharNumber = adharNumber;
		this.creationDate = creationDate;
	}
	@Column(name="adhar_num",length=20,unique=true)
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	@Column(name="creation_dt")
	@Temporal(TemporalType.DATE)
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	

}
