package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.app.pojos.GymMember;
import com.app.pojos.Instructor;
import com.app.pojos.Login;
import com.app.pojos.SubscriptionInfo;
import com.app.service.AdminService;

@CrossOrigin
@EnableWebMvc
@RestController
@RequestMapping("/admin")
public class AdminController {
	// dependency
	
	@Autowired
	private AdminService aService;

	@PostConstruct
	public void init() {
		System.out.println("in init " + aService);
	}
	
	@PostMapping(value="/registerMember")
	public ResponseEntity<?> registerMember(@RequestBody GymMember gm)
	{
		//System.out.println("From Session-------------------"+img);
		//v.setImgPath(img);
		String str=aService.registerGymMember(gm);
		if(str!=null)
			return new ResponseEntity<String>(str,HttpStatus.CREATED);
		return new ResponseEntity<String>("something went wrong ",HttpStatus.NOT_FOUND);
	}

	@PostMapping(value="/registerInstructor")
	public ResponseEntity<?> registerInstructor(@RequestBody Instructor ins)
	{
		//System.out.println("From Session-------------------"+img);
		//v.setImgPath(img);
		String str=aService.registerInstructor(ins);
		if(str!=null)
			return new ResponseEntity<String>(str,HttpStatus.CREATED);
		return new ResponseEntity<String>("something went wrong ",HttpStatus.NOT_FOUND);
	}
	@PostMapping(value="/login",headers="Accept=application/json")
	public ResponseEntity<?>  login(@RequestBody Login log,HttpSession hs)
	{
		String usernam=log.getUserName();
		String pass= log.getPassword();
		Login l1 = aService.authenticateUser(usernam,pass);
	if(l1!=null)
		{
		if(l1.getRole().equals("admin")) {
		
		hs.setAttribute("admin", l1);	
		return new ResponseEntity<Login>(l1, HttpStatus.OK);
	}
	else
	{
		Object o=aService.checkSession(l1);
	
	if(o instanceof GymMember)

		hs.setAttribute("member", (GymMember)o);
	if(o instanceof Instructor)
		hs.setAttribute("instructor", (Instructor)o);
	return new ResponseEntity<Login>(l1, HttpStatus.OK);
	}
		}
	return new ResponseEntity<String>("Invalid userName or Password", HttpStatus.NOT_FOUND);
	}
	
	
	
	@GetMapping("/member/{mid}")
	public ResponseEntity<?> getMemberDetails(@PathVariable int mid) {
		System.out.println("srvr : get stud dtls " + mid);
		GymMember gm= aService.getMemberDetails(mid);
		if (gm != null)
			return new ResponseEntity<GymMember>(gm, HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("Invalid member ID " + mid, HttpStatus.NOT_FOUND);
	}
	@GetMapping("/instructor/{mid}")
	public ResponseEntity<?> getInstructorDetails(@PathVariable int tid) {
		System.out.println("srvr : get stud dtls " + tid);
		Instructor ins= aService.getInstructorDetails(tid);
		if (ins != null)
			return new ResponseEntity<Instructor>(ins, HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("Invalid instructor ID " + tid, HttpStatus.NOT_FOUND);
	}
	@GetMapping("/smember/{userName}")
	public ResponseEntity<?> getMemberDetails(@PathVariable String userName) {
		System.out.println("srvr : get stud dtls " + userName);
		GymMember gm= aService.getMemberDetailsByUserName(userName);
		if (gm != null)
			return new ResponseEntity<GymMember>(gm, HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("Invalid userName" + userName, HttpStatus.NOT_FOUND);
	}
	@GetMapping("/sinstructor/{userName}")
	public ResponseEntity<?> getInstructorDetails(@PathVariable String userName) {
		System.out.println("srvr : get stud dtls " + userName);
		Instructor ins= aService.getInstructorDetailsByUserName(userName);
		if (ins != null)
			return new ResponseEntity<Instructor>(ins, HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("Invalid usrName " + userName, HttpStatus.NOT_FOUND);
	}
	@CrossOrigin
	@GetMapping("/member")
	public ResponseEntity<?> getAllMemberDetails() {
		System.out.println("srvr : get member dtls ");
	
		if (aService.getAllMemberDetails().size()!=0)
			return new ResponseEntity<List<GymMember>>(aService.getAllMemberDetails(),HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("something went wrong ", HttpStatus.NOT_FOUND);
		
	}
	@GetMapping("/instructor")
	public ResponseEntity<?> getAllInstructorDetails() {
		System.out.println("srvr : get instructor dtls ");

		if (aService.getAllInstructorDetails().size()!=0)
			return new ResponseEntity<List<Instructor>>(aService.getAllInstructorDetails(),HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("something went wrong ", HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("member/{mid}")
	public ResponseEntity<?> deleteMember(@PathVariable int mid) {
		System.out.println("srvr : del member dtls " + mid);
		String str=aService.deleteMember(aService.getMemberDetails(mid));
		if(str!=null)
			return new ResponseEntity<String>(str,HttpStatus.CREATED);
		return new ResponseEntity<String>("something went wrong ",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("instructor/{tid}")
	public ResponseEntity<?> deleteInstructor(@PathVariable int tid) {
		System.out.println("srvr : del Instructor dtls " + tid);
		String str= aService.deleteInstructor(aService.getInstructorDetails(tid));
		if(str!=null)
			return new ResponseEntity<String>(str,HttpStatus.CREATED);
		return new ResponseEntity<String>("something went wrong ",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/member")
	public ResponseEntity<? >updateMember(@RequestBody GymMember gm) {
		System.out.println("srvr : update Member " + gm);
		String str= aService.updateMember(gm);
		if(str!=null)
			return new ResponseEntity<String>(str,HttpStatus.CREATED);
		return new ResponseEntity<String>("something went wrong ",HttpStatus.NOT_FOUND);

	}
	@PutMapping("/instructor")
	public ResponseEntity<?> updateInstructor(@RequestBody Instructor ins) {
		System.out.println("srvr : update Instructor " + ins);
	String str= aService.updateInstructor(ins);
	if(str!=null)
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
	return new ResponseEntity<String>("something went wrong ",HttpStatus.NOT_FOUND);

	}
	@PostMapping(value="/addSubscription/{mid}")
	public ResponseEntity<?> addSubscription(@RequestBody SubscriptionInfo sub,@PathVariable int mid)
	{
		String str=aService.addSubscription(mid,sub);
		if(str!=null)
			return new ResponseEntity<String>(str,HttpStatus.CREATED);
		return new ResponseEntity<String>("something went wrong ",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/subscription/{mid}")
	public ResponseEntity<?> getSubscriptionDetails(@PathVariable int mid) {
		System.out.println("srvr : get subscription dtls " + mid);
		List<SubscriptionInfo> sub= aService.getSubscriptionDetails(mid);
		if (sub.size()!=0)
			return new ResponseEntity<List<SubscriptionInfo>>(sub,HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("something went wrong ", HttpStatus.NOT_FOUND);
	}

}
