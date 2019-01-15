package com.app.service;

import java.util.List;

import pojos.GymMember;
import pojos.Instructor;
import pojos.Login;
import pojos.SubscriptionInfo;

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
	String addSubscription(SubscriptionInfo s);
}
