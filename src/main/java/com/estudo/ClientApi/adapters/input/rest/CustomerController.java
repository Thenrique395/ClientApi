package com.estudo.ClientApi.adapters.input.rest;

import com.estudo.ClientApi.adapters.input.rest.dto.CustomerDTO;
import com.estudo.ClientApi.domain.model.Customer;
import com.estudo.ClientApi.domain.ports.input.CreateCustomerUseCase;
import com.estudo.ClientApi.utils.mappers.CustomerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final CustomerMapper customerMapper;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase, CustomerMapper customerMapper) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> CreateCustomer(@RequestBody CustomerDTO customerDTO) {

        Customer customer = CustomerMapper.toDomain(customerDTO);
        var createdCustomer = createCustomerUseCase.execute(customer);
        return ResponseEntity.ok(CustomerMapper.toDto(createdCustomer));

    }
}
