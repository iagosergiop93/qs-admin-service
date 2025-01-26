package com.booking.qs_admin_service.controllers;

import com.booking.qs_admin_service.domain.organizations.Organization;
import com.booking.qs_admin_service.dtos.Response;
import com.booking.qs_admin_service.dtos.organization.CreateOrganizationRequest;
import com.booking.qs_admin_service.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService orgService;

    @GetMapping("/api/organization/{id}")
    public Response<Organization> getOrganizationById(@PathVariable String id) {
        return orgService.getOrganizationById(id);
    }

    @PostMapping("/api/organization")
    public Response<Organization> createNewOrganization(@RequestBody CreateOrganizationRequest request) {
        return orgService.createNewOrg(request);
    }
}
