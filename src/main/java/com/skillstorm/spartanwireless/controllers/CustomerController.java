package com.skillstorm.spartanwireless.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spartanwireless.dtos.CustomerRequestDto;
import com.skillstorm.spartanwireless.dtos.CustomerResponseDto;
import com.skillstorm.spartanwireless.services.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        return new ResponseEntity<>(customerService.createCustomer(customerRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllActiveCustomers() {
        return new ResponseEntity<>(customerService.getAllActiveCustomers(), HttpStatus. OK);
    }

    @GetMapping("/{custId}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Long custId) {
        return new ResponseEntity<>(customerService.getCustomerById(custId), HttpStatus.OK);
    }

    @PutMapping("/{custId}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable Long custId, @RequestBody CustomerRequestDto customerRequestDto) {
        return new ResponseEntity<>(customerService.updateCustomer(custId, customerRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{custId}")
    public void deleteCustomer(@PathVariable Long custId) {
        customerService.deleteCustomerById(custId);
    }
    
}
