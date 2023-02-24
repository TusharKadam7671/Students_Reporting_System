package com.salesken.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.model.Semester;
import com.salesken.model.Student;
import com.salesken.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository student_repo;

	@Override
	public String addStudent(Integer student_Id, String student_Name) {

		Semester s1 = new Semester(1,0,0,0);
		Semester s2 = new Semester(2,0,0,0);
		List<Semester> semesters = new ArrayList<>();
		semesters.add(s1);
		semesters.add(s2);
		
		Student student = new Student(student_Id, student_Name, semesters);
		
		try 
		{
            student_repo.save(student);
        } 
		catch (Exception e) 
		{
            return e.toString();
        }

        return "Student added successfully !";

	}

	@Override
	public String addMarks(Integer student_Id, Integer semester_Id, String subject_Name, Integer marks) {
		
		Optional<Student> opt = student_repo.findById(student_Id);
		if(opt.isEmpty())
		{
			return "No student is available with given id: "+student_Id;
		}
		
		Student student = opt.get();
		
		List<Semester> semesters = student.getSemester();
		
		for(Semester s : semesters)
		{
			if(s.getSemester_Id()==semester_Id)
			{
				if(subject_Name.equals("English"))
				{
					s.setEnglish_marks(marks);
				}
				else if(subject_Name.equals("Maths"))
				{
					s.setMaths_marks(marks);
				}
				else if(subject_Name.equals("Science"))
				{
					s.setScience_marks(marks);
				}
				else
				{
					return "Please check subject name";
				}
			}
		}
		
		student.setSemester(semesters);
		student_repo.save(student);
		
		return "Marks added successfully";
		
	}

	@Override
	public String averagePercentage(Integer semester_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTop2Students() {

		Iterable<Student> itr = student_repo.findAll();

		List<Student> students = new ArrayList<>();
		
		itr.forEach(students::add);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (Student st : students) 
		{
			Integer marks = 0;
			
			List<Semester> semesters = st.getSemester();
			for(Semester sem : semesters)
			{
				marks = marks + sem.getEnglish_marks() + sem.getMaths_marks() + sem.getScience_marks();
			}
			
			map.put(st.getStudent_Id(), marks);
		}

		List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() 
		{

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) 
			{
				return o2.getValue() - o1.getValue();
			}

		});

		List<Integer> top2list = new ArrayList<>();
		
		int c = 1;
		
		for (Entry<Integer, Integer> entry : list) 
		{
			if (c <= 2) 
			{
				top2list.add(entry.getKey());
				c++;
			}

		}
		
		return top2list.toString();
	}

	
}
