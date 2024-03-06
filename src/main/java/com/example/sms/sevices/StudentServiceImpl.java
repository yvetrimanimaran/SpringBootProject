package com.example.sms.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.model.Student;
import com.example.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	
	
	@Autowired
	private StudentRepository stuRepo;

	@Override
	public List<Student> showAllStudents() {
		
		return stuRepo.findAll();
	}

	@Override
	public Optional<Student> searchStudent(int rollno) {
		
		return stuRepo.findById(rollno);
	}

	@Override
	public Student addNewStudent(Student student) {

		return stuRepo.save(student);
	}

	@Override
	public void deleteStudent(int rollno) {
		stuRepo.deleteById(rollno);
		
	}

	@Override
	public List<Student> showStudentsStdWise(int std) {
		
		return stuRepo.findByStd(std);
	}

	
	
	@Override
	public List<Student> showStudentsGendetWise(String gender) {
		
		return stuRepo.findByGender(gender);
	}

	@Override
	public List<Student> showStudentsNameAndGenderWise(String name, String gender) {
		// TODO Auto-generated method stub
		return stuRepo.dispStudents(name, gender);
	}

	@Override
	public List<Student> showStudentsNameWise(String name) {
		// TODO Auto-generated method stub
		return stuRepo.findByName(name);
	}


		 
	}

	
	
	
	

