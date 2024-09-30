package org.voting_app.voting_app.exceptions;

public class ListIsEmptyException extends RuntimeException {
    public ListIsEmptyException(String message) {
        super(message);
    }
}
