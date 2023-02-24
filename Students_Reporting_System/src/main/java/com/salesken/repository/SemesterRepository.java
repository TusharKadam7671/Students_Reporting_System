package com.salesken.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.salesken.model.Semester;

@Repository
public interface SemesterRepository extends ElasticsearchRepository<Semester, Integer>{

}
