package com.tozzr.mediatec.movies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "directors", rel = "directors")
interface DirectorRepository extends JpaRepository<Director, Integer> {
	
	List<Director> findByIdIn(List<Integer> ids);
	
}
