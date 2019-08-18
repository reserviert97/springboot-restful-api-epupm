package com.gapoktanamanah.sistemlaporan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="packaging")
public class Packaging extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 15)
	private String invoiceNumber;
	
	@NotNull
	private int volume;
	
	@NotNull
	private Long total;
	
	@NotNull
	@Size(max = 10)
	private String type;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="operation_id")
	@NotNull
	@JsonIgnore
	private Operation operation;
	
	public Packaging() {}
	
	public Packaging(String invoiceNumber, int volume, Long total, String type) {
		this.invoiceNumber = invoiceNumber;
		this.volume = volume;
		this.total = total;
		this.type = type;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
}
