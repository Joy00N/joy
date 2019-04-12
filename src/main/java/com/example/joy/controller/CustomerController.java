package com.example.joy.controller;

import com.example.joy.model.Customer;
import com.example.joy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerByFirstName(@PathVariable("id") String id) {
        return customerRepository.findByFirstName(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Customer create(@Valid @RequestBody Customer customer) {
        customer.setFirstName(customer.getFirstName());
        customerRepository.save(customer);
        return customer;
    }
}
