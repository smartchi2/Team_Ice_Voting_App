package org.voting_app.voting_app.exceptions;

public class IncompleteRequestException extends RuntimeException {
    public IncompleteRequestException(String message) {
        super(message);
    }
}
