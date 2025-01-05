package com.estudo.ClientApi.adapters.input.rest;

import com.estudo.ClientApi.adapters.input.rest.dto.CustomerDTO;
import com.estudo.ClientApi.domain.exceptions.CustomerNotFoundException;
import com.estudo.ClientApi.domain.model.Customer;
import com.estudo.ClientApi.domain.ports.input.ICreateCustomerUseCase;
import com.estudo.ClientApi.domain.ports.input.IFindCustomerUseCase;
import com.estudo.ClientApi.utils.mappers.CustomerMapper;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final IFindCustomerUseCase findCustomerUseCase;
    private final ICreateCustomerUseCase ICreateCustomerUseCase;
    private final CustomerMapper customerMapper;

    public CustomerController(IFindCustomerUseCase findCustomerUseCase, ICreateCustomerUseCase ICreateCustomerUseCase, CustomerMapper customerMapper) {
        this.findCustomerUseCase = findCustomerUseCase;
        this.ICreateCustomerUseCase = ICreateCustomerUseCase;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> CreateCustomer(@RequestBody CustomerDTO customerDTO) {

            Customer customer = CustomerMapper.toDomain(customerDTO);
            var createdCustomer = ICreateCustomerUseCase.execute(customer);
            return ResponseEntity.ok(CustomerMapper.toDto(createdCustomer));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> FindCustumerById(@Parameter @RequestParam Long Id) {

            var createdCustomer = findCustomerUseCase.getCustomerById(Id);
            return ResponseEntity.ok(CustomerMapper.toDto(createdCustomer.get()));
    }
}
