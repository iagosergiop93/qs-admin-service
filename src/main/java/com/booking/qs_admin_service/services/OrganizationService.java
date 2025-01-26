package com.booking.qs_admin_service.services;

import com.booking.qs_admin_service.domain.organizations.Organization;
import com.booking.qs_admin_service.domain.organizations.repositories.OrganizationRepository;
import com.booking.qs_admin_service.dtos.Error;
import com.booking.qs_admin_service.dtos.ErrorType;
import com.booking.qs_admin_service.dtos.Response;
import com.booking.qs_admin_service.dtos.organization.CreateOrganizationRequest;
import com.booking.qs_admin_service.utils.OrganizationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository orgRepo;

    public Response<Organization> getOrganizationById(String orgId) {
        var response = new Response<Organization>();
        try {
            var orgOptional = orgRepo.findById(orgId);
            orgOptional.ifPresentOrElse(
                    response::with,
                    () -> response.addError(new Error("400", "No data found", ErrorType.INFO))
            );
            response.withSuccess(true);
        } catch (Exception e) {
            response
                    .withSuccess(false)
                    .addError(
                            new Error("500", e.getMessage())
                    );
        }
        return response;
    }

    public Response<Organization> createNewOrg(CreateOrganizationRequest request) {
        var response = new Response<Organization>();
        try {
            var org = OrganizationUtils.createOrganization(request);
            assert org.getId() != null;
            var alreadyExists = orgRepo.existsById(org.getId());
            if(alreadyExists) {
                response
                        .withSuccess(false)
                        .addError(new Error("400", "Organization already exists"));
            }
            else {
                org.setNew(true);
                var result = orgRepo.save(org);
                response
                        .with(result)
                        .withSuccess(true);
            }
        } catch (Exception e) {
            response.withSuccess(false)
                    .addError(
                            new Error("500", e.getMessage())
                    );
        }
        return response;
    }
}
