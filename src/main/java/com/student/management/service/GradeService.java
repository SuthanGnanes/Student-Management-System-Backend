package com.student.management.service;

import java.util.List;
import java.util.Optional;

import com.student.management.data.entity.Grades;

public interface GradeService {
	
	List<Grades> getGrades();
	Optional<Grades> getGradeByName(String name);

}
