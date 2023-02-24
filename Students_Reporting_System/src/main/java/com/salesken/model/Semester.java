package com.salesken.model;

import javax.annotation.MatchesPattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "semester_index")
public class Semester {
	
	@Id
	@MatchesPattern(value = "[12]")
    private String semester_Id;
	
	private Integer english_marks;
	
	private Integer maths_marks;
	
	private Integer science_marks;

}
