package org.voting_app.voting_app.exceptions;

public class UserNotAllowedToVoteException extends RuntimeException{
    public UserNotAllowedToVoteException(String message){
        super(message);
    }
}
