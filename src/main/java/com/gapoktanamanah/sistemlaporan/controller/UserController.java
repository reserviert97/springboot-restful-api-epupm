package com.gapoktanamanah.sistemlaporan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gapoktanamanah.sistemlaporan.exception.ResourceNotFoundException;
import com.gapoktanamanah.sistemlaporan.model.User;
import com.gapoktanamanah.sistemlaporan.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with id : " + userId + " not found"));
	}
	
	@PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
    }
	
	@DeleteMapping("/users/{userId}")
	public User deleteUser(@PathVariable Long userId) {
		
		return userRepository.findById(userId).map(user -> {
			userRepository.delete(user);
            return user;
        }).orElseThrow(() -> new ResourceNotFoundException("User with id : " + userId + " not found"));
	}
}





















