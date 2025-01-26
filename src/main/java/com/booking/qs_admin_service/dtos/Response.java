package com.booking.qs_admin_service.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Response<T> {
    private T data;
    private boolean success;
    private List<Error> errors = new ArrayList<>();

    public Response<T> with(T data) {
        this.setData(data);
        return this;
    }

    public Response<T> withSuccess(boolean success) {
        this.setSuccess(success);
        return this;
    }

    public Response<T> addError(Error error) {
        this.errors.add(error);
        return this;
    }
}
