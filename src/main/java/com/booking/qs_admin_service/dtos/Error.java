package com.booking.qs_admin_service.dtos;

import lombok.Data;

@Data
public class Error {
    private String code;
    private String description;
    private ErrorType errorType = ErrorType.ERROR;

    public Error(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Error(String code, String description, ErrorType errorType) {
        this.code = code;
        this.description = description;
        this.errorType = errorType;
    }
}
