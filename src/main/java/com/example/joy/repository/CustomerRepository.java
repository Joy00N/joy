package com.example.joy.repository;

import com.example.joy.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigInteger;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customers", path = "/customers")
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findById(BigInteger id);
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
