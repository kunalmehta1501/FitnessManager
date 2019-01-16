package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.GymMember;
import com.app.pojos.Instructor;
import com.app.pojos.Login;
import com.app.pojos.SubscriptionInfo;


@Repository

public class InstructorDaoImpl implements InstructorDao {
	@Autowired
	private SessionFactory factory;
	@Override
	public List<GymMember> getMyMember(int tid) {
		String jpql = "select m from GymMember m where m.memberId=(select s.gymSubscribe from SubscriptionInfo s,InstructorInfo ins where s.instructor=ins.trainerId";
		return factory.getCurrentSession().createQuery(jpql, GymMember.class).getResultList();
	}
	

	
	
	
	
	

}
