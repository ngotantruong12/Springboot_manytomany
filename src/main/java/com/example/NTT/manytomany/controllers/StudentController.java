package com.example.NTT.manytomany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NTT.manytomany.dtos.request.StudentSlimDto;
import com.example.NTT.manytomany.dtos.response.ObjectRespone;
import com.example.NTT.manytomany.services.IStudentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping (path = "/api")
public class StudentController {
	
	@Autowired
	private IStudentService iStudentService;
	
	@GetMapping("/student")
	ResponseEntity<ObjectRespone> getAllStudent(){
		return ResponseEntity.status(HttpStatus.OK)
		.body(new ObjectRespone("ok", "Query get all Course successfuly ",iStudentService.getAll()));
	}
	
	@PostMapping("/student")
	ResponseEntity<ObjectRespone> createStudent(@RequestBody StudentSlimDto student){
		return ResponseEntity.status(HttpStatus.OK)
		.body(new ObjectRespone("ok", "Query create Student successfuly ", iStudentService.addStudent(student) ));
	}
	
	@PostMapping("/course/{courseId}/student/{studentId}") // them 1 stu vao 1 khoa hoc
	ResponseEntity<ObjectRespone> registerCourse(@PathVariable("studentId") Long studentId, 
								@PathVariable("courseId") Long courseId){
		return ResponseEntity.status(HttpStatus.OK)
		.body(new ObjectRespone("ok", "Query student register Course successfuly ", iStudentService.registerCourseForStudent(studentId, courseId) ));
	}
	

}
