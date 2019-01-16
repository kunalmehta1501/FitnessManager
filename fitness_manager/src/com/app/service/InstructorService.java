package com.app.service;

import java.util.List;

import com.app.pojos.DietInfo;
import com.app.pojos.GymMember;
import com.app.pojos.Instructor;
import com.app.pojos.Login;
import com.app.pojos.SubscriptionInfo;

public interface InstructorService {

	List<GymMember> getMyMembers(int tid);

	String addDiet(int mid, DietInfo diet);

	List<DietInfo> getDietDetails(int mid);

	
}