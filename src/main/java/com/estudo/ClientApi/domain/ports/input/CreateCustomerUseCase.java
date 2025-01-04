package com.estudo.ClientApi.domain.ports.input;

import com.estudo.ClientApi.domain.model.Customer;

public interface CreateCustomerUseCase {

    Customer execute(Customer customer);
}
