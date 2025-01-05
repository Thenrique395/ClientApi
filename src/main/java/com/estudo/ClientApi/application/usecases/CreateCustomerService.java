package com.estudo.ClientApi.application.usecases;

import com.estudo.ClientApi.domain.model.Customer;
import com.estudo.ClientApi.domain.ports.input.ICreateCustomerUseCase;
import com.estudo.ClientApi.domain.ports.output.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService implements ICreateCustomerUseCase {

    private final CustomerRepository customerRepository;

    public CreateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer execute(Customer customer) {
        return customerRepository.save(customer);
    }
}
