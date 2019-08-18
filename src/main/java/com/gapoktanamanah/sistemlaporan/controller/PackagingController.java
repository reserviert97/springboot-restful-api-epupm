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
import com.gapoktanamanah.sistemlaporan.model.Operation;
import com.gapoktanamanah.sistemlaporan.model.Packaging;
import com.gapoktanamanah.sistemlaporan.repository.PackagingRepository;
import com.gapoktanamanah.sistemlaporan.request.RequestPackage;

@RestController
public class PackagingController {
	
	@Autowired
	private PackagingRepository packagingRepository;
	
	@GetMapping("/packaging")
	public Page<Packaging> getAllPackagings(Pageable pageable) {
        return packagingRepository.findAll(pageable);
    }
	
	@PostMapping("/packaging")
	@Transactional
    public Packaging createPackaging(@Valid @RequestBody RequestPackage packaging) {
		
		Operation operation = new Operation(
					packaging.getType(),
					packaging.getInvoiceNumber()
				);
		
		Packaging tempPackage = new Packaging(
							packaging.getInvoiceNumber(),
							packaging.getVolume(),
							packaging.getTotal(),
							packaging.getType()
					);
		
		tempPackage.setOperation(operation);		
		tempPackage = packagingRepository.save(tempPackage);
		
		return tempPackage;
    }
	
	@GetMapping("/packaging/{packagingId}")
	public Packaging getPackagingById(@PathVariable Long packagingId) {
		return packagingRepository.findById(packagingId)
				.orElseThrow(() -> new ResourceNotFoundException("Packaging with id : " + packagingId + " not found"));
	}
	
	@DeleteMapping("/packagings/{packagingId}")
	public Packaging deletePackaging(@PathVariable Long packagingId) {
		
		return packagingRepository.findById(packagingId).map(packaging -> {
			packagingRepository.delete(packaging);
            return packaging;
        }).orElseThrow(() -> new ResourceNotFoundException("Packaging with id : " + packagingId + " not found"));
	}

}
