package com.student.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.data.entity.Students;
import com.student.management.data.repository.StudentsRepository;

@Service
public class StudentsServiceImpl implements StudentsService {

	@Autowired 
	StudentsRepository studentsRepository;
	
	@Override
	public void createStudent(Students student) {
		studentsRepository.save(student);
	}
	
	@Override
	public List<Students> listingStudents(){
		return studentsRepository.findAll();
	}
}
