package com.app.dao;

import java.util.List;

import pojos.Student;

public interface StudentDao {
	Student getStudentDetails(int id);
	List<Student> getAllStudentDetails();
	String registerStudent(Student s);//i/p ---transient pojo 
	String deleteStudent(Student s);//i/p ---detached pojo
	String updateStudent(Student s);//i/p ---detached pojo with updated state
}
