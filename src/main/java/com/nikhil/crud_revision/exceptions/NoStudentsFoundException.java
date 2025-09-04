package com.nikhil.crud_revision.exceptions;

public class NoStudentsFoundException extends RuntimeException {
    public NoStudentsFoundException() {
        super("No students found");
    }
}
