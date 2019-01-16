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
	public String login(@RequestBody Login log,HttpSession hs)
	{
		String usernam=log.getUserName();
		String pass= log.getPassword();
		Login l1 = aService.authenticateUser(usernam,pass);
	if(l1.getRole().equals("admin")) {
		hs.setAttribute("admin", l1);	
	}
	else
	{
		Object o=aService.checkSession(l1);
	
	if(o instanceof GymMember)

		hs.setAttribute("member", (GymMember)o);
	if(o instanceof Instructor)
		hs.setAttribute("instructor", (Instructor)o);
		
	}
	return l1.getRole();
	
	}
	@GetMapping("/member/{mid}")
	public ResponseEntity<?> getMemberDetails(@PathVariable int mid) {
		System.out.println("srvr : get stud dtls " + mid);
		GymMember gm= aService.getMemberDetails(mid);
		if (gm != null)
			return new ResponseEntity<GymMember>(gm, HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("Invalid Student ID " + mid, HttpStatus.NOT_FOUND);
	}
	@GetMapping("/instructor/{mid}")
	public ResponseEntity<?> getInstructorDetails(@PathVariable int tid) {
		System.out.println("srvr : get stud dtls " + tid);
		Instructor ins= aService.getInstructorDetails(tid);
		if (ins != null)
			return new ResponseEntity<Instructor>(ins, HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("Invalid Student ID " + tid, HttpStatus.NOT_FOUND);
	}
	@GetMapping("/member")
	public List<GymMember> getAllMemberDetails() {
		System.out.println("srvr : get stud dtls ");
		return aService.getAllMemberDetails();
	}
	@GetMapping("/instructor")
	public List<Instructor> getAllInstructorDetails() {
		System.out.println("srvr : get stud dtls ");
		return aService.getAllInstructorDetails();
	}
	@DeleteMapping("member/{mid}")
	public String deleteMember(@PathVariable int mid) {
		System.out.println("srvr : del member dtls " + mid);
		return aService.deleteMember(aService.getMemberDetails(mid));
	}
	@DeleteMapping("instructor/{tid}")
	public String deleteInstructor(@PathVariable int tid) {
		System.out.println("srvr : del Instructor dtls " + tid);
		return aService.deleteInstructor(aService.getInstructorDetails(tid));
	}
	@PutMapping("/member")
	public String updateMember(@RequestBody GymMember gm) {
		System.out.println("srvr : update Member " + gm);
		return aService.updateMember(gm);

	}
	@PutMapping("/instructor")
	public String updateInstructor(@RequestBody Instructor ins) {
		System.out.println("srvr : update Instructor " + ins);
		return aService.updateInstructor(ins);

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
		if (sub != null)
			return new ResponseEntity<List<SubscriptionInfo>>(HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("something went wrong ", HttpStatus.NOT_FOUND);
	}

}
