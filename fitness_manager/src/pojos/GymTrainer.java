package pojos;


import java.util.Arrays;


import javax.persistence.*;



@Entity
@Table(name="gym_trainer")
public class GymTrainer {
	
	private String trainerId;
	private String trainerName;
	private String userName;
	private String trainerEmail;
	private String trainerPhone;
	private double salary;
	private String password;
	private byte[] photo;	
	
	
	public GymTrainer() {
		System.out.println("in gymMember constr");
	}
	
	

	public GymTrainer(String trainerName, String userName, String trainerEmail, String trainerPhone, double salary,
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
	public String getTrainerId() {
		return trainerId;
	}
	
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	

	@Column(name="user_name",length=50)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="phone",length=50)
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


	@Column(length=50,unique=true,name="email")
	public String getTrainerEmail() {
		return trainerEmail;
	}



	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}


	@Column(name="salary",columnDefinition="double(7,1)")
	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Column(name="password",length=50)
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "GymTrainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", userName=" + userName
				+ ", trainerEmail=" + trainerEmail + ", trainerPhone=" + trainerPhone + ", salary=" + salary
				+ ", password=" + password + ", photo=" + Arrays.toString(photo) + "]";
	}



	


	
	

	

}