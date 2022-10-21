package dev.conductor.centra.domain.applicationUser.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
 
    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsException(String reason) {
        super(reason);
    }
}
