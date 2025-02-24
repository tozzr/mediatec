package com.tozzr.mediatec.movies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	Page<Movie> findAll(Pageable pageable);
	
}
