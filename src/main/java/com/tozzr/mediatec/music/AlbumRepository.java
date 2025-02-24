package com.tozzr.mediatec.music;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

interface AlbumRepository extends JpaRepository<Album, Integer> {
	
	Page<Album> findAll(Pageable pageable);
	
}
