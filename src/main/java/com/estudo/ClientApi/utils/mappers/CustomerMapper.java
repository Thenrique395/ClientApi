package com.estudo.ClientApi.utils.mappers;

import com.estudo.ClientApi.adapters.input.rest.dto.CustomerDTO;
import com.estudo.ClientApi.adapters.output.persistence.entities.CustomerEntity;
import com.estudo.ClientApi.domain.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapper {

    public static CustomerEntity toEntity(Customer customer) {
        if (customer == null) {
            return null;
        }

        return new CustomerEntity(customer.getName(), customer.getEmail());
    }

    public static Customer toDomain(CustomerEntity customerEntity) {
        if (customerEntity == null)
            return null;

        return new Customer(customerEntity.getName(), customerEntity.getEmail());
    }

    public static CustomerDTO toDto(Customer customer) {
        if (customer == null)
            return null;

        return new CustomerDTO(customer.getName(), customer.getEmail(), 1, LocalDate.of(1991, 2, 3), null);
    }

    public static Customer toDomain(CustomerDTO customerDTO) {
        if (customerDTO == null)
            return null;

        return new Customer(customerDTO.name(), customerDTO.email());
    }
}
