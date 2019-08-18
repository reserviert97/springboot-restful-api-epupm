package com.gapoktanamanah.sistemlaporan.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequestPackage {
	
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
	
	public RequestPackage() {}

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
	
	

}
