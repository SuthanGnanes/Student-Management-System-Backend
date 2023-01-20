package com.student.management.service;

import java.util.List;

import com.student.management.data.entity.Students;

public interface StudentsService {
	public void createStudent(Students student);
	public List<Students> listingStudents();
}
