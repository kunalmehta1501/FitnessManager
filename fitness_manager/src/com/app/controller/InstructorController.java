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

import com.app.pojos.DietInfo;
import com.app.pojos.GymMember;
import com.app.pojos.Instructor;
import com.app.pojos.Login;
import com.app.pojos.SubscriptionInfo;
import com.app.service.AdminService;
import com.app.service.InstructorService;

@CrossOrigin
@EnableWebMvc
@RestController
@RequestMapping("/instructor")
public class InstructorController {
	// dependency
	
	@Autowired
	private InstructorService tService;

	@PostConstruct
	public void init() {
		System.out.println("in init " + tService);
	}
	
	@GetMapping("/member")
	public ResponseEntity<?> getMyMembers(HttpSession hs) {
		System.out.println("srvr : get my members dtls ");
		Instructor instr=(Instructor)hs.getAttribute("instructor");
		List<GymMember> list=tService.getMyMembers(instr.getTrainerId());
		if (!list.isEmpty())
			return new ResponseEntity<List<GymMember>>(list,HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("something went wrong ", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value="/addDiet/{mid}")
	public ResponseEntity<?> addDiet(@RequestBody DietInfo diet,@PathVariable int mid)
	{
		String str=tService.addDiet(mid,diet);
		if(str!=null)
			return new ResponseEntity<String>(str,HttpStatus.CREATED);
		return new ResponseEntity<String>("something went wrong ",HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@GetMapping("/diet/{mid}")
	public ResponseEntity<?> getDietDetails(@PathVariable int mid) {
		System.out.println("srvr : get subscription dtls " + mid);
		List<DietInfo> list= tService.getDietDetails(mid);
		if (!list.isEmpty() )
			return new ResponseEntity<List<DietInfo>>(list,HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("something went wrong ", HttpStatus.NOT_FOUND);
	}

}
