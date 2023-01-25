package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.data.dto.ClassesDto;
import com.student.management.data.entity.Classes;
import com.student.management.data.mapper.Mapper;
import com.student.management.data.responce.ResponseHandler;
import com.student.management.service.ClassesService;
import com.student.management.util.Constants;
import com.student.management.util.EndpointURI;

@CrossOrigin("*")
@RestController
public class ClassesController {

	@Autowired
	private ClassesService classesService;
	@Autowired
	private Mapper mapper;

	@PostMapping(value = EndpointURI.ADD_CLASS)
	public ResponseEntity<Object> createClass(@RequestBody ClassesDto classesDto) {
		Classes classes = mapper.map(classesDto, Classes.class);
		Long classId = classesService.createClass(classes);
		new ResponseHandler();
		return ResponseHandler.generateResponse(Constants.CLASS_ADD_SUCCESS, HttpStatus.OK, classId);
	}

}
