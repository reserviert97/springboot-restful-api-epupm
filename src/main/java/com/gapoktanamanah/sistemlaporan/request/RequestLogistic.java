package com.gapoktanamanah.sistemlaporan.request;

import javax.validation.constraints.NotNull;

public class RequestLogistic {
	
	@NotNull
	private String invoiceNumber;
	@NotNull
	private int volume;
	@NotNull
	private int price;
	@NotNull
	private Long total;
	@NotNull
	private String type;
	@NotNull
	private Long userId;
	
	public RequestLogistic() {}	

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
	
	

}
