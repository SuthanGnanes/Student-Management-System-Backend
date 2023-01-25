package com.student.management.service;

import java.util.Optional;

import com.student.management.data.entity.Classes;

public interface ClassesService {

	public Long createClass(Classes classes);

	public Optional<Classes> getClassByClassesIdAndGradeId(Long classesId, Long gradeId);

}
