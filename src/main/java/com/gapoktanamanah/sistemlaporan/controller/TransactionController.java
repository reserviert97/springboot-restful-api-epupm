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
import com.gapoktanamanah.sistemlaporan.model.Transaction;
import com.gapoktanamanah.sistemlaporan.model.User;
import com.gapoktanamanah.sistemlaporan.repository.TransactionRepository;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@GetMapping("/transactions")
	public Page<Transaction> getAllTransactions(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }
	
	@PostMapping("/transactions")
    public Transaction createUser(@Valid @RequestBody Transaction transaction) {
		return transactionRepository.save(transaction);
    }
	
	@GetMapping("/transactions/{transactionId}")
	public Transaction getTransactionById(@PathVariable Long transactionId) {
		return transactionRepository.findById(transactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Transaction with id : " + transactionId + " not found"));
	}
	
	@DeleteMapping("/transactions/{transactionId}")
	public Transaction deleteTransaction(@PathVariable Long transactionId) {
		
		return transactionRepository.findById(transactionId).map(transaction -> {
			transactionRepository.delete(transaction);
            return transaction;
        }).orElseThrow(() -> new ResourceNotFoundException("Transaction with id : " + transactionId + " not found"));
	}
	
}
