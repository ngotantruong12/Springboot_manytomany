package com.example.NTT.manytomany.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.NTT.manytomany.dtos.request.StudentSlimDto;
import com.example.NTT.manytomany.dtos.response.StudentAllDto;
import com.example.NTT.manytomany.entities.CourseEntity;
import com.example.NTT.manytomany.entities.StudentEntity;

public class StudentMapper {
	
	//add student
	public static StudentEntity studentSlimDtoToStudentEntity (StudentSlimDto request) {
		StudentEntity entity = new StudentEntity();
		entity.setName(request.getName());
		entity.setAddress(request.getAddress());
		entity.setPhone(request.getName());
		return entity;
		
	}
	
	// response a student ,  Set<courseEntity> To  Set<CourseSlimDtoSet> 
	public static StudentAllDto studentEntityToStudentAllDto (StudentEntity entity) {
		StudentAllDto response = new StudentAllDto();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setAddress(entity.getAddress());
		response.setPhone(entity.getPhone());
		response.setCourses(CourseMapper.courseEntitySetToCourseSlimDtoSet(entity.getCourses()));
		
		return response;
	}
	
	// response all student
	public static List<StudentAllDto> studentEntitiesToStudentAllDto (List<StudentEntity> entities){
		List<StudentAllDto> listStudentAllresponse = new ArrayList<>();
		for(StudentEntity entity : entities) {
			listStudentAllresponse.add(studentEntityToStudentAllDto(entity));
		}
		
		return listStudentAllresponse;
		
	}
	
	// StudentEntity -> StudentSlimDto	
	public static StudentSlimDto StudentEntityToStudentSlimDto(StudentEntity entity) {
		StudentSlimDto dto = new StudentSlimDto();
		dto.setName(entity.getName());
		dto.setAddress(entity.getAddress());
		dto.setPhone(entity.getPhone());
		return dto;
	
	}
	
	// Set<StudentEntity> -> Set<StudentSlimDto>
	public static Set<StudentSlimDto> StudentEntitiesSetToStudentSlimDtoSet(Set<StudentEntity> entities) {
		 Set<StudentSlimDto> listdto = new HashSet<>();
		 for(StudentEntity entity : entities) {
			 listdto.add(StudentEntityToStudentSlimDto(entity));
		 }
		return listdto;
	
	}

}
