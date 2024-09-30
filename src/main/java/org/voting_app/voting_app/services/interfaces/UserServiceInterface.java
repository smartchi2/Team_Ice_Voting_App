package org.voting_app.voting_app.services.interfaces;

import org.voting_app.voting_app.dtos.request.*;
import org.voting_app.voting_app.dtos.response.*;

public interface UserServiceInterface {
    RegisterUserResponse registerUserResponse(RegisterUserRequest registerUserRequest);
    LoginUserResponse loginUserResponse(LoginUserRequest loginUserRequest);
    LogOutUserResponse logOutUserResponse(LogOutUserRequest logOutUserRequest);
    FindUserByIdResponse findUserByIdResponse(FindUserByIdRequest findUserByIdRequest);
    FindAllUserResponse findAllUserResponse(FindAllUserRequest findAllUserRequest);
}
