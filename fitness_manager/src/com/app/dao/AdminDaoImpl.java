package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import pojos.GymMember;
import pojos.Instructor;
import pojos.Login;
import pojos.SubscriptionInfo;


@Repository

public class AdminDaoImpl implements AdminDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public String registerGymMember(GymMember gm) {
		System.out.println("in dao --reg stud "+gm);
			
		factory.getCurrentSession().save(gm);
		return "Member reged successfully with id "+gm.getMemberId();
		
	}
	@Override
	public List<GymMember> getAllMemberDetails() {
		String jpql = "select m from GymMember m";
		return factory.getCurrentSession().createQuery(jpql, GymMember.class).getResultList();
	}
	

	@Override
	public List<Instructor> getAllInstructorDetails() {
		String jpql = "select ins from Instructor ins";
		return factory.getCurrentSession().createQuery(jpql, Instructor.class).getResultList();
	}
	@Override
	public String registerInstructor(Instructor ins) {
		factory.getCurrentSession().save(ins);
		return "Instructor reged successfully with id "+ins.getTrainerId();
	}
	
	@Override
	public Login authenticateUser(String userName, String password1) {
		String jpql = "select l from Login l where l.userName = :un and l.password=:pa";
		Login l1=factory.getCurrentSession().createQuery(jpql, Login.class).setParameter("un", userName)
				.setParameter("pa", password1).getSingleResult();
		return l1;
	}
	
	@Override
	public GymMember getMemberDetails(int id) {
		
		return factory.getCurrentSession().get(GymMember.class, id);
	}
	@Override
	public Instructor getInstructorDetails(int id) {
		
		return factory.getCurrentSession().get(Instructor.class, id);
	}
	@Override
	public String deleteMember(GymMember gm) {
		factory.getCurrentSession().delete(gm);
		return "Member details deleted successfully with id "+gm.getMemberId();
	}
	@Override
	public String deleteInstructor(Instructor ins) {
		factory.getCurrentSession().delete(ins);
		return "Member details deleted successfully with id "+ins.getTrainerId();
	}
	@Override
	public String updateMember(GymMember gm) {
		factory.getCurrentSession().update(gm);
		return "Student details updated successfully with id "+gm.getMemberId();
	}
	@Override
	public String addSubscription(SubscriptionInfo s)
	{
		factory.getCurrentSession().save(s);
		return "subscription added successfully with id "+s.getSubscriptionId();
	}
	@Override
	public Instructor getInstructorByUser(String username) {
		String jpql = "select ins from Instructor ins where ins.userName = :un";
		Instructor ins=factory.getCurrentSession().createQuery(jpql, Instructor.class).setParameter("un", username)
				.getSingleResult();
		return ins;
	}
	@Override
	public GymMember getMemberByUser(String username) {
		String jpql = "select m from GymMember m where m.userName = :un";
		GymMember m=factory.getCurrentSession().createQuery(jpql, GymMember.class).setParameter("un", username)
				.getSingleResult();
		return m;
	}
	/*
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
	*/
	
	
	

}
