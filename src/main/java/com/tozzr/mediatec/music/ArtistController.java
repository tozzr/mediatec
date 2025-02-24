package com.tozzr.mediatec.music;

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
@RequestMapping("/api/artists")
class ArtistController {
	
	private final ArtistRepository artistRepository;

	public ArtistController(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	@GetMapping
	public Page<Artist> getArtists(Pageable pageable) {
		return artistRepository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Artist getArtist(@PathVariable Integer id) {
		return artistRepository.findById(id).orElseThrow();
	}

	@PostMapping
	public Artist createArtist(@RequestBody Artist user) {
		return artistRepository.save(user);
	}

	@PutMapping("/{id}")
	public Artist updateArtist(@PathVariable Integer id, @RequestBody Artist Artist) {
		Artist.setId(id);
		return artistRepository.save(Artist);
	}

	@DeleteMapping("/{id}")
	public void deleteArtist(@PathVariable Integer id) {
		artistRepository.deleteById(id);
	}
}
