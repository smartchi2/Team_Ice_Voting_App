package org.voting_app.voting_app.exceptions;

public class CandidateAlreadyExistsException extends RuntimeException{
    public CandidateAlreadyExistsException(String message){
        super(message);
    }
}
