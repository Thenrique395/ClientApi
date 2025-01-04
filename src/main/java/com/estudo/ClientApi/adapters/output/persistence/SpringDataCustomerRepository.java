package com.estudo.ClientApi.adapters.output.persistence;

import com.estudo.ClientApi.adapters.output.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
