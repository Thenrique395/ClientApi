package com.estudo.ClientApi.utils.mappers;

import com.estudo.ClientApi.adapters.input.rest.dto.CustomerDTO;
import com.estudo.ClientApi.adapters.output.persistence.entities.CustomerEntity;
import com.estudo.ClientApi.domain.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ArrayList<Customer> toListDomain(List<CustomerEntity> customersEntity) {
        if (customersEntity.isEmpty())
            return new ArrayList<Customer>();

        return customersEntity.stream()
                .map(CustomerMapper::toDomain).collect(Collectors.toCollection(ArrayList::new));
    }

    public static CustomerDTO toDto(Customer customer) {
        if (customer == null)
            return null;

        return new CustomerDTO(customer.getName(), customer.getEmail(), 1, LocalDate.of(1991, 2, 3), null);
    }

    public static ArrayList<CustomerDTO> toListDto(List<Customer> customers) {
        if (customers.isEmpty())
            return new ArrayList<CustomerDTO>();

        return customers.stream()
                .map(CustomerMapper::toDto).collect(Collectors.toCollection(ArrayList::new));
    }

    public static Customer toDomain(CustomerDTO customerDTO) {
        if (customerDTO == null)
            return null;

        return new Customer(customerDTO.name(), customerDTO.email());
    }
}
