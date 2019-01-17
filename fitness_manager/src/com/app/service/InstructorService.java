package com.app.service;

import java.util.List;

import com.app.pojos.DietInfo;
import com.app.pojos.GymMember;
import com.app.pojos.Instructor;
import com.app.pojos.Login;
import com.app.pojos.MeasurementInfo;
import com.app.pojos.SubscriptionInfo;
import com.app.pojos.WorkoutInfo;

public interface InstructorService {

	List<GymMember> getMyMembers(int tid);

	String addDiet(int mid, DietInfo diet);

	List<DietInfo> getDietDetails(int mid);

	String addMeasurement(int mid, MeasurementInfo m);

	List<WorkoutInfo> getWorkoutDetails(int mid);

	List<MeasurementInfo> getMeasurementDetails(int mid);

	String addWorkout(int mid, WorkoutInfo w);

	
}
