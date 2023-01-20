package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.data.dto.StudentCreateDto;
import com.student.management.data.dto.StudentsResponceDto;
import com.student.management.data.entity.Students;
import com.student.management.data.mapper.Mapper;
import com.student.management.service.StudentsService;
import com.student.management.util.Constants;
import com.student.management.util.EndpointURI;

@CrossOrigin("http://localhost:3000/")
@RestController
public class StudentsController {
	
	@Autowired
	private StudentsService studentsService;
	@Autowired
	private Mapper mapper;
	
	@PostMapping(value = EndpointURI.ADD_STUDENT)
	public ResponseEntity<Object> createStudents(@RequestBody StudentCreateDto studentCreateDto){
		Students students = mapper.map(studentCreateDto, Students.class);
		studentsService.createStudent(students);
		return new ResponseEntity<Object>(Constants.STUDENTS_ADD_SUCCESS, HttpStatus.OK);	
	}
	
	@GetMapping(value = EndpointURI.GET_STUDENTS)
	public ResponseEntity<Object> listAllStudents(){
		return new ResponseEntity<Object>(mapper.map(studentsService.listingStudents(), StudentsResponceDto.class), HttpStatus.OK);
	}
	
	

}
