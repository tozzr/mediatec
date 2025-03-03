package com.tozzr.mediatec.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "movies", rel = "movies")
interface MovieRepository extends JpaRepository<Movie, Integer> {
}
