package com.student.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.data.entity.Instructors;
import com.student.management.data.repository.InstructorsRepository;

@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
	InstructorsRepository instructorsRepository;
	
	@Override
	public List<Instructors> getInstructors() {
		return instructorsRepository.findAll();
	}

}
