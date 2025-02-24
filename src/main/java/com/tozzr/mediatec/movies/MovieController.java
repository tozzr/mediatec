package com.tozzr.mediatec.movies;

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
@RequestMapping("/api/movies")
class MovieController {
	
	private final MovieRepository movieRepository;

	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@GetMapping
	public Page<Movie> getMovies(Pageable pageable) {
		return movieRepository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable Integer id) {
		return movieRepository.findById(id).orElseThrow();
	}

	@PostMapping
	public Movie createMovie(@RequestBody Movie user) {
		return movieRepository.save(user);
	}

	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie Movie) {
		Movie.setId(id);
		return movieRepository.save(Movie);
	}

	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Integer id) {
		movieRepository.deleteById(id);
	}
}
