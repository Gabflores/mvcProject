package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Customer saveCustomer(Customer customer);

    Optional<Customer> getCustomer(String email);

    List<Customer> getCustomers();
}
