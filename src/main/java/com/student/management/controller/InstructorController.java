package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.data.dto.InstructorDto;
import com.student.management.data.mapper.Mapper;
import com.student.management.service.InstructorService;
import com.student.management.util.EndpointURI;

@CrossOrigin("*")
@RestController
public class InstructorController {

	@Autowired
	private InstructorService instructorService;
	@Autowired
	private Mapper mapper;
	
	@GetMapping(value = EndpointURI.GET_INSTRUCTORS)
	public ResponseEntity<Object> listAllInstructors(){
		return new ResponseEntity<Object>(mapper.map(instructorService.getInstructors(), InstructorDto.class), HttpStatus.OK);
	}
}
