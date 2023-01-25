package com.student.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.data.entity.Grades;
import com.student.management.data.repository.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeRepository gradeRepository;
	
	@Override
	public List<Grades> getGrades(){
		return gradeRepository.findAll();
	}

	@Override
	public Optional<Grades> getGradeByName(String name) {
		return gradeRepository.findByName(name);
	}
	
}
