package com.example.NTT.manytomany.dtos.response;

import java.util.Set;

import com.example.NTT.manytomany.dtos.request.CourseSlimDto;

import lombok.Data;

@Data
public class StudentAllDto {

    private Long id;

    private String name;

    private String address;

    private String phone;
    
    private Set<CourseSlimDto> courses;
}
