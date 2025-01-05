package com.estudo.ClientApi.adapters.output.persistence;

import com.estudo.ClientApi.adapters.output.persistence.entities.CustomerEntity;
import com.estudo.ClientApi.domain.model.Customer;
import com.estudo.ClientApi.domain.ports.output.CustomerRepository;
import com.estudo.ClientApi.utils.mappers.CustomerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCustomerRepository implements CustomerRepository {

    private final SpringDataCustomerRepository springDataCustomerRepository;
    private final CustomerMapper customerMapper;

    public JpaCustomerRepository(SpringDataCustomerRepository springDataCustomerRepository, CustomerMapper customerMapper) {
        this.springDataCustomerRepository = springDataCustomerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = CustomerMapper.toEntity(customer);
        return CustomerMapper.toDomain(springDataCustomerRepository.save(entity));
    }

    @Override
    public Optional<Customer> findById(Long id) {
        var customerEntity = springDataCustomerRepository.findById(id);
        Optional<Customer> optionalCustomer = customerEntity
                .map(entity -> new Customer(entity.getName(), entity.getEmail()));

        return optionalCustomer;
    }

    @Override
    public List<Customer> findAll() {
        var customerEntity = springDataCustomerRepository.findAll();
        return CustomerMapper.toListDomain(customerEntity);
    }

    @Override
    public void deleteById(Long id) {
        springDataCustomerRepository.deleteById(id);
    }
}
