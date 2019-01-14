package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminDao;

import pojos.GymMember;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao aDao;
	public String registerGymMember(GymMember gm)
	{
		return aDao.registerGymMember(gm);
	}
}
