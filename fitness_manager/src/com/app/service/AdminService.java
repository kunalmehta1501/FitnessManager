package com.app.service;

import java.util.List;

import com.app.pojos.GymMember;
import com.app.pojos.Instructor;
import com.app.pojos.Login;
import com.app.pojos.SubscriptionInfo;

public interface AdminService {
	String registerGymMember(GymMember gm);
	String registerInstructor(Instructor ins);
	
	List<GymMember> getAllMemberDetails();
	List<Instructor> getAllInstructorDetails();
	Login authenticateUser(String userName, String password1);
	Object checkSession(Login l1);

	GymMember getMemberDetails(int id);
	Instructor getInstructorDetails(int id);
	String deleteMember(GymMember gm);
	String deleteInstructor(Instructor ins);
	String updateMember(GymMember gm);
	String addSubscription(int mid,SubscriptionInfo s);
	String updateInstructor(Instructor ins);
	List<SubscriptionInfo> getSubscriptionDetails(int mid);
	GymMember getMemberDetailsByUserName(String userName);
	Instructor getInstructorDetailsByUserName(String userName);
	
}
