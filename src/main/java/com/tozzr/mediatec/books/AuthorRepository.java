package com.tozzr.mediatec.books;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "authors", rel = "authors")
interface AuthorRepository extends PagingAndSortingRepository<Author, Integer> {

	List<Author> findByIdIn(List<Integer> ids);
	
}
