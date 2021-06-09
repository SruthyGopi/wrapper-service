package com.example.wrapper.service.wrapperservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class CustomerDetails {
	@Id
	//@GeneratedValue(strategy =GenerationType.AUTO)
	private Long customerId;
	private String address;
	private String phoneNo;
	private String email;
	public CustomerDetails(Long customerId, String address, String phoneNo, String email) {
		super();
		this.customerId = customerId;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	public CustomerDetails() {
		super();
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}

