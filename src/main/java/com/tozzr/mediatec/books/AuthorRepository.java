package com.tozzr.mediatec.books;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	Page<Author> findAll(Pageable pageable);
	
}
