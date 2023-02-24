package com.salesken.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(indexName = "student_index")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	private Integer student_Id;
	
	private String student_Name;
	
	private List<Semester> semester;

}
