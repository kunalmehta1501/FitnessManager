package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.GymMember;
import com.app.pojos.Instructor;
import com.app.pojos.Login;
import com.app.pojos.SubscriptionInfo;


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
	public String updateInstructor(Instructor ins) {
		factory.getCurrentSession().update(ins);
		return "Student details updated successfully with id "+ins.getTrainerId();
	}
	@Override
	public String addSubscription(int mid,SubscriptionInfo s)
	{
		Session hs=factory.getCurrentSession();
		hs.get(GymMember.class,mid).addSubscription(s);
		hs.update(s);
	
		int i=s.getSubscriptionId();
		System.out.println("SId="+i);
		return "subscription added successfully with id "+i;
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
	
	@Override
	public List<SubscriptionInfo> getSubscriptionInfo(int mid) {
		return factory.getCurrentSession().get(GymMember.class, mid).getSubscriptionInfo();
		}
	
	
	

}
