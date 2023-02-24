package com.salesken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesken.service.StudentService;

@Controller
public class StudentUIController {
	
	@Autowired
	private StudentService student_service;
	
	
	@PostMapping("/savestudent")
	public String saveStudentHandler(@RequestParam Integer student_Id, @RequestParam String student_Name)
	{
		String result = student_service.addStudent(student_Id, student_Name);
		return result;
	}
	
	@PostMapping("/addmarks")
	public String addMarksHandler(@RequestParam Integer student_Id, @RequestParam Integer semester_Id, 
									@RequestParam String subject_Name, @RequestParam Integer marks)
	{
		String result = student_service.addMarks(student_Id, semester_Id, subject_Name, marks);
		return result;
	}
	
	@GetMapping("/avgmarks")
	public String getAvgMarksHandler(Model model, @RequestParam Integer semester_Id)
	{
		String avgMarks = student_service.averagePercentage(semester_Id);
		model.addAttribute("avgMarks",avgMarks);
		return "avgMarks";
	}
	
	@GetMapping("/toptwo")
	public String getTop2Students(Model model)
	{
		String result = student_service.getTop2Students();
		model.addAttribute("top2",result);
		return result;
	}

}

