package com.megshan.immiportalservice.domain;

import lombok.Data;

@Data
public class Address {

    private String street1;
    private String street2;
    private String city;
    private String state;
    private Long zip;
    private String country;
}
