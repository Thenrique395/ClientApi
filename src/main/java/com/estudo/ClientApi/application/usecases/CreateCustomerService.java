package com.estudo.ClientApi.application.usecases;

import com.estudo.ClientApi.domain.model.Customer;
import com.estudo.ClientApi.domain.ports.input.CreateCustomerUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService implements CreateCustomerUseCase {
    @Override
    public Customer execute(Customer customer) {
        return null;
    }
}
