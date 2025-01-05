package com.estudo.ClientApi.application.usecases;

import com.estudo.ClientApi.domain.model.Customer;
import com.estudo.ClientApi.domain.ports.input.IFindCustomerUseCase;
import com.estudo.ClientApi.domain.ports.output.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FindCustomerUseCase implements IFindCustomerUseCase {

    private final CustomerRepository customerRepository;

    public FindCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getCustomersAll() {
        var customers = customerRepository.findAll();

        return customers != null ? customers : new ArrayList<Customer>();
    }
}

