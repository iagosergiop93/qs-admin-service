package com.booking.qs_admin_service.domain.organizations.repositories;

import com.booking.qs_admin_service.domain.organizations.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,String> {
}
