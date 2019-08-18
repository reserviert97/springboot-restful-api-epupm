package com.gapoktanamanah.sistemlaporan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapoktanamanah.sistemlaporan.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
