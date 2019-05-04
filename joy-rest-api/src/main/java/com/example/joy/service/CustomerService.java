package com.example.joy.service;

import com.example.joy.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(String id);
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    void saveOrUpdateCustomer(Customer customer);
    void deleteCustomer(String id);

}
