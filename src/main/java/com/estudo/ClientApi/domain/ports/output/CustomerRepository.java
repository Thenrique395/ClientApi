package com.estudo.ClientApi.domain.ports.output;


import com.estudo.ClientApi.adapters.output.persistence.entities.CustomerEntity;
import com.estudo.ClientApi.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
     Customer save(Customer customer);
     Optional<Customer> findById(Long Id);
     List<Customer> findAll();

     void deleteById(Long id);
}
