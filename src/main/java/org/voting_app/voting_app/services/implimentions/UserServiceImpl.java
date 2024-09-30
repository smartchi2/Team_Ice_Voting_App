package org.voting_app.voting_app.services.implimentions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voting_app.voting_app.dtos.request.*;
import org.voting_app.voting_app.dtos.response.*;
import org.voting_app.voting_app.data.model.User;
import org.voting_app.voting_app.data.repositories.UserRepository;
import org.voting_app.voting_app.services.interfaces.UserServiceInterface;
import org.voting_app.voting_app.exceptions.*;
import org.voting_app.voting_app.util.RegistrationNumber;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUserResponse(RegisterUserRequest registerUserRequest) {
        User user = new User();
        validateEmailIfExist(registerUserRequest.getEmail());
        validateEmail(registerUserRequest.getEmail());
        validatePhoneNumber(registerUserRequest.getPhoneNumber());
        validatePassword(registerUserRequest.getPassword());
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setEmail(registerUserRequest.getEmail());
        user.setPhoneNumber(registerUserRequest.getPhoneNumber());
        user.setPassword(registerUserRequest.getPassword());
        user.setAddress(registerUserRequest.getAddress());
        user.setNationality(registerUserRequest.getNationality());
        user.setDateOfBirth(registerUserRequest.getDateOfBirth());
        user.setProfession(registerUserRequest.getProfession());
        user.setReligion(registerUserRequest.getReligion());
        user.setStateOfOrigin(registerUserRequest.getStateOfOrigin());
        user.setGender(registerUserRequest.getGender());
        user.setAge(registerUserRequest.getAge());
        user.setRegistrationNumber(RegistrationNumber.generateUserRegistrationNumber());
        user.setRole(registerUserRequest.getRole());
        if (user.getFirstName().isEmpty()||user.getLastName().isEmpty()||user.getEmail().isEmpty()||
                user.getPhoneNumber().isEmpty()||user.getAddress().isEmpty()||user.getNationality().isEmpty()
                ||user.getDateOfBirth().isEmpty()||user.getProfession().isEmpty()||user.getReligion().isEmpty()
                ||user.getStateOfOrigin().isEmpty()||user.getPassword().isEmpty()||user.getGender().isEmpty()||
                user.getAge()==0||user.getRole().isEmpty())
        {
            throw new IncompleteRequestException("Incomplete Request");
        }
//        if(user.getRole().equals("admin")){
//
//        }
//        if(user.getRole().equals("voter")){
//            return registerUserResponse("User "
//        }
        if (user.getAge()<18){
            throw new UserNotAllowedToVoteException("User not allowed to vote");
        }
        userRepository.save(user);
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setId(user.getId());
        registerUserResponse.setRegistrationNumber(user.getRegistrationNumber());
        registerUserResponse.setMessage("User Registered Successfully");
        return registerUserResponse;
    }

    private void validatePassword(String password) {
        if (password.length()!=6){
            throw new InvalidPhoneNumberException("InvalidPassword");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            throw new InvalidPasswordException("Invalid Password");
        }
    }

    private void validateEmail(String email) {
        int counter = 0;
        for(int count = 0; count < email.length(); count++) {
            if (email.charAt(count) == '@') {
                counter++;
            }
        }
        if (counter != 1) {
            throw new InvalidEmailException("Invalid Email");
        }
    }

    private void validateEmailIfExist(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isPresent()){
            throw new UserAlreadyExistException("User Already Exist");
        }
    }

    @Override
    public LoginUserResponse loginUserResponse(LoginUserRequest loginUserRequest) {
        User user = userRepository.findUserByEmail(loginUserRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        loginUserRequest.setEmail(user.getEmail());
        loginUserRequest.setPassword(user.getPassword());
        userRepository.save(user);
        LoginUserResponse loginUserResponse = new LoginUserResponse();
        loginUserResponse.setId(user.getId());
        loginUserResponse.setMessage("User LoggedIn Successfully");
        return loginUserResponse;
    }

    @Override
    public LogOutUserResponse logOutUserResponse(LogOutUserRequest logOutUserRequest) {
        User user = userRepository.findUserById(logOutUserRequest.getId())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        LogOutUserResponse logOutUserResponse = new LogOutUserResponse();
        logOutUserResponse.setId(user.getId());
        logOutUserResponse.setMessage("User Logged Out Successfully");
        return logOutUserResponse;
    }

    @Override
    public FindUserByIdResponse findUserByIdResponse(FindUserByIdRequest findUserByIdRequest) {
        User user = userRepository.findUserById(findUserByIdRequest.getId())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        FindUserByIdResponse findUserByIdResponse = new FindUserByIdResponse();
        findUserByIdResponse.setId(user.getId());
        findUserByIdResponse.setMessage("User Found Successfully");
        return findUserByIdResponse;
    }

    @Override
    public FindAllUserResponse findAllUserResponse(FindAllUserRequest findAllUserRequest) {
        List<User> listOfUsers = userRepository.findAll();
        FindAllUserResponse findAllUserResponse = new FindAllUserResponse();
        if(!listOfUsers.isEmpty()){
            User user = listOfUsers.get(listOfUsers.size() - 1);
            findAllUserResponse.setMessage("Users Found Successfully");
            return findAllUserResponse;
        }
        else {
            throw new ListIsEmptyException("List Is Empty");
        }
    }
}
