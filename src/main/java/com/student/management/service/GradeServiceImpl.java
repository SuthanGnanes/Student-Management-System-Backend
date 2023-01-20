package com.student.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.student.management.data.entity.Grades;
import com.student.management.data.repository.GradeRepository;

public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeRepository gradeRepository;
	
	public List<Grades> getGrades(){
		return gradeRepository.findAll();
	}
	
}
