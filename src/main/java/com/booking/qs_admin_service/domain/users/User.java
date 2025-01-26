package com.booking.qs_admin_service.domain.users;

import com.booking.qs_admin_service.domain.AbstractEntity;
import com.booking.qs_admin_service.domain.organizations.Organization;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "users")
public class User extends AbstractEntity<String> {
    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String firstName;

    private String lastName;

    @ManyToOne(optional = false)
    private Organization organization;

    @ManyToOne(optional = false)
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String getId() {
        return id;
    }
}
