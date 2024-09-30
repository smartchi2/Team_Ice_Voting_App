package org.voting_app.voting_app.exceptions;

public class OnlyThreeCandidatesAreAllowedException extends RuntimeException {
    public OnlyThreeCandidatesAreAllowedException(String message) {
        super(message);
    }
}
