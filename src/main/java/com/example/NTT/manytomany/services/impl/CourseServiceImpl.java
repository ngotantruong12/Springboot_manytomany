package com.example.NTT.manytomany.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NTT.manytomany.dtos.request.CourseSlimDto;
import com.example.NTT.manytomany.dtos.response.CourseAllDto;
import com.example.NTT.manytomany.entities.CourseEntity;
import com.example.NTT.manytomany.mapper.CourseMapper;
import com.example.NTT.manytomany.repositoies.CourseRepository;
import com.example.NTT.manytomany.services.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private CourseRepository courseRepository;

	
	@Override
	public List<CourseAllDto> getAll() {
		return CourseMapper.courseEntitiesToCourseAllDtos(courseRepository.findAll());
	}

	@Override
	public CourseAllDto addCourse(CourseSlimDto course) {
		return CourseMapper.courseEntityToCourseAllDto(courseRepository
				.save(CourseMapper.courseSlimDtoToCourseEntity(course)));
	}
	

}
