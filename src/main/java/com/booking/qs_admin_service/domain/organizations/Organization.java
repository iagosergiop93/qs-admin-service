package com.booking.qs_admin_service.domain.organizations;

import com.booking.qs_admin_service.domain.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "organizations")
public class Organization extends AbstractEntity<String> {
    @Id
    private String id;

    private String name;

    private String description;

    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id);
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
