package com.tozzr.mediatec.music;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

interface ArtistRepository extends JpaRepository<Artist, Integer> {
	
	Page<Artist> findAll(Pageable pageable);
	
}
