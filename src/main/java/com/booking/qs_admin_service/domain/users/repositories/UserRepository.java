package com.booking.qs_admin_service.domain.users.repositories;

import com.booking.qs_admin_service.domain.users.User;
import com.booking.qs_admin_service.dtos.users.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);

    @Query(value = "Select id,username,email,firstName,lastName,organization_id,role_roleId from users u where u.organization_id = :orgId", nativeQuery = true)
    List<UserResponse> findByOrg(@Param("orgId") String orgId);
}
