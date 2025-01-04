package com.estudo.ClientApi.domain.ports.output;


import com.estudo.ClientApi.domain.model.Customer;

import java.util.Optional;

public interface CustomerRepository {
     Customer save(Customer customer);
     Optional<Customer> findById(Long Id);
     void deleteById(Long id);
}
