package com.example.NTT.manytomany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NTT.manytomany.dtos.request.CourseSlimDto;
import com.example.NTT.manytomany.dtos.response.ObjectRespone;
import com.example.NTT.manytomany.entities.CourseEntity;
import com.example.NTT.manytomany.services.ICourseService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping (path = "/api")
public class CourseController {
	
	@Autowired
	private ICourseService iCourseService;
	
	@GetMapping("/course")
	ResponseEntity<ObjectRespone> getAllCourse(){
		return ResponseEntity.status(HttpStatus.OK)
		.body(new ObjectRespone("ok", "Query get all Course successfuly ",iCourseService.getAll()));
	}
	
	@PostMapping("/course")
	ResponseEntity<ObjectRespone> createCourse(@RequestBody CourseSlimDto course){
		return ResponseEntity.status(HttpStatus.OK)
		.body(new ObjectRespone("ok", "Query get all Course successfuly ", iCourseService.addCourse(course) ));
	}

}
