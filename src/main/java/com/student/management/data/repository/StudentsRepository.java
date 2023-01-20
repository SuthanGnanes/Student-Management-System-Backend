package com.student.management.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.data.entity.Students;

public interface StudentsRepository extends JpaRepository<Students, Long>{

}
