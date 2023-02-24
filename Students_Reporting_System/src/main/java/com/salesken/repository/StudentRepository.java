package com.salesken.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.salesken.model.Student;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, Integer>{

}
