package com.example.NTT.manytomany.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.NTT.manytomany.dtos.request.StudentSlimDto;
import com.example.NTT.manytomany.dtos.response.StudentAllDto;

@Service
public interface IStudentService {
	List<StudentAllDto> getAll ();
	StudentAllDto addStudent (StudentSlimDto student);
	StudentAllDto registerCourseForStudent(Long studentId, Long courseId);
}
