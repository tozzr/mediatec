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
@RequestMapping("/api/books")
class BookController {
	
	private final BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping
	public Page<Book> getBooks(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable Integer id) {
		return bookRepository.findById(id).orElseThrow();
	}

	@PostMapping
	public Book createBook(@RequestBody Book user) {
		return bookRepository.save(user);
	}

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
		book.setId(id);
		return bookRepository.save(book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Integer id) {
		bookRepository.deleteById(id);
	}
}
