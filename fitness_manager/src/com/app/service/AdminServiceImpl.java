package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminDao;

import pojos.GymMember;
import pojos.Instructor;
import pojos.Login;
import pojos.SubscriptionInfo;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao aDao;
	public String registerGymMember(GymMember gm)
	{
		return aDao.registerGymMember(gm);
	}
	@Override
	public String registerInstructor(Instructor ins) {
		// TODO Auto-generated method stub
		return aDao.registerInstructor(ins);
	}
	@Override
	public List<GymMember> getAllMemberDetails() {
		// TODO Auto-generated method stub
		return aDao.getAllMemberDetails();
	}
	@Override
	public List<Instructor> getAllInstructorDetails() {
		// TODO Auto-generated method stub
		return aDao.getAllInstructorDetails();
	}
	@Override
	public Login authenticateUser(String userName, String password1) {
		// TODO Auto-generated method stub
		return aDao.authenticateUser(userName, password1);
	}
	@Override
	public GymMember getMemberDetails(int id) {
		// TODO Auto-generated method stub
		return aDao.getMemberDetails(id);
	}
	@Override
	public Instructor getInstructorDetails(int id) {
		// TODO Auto-generated method stub
		return aDao.getInstructorDetails(id);
	}
	@Override
	public String deleteMember(GymMember gm) {
		// TODO Auto-generated method stub
		return aDao.deleteMember(gm);
	}
	@Override
	public String deleteInstructor(Instructor ins) {
		// TODO Auto-generated method stub
		return aDao.deleteInstructor(ins);
	}
	@Override
	public String updateMember(GymMember gm) {
		// TODO Auto-generated method stub
		return aDao.updateMember(gm);
	}
	@Override
	public String addSubscription(SubscriptionInfo s) {
		// TODO Auto-generated method stub
		return aDao.addSubscription(s);
	}
	@Override
	public Object checkSession(Login l1) {
		Object o=null;
		if (l1.getRole().equals("member"))
		o=	aDao.getMemberByUser(l1.getUserName());
		if(l1.getRole().equals("instructor"))
			o=aDao.getInstructorByUser(l1.getUserName());
		return o;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
