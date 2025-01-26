package com.booking.qs_admin_service.utils;

import com.booking.qs_admin_service.domain.organizations.Organization;
import com.booking.qs_admin_service.domain.users.Role;
import com.booking.qs_admin_service.domain.users.User;
import com.booking.qs_admin_service.dtos.users.CreateUserRequest;

public class UserUtils {

    public static User createUser(CreateUserRequest request) {
        var user = new User();
        user.setId(request.getUserId());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        if(request.getRoleId() != null) {
            Role role = new Role();
            role.setRoleId(request.getRoleId());
            user.setRole(role);
        }
        if(request.getOrgId() != null) {
            Organization org = new Organization();
            org.setId(request.getOrgId());
            user.setOrganization(org);
        }

        return user;
    }
}
