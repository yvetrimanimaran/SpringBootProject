package com.example.sms.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.model.Student;
import com.example.sms.sevices.StudentService;


@RestController
public class HomeRestController {
	
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/api/students")
	public List<Student> getAllStudents()
	{
		return studentService.showAllStudents();
	}
	
	@GetMapping("/api/students/{std}")
	public List<Student> getAllStudentsStdWise(@PathVariable("std") int std)
	
	{
		return studentService.showStudentsStdWise(std);
	
	}
	
	@GetMapping("/api/student/{id}")
	public Optional<Student> getStudent(@PathVariable("id") int rollno)
	{
		return studentService.searchStudent(rollno);
	}
	
	@PostMapping("/api/student")
	public Student addStudentData(@RequestBody Student stu)
	{
		Optional<Student> opt=studentService.searchStudent(stu.getRollno());
		if(opt.isEmpty())
			return studentService.addNewStudent(stu);
		else
			return new Student();
	}
	
	@PutMapping("/api/student")
	public Student updatStudentData(@RequestBody Student stu)
	{
		Optional<Student> opt = studentService.searchStudent(stu.getRollno());
		if(opt.isPresent())
			return studentService.addNewStudent(stu);
		else
			return new Student();	

	}
	
	@DeleteMapping("/api/student/{id}")
	public Optional<Student> deleteData(@PathVariable("id") int rollno)
	{
		Optional<Student> fetchedData = studentService.searchStudent(rollno);
		if(fetchedData.isPresent())
		{
			studentService.deleteStudent(rollno);
			return fetchedData;
		}
		else
			return fetchedData;
	}
	
	
	
	

}
