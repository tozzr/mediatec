package com.tozzr.mediatec.books;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;

	@ManyToOne
	@JsonIgnore
	private Author author;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@JsonProperty("authorId") // Expose only the Author ID
	public Integer getAuthorId() {
		return (author != null) ? author.getId() : null;
	}

	public void setAuthorId(Integer authorId) {
		this.author = (authorId != null) ? new Author(authorId) : null;
	}
	
}
