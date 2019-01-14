package pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cdac_students")
public class Student {
	private Integer studentId;
	private String email;
	private Course myCourse;
	private Integer idd;
	//one-to-one association between entity n value type(component)
	private AdharCard card;
	//one-to-many association between entity n value type(component)
	private List<Vehicle> vehicles=new ArrayList<>();
	
	public Student() {
		System.out.println("in stud constr");
	}
	public Student(String email) {
		super();
		this.email = email;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stud_id")
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	@Column(length=20,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@ManyToOne //mandatory o.w MappingExc
	@JoinColumn(name="c_id") //FK col. details optional BUT reco
	public Course getMyCourse() {
		return myCourse;
	}
	public void setMyCourse(Course myCourse) {
		this.myCourse = myCourse;
	}
	@Embedded //OPTIONAL
	public AdharCard getCard() {
		return card;
	}
	public void setCard(AdharCard card) {
		this.card = card;
	}
	@ElementCollection //mandatory
	@CollectionTable(name="stud_vehicles",joinColumns=@JoinColumn(name="s_id"))//optional but reco.
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", email=" + email + "]";
	}
	

}
