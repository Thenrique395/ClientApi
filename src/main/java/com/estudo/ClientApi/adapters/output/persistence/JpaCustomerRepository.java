package com.estudo.ClientApi.adapters.output.persistence;

import com.estudo.ClientApi.adapters.output.persistence.entities.CustomerEntity;
import com.estudo.ClientApi.domain.model.Customer;
import com.estudo.ClientApi.domain.ports.output.CustomerRepository;
import com.estudo.ClientApi.utils.mappers.CustomerMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaCustomerRepository  implements CustomerRepository {

    private final  SpringDataCustomerRepository springDataCustomerRepository;
    private final CustomerMapper customerMapper;

    public JpaCustomerRepository(SpringDataCustomerRepository springDataCustomerRepository, CustomerMapper customerMapper) {
        this.springDataCustomerRepository = springDataCustomerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = customerMapper.toEntity(customer);
        return  customerMapper.toDomain(springDataCustomerRepository.save(entity));
    }

    @Override
    public Optional<Customer> findById(Long id) {
        var custumer = springDataCustomerRepository.findById(id);

        return  null;
    }

    @Override
    public void deleteById(Long id) {
 springDataCustomerRepository.deleteById(id);
    }
}
