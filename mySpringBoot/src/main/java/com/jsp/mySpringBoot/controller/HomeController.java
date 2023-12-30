package com.jsp.mySpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.mySpringBoot.Response.ResponseStructure;
import com.jsp.mySpringBoot.dto.Student;
import com.jsp.mySpringBoot.exteption.StudentNoFoundException;
import com.jsp.mySpringBoot.repository.StudentRepository;

import jakarta.servlet.http.HttpServlet;

@RestController
public class HomeController {
	@Autowired
	StudentRepository studentRepo;
	
	@PostMapping("/saveStudent")
	public String saveStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return "data saved";
	}
	
	@GetMapping("/getstudent")
	public ResponseStructure<Student> getStudent(@RequestParam("id") int id) {
		Optional<Student> opt = studentRepo.findById(id);
		if(opt.isPresent()) {
		Student student = opt.get();
		ResponseStructure<Student> res = new ResponseStructure<Student>();
		res.setStatusCode(HttpStatus.FOUND.value());
		res.setData(student);
		res.setMessage("Data found successfully");
		return res;
		}else {
			throw new StudentNoFoundException("student not found Exception");
		}
	}
	
	@GetMapping("/getAllStudent")
	public ResponseStructure<List<Student>> getAllStudent(){
		 List<Student> findAll = studentRepo.findAll();
		 ResponseStructure<List<Student>> res = new ResponseStructure<List<Student>> ();
		 res.setStatusCode(HttpStatus.FOUND.value());
			res.setData(findAll);
			res.setMessage("All Data found successfully");
			return res;
	}
	@PutMapping("/updateStudent")
	public ResponseStructure<Student> updateStudent(@RequestBody Student student) {
		 Student save = studentRepo.save(student);
		 ResponseStructure<Student> res = new ResponseStructure<Student>();
			res.setStatusCode(HttpStatus.FOUND.value());
			res.setData(save);
			res.setMessage("Data "+student.getName()+" Updated successfully");
			return res;
	}
	
	@GetMapping("/getStudentByName")
	public ResponseStructure<List<Student>> getStudentByName(@RequestParam("name") String name){
		 List<Student> findByName = studentRepo.findByName(name);
		 ResponseStructure<List<Student>> res = new ResponseStructure<List<Student>> ();
		 res.setStatusCode(HttpStatus.FOUND.value());
			res.setData(findByName);
			res.setMessage("All Data found successfully");
			return res;
	}
	@GetMapping("/getStudentByAgeGreaterThan")
	public ResponseStructure<List<Student>> getStudentByAgeGreaterThan(@RequestParam("age") int age){
		 List<Student> findByAgeGreaterThan = studentRepo.findByAgeGreaterThan(age);
		 ResponseStructure<List<Student>> res = new ResponseStructure<List<Student>> ();
		 res.setStatusCode(HttpStatus.FOUND.value());
			res.setData(findByAgeGreaterThan);
			res.setMessage("All Data found successfully");
			return res;
	}
	@GetMapping("/getStudentByAgeSmallerThan")
	public ResponseStructure<List<Student>> getStudentByAgeSmallerThan(@RequestParam("age") int age){
		 List<Student> findByAgeLessThan = studentRepo.findByAgeLessThan(age);
		 ResponseStructure<List<Student>> res = new ResponseStructure<List<Student>> ();
		 res.setStatusCode(HttpStatus.FOUND.value());
			res.setData(findByAgeLessThan);
			res.setMessage("All Data found successfully");
			return res;
	}
	@GetMapping("/getStudentByAgeBetween")
	public ResponseStructure<List<Student>> getStudentByAgeBetween(@RequestParam("age") int age1,@RequestParam("age") int age2){
		 List<Student> findByAgeBetween = studentRepo.findByAgeBetween(age1, age2);
		 ResponseStructure<List<Student>> res = new ResponseStructure<List<Student>> ();
		 res.setStatusCode(HttpStatus.FOUND.value());
			res.setData(findByAgeBetween);
			res.setMessage("All Data found successfully");
			return res;
	}
	@DeleteMapping("/deleteStudent")
	public ResponseStructure<Student> deleteStudent(@RequestParam("id") int id){
		studentRepo.deleteById(id);
		ResponseStructure<Student> res = new ResponseStructure<Student>();
		res.setStatusCode(HttpStatus.FOUND.value());
		
		res.setMessage("Data found successfully");
		return res;
	}

}
