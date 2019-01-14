package pojos;


import java.util.Date;

import javax.persistence.*;




@Entity
@Table(name="workout_info")
public class WorkoutInfo {
	private Integer workoutId;
	private  GymMember myId;
	private String activityName;
	private String weight;
	private String reps;
	private String steps;
	private Date dateOfRecord;
	
	
	public WorkoutInfo() {
		// TODO Auto-generated constructor stub
	}

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="workout_id")
	public Integer getworkoutId() {
		return workoutId;
	}


	public void setWorkoutId(Integer workoutId) {
		this.workoutId = workoutId;
	}

	@ManyToOne 
	@JoinColumn(name="member_id")
	public GymMember getMyId() {
		return myId;
	}


	public void setMyId(GymMember myId) {
		this.myId = myId;
	}

	@Column(length=100,name="activity_name")
	public String getActivityName() {
		return activityName;
	}


	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Column(length=100,name="weight")
	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Column(length=100,name="reps")
	public String getReps() {
		return reps;
	}


	public void setReps(String reps) {
		this.reps = reps;
	}

	@Column(length=100,name="steps")
	public String getSteps() {
		return steps;
	}


	public void setSteps(String steps) {
		this.steps = steps;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_record")
	public Date getDateOfRecord() {
		return dateOfRecord;
	}

	
	public void setDateOfRecord(Date dateOfRecord) {
		this.dateOfRecord = dateOfRecord;
	}

	@Override
	public String toString() {
		return "WorkoutInfo [workoutId=" + workoutId + ", memberId=" + myId + ", activityName=" + activityName
				+ ", weight=" + weight + ", reps=" + reps + ", steps=" + steps + ", dateOfRecord=" + dateOfRecord + "]";
	}
	
	

	
	
	
}

