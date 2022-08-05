package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Guardando un nuevo cliente {} en la base de datos", customer.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomer(String email) {
        log.info("Buscando cliente {} en la base de datos", email);
        return Optional.ofNullable(customerRepository.findByEmail(email));
    }

    @Override
    public List<Customer> getCustomers() {
        log.info("Buscando todos los clientes de la base de datos");
        return customerRepository.findAll();
    }
}
