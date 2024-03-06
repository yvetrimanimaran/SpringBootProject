package com.example.sms.sevices;

import java.util.List;
import java.util.Optional;

import com.example.sms.model.Student;

public interface StudentService {
	
	List<Student> showAllStudents();
	
	Optional<Student> searchStudent(int rollno);

	Student addNewStudent(Student student);

	void deleteStudent(int rollno);
	
	List<Student> showStudentsStdWise(int std);
	
	List<Student> showStudentsGendetWise(String gender);
	
	List<Student> showStudentsNameAndGenderWise(String name, String gender);
	
	List<Student> showStudentsNameWise(String name);
}
