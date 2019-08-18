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
import com.gapoktanamanah.sistemlaporan.model.Operation;
import com.gapoktanamanah.sistemlaporan.repository.OperationRepository;

@RestController
public class OperationController {

	@Autowired
	private OperationRepository operationRepository;
	
	@GetMapping("/operations")
	public Page<Operation> getAllOperations(Pageable pageable) {
        return operationRepository.findAll(pageable);
    }
	
	@PostMapping("/operations")
    public Operation createUser(@Valid @RequestBody Operation operation) {
		return operationRepository.save(operation);
    }
	
	@GetMapping("/operations/{operationId}")
	public Operation getOperationById(@PathVariable Long operationId) {
		return operationRepository.findById(operationId)
				.orElseThrow(() -> new ResourceNotFoundException("Operation with id : " + operationId + " not found"));
	}
	
	@DeleteMapping("/operations/{operationId}")
	public Operation deleteOperation(@PathVariable Long operationId) {
		
		return operationRepository.findById(operationId).map(operation -> {
			operationRepository.delete(operation);
            return operation;
        }).orElseThrow(() -> new ResourceNotFoundException("Operation with id : " + operationId + " not found"));
	}

}
