package com.nikhil.crud_revision.exceptions;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
        super("A student already exists with email: " + email);
    }
}
