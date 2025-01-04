package com.estudo.ClientApi.adapters.input.rest.dto;

public record AddressDTO(
        String street,
        String city,
        String state,
        String postalCode,
        String country
) {}