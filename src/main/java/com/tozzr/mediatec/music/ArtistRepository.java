package com.tozzr.mediatec.music;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "artists", rel = "artists")
interface ArtistRepository extends JpaRepository<Artist, Integer> {
	
	List<Artist> findByIdIn(List<Integer> ids);
	
}
