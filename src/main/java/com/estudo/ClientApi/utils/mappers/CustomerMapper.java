package com.estudo.ClientApi.utils.mappers;

import com.estudo.ClientApi.adapters.input.rest.dto.AddressDTO;
import com.estudo.ClientApi.adapters.input.rest.dto.CustomerDTO;
import com.estudo.ClientApi.adapters.output.persistence.entities.CustomerEntity;
import com.estudo.ClientApi.domain.model.Customer;

import java.time.LocalDate;
import java.util.List;

public class CustomerMapper {

    public static CustomerEntity toEntity(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerEntity entity = new CustomerEntity();
        entity.setId(customer.getId());
        entity.setName(customer.getName());
        entity.setEmail(customer.getEmail());
        return entity;
    }

    /*Converte de entidade do banco para dominio */
    public static Customer toDomain(CustomerEntity customerEntity) {
        if (customerEntity == null)
            return null;

        return new Customer(customerEntity.getId(), customerEntity.getName(), customerEntity.getEmail());
    }

    /*Converte dominio para DTO*/
    public static CustomerDTO toDto(Customer customer) {
        if (customer == null)
            return null;

        return  new CustomerDTO(customer.getName(), customer.getEmail(), 1, LocalDate.of(1991, 02, 03), null);
    }

    /*Converte de Dto para dominio */
    public static Customer toDomain(CustomerDTO customerDTO) {
        if (customerDTO == null)
            return null;

        return new Customer(customerDTO.name(), customerDTO.email());
    }
}
