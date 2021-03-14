package com.ozgur.bookstore.request.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdressRequest {

    private String city;
    private String street;
    private int zipcode;

}
