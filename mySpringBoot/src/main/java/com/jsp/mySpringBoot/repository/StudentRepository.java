package com.jsp.mySpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
///import org.springframework.web.bind.annotation.RestController;

import com.jsp.mySpringBoot.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	List<Student> findByName(String name);
	List<Student> findByAgeGreaterThan(int age);
	List<Student> findByAgeLessThan(int age);
	List<Student> findByAgeBetween(int age1,int age2);
	
}
