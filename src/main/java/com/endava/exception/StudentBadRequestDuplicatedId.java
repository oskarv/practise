package com.endava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad request. Student already exists.")
public class StudentBadRequestDuplicatedId extends RuntimeException {

}
