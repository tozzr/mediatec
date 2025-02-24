package com.tozzr.mediatec.books;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

interface BookRepository extends JpaRepository<Book, Integer> {
	
	Page<Book> findAll(Pageable pageable);
	
}
