package com.ozgur.bookstore.request.customer;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"name","lastName","gender","address","contact"})
public class CustomerRequest {

    private String name;
    private String lastName;
    private String identificationNumber;

    private AdressRequest address;
    private ContactRequest contact;
}
