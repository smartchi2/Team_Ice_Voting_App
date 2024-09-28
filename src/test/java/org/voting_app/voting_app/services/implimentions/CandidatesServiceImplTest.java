package org.voting_app.voting_app.services.implimentions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.voting_app.voting_app.data.repositories.CandidatesRepository;
import org.voting_app.voting_app.dtos.request.LogInCandidateRequest;
import org.voting_app.voting_app.dtos.request.RegisterToAdminRequest;
import org.voting_app.voting_app.dtos.request.UpdateCandidateProfileRequest;
import org.voting_app.voting_app.dtos.response.LogInCandidateResponse;
import org.voting_app.voting_app.dtos.response.RegisterToAdminResponse;
import org.voting_app.voting_app.exceptions.OnlyThreeCandidatesAreAllowedException;
import org.voting_app.voting_app.exceptions.UserNotAllowedToVoteException;
import org.voting_app.voting_app.services.interfaces.CandidatesServiceInterface;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CandidatesServiceImplTest {
    @Autowired
    private CandidatesRepository candidatesRepository;

    @BeforeEach
    public void setUp() {
        candidatesRepository.deleteAll();
    }
    @Autowired
    private CandidatesServiceInterface candidatesServiceInterface;
    @Autowired
    private CandidatesRepository CandidatesRepository;
    @Test
    public void testThatCandidateCanRegister() {
        RegisterToAdminRequest request = new RegisterToAdminRequest();
        request.setFirstName("Buhari");
        request.setLastName("Tinubu");
        request.setEmail("Tinubu.Buhari@gmail.com");
        request.setPassword("099888");
        request.setPhoneNumber("09056743212");
        RegisterToAdminResponse registerToAdminResponse = candidatesServiceInterface.registerToAdminResponse(request);
        assertThat(registerToAdminResponse.getMessage()).isEqualTo("Candidate registered successfully");
    }
    @Test
    public void testThatCandidatesCannotBeMoreThanThree() {
        RegisterToAdminRequest request = new RegisterToAdminRequest();
        request.setFirstName("Buhari");
        request.setLastName("Tinubu");
        request.setEmail("Tinubu.Buhari@gmail.com");
        request.setPassword("099888");
        request.setPhoneNumber("09056743212");
        RegisterToAdminResponse registerToAdminResponse = candidatesServiceInterface.registerToAdminResponse(request);
        assertThat(registerToAdminResponse.getMessage()).isEqualTo("Candidate registered successfully");

        RegisterToAdminRequest request1 = new RegisterToAdminRequest();
        request1.setFirstName("Buhar");
        request1.setLastName("Tinub");
        request1.setEmail("Tinub.Buhar@gmail.com");
        request1.setPassword("099888");
        request1.setPhoneNumber("09056743812");
        RegisterToAdminResponse registerToAdminResponse1 = candidatesServiceInterface.registerToAdminResponse(request1);
        assertThat(registerToAdminResponse1.getMessage()).isEqualTo("Candidate registered successfully");

        RegisterToAdminRequest request2 = new RegisterToAdminRequest();
        request2.setFirstName("Buhai");
        request2.setLastName("Tinuu");
        request2.setEmail("Tinuu.Buhai@gmail.com");
        request2.setPassword("099888");
        request2.setPhoneNumber("09054743212");
        RegisterToAdminResponse registerToAdminResponse2 = candidatesServiceInterface.registerToAdminResponse(request2);
        assertThat(registerToAdminResponse2.getMessage()).isEqualTo("Candidate registered successfully");

        RegisterToAdminRequest request3 = new RegisterToAdminRequest();
        request3.setFirstName("Buari");
        request3.setLastName("Tiubu");
        request3.setEmail("Tiubu.Buari@gmail.com");
        request3.setPassword("099888");
        request3.setPhoneNumber("07056743212");
        assertThrows(OnlyThreeCandidatesAreAllowedException.class, () -> candidatesServiceInterface.registerToAdminResponse(request3));
    }
    @Test
    public void testThatCandidateCanLogIn() {
        RegisterToAdminRequest request = new RegisterToAdminRequest();
        request.setFirstName("Buhari");
        request.setLastName("Tinubu");
        request.setEmail("Tinubu.Buhari@gmail.com");
        request.setPassword("099888");
        request.setPhoneNumber("09056743212");
        RegisterToAdminResponse registerToAdminResponse = candidatesServiceInterface.registerToAdminResponse(request);
        assertThat(registerToAdminResponse.getMessage()).isEqualTo("Candidate registered successfully");

        LogInCandidateRequest logInCandidateRequest = new LogInCandidateRequest();
        logInCandidateRequest.setEmail("Tinubu.Buhari@gmail.com");
        logInCandidateRequest.setPassword("099888");
        LogInCandidateResponse logInCandidateResponse = candidatesServiceInterface.logInCandidateResponse(logInCandidateRequest);
        assertThat(logInCandidateResponse.getMessage()).isEqualTo("Candidate LoggedIn Successfully");
    }
    @Test
    public void testThatCandidateCanUpdateProfile() {
        RegisterToAdminRequest request = new RegisterToAdminRequest();
        request.setFirstName("Buhari");
        request.setLastName("Tinubu");
        request.setEmail("Tinubu.Buhari@gmail.com");
        request.setPassword("099888");
        request.setPhoneNumber("09056743212");
        RegisterToAdminResponse registerToAdminResponse = candidatesServiceInterface.registerToAdminResponse(request);
        assertThat(registerToAdminResponse.getMessage()).isEqualTo("Candidate registered successfully");

        LogInCandidateRequest logInCandidateRequest = new LogInCandidateRequest();
        logInCandidateRequest.setEmail("Tinubu.Buhari@gmail.com");
        logInCandidateRequest.setPassword("099888");
        LogInCandidateResponse logInCandidateResponse = candidatesServiceInterface.logInCandidateResponse(logInCandidateRequest);
        assertThat(logInCandidateResponse.getMessage()).isEqualTo("Candidate LoggedIn Successfully");

        UpdateCandidateProfileRequest updateCandidateProfileRequest = new UpdateCandidateProfileRequest();
        updateCandidateProfileRequest.setId(logInCandidateResponse.getId());
        updateCandidateProfileRequest.setParty("APC");
        updateCandidateProfileRequest.setPhoneNumber("09056743212");
        updateCandidateProfileRequest.setPosition("PRESIDENT");
        updateCandidateProfileRequest.setPvc("456790");
    }
}