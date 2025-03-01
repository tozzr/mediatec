package com.tozzr.mediatec;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tozzr.mediatec.users.CustomUserDetails;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private final UserDetailsService userDetailsService;

	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(credentials.get("username"), credentials.get("password")));

		UserDetails userDetails = userDetailsService.loadUserByUsername(credentials.get("username"));
		String token = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(Map.of("id", ((CustomUserDetails) userDetails).getUser().getId(), "username",
				userDetails.getUsername(), "roles", userDetails.getAuthorities(), "token", token));
	}
}
