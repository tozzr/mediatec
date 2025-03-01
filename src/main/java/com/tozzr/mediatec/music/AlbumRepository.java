package com.tozzr.mediatec.music;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "albums", rel = "albums")
interface AlbumRepository extends JpaRepository<Album, Integer> {
	
	Page<Album> findAll(Pageable pageable);
	
}
