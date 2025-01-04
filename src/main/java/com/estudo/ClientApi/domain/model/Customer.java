package com.estudo.ClientApi.domain.model;

import lombok.*;

@Getter
@Setter
public class Customer {
    public Customer(String email, String name) {
        this.email = email;
        this.name = name;
    }

    // Construtor sem parâmetros
    public Customer() {
        this.name = null;
        this.email = null;
    }

    private final String name;
    private final String email;
}
