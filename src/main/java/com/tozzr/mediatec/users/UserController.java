package com.tozzr.mediatec.users;

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
@RequestMapping("/api/users")
class UserController {
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping
	public Page<User> getUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) {
		return userRepository.findById(id).orElseThrow();
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User user) {
		user.setId(id);
		return userRepository.save(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
}
