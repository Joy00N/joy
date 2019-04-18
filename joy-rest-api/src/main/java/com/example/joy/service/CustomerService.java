package main.java.com.example.joy.service;

import com.example.joy.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerService extends CrudRepository<Customer, Integer> {
}
