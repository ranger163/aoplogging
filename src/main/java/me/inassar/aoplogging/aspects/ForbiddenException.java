package me.inassar.aoplogging.aspects;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(final String message) {
        super(message);
    }
}