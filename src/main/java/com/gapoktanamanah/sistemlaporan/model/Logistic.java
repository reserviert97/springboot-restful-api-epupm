package com.gapoktanamanah.sistemlaporan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="logistic")
public class Logistic extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 15)
	private String invoiceNumber;
	
	@NotNull
	private int volume;
	
	@NotNull
	private int price;
	
	@NotNull
	private Long total;
	
	@NotNull
	@Size(max = 10)
	private String type;
	
	@NotNull
	@Column(name="user_id")
	private Long userId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="operation_id")
	@NotNull
	@JsonIgnore
	private Operation operation;
	
	public Logistic() {}

	public Logistic(String invoiceNumber, int volume, int price, Long total, String type, Long userId) {
		this.invoiceNumber = invoiceNumber;
		this.volume = volume;
		this.price = price;
		this.total = total;
		this.type = type;
		this.userId = userId;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Logistic [id=" + id + ", invoiceNumber=" + invoiceNumber + ", volume=" + volume + ", price=" + price
				+ ", total=" + total + ", type=" + type + ", userId=" + userId + "]";
	}
	
	
	

}
