package com.tozzr.mediatec.books;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
class AuthorController {
	
	private final AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@GetMapping
	public Page<Author> getAuthors(Pageable pageable) {
		return authorRepository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Author getAuthor(@PathVariable Integer id) {
		return authorRepository.findById(id).orElseThrow();
	}

	@PostMapping
	public Author createAuthor(@RequestBody Author user) {
		return authorRepository.save(user);
	}

	@PutMapping("/{id}")
	public Author updateAuthor(@PathVariable Integer id, @RequestBody Author author) {
		author.setId(id);
		return authorRepository.save(author);
	}

	@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable Integer id) {
		authorRepository.deleteById(id);
	}
}
