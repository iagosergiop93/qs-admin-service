package com.booking.qs_admin_service.utils;

import com.booking.qs_admin_service.domain.organizations.Organization;
import com.booking.qs_admin_service.dtos.organization.CreateOrganizationRequest;

public class OrganizationUtils {

    public static Organization createOrganization(CreateOrganizationRequest request) {
        var org = new Organization();
        org.setId(request.getOrgId());
        org.setName(request.getName());
        org.setDescription(request.getDescription());
        org.setAddress(request.getAddress());

        return org;
    }
}
