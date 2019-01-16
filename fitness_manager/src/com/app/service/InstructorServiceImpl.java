package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.dao.InstructorDao;
import com.app.pojos.DietInfo;
import com.app.pojos.GymMember;
import com.app.pojos.Instructor;
import com.app.pojos.Login;
import com.app.pojos.SubscriptionInfo;
@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	private InstructorDao tDao;

	@Override
	public List<GymMember> getMyMembers(int tid) {
		
		return tDao.getMyMember(tid);
	}

	@Override
	public String addDiet(int mid, DietInfo diet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DietInfo> getDietDetails(int mid) {
		// TODO Auto-generated method stub
		return null;
	}
	
		
	
	
	
	
}
