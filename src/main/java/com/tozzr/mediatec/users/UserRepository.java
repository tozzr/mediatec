package com.tozzr.mediatec.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "users", rel = "users")
interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
