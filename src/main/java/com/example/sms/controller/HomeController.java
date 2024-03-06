package com.example.sms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sms.model.Student;
import com.example.sms.sevices.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService stuService;

	@GetMapping("/")
	public String homepage() {
		return "index";
	}

	@GetMapping("/view")
	public String viewpage(Model model) {
		model.addAttribute("allStudents", stuService.showAllStudents());
		return "view-student";
	}

	@GetMapping("/add")
	public String addpage(Model model) {
		model.addAttribute("obj", new Student());
		return "add-Student";
	}

	@PostMapping("/add")
	public String addStudentData(@ModelAttribute("obj") Student stu) {
		Optional<Student> opt = stuService.searchStudent(stu.getRollno());

		if (opt.isEmpty()) {
			stuService.addNewStudent(stu);
			return "redirect:/view";
		} else {
			return "redirect:/add?failed";
		}
	}

	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable("id") int rollno, Model model) {
		Optional<Student> fetchedData = stuService.searchStudent(rollno);
		model.addAttribute("obj", fetchedData);
		return "edit-Student";
	}

	@PostMapping("/edit")
	public String editData(@ModelAttribute("obj") Student stu) {
		stuService.addNewStudent(stu);
		return "redirect:/view";
	}
	@GetMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int rollno)
	{
		stuService.deleteStudent(rollno);
		return "redirect:/view";
	}
	@PostMapping("/search-std")
	public String searchStudentStd(@RequestParam("std") int std, Model model)
	{
		model.addAttribute("allStudents", stuService.showStudentsStdWise(std));
		return "view-student";
	}
	
	@PostMapping("/search-name")
	public String searchStudentName(@RequestParam("name") String name, Model model)
	{
		model.addAttribute("allStudents", stuService.showStudentsNameWise(name));
		return "view-student";
	}
	
	@GetMapping("/search-custom")
	public String searchQuery(Model model)
	{
		model.addAttribute("allStudents", stuService.showStudentsNameAndGenderWise("maran", "male"));
		return "view-Student";
	
	} 
	
	
	
	@GetMapping("/search-male")
	public String getMaleStudents(Model model)
	{
		model.addAttribute("allStudents", stuService.showStudentsGendetWise("male"));
		return "view-student";
	}
	
	@GetMapping("search-female")
	public String getFemaleStudents(Model model)
	{
		model.addAttribute("allStudents", stuService.showStudentsGendetWise("female"));
		return "view-student";
	
	}
}
