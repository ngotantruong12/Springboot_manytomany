package com.example.NTT.manytomany.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NTT.manytomany.dtos.request.StudentSlimDto;
import com.example.NTT.manytomany.dtos.response.StudentAllDto;
import com.example.NTT.manytomany.entities.CourseEntity;
import com.example.NTT.manytomany.entities.StudentEntity;
import com.example.NTT.manytomany.exceptions.NotFoundException;
import com.example.NTT.manytomany.mapper.StudentMapper;
import com.example.NTT.manytomany.repositoies.CourseRepository;
import com.example.NTT.manytomany.repositoies.StudentRepository;
import com.example.NTT.manytomany.services.IStudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired CourseRepository courseRepository;
	
	@Override
	public List<StudentAllDto> getAll() {
		List<StudentEntity> a = studentRepository.findAll();
		return StudentMapper.studentEntitiesToStudentAllDto(studentRepository.findAll());
//		return studentRepository.findAll();
	}

	@Transactional
	@Override
	public StudentAllDto addStudent(StudentSlimDto student) {
		return StudentMapper.studentEntityToStudentAllDto(studentRepository
				.save(StudentMapper.studentSlimDtoToStudentEntity(student)));
	}

	@Override
	public StudentAllDto registerCourseForStudent(Long studentId, Long courseId) throws  NotFoundException{
//		Optional<Course> course = courseRepository.findById(courseId);
//		if(!course.isPresent())  {
//			System.out.println("aaaaa");
//			throw new NotFoundException("Cannot found Course with id: "+ courseId );
//			
//		}
		Set<CourseEntity> courseEntities = null;
		Set<StudentEntity> studentEntities = null;
		CourseEntity course = courseRepository.findById(courseId)
				.orElseThrow(() -> new NotFoundException("Cannot found Course with id: "+ courseId ));
		
		StudentEntity student = studentRepository.findById(studentId)
				.orElseThrow(() -> new NotFoundException("Cannot found Student with id: "+ studentId ));
		
		// case 1 // addCourse in file entity
		student.addCourse(course); //// correct
		
		
		// case 2
//		courseEntities = student.getCourses();
//		courseEntities.add(course);
//		
//		student.setCourses(courseEntities);
//		
//		studentEntities = course.getStudents();
//		studentEntities.add(student);
//		CourseEntity b = courseRepository.save(course);
//		//  ---------------- > correct 
//		
		// case 3 
//		student.getCourses().add(course);
//		
//		course.getStudents().add(student);
//		CourseEntity a = courseRepository.save(course);
		
		
		return StudentMapper.studentEntityToStudentAllDto(studentRepository.save(student));
	}

}
