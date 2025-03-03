package com.tozzr.mediatec.movies;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;

	@ManyToOne
	@JsonIgnore
	private Director director;
	
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

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}
	
	@JsonProperty("directorId") // Expose only the Author ID
	public Integer getDirectorId() {
		return (director != null) ? director.getId() : null;
	}

	public void setDirectorId(Integer directorId) {
		this.director = (directorId != null) ? new Director(directorId) : null;
	}
	
}