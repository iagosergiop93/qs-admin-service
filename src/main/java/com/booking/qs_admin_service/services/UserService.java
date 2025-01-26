package com.booking.qs_admin_service.services;

import com.booking.qs_admin_service.domain.organizations.repositories.OrganizationRepository;
import com.booking.qs_admin_service.domain.users.User;
import com.booking.qs_admin_service.domain.users.repositories.UserRepository;
import com.booking.qs_admin_service.dtos.Error;
import com.booking.qs_admin_service.dtos.ErrorType;
import com.booking.qs_admin_service.dtos.Response;
import com.booking.qs_admin_service.dtos.users.CreateUserRequest;
import com.booking.qs_admin_service.dtos.users.UsersByOrgRequest;
import com.booking.qs_admin_service.dtos.users.UserResponse;
import com.booking.qs_admin_service.utils.UserUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private OrganizationRepository orgRepo;

    public Response<User> getUsersById(String id) {
        var response = new Response<User>();
        try {
            var userOptional = userRepo.findById(id);
            userOptional.ifPresentOrElse(
                    user -> response.with(user),
                    () -> response.addError(new Error("400", "No data found", ErrorType.INFO))
            );
            response.withSuccess(true);
        } catch (Exception e) {
            response
                    .withSuccess(false)
                    .addError(new Error("500", e.getMessage()));
        }
        return response;
    }

    public Response<User> getUserByUsername(String username) {
        var response = new Response<User>();
        try {
            var userOptional = userRepo.findByUsername(username);
            userOptional.ifPresentOrElse(
                    user -> response.with(user),
                    () -> response.addError(new Error("400", "No data found", ErrorType.INFO))
            );
            response.withSuccess(true);
        } catch (Exception e) {
            response
                    .withSuccess(false)
                    .addError(new Error("500", e.getMessage()));
        }
        return response;
    }

    @Transactional
    public Response<User> createNewUser(CreateUserRequest request) {
        var response = new Response<User>();
        try {
            var orgExists = orgRepo.existsById(request.getOrgId());
            if(!orgExists) {
                return response
                        .withSuccess(false)
                        .addError(
                                new Error("400", "Invalid Organization")
                        );
            }
            var userAlreadyExists = userRepo.existsById(request.getUserId());
            if(userAlreadyExists) {
                return response
                        .withSuccess(false)
                        .addError(
                                new Error("400", "A user with this id already exists")
                        );
            }
            var user = UserUtils.createUser(request);
            user.setNew(true);
            user = userRepo.save(user);
            response
                    .withSuccess(true)
                    .with(user);
        } catch (Exception e) {
            response
                    .withSuccess(false)
                    .addError(
                            new Error("500", e.getMessage())
                    );
        }
        return response;
    }

    public Response<List<UserResponse>> getUsersByOrg(UsersByOrgRequest request) {
        var response = new Response<List<UserResponse>>();
        try {
            var userList = userRepo.findByOrg(request.getOrgId());
            response
                    .with(userList)
                    .withSuccess(true);
        } catch (Exception e) {
            response
                    .withSuccess(false)
                    .addError(
                            new Error("500", "Server Error")
                    );
        }
        return response;
    }
}
