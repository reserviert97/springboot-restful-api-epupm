package com.gapoktanamanah.sistemlaporan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gapoktanamanah.sistemlaporan.exception.ResourceNotFoundException;
import com.gapoktanamanah.sistemlaporan.model.Logistic;
import com.gapoktanamanah.sistemlaporan.model.Operation;
import com.gapoktanamanah.sistemlaporan.repository.LogisticRepository;
import com.gapoktanamanah.sistemlaporan.request.RequestLogistic;

@RestController
public class LogisticController {

	@Autowired
	private LogisticRepository logisticRepository;
	
	
	@GetMapping("/logistic")
	public Page<Logistic> getAllLogistics(Pageable pageable) {
        return logisticRepository.findAll(pageable);
    }
	
	@PostMapping("/logistic")
	@Transactional
    public Logistic createLogisti(@Valid @RequestBody RequestLogistic request) {
		
		System.out.println(request.getType() + " INI REQUESTNYA");
		System.out.println(request.getInvoiceNumber() + " INI REQUESTNYA");
		
		Operation operation = new Operation(
					request.getType(),
					request.getInvoiceNumber()
				);
		
		Logistic logistic = new Logistic(
							request.getInvoiceNumber(),
							request.getVolume(),
							request.getPrice(),
							request.getTotal(),
							request.getType(),
							request.getUserId()
					);
		
		logistic.setOperation(operation);	
		logistic = logisticRepository.save(logistic);
		
		return logistic;
    }
	
	@GetMapping("/logistic/{logisticId}")
	public Logistic getLogisticById(@PathVariable Long logisticId) {
		return logisticRepository.findById(logisticId)
				.orElseThrow(() -> new ResourceNotFoundException("Logistic with id : " + logisticId + " not found"));
	}
	
	@DeleteMapping("/logistic/{logisticId}")
	public Logistic deleteLogistic(@PathVariable Long logisticId) {
		
		return logisticRepository.findById(logisticId).map(logistic -> {
			logisticRepository.delete(logistic);
            return logistic;
        }).orElseThrow(() -> new ResourceNotFoundException("Logistic with id : " + logisticId + " not found"));
	}

}
