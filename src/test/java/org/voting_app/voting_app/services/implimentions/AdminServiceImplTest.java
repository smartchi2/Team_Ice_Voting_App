package org.voting_app.voting_app.services.implimentions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.voting_app.voting_app.data.model.Candidates;
import org.voting_app.voting_app.dtos.request.LoginAdminRequest;
import org.voting_app.voting_app.dtos.request.RegisterUserRequest;
import org.voting_app.voting_app.dtos.response.LoginAdminResponse;
import org.voting_app.voting_app.dtos.response.RegisterUserResponse;
import org.voting_app.voting_app.services.interfaces.AdminServiceInterface;
import org.voting_app.voting_app.services.interfaces.UserServiceInterface;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class AdminServiceImplTest {
    @Autowired
    private AdminServiceInterface adminServiceInterface;
    @Autowired
    private UserServiceInterface userServiceInterface;
    @Test
    public void loginAdmin() {
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

        LoginAdminRequest adminRequest = new LoginAdminRequest();
        adminRequest.setEmail(registerUserRequest.getEmail());
        adminRequest.setPassword("passwo");
         LoginAdminResponse loginAdminResponse = adminServiceInterface.loginAdmin(adminRequest);
         assertThat(loginAdminResponse.getMessage()).isEqualTo("Login Successful");
    }
    @Test
    public void addCandidate() {
        Candidates candidate = new Candidates();
        candidate.setCandidateName("");
    }

    @Test
    public void findCandidate() {
    }
}