package com.booking.qs_admin_service.controllers;

import com.booking.qs_admin_service.domain.users.User;
import com.booking.qs_admin_service.dtos.Response;
import com.booking.qs_admin_service.dtos.users.CreateUserRequest;
import com.booking.qs_admin_service.dtos.users.UsersByOrgRequest;
import com.booking.qs_admin_service.dtos.users.UserResponse;
import com.booking.qs_admin_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users/{id}")
    public Response<User> getUserById(@PathVariable String id) {
        return userService.getUsersById(id);
    }

    @GetMapping("/api/users/username/{username}")
    public Response<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/api/users/organization/{orgId}")
    public Response<List<UserResponse>> listUsersByOrganization(@PathVariable String orgId) {
        var request = new UsersByOrgRequest(orgId);
        return userService.getUsersByOrg(request);
    }

    @PostMapping("/api/users/create")
    public Response<User> createNewUser(@RequestBody CreateUserRequest request) {
        return userService.createNewUser(request);
    }

}
