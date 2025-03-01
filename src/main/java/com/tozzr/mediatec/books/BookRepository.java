package com.tozzr.mediatec.books;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "books", rel = "books")
interface BookRepository extends JpaRepository<Book, Integer> {
	
	Page<Book> findAll(Pageable pageable);
	
}
