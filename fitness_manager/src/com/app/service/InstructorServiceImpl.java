package com.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.dao.InstructorDao;
import com.app.pojos.DietInfo;
import com.app.pojos.GymMember;

import com.app.pojos.MeasurementInfo;

import com.app.pojos.WorkoutInfo;
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
	public String addDiet(int mid,DietInfo s) {
		// TODO Auto-generated method stub
		return tDao.addDiet(mid,s);
	}

	@Override
	public List<DietInfo> getDietDetails(int mid) {
		return tDao.getDietDetails(mid);
	}
	
	@Override
	public String addMeasurement(int mid,MeasurementInfo m) {
		// TODO Auto-generated method stub
		return tDao.addMeasurement(mid,m);
	}
	@Override
	public List<MeasurementInfo> getMeasurementDetails(int mid) {
		return tDao.getMeasurementDetails(mid);
	}
	
	
	
	@Override
	public String addWorkout(int mid,WorkoutInfo w) {
		// TODO Auto-generated method stub
		return tDao.addWorkout(mid,w);
	}
	
	
	@Override
	public List<WorkoutInfo> getWorkoutDetails(int mid) {
		return tDao.getWorkoutDetails(mid);
	}

	@Override
	public List<MeasurementInfo> getMeasurementByDate(int mid, String fromDate, String toDate) throws Exception {
		Date f = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
		Date t = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
		return tDao.getMeasurementDetails(mid,f,t);
	}
	@Override
	public List<WorkoutInfo> getWorkoutByDate(int mid, String fromDate, String toDate) throws Exception {
		Date f = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
		Date t = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
		return tDao.getWorkoutDetails(mid,f,t);
	}
	@Override
	public List<DietInfo> getDietByDate(int mid, String fromDate, String toDate) throws Exception {
		Date f = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
		Date t = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
		return tDao.getDietDetails(mid,f,t);
	}
	
}
