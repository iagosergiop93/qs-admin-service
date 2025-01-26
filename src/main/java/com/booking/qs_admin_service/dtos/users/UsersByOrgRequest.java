package com.booking.qs_admin_service.dtos.users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersByOrgRequest {
    private String orgId;

    public UsersByOrgRequest(String orgId) {
        this.orgId = orgId;
    }
}
