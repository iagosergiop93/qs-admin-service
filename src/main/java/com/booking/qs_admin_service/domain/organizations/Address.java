package com.booking.qs_admin_service.domain.organizations;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.Instant;

@Data
@Embeddable
public class Address {
    private String street1;
    private String street2;
    private String zipCode;
    private String city;
    private String state;
    private String country;
}
