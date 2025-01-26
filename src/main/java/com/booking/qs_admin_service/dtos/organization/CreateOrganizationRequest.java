package com.booking.qs_admin_service.dtos.organization;

import com.booking.qs_admin_service.domain.organizations.Address;
import lombok.Data;

@Data
public class CreateOrganizationRequest {
    private String orgId;
    private String name;
    private String description;
    private Address address;
}
