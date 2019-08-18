package com.gapoktanamanah.sistemlaporan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapoktanamanah.sistemlaporan.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
}
