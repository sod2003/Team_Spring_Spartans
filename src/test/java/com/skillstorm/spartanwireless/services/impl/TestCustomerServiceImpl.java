package com.skillstorm.spartanwireless.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.repositories.TestCustomerRepo;
import com.skillstorm.spartanwireless.services.CustomerService;

public class TestCustomerServiceImpl {

    CustomerService cs;
    List<Customer> customers;

    @BeforeAll
    public void init() {
        // TODO Create a customers list
        cs = new CustomerServiceImpl(new TestCustomerRepo());
    }
    
    @Test
    public void TestCreateCustomer() {
        cs.createCustomer(null); // TODO Implement createCustomer Test.
        assertEquals(getClass(), getClass());
    }

    @Test
    public void TestGetAllCustomers() {
        // TODO Create a test for Service's getAllCustomers method
    }

    @Test
    public void TestGetAllActiveCustomers() {
        // TODO Create a test for Service's getAllActiveCustomers method
    }

    @Test
    public void TestGetCustomerById() {
        // TODO Create test for Service's getCustomerById method
    }
    
    @Test
    public void TestUpdateCustomer() {
        // TODO Create test for Repo's updateCustomer method
    }

    @Test
    public void TestDeleteCustomerById() {
        // TODO Create test for Service's deleteCustomerById method
        // Remember to use isArchived functionality
    }
}