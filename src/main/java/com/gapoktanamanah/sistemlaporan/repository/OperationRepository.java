package com.gapoktanamanah.sistemlaporan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapoktanamanah.sistemlaporan.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
