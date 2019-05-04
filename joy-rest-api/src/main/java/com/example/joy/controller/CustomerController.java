package main.java.com.example.joy.controller;

import com.example.joy.model.Customer;
import com.example.joy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<Customer> getAllCustomers() {
        List<Customer> result = customerService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") String id) {
        return customerService.findById(id);
    }

    @GetMapping("/{fName}")
    public List<Customer> getCustomerByFirstName(@PathVariable("fName") String fname) {
        return customerService.findByFirstName(fname);
    }

    @GetMapping("/{lName}")
    public List<Customer> getCustomerByLastName(@PathVariable("lName") String lname) {
        return customerService.findByLastName(lname);
    }

    @PostMapping
    public void create(@Valid @RequestBody Customer customer) {
        customerService.saveOrUpdateCustomer(customer);
    }

    @DeleteMapping
    public void deleteCustomer(@PathVariable String  id) {
        customerService.deleteCustomer(id);
    }
}
