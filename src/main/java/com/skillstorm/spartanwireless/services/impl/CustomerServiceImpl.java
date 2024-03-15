package com.skillstorm.spartanwireless.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spartanwireless.dtos.CustomerRequestDto;
import com.skillstorm.spartanwireless.dtos.CustomerResponseDto;
import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.repositories.CustomerRepository;
import com.skillstorm.spartanwireless.services.CustomerService;

import static com.skillstorm.spartanwireless.mappers.CustomerMapper.mapToCustomer;
import static com.skillstorm.spartanwireless.mappers.CustomerMapper.mapToCustomerResponseDto;;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository cr) {
        customerRepository = cr;
    }

    /*
     * Type is completely known from custom mappers, 
     * you will see that we have checked this for every
     * api. We are suppressing warnings. The input from the
     * request are validated, then they are funnelled through
     * our custom wrappers that are EXPLICITYLY TYPED. Or,
     * in the case when there are no dtos (just id's) the EXACT
     * type from the controller down the api is ensured.
     * For the sake of being concise, we are not using Generic
     * types which would need explicit null checks. 
     */
    @SuppressWarnings("null")
    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        return mapToCustomerResponseDto(customerRepository.save(mapToCustomer(customerRequestDto)));
    }

    @Override
    public List<CustomerResponseDto> getAllActiveCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().filter(customer -> customer.isArchived() != true).map(customer -> mapToCustomerResponseDto(customer)).collect(Collectors.toList());
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> mapToCustomerResponseDto(customer)).collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public CustomerResponseDto getCustomerById(Long custId) {
        return mapToCustomerResponseDto(customerRepository.findById(custId).get());
    }

    @Override
    public CustomerResponseDto updateCustomer(Long custId, CustomerRequestDto customerRequestDto) {
        Customer customer = mapToCustomer(customerRequestDto);
        customer.setCustId(custId);
        return mapToCustomerResponseDto(customerRepository.save(customer));
    }

    @SuppressWarnings("null")
    @Override
    public String deleteCustomerById(Long custId) {
        Customer customer = customerRepository.findById(custId).get();
        customer.setArchived(true);
        customerRepository.save(customer);
        return "archived";
    }

    
    
}
