package com.estudo.ClientApi.domain.ports.input;

import com.estudo.ClientApi.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface IFindCustomerUseCase {
    Optional<Customer> getCustomerById(Long id);

    List<Customer> getCustomersAll();

}
