package com.example.wrapper.service.wrapperservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wrapper.service.wrapperservice.model.Wrapper;
import com.example.wrapper.service.wrapperservice.service.WrapperService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping ("/wrapperservice")
@Api(value="wrapperservice")
public class WrapperServiceController {
	
	@Autowired
	private WrapperService wrapperService;

	@ApiOperation(value = "Get Customer by Id", response = Wrapper.class, tags=" Get Customer by Id")
	@GetMapping("/{id}")
	public Wrapper getAllCustomerInfo(@PathVariable("id") Long customerId) {
		return wrapperService.getCustomerInfoById (customerId);
	}

	@ApiOperation(value = "Update customer ",response = Wrapper.class,tags=" Update customer")
	@PutMapping("/update/{id}")
	public String updateAllCustomerInfo(@RequestBody Wrapper wrapper,@PathVariable("id") Long customerId) {
		return wrapperService.updateAllCustomerInfo (wrapper, customerId);
	}
	
	@ApiOperation(value = "Add customer ",response = Wrapper.class,tags=" Add customer")
	@PostMapping("/add")
	public Wrapper addNewCustomerInfo(@RequestBody Wrapper wrapper) {
		return wrapperService.addNewCustomerInfo (wrapper);
	}

	@ApiOperation(value = "delete customer",response = Wrapper.class,tags=" delete customer")
	 @DeleteMapping("/delete/{id}")
	 public String deleteCustomer(@PathVariable("id") Long customerId ) {
		  return wrapperService.deleteCustomer (customerId);
	 }




}
