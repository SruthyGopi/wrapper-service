package com.example.wrapper.service.wrapperservice;


import com.example.wrapper.service.wrapperservice.model.CustomerBasics;
import com.example.wrapper.service.wrapperservice.model.CustomerDetails;
import com.example.wrapper.service.wrapperservice.model.Wrapper;
import com.example.wrapper.service.wrapperservice.service.WrapperService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class WrapperServiceControllerTest
{

  final String getExpected = "{\"customerDetails\": { \"customerId\": 1,\"address\": \"IND\",\"phoneNo\": \"987666\"},\n" +
                             "    \"customerBasics\": {\"customerId\": 1, \"firstName\": \"Sruthy\",\"surName\": \"pg\",\"dateOfBirth\": \"20/02/2020\"}}";
  @Autowired
  private MockMvc mockMvc;


  @MockBean
  private WrapperService wrapperService;


  @Test
  void getCustomerInfoById() throws Exception
  {
    CustomerBasics customerBasics = new CustomerBasics();
    CustomerDetails customerDetails = new CustomerDetails();
    Wrapper wrapper = new Wrapper();
    customerBasics.setCustomerId(1L);
    customerBasics.setFirstName("Sruthy");
    customerBasics.setSurName("pg");
    customerBasics.setDateOfBirth("20/02/2020");
    customerDetails.setCustomerId(1L);
    customerDetails.setAddress("IND");
    customerDetails.setPhoneNo("987666");
    customerDetails.setEmail("sruthy@gmail.com");
    wrapper.setCustomerBasics(customerBasics);
    wrapper.setCustomerDetails(customerDetails);
    Mockito.when(wrapperService.getCustomerInfoById(Mockito.anyLong())).thenReturn(wrapper);
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
            "/wrapperservice/1").accept(
            MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse());
    JSONAssert.assertEquals(getExpected, result.getResponse()
            .getContentAsString(), false);
  }
}