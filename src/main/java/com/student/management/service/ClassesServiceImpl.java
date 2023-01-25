package com.student.management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.data.entity.Classes;
import com.student.management.data.repository.ClassesRepository;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	ClassesRepository classesRepository;
	

	@Override
	public Long createClass(Classes classes) {
		Classes classesRtn = classesRepository.save(classes);
		return classesRtn.getId();
		
		
	}


	@Override
	public Optional<Classes> getClassByClassesIdAndGradeId(Long classesId, Long gradeId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}	
	
}
