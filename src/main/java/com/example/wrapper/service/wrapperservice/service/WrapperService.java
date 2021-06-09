package com.example.wrapper.service.wrapperservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.wrapper.service.wrapperservice.model.CustomerBasics;
import com.example.wrapper.service.wrapperservice.model.CustomerDetails;
import com.example.wrapper.service.wrapperservice.model.Wrapper;

@Service
public class WrapperService {

	@Autowired
	private RestTemplate restTemplate;

	public Wrapper getCustomerInfoById(Long customerId) {
		Wrapper wrapper = new Wrapper();
		CustomerBasics customerBasics = restTemplate
				.getForObject("http://customer-basics-microservice/customerbasics/" + customerId, CustomerBasics.class);
		CustomerDetails customerDetails = restTemplate.getForObject(
				"http://customer-details-microservice/customerdetails/" + customerId, CustomerDetails.class);
		
		wrapper.setCustomerBasics(customerBasics);
		wrapper.setCustomerDetails(customerDetails);
		return wrapper;

	}

	public String updateAllCustomerInfo(Wrapper wrapper, Long customerId) {
		restTemplate.put("http://customer-basics-microservice/customerbasics/update/" + customerId,
				wrapper.getCustomerBasics(), CustomerBasics.class);
		restTemplate.put("http://customer-details-microservice/customerdetails/update/" + customerId,
				wrapper.getCustomerDetails(), CustomerDetails.class);
		

		return "successfuly updated the customer details";

	}

	public Wrapper addNewCustomerInfo(Wrapper wrapper) {

		CustomerBasics customerBasics = restTemplate.postForObject(
				"http://customer-basics-microservice/customerbasics/add", wrapper.getCustomerBasics(),
				CustomerBasics.class);
		CustomerDetails customerDetails = restTemplate.postForObject(
				"ttp://customer-details-microservice/customerdetails/add", wrapper.getCustomerDetails(),
				CustomerDetails.class);
		wrapper.setCustomerBasics(customerBasics);
		wrapper.setCustomerDetails(customerDetails);
		return wrapper;
	}

	public String deleteCustomer(Long customerId) {
		restTemplate.delete("http://customer-basics-microservice/customerbasics/delete/" + customerId,
				CustomerBasics.class);
		restTemplate.delete("http://customer-details-microservice/customerdetails/delete/" + customerId,
				CustomerDetails.class);
		

		return "successfuly deleted the customer details";
	}

	
	
}
