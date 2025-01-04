package com.estudo.ClientApi.adapters.input.rest.dto;

import java.time.LocalDate;
import java.util.List;

public record CustomerDTO(
        String name,
        String email,
        int age,
        LocalDate dateOfBirth,
        List<AddressDTO> addresses
) {}