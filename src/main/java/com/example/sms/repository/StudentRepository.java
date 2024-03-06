package com.example.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByStd(Integer std);
	 
	List<Student> findByGender(String gender);
	
	
	@Query(value = "select * from student where name=?1 and gender=?2", nativeQuery=true)

    List<Student> dispStudents(String name, String gender);
	
	List<Student> findByName(String name);

}
