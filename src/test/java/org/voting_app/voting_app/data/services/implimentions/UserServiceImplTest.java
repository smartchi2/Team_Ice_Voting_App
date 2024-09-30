package org.voting_app.voting_app.data.services.implimentions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.voting_app.voting_app.dtos.request.*;
import org.voting_app.voting_app.dtos.response.*;
import org.voting_app.voting_app.data.repositories.UserRepository;
import org.voting_app.voting_app.services.implimentions.UserServiceImpl;
import org.voting_app.voting_app.services.interfaces.UserServiceInterface;
import org.voting_app.voting_app.exceptions.UserAlreadyExistException;
import org.voting_app.voting_app.exceptions.UserNotAllowedToVoteException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testThatUserCanRegister() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("John");
        registerUserRequest.setLastName("Doe");
        registerUserRequest.setEmail("john@doe.com");
        registerUserRequest.setPassword("passwo");
        registerUserRequest.setDateOfBirth("2/2/2007");
        registerUserRequest.setAddress("Pako");
        registerUserRequest.setPhoneNumber("09087654212");
        registerUserRequest.setNationality("Nigerian");
        registerUserRequest.setProfession("Doctor");
        registerUserRequest.setStateOfOrigin("Ekiti");
        registerUserRequest.setReligion("Christian");
        registerUserRequest.setGender("Male");
        registerUserRequest.setAge(18);
        registerUserRequest.setRole("admin");
        RegisterUserResponse response = userServiceInterface.registerUserResponse(registerUserRequest);
        assertThat(response.getMessage()).isEqualTo("User Registered Successfully");
    }
    @Test
    public void testThatUserCanBeNullifiedIfAgeIssLessThan18() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("John");
        registerUserRequest.setLastName("Doe");
        registerUserRequest.setEmail("john@doe.com");
        registerUserRequest.setPassword("passwo");
        registerUserRequest.setDateOfBirth("2/2/2007");
        registerUserRequest.setAddress("Pako");
        registerUserRequest.setPhoneNumber("09087654212");
        registerUserRequest.setNationality("Nigerian");
        registerUserRequest.setProfession("Doctor");
        registerUserRequest.setStateOfOrigin("Ekiti");
        registerUserRequest.setReligion("Christian");
        registerUserRequest.setGender("Male");
        registerUserRequest.setAge(13);
        registerUserRequest.setRole("admin");
        assertThrows(UserNotAllowedToVoteException.class, () -> userServiceInterface.registerUserResponse(registerUserRequest));
    }
    @Test
    public void testThatUserCanNotRegisterTwice() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("John");
        registerUserRequest.setLastName("Doe");
        registerUserRequest.setEmail("john@doe.com");
        registerUserRequest.setPassword("passwo");
        registerUserRequest.setDateOfBirth("2/2/2007");
        registerUserRequest.setAddress("Pako");
        registerUserRequest.setPhoneNumber("09087654212");
        registerUserRequest.setNationality("Nigerian");
        registerUserRequest.setProfession("Doctor");
        registerUserRequest.setStateOfOrigin("Ekiti");
        registerUserRequest.setReligion("Christian");
        registerUserRequest.setGender("Male");
        registerUserRequest.setAge(18);
        registerUserRequest.setRole("admin");
        RegisterUserResponse response = userServiceInterface.registerUserResponse(registerUserRequest);
        assertThat(response.getMessage()).isEqualTo("User Registered Successfully");

        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        registerUserRequest1.setFirstName("John");
        registerUserRequest1.setLastName("Doe");
        registerUserRequest1.setEmail("john@doe.com");
        registerUserRequest1.setPassword("passwo");
        registerUserRequest1.setDateOfBirth("2/2/2007");
        registerUserRequest1.setAddress("Pako");
        registerUserRequest1.setPhoneNumber("09087654212");
        registerUserRequest1.setNationality("Nigerian");
        registerUserRequest1.setProfession("Doctor");
        registerUserRequest1.setStateOfOrigin("Ekiti");
        registerUserRequest1.setReligion("Christian");
        registerUserRequest.setGender("Male");
        registerUserRequest.setAge(18);
        registerUserRequest.setRole("admin");
        assertThrows(UserAlreadyExistException.class, () -> userServiceInterface.registerUserResponse(registerUserRequest1));
    }
    @Test
    public void testThatUserCanLogin() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("John");
        registerUserRequest.setLastName("Doe");
        registerUserRequest.setEmail("john@doe.com");
        registerUserRequest.setPassword("passwo");
        registerUserRequest.setDateOfBirth("2/2/2007");
        registerUserRequest.setAddress("Pako");
        registerUserRequest.setPhoneNumber("09087654212");
        registerUserRequest.setNationality("Nigerian");
        registerUserRequest.setProfession("Doctor");
        registerUserRequest.setStateOfOrigin("Ekiti");
        registerUserRequest.setReligion("Christian");
        registerUserRequest.setGender("Male");
        registerUserRequest.setAge(18);
        registerUserRequest.setRole("admin");
        RegisterUserResponse response = userServiceInterface.registerUserResponse(registerUserRequest);
        assertThat(response.getMessage()).isEqualTo("User Registered Successfully");

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("john@doe.com");
        loginUserRequest.setPassword("password");
        LoginUserResponse loginUserResponse = userServiceInterface.loginUserResponse(loginUserRequest);
        assertThat(loginUserResponse.getMessage()).isEqualTo("User LoggedIn Successfully");
    }
    @Test
    public void testThatUserCanLogout() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("John");
        registerUserRequest.setLastName("Doe");
        registerUserRequest.setEmail("john@doe.com");
        registerUserRequest.setPassword("passwo");
        registerUserRequest.setDateOfBirth("2/2/2007");
        registerUserRequest.setAddress("Pako");
        registerUserRequest.setPhoneNumber("09087654212");
        registerUserRequest.setNationality("Nigerian");
        registerUserRequest.setProfession("Doctor");
        registerUserRequest.setStateOfOrigin("Ekiti");
        registerUserRequest.setReligion("Christian");
        registerUserRequest.setGender("Male");
        registerUserRequest.setAge(18);
        registerUserRequest.setRole("admin");
        RegisterUserResponse response = userServiceInterface.registerUserResponse(registerUserRequest);
        assertThat(response.getMessage()).isEqualTo("User Registered Successfully");

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("john@doe.com");
        loginUserRequest.setPassword("password");
        LoginUserResponse loginUserResponse = userServiceInterface.loginUserResponse(loginUserRequest);
        assertThat(loginUserResponse.getMessage()).isEqualTo("User LoggedIn Successfully");

        LogOutUserRequest logOutUserRequest = new LogOutUserRequest();
        logOutUserRequest.setId(loginUserResponse.getId());
        LogOutUserResponse logOutUserResponse = userServiceInterface.logOutUserResponse(logOutUserRequest);
        assertThat(logOutUserResponse.getMessage()).isEqualTo("User Logged Out Successfully");
    }
    @Test
    public void testThatUserCanBeFoundById() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("John");
        registerUserRequest.setLastName("Doe");
        registerUserRequest.setEmail("john@doe.com");
        registerUserRequest.setPassword("passwo");
        registerUserRequest.setDateOfBirth("2/2/2007");
        registerUserRequest.setAddress("Pako");
        registerUserRequest.setPhoneNumber("09087654212");
        registerUserRequest.setNationality("Nigerian");
        registerUserRequest.setProfession("Doctor");
        registerUserRequest.setStateOfOrigin("Ekiti");
        registerUserRequest.setReligion("Christian");
        registerUserRequest.setGender("Male");
        registerUserRequest.setAge(18);
        registerUserRequest.setRole("admin");
        RegisterUserResponse response = userServiceInterface.registerUserResponse(registerUserRequest);
        assertThat(response.getMessage()).isEqualTo("User Registered Successfully");

        FindUserByIdRequest findUserByIdRequest = new FindUserByIdRequest();
        findUserByIdRequest.setId(response.getId());
        FindUserByIdResponse findUserByIdResponse = userServiceInterface.findUserByIdResponse(findUserByIdRequest);
        assertThat(findUserByIdResponse.getMessage()).isEqualTo("User Found Successfully");
    }
    @Test
    public void testThatAllUsersCanBeFound() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("John");
        registerUserRequest.setLastName("Doe");
        registerUserRequest.setEmail("john@doe.com");
        registerUserRequest.setPassword("passwo");
        registerUserRequest.setDateOfBirth("2/2/2007");
        registerUserRequest.setAddress("Pako");
        registerUserRequest.setPhoneNumber("09087654212");
        registerUserRequest.setNationality("Nigerian");
        registerUserRequest.setProfession("Doctor");
        registerUserRequest.setStateOfOrigin("Ekiti");
        registerUserRequest.setReligion("Christian");
        registerUserRequest.setGender("Male");
        registerUserRequest.setAge(18);
        registerUserRequest.setRole("admin");
        RegisterUserResponse response = userServiceInterface.registerUserResponse(registerUserRequest);
        assertThat(response.getMessage()).isEqualTo("User Registered Successfully");

        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        registerUserRequest1.setFirstName("Baby");
        registerUserRequest1.setLastName("Doe");
        registerUserRequest1.setEmail("Baby@doe.com");
        registerUserRequest1.setPassword("passwo");
        registerUserRequest1.setDateOfBirth("2/2/2007");
        registerUserRequest1.setAddress("Oremiji");
        registerUserRequest1.setPhoneNumber("08098765321");
        registerUserRequest1.setNationality("Nigerian");
        registerUserRequest1.setProfession("Doctor");
        registerUserRequest1.setStateOfOrigin("Ekiti");
        registerUserRequest1.setReligion("Christian");
        registerUserRequest1.setGender("Female");
        registerUserRequest1.setAge(18);
        registerUserRequest1.setRole("admin");
        RegisterUserResponse response1 = userServiceInterface.registerUserResponse(registerUserRequest1);
        assertThat(response1.getMessage()).isEqualTo("User Registered Successfully");

        RegisterUserRequest registerUserRequest2 = new RegisterUserRequest();
        registerUserRequest2.setFirstName("Peter");
        registerUserRequest2.setLastName("David");
        registerUserRequest2.setEmail("David@doe.com");
        registerUserRequest2.setPassword("passwo");
        registerUserRequest2.setDateOfBirth("2/2/2007");
        registerUserRequest2.setAddress("Sabo");
        registerUserRequest2.setPhoneNumber("09012345672");
        registerUserRequest2.setNationality("Nigerian");
        registerUserRequest2.setProfession("Doctor");
        registerUserRequest2.setStateOfOrigin("Ekiti");
        registerUserRequest2.setReligion("Christian");
        registerUserRequest2.setGender("Male");
        registerUserRequest2.setAge(18);
        registerUserRequest2.setRole("admin");
        RegisterUserResponse response2 = userServiceInterface.registerUserResponse(registerUserRequest2);
        assertThat(response2.getMessage()).isEqualTo("User Registered Successfully");

        FindAllUserRequest findAllUserRequest = new FindAllUserRequest();
        FindAllUserResponse findAllUserResponse = userServiceInterface.findAllUserResponse(findAllUserRequest);
        assertThat(findAllUserResponse.getMessage()).isEqualTo("Users Found Successfully");
    }
}