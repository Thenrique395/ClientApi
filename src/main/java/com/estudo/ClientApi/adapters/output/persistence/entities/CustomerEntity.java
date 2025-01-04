package com.estudo.ClientApi.adapters.output.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
//@RequiredArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String name;
    private final String email;

    public CustomerEntity(String email, String name) {
        this.email = email;
        this.name = name;
    }

    // Construtor sem parâmetros
    public CustomerEntity() {
        this.name = null;
        this.email = null;
    }

}
