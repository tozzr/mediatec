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
@RequestMapping("/api/albums")
class AlbumController {
	
	private final AlbumRepository albumRepository;

	public AlbumController(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}

	@GetMapping
	public Page<Album> getAlbums(Pageable pageable) {
		return albumRepository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Album getAlbum(@PathVariable Integer id) {
		return albumRepository.findById(id).orElseThrow();
	}

	@PostMapping
	public Album createAlbum(@RequestBody Album user) {
		return albumRepository.save(user);
	}

	@PutMapping("/{id}")
	public Album updateAlbum(@PathVariable Integer id, @RequestBody Album Album) {
		Album.setId(id);
		return albumRepository.save(Album);
	}

	@DeleteMapping("/{id}")
	public void deleteAlbum(@PathVariable Integer id) {
		albumRepository.deleteById(id);
	}
}
