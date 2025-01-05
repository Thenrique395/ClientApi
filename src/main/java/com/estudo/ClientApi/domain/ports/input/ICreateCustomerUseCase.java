package com.estudo.ClientApi.domain.ports.input;

import com.estudo.ClientApi.domain.model.Customer;

public interface ICreateCustomerUseCase {

    Customer execute(Customer customer);
}
