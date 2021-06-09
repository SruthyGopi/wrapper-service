package com.example.wrapper.service.wrapperservice.model;


public class Wrapper {
	
	private CustomerBasics customerBasics;
	private CustomerDetails customerDetails;
	


//private String customerBasics_s;

//private String customerDetails_s;

public Wrapper(CustomerDetails customerDetails, CustomerBasics customerBasics) {
	super();
	this.customerBasics = customerBasics;
	this.customerDetails = customerDetails;
	
	//this.customerBasics_s = customerBasics_s;
	//this.customerDetails_s = customerDetails_s;
}

public Wrapper() {
	super();
}

public CustomerBasics getCustomerBasics() {
	return customerBasics;
}

public void setCustomerBasics(CustomerBasics customerBasics) {
	this.customerBasics = customerBasics;
}

public CustomerDetails getCustomerDetails() {
	return customerDetails;
}

public void setCustomerDetails(CustomerDetails customerDetails) {
	this.customerDetails = customerDetails;
}


/*
 * public void setCustomerBasics(String customerBasics_s) {
 * this.customerBasics_s = customerBasics_s;
 * 
 * }
 * 
 * public void setCustomerDetails(String customerDetails_s) {
 * this.customerDetails_s = customerDetails_s;
 * 
 * }
 */

}
