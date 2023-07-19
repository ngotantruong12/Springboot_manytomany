package com.example.NTT.manytomany.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.NTT.manytomany.dtos.request.CourseSlimDto;
import com.example.NTT.manytomany.dtos.response.CourseAllDto;

@Service
public interface ICourseService {
	List<CourseAllDto> getAll ();
	CourseAllDto addCourse (CourseSlimDto request);

}
