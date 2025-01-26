package com.booking.qs_admin_service.dtos.users;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String orgId;
    private String userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String roleId;
}
