package main.java.com.example.joy.controller;

import com.example.joy.model.Customer;
import com.example.joy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
    public Customer getCustomerByFirstName(@PathVariable("id") BigInteger id) {
        return customerRepository.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Customer create(@Valid @RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyCustomerById(@PathVariable("id") BigInteger id, @Valid @RequestBody Customer customer) {
        customer.setId(id);
        customerRepository.save(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable BigInteger id) {
        customerRepository.delete(customerRepository.findById(id));
    }
}
