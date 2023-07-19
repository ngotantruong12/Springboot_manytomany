package com.example.NTT.manytomany.dtos.response;

import java.util.HashSet;
import java.util.Set;

import com.example.NTT.manytomany.dtos.request.StudentSlimDto;

import lombok.Data;

@Data
public class CourseAllDto {
	
	private Long id;

    private String name;

    private String teacher;
    
    private Set<StudentSlimDto> students = new HashSet<>();

}
