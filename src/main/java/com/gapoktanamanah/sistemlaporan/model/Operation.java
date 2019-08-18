package com.gapoktanamanah.sistemlaporan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="operations")
public class Operation extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 10)
	private String type;
	
	@NotNull
	@Size(max = 15)
	private String invoiceNumber;
	
	@OneToOne(mappedBy="operation", cascade=CascadeType.ALL)
	private Packaging packaging;

	@OneToOne(mappedBy="operation", cascade=CascadeType.ALL)
	private Logistic logistic;
	
	@OneToOne(mappedBy="operation", cascade=CascadeType.ALL)
	private Processing processing;
	
	public Operation() {}

	public Operation(String type, String invoiceNumber) {
		this.type = type;
		this.invoiceNumber = invoiceNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Packaging getPackaging() {
		return packaging;
	}

	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	public Logistic getLogistic() {
		return logistic;
	}

	public void setLogistic(Logistic logistic) {
		this.logistic = logistic;
	}

	public Processing getProcessing() {
		return processing;
	}

	public void setProcessing(Processing processing) {
		this.processing = processing;
	}
	
	
	
}
