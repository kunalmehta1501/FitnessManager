package pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="cdac_students")
public class Student {
	private Integer studentId;
	private String email,password;
	private double regFees;
	private String name;
	private Date dob;
	
	
	
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
	
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Column(length=10)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="fees",columnDefinition="double(7,1)")
	public double getRegFees() {
		return regFees;
	}
	public void setRegFees(double regFees) {
		this.regFees = regFees;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", email=" + email + "]";
	}
	

}
