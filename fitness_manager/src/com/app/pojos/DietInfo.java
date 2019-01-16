package com.app.pojos;


import javax.persistence.*;




@Entity
@Table(name="diet_info")
public class DietInfo{
	private Integer dietId;
	private  GymMember memberId;
	private String breakfast;
	private String lunch;
	private String dinner;
	private String snack;
	private String dessert;
	
	public DietInfo() {
		System.out.println("inside default DietPlan");
	}
	
	
	//one-to-many association between entity n value type(component)
	//private List<Vehicle> vehicles=new ArrayList<>();
	
	
	
	
	
	public DietInfo(String breakfast, String lunch, String dinner, String snack, String dessert) {
		super();
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.snack = snack;
		this.dessert = dessert;
	}
	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="diet_id")
	public Integer getDietId() {
		return dietId;
	}


	public void setDietId(Integer dietId) {
		this.dietId = dietId;
	}
	@ManyToOne 
	@JoinColumn(name="member_id") 
	public GymMember getMemberId() {
		return memberId;
	}


	public void setMemberId(GymMember memberId) {
		this.memberId = memberId;
	}

	@Column(length=100,name="breakfast")
	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	@Column(length=100,name="lunch")
	public String getLunch() {
		return lunch;
	}


	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	@Column(length=100,name="dinner")
	public String getDinner() {
		return dinner;
	}


	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	@Column(length=100,name="snack")
	public String getSnack() {
		return snack;
	}


	public void setSnack(String snack) {
		this.snack = snack;
	}

	@Column(length=100,name="dessert")
	public String getDessert() {
		return dessert;
	}


	public void setDessert(String dessert) {
		this.dessert = dessert;
	}


	@Override
	public String toString() {
		return "DietPlan [DietId=" + dietId + ", memberId=" + memberId + ", breakfast=" + breakfast + ", lunch=" + lunch
				+ ", dinner=" + dinner + ", snack=" + snack + ", dessert=" + dessert + "]";
	}


	
	
	
}

