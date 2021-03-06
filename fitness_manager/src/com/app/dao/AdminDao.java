package com.app.dao;

import java.util.List;

import com.app.pojos.GymMember;
import com.app.pojos.Instructor;
import com.app.pojos.Login;
import com.app.pojos.SubscriptionInfo;

public interface AdminDao {
	//String launchCourseWithStudents(Course c);
	/*Course getCourseDetails(String name);
	Course getCourseDetailsWithStudents(String name);
	String linkStudentAdharCard(int sid,AdharCard card);*/
	String registerGymMember(GymMember gm);
	String registerInstructor(Instructor ins);
	
	List<GymMember> getAllMemberDetails();
	List<Instructor> getAllInstructorDetails();
	Login authenticateUser(String userName, String password1);

	GymMember getMemberDetails(int id);
	Instructor getInstructorDetails(int id);
	String deleteMember(GymMember gm);
	String deleteInstructor(Instructor ins);
	String updateMember(GymMember gm);
	String addSubscription(int mid,SubscriptionInfo s);
	Instructor getInstructorByUser(String username);
	GymMember getMemberByUser(String username);
	String updateInstructor(Instructor ins);
	List<SubscriptionInfo> getSubscriptionInfo(int mid);
	
	
	
	

}
