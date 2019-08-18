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
@Table(name="processing")
public class Processing extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 15)
	private String invoiceNumber;
	
	@NotNull
	@Column(name="volume_before")
	private int volumeBefore;
	
	@NotNull
	@Column(name="volume_after")
	private int volumeAfter;
	
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
	
	public Processing() {}

}
