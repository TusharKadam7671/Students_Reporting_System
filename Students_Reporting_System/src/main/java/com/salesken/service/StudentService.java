package com.salesken.service;



public interface StudentService {

	public String addStudent(Integer student_Id, String student_Name);
	
	public String addMarks(Integer student_Id, Integer semester_Id, String subject_Name, Integer marks);
	
	public String averagePercentage(Integer semester_Id);
	
	public String getTop2Students();
}
