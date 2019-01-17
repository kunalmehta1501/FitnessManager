package com.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.DietInfo;
import com.app.pojos.GymMember;
import com.app.pojos.Instructor;
import com.app.pojos.Login;
import com.app.pojos.MeasurementInfo;
import com.app.pojos.SubscriptionInfo;
import com.app.pojos.WorkoutInfo;


@Repository

public class InstructorDaoImpl implements InstructorDao {
	@Autowired
	private SessionFactory factory;
	@Override
	public List<GymMember> getMyMember(int tid) {
	//	String jpql = "select m from GymMember m where m.memberId=any(select s.gymSubscribe.memberId from SubscriptionInfo s,Instructor ins where s.tid=ins.trainerId)";

	//	return factory.getCurrentSession().createQuery(jpql, GymMember.class).getResultList();
		@SuppressWarnings({ "deprecation", "rawtypes" })
		Query query = factory.getCurrentSession().createSQLQuery("CALL getMember(:tid1)").setParameter("tid1",tid).addEntity(GymMember.class);
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<GymMember> list = query.list();
		return list;
	}
	@Override
	public String addDiet(int mid,DietInfo d)
	{
		Session hs=factory.getCurrentSession();
		hs.get(GymMember.class,mid).addDiet(d);
        hs.save(d);
		
		return "Diet added successfully with id "+d.getDietId();
	}
	@Override
	public List<DietInfo> getDietDetails(int mid) {
		return factory.getCurrentSession().get(GymMember.class, mid).getDietInfo();
		}
	@Override
	public String addMeasurement(int mid,MeasurementInfo m)
	{
		Session hs=factory.getCurrentSession();
		hs.get(GymMember.class,mid).addMeasurement(m);
        hs.save(m);
		
		return "Diet added successfully with id "+m.getMeasurementId();
	}
	@Override
	public List<MeasurementInfo> getMeasurementDetails(int mid) {
		return factory.getCurrentSession().get(GymMember.class, mid).getMeasurementInfo();
		}
	@Override
	public String addWorkout(int mid,WorkoutInfo w)
	{
		Session hs=factory.getCurrentSession();
		hs.get(GymMember.class,mid).addWorkOut(w);
        hs.save(w);
		
		return "Diet added successfully with id "+w.getworkoutId();
	}
	@Override
	public List<WorkoutInfo> getWorkoutDetails(int mid) {
		return factory.getCurrentSession().get(GymMember.class, mid).getWorkOutInfo();
		}
	@Override
	public List<MeasurementInfo> getMeasurementDetails(int mid, Date f, Date t) {
		String jpql = "select m from MeasurementInfo m where m.gymMember.memberId= :id and m.dateOfRecord>=:from and m.dateOfRecord<=:to";

			return factory.getCurrentSession().createQuery(jpql, MeasurementInfo.class)
					.setParameter("id", mid).setParameter("from", f).setParameter("to",t).getResultList();
			
	}
	@Override
	public List<WorkoutInfo> getWorkoutDetails(int mid, Date f, Date t) {
		String jpql = "select w from WorkoutInfo w where w.myId.memberId= :id and w.dateOfRecord>=:from and w.dateOfRecord<=:to";

			return factory.getCurrentSession().createQuery(jpql, WorkoutInfo.class)
					.setParameter("id", mid).setParameter("from", f).setParameter("to",t).getResultList();
			
	}
	@Override
	public List<DietInfo> getDietDetails(int mid, Date f, Date t) {
		String jpql = "select d from DietInfo d where d.memberId.memberId= :id and d.dateOfRecord>=:from and d.dateOfRecord<=:to";

			return factory.getCurrentSession().createQuery(jpql, DietInfo.class)
					.setParameter("id", mid).setParameter("from", f).setParameter("to",t).getResultList();
			
	}
	
	
	
	
	

}
