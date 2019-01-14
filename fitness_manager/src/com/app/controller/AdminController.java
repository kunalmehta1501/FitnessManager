package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.AdminDao;
import com.app.service.AdminService;
import com.app.service.AdminServiceImpl;

import pojos.GymMember;


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
	
	@PostMapping
	public String registerGymMember(@RequestBody GymMember gm) {
		System.out.println("srvr : reg student  " + gm);
		return aService.registerGymMember(gm);
	}
	
	
/*
	// get student resource
	@GetMapping("/{sid}")
	public ResponseEntity<?> getStudentDetails(@PathVariable int sid) {
		System.out.println("srvr : get stud dtls " + sid);
		Student s = dao.getStudentDetails(sid);
		if (s != null)
			return new ResponseEntity<Student>(s, HttpStatus.OK);
		else // invalid id
			return new ResponseEntity<String>("Invalid Student ID " + sid, HttpStatus.NOT_FOUND);
	}

	// get all student dtls
	@GetMapping
	public List<Student> getAllStudentDetails() {
		System.out.println("srvr : get stud dtls ");
		return dao.getAllStudentDetails();
	}

	// create new student resource
	@PostMapping
	public String registerStudent(@RequestBody Student s) {
		System.out.println("srvr : reg student  " + s);
		return dao.registerStudent(s);
	}

	// delete student record
	@DeleteMapping("/{sid}")
	public String deleteStudentDetails(@PathVariable int sid) {
		System.out.println("srvr : del stud dtls " + sid);
		return dao.deleteStudent(dao.getStudentDetails(sid));
	}

	// update existing student resource
	@PutMapping
	public String updateStudent(@RequestBody Student s) {
		System.out.println("srvr : update student  " + s);
		return dao.updateStudent(s);

	}*/

}
