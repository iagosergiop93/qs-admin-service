package com.booking.qs_admin_service.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    private String roleId;
    private String name;

    @JsonIgnore
    private Instant createdAt;
    @JsonIgnore
    private Instant updatedAt;
}
