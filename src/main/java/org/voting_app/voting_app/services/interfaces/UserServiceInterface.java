package org.voting_app.voting_app.services.interfaces;

import org.voting_app.voting_app.dtos.request.FindUserByIdRequest;
import org.voting_app.voting_app.dtos.request.LogOutUserRequest;
import org.voting_app.voting_app.dtos.request.LoginUserRequest;
import org.voting_app.voting_app.dtos.request.RegisterUserRequest;
import org.voting_app.voting_app.dtos.response.FindUserByIdResponse;
import org.voting_app.voting_app.dtos.response.LogOutUserResponse;
import org.voting_app.voting_app.dtos.response.LoginUserResponse;
import org.voting_app.voting_app.dtos.response.RegisterUserResponse;

public interface UserServiceInterface {
    RegisterUserResponse registerUserResponse(RegisterUserRequest registerUserRequest);
    LoginUserResponse loginUserResponse(LoginUserRequest loginUserRequest);
    LogOutUserResponse logOutUserResponse(LogOutUserRequest logOutUserRequest);
    FindUserByIdResponse findUserByIdResponse(FindUserByIdRequest findUserByIdRequest);
}
