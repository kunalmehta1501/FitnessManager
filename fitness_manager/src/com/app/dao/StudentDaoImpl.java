package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojos.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public Student getStudentDetails(int id) {
		// TODO Auto-generated method stub
		return factory.getCurrentSession().get(Student.class, id);
	}

	@Override
	public List<Student> getAllStudentDetails() {
		String jpql = "select s from Student s";
		return factory.getCurrentSession().createQuery(jpql, Student.class).getResultList();
	}

	@Override
	public String registerStudent(Student s) {
		System.out.println("in dao --reg stud "+s);
		factory.getCurrentSession().save(s);
		return "Student reged successfully with id "+s.getStudentId();
				
	}

	@Override
	public String deleteStudent(Student s) {
		factory.getCurrentSession().delete(s);
		return "Student details deleted successfully with id "+s.getStudentId();
	}

	@Override
	public String updateStudent(Student s) {
		factory.getCurrentSession().update(s);
		return "Student details updated successfully with id "+s.getStudentId();
	}
	
	
	
	

}
