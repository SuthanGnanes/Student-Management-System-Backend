package com.student.management.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.data.entity.Instructors;

public interface InstructorsRepository extends JpaRepository<Instructors, Long>{

}
