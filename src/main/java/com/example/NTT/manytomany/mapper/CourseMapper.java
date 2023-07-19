package com.example.NTT.manytomany.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.NTT.manytomany.dtos.request.CourseSlimDto;
import com.example.NTT.manytomany.dtos.response.CourseAllDto;
import com.example.NTT.manytomany.entities.CourseEntity;

public class CourseMapper {

	// add
	public static CourseEntity courseSlimDtoToCourseEntity (CourseSlimDto request) {
		CourseEntity entity = new CourseEntity();
		entity.setName(request.getName());
		entity.setTeacher(request.getTeacher());
		return entity;
	}
	
	// 
	public static CourseSlimDto courseEntityTocourseSlimDto (CourseEntity entity) {
		CourseSlimDto courseSlimDto = new CourseSlimDto();
		courseSlimDto.setName(entity.getName());
		courseSlimDto.setTeacher(entity.getTeacher());
		return courseSlimDto;
	}
	
	// Set<courseEntity> To  Set<CourseSlimDtoSet>  
	public static Set<CourseSlimDto> courseEntitySetToCourseSlimDtoSet (Set<CourseEntity> entities) {
		Set<CourseSlimDto> setCourseSlimDto = new HashSet<>();
		
		for(CourseEntity entity : entities ) {
			setCourseSlimDto.add(courseEntityTocourseSlimDto(entity));
		}
		return setCourseSlimDto;
	}
	
//	// return a Course
	public static CourseAllDto courseEntityToCourseAllDto (CourseEntity entity) {
		CourseAllDto courseAllDto = new CourseAllDto();
		courseAllDto.setId(entity.getId());
		courseAllDto.setName(entity.getName());
		courseAllDto.setTeacher(entity.getTeacher());
		courseAllDto.setStudents(StudentMapper.StudentEntitiesSetToStudentSlimDtoSet(entity.getStudents()));
		return courseAllDto;
		
	}
	
//	// return all course
	public static List<CourseAllDto> courseEntitiesToCourseAllDtos (List<CourseEntity> entities){
		List<CourseAllDto> listCourseAllDtos = new ArrayList<>();
		for (CourseEntity entity : entities) {
			listCourseAllDtos.add(courseEntityToCourseAllDto(entity));
		}
		return listCourseAllDtos;
	}
}
