package com.example.NTT.manytomany.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NTT.manytomany.entities.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long>{
	
	CourseEntity findCourseByStudentsId(Long Id);

}
