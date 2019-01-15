package com.app.dao;

import java.util.List;

import pojos.GymMember;
import pojos.Instructor;

public interface AdminDao {
	//String launchCourseWithStudents(Course c);
	String registerGymMember(GymMember gm);
	List<GymMember> getAllMemberDetails();
	List<Instructor> getAllInstructorDetails();
	/*Course getCourseDetails(String name);
	Course getCourseDetailsWithStudents(String name);
	String linkStudentAdharCard(int sid,AdharCard card);*/

}
