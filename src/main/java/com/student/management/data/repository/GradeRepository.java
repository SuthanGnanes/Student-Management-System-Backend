package com.student.management.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.data.entity.Grades;

public interface GradeRepository extends JpaRepository<Grades, Long> {

}
