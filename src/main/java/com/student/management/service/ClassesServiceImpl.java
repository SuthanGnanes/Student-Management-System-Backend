package com.student.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.data.entity.Classes;
import com.student.management.data.repository.ClassesRepository;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	ClassesRepository classesRepository;
	

	@Override
	public void createClass(Classes classes) {
		classesRepository.save(classes);
		
	}	
	
}
