package com.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.data.dto.StudentCreateDto;
import com.student.management.data.dto.StudentsResponceDto;
import com.student.management.data.entity.Students;
import com.student.management.data.mapper.Mapper;
import com.student.management.data.responce.ValidationFailureResponse;
import com.student.management.service.StudentsService;
import com.student.management.util.Constants;
import com.student.management.util.EndpointURI;
import com.student.management.util.ValidationConstance;
import com.student.management.util.ValidationFailureStatusCodes;


@CrossOrigin("*")
@RestController
public class StudentsController {
	
	@Autowired
	private StudentsService studentsService;
	@Autowired
	private Mapper mapper;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes; 
	
	
	@PostMapping(value = EndpointURI.ADD_STUDENT)
	public ResponseEntity<Object> createStudent(@RequestBody StudentCreateDto studentCreateDto){
		Students student = mapper.map(studentCreateDto, Students.class);
		if(studentsService.isEmailAlreadyExist(studentCreateDto.getEmail())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMAIL_EXISTS,
					validationFailureStatusCodes.getEmailAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		studentsService.createStudent(student);
		return new ResponseEntity<Object>(Constants.STUDENTS_ADD_SUCCESS, HttpStatus.OK);
		
	}
	@PutMapping(value = EndpointURI.UPDATE_STUDENTS)
	public ResponseEntity<Object> createStudents(@RequestBody List<StudentCreateDto> studentCreateDto){
		List<Students> students = mapper.map(studentCreateDto, Students.class);
		studentsService.createStudents(students);
		return new ResponseEntity<Object>(Constants.STUDENT_UPDATED_SUCCESS, HttpStatus.OK);
		
	}
	
	@GetMapping(value = EndpointURI.GET_STUDENTS)
	public ResponseEntity<Object> listAllStudents(){
		return new ResponseEntity<Object>(mapper.map(studentsService.listingStudents(), StudentsResponceDto.class), HttpStatus.OK);
	}
	
	

}
