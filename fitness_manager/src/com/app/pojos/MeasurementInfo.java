package com.app.pojos;

import java.util.Date;


import javax.persistence.*;

@Entity
@Table(name="measurement_info")
public class MeasurementInfo {
	private Integer measurementId;
	private String typeOfMeasurement;
	private GymMember gymMember;
	private Date dateOfRecord;
	private String measurement;
	public MeasurementInfo() {
		System.out.println("in measurementInfo constr");
	}
	
	public MeasurementInfo(String typeOfMeasurement, Date dateOfRecord, String measurement) {
		super();
		this.typeOfMeasurement = typeOfMeasurement;
		this.dateOfRecord = dateOfRecord;
		this.measurement = measurement;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="measurement_id")
	public Integer getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Integer measurementId) {
		this.measurementId = measurementId;
	}
	@Column(length=50,name="type_of_measurement")
	public String getTypeOfMeasurement() {
		return typeOfMeasurement;
	}

	public void setTypeOfMeasurement(String typeOfMeasurement) {
		this.typeOfMeasurement = typeOfMeasurement;
	}
	
	@ManyToOne 
	@JoinColumn(name="member_id")
	public GymMember getGymMember() {
		return gymMember;
	}

	public void setGymMember(GymMember gymMember) {
		this.gymMember = gymMember;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_record")
	public Date getDateOfRecord() {
		return dateOfRecord;
	}

	public void setDateOfRecord(Date dateOfRecord) {
		this.dateOfRecord = dateOfRecord;
	}
	
	@Column(length=50,name="measurement")
	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}


	@Override
	public String toString() {
		return "MeasurementInfo [measurementId=" + measurementId + ", typeOfMeasurement=" + typeOfMeasurement
				+ ", gymMember=" + gymMember + ", dateOfRecord=" + dateOfRecord + "]";
	}
	
	


	

}
