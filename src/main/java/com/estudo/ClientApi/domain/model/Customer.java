package com.estudo.ClientApi.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Customer {
    private final String name;
    private final String email;
}
