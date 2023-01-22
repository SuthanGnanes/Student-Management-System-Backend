package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.data.dto.GradeDto;
import com.student.management.data.mapper.Mapper;
import com.student.management.service.GradeService;
import com.student.management.util.EndpointURI;

@CrossOrigin("http://localhost:3000/")
@RestController
public class GradeController {
	
	@Autowired
	GradeService gradeService;

	@Autowired
	Mapper mapper;
	
	@GetMapping(value = EndpointURI.GET_GRADES)
	public ResponseEntity<Object> listAllGrades(){
		return new ResponseEntity<Object>(mapper.map(gradeService.getGrades(), GradeDto.class), HttpStatus.OK);
	
	}
}
