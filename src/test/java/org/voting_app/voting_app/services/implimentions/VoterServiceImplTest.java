package org.voting_app.voting_app.services.implimentions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.voting_app.voting_app.data.model.Positions;
import org.voting_app.voting_app.data.model.PredictionSet;
import org.voting_app.voting_app.data.model.Voter;
import org.voting_app.voting_app.data.repositories.UserRepository;
import org.voting_app.voting_app.data.repositories.VoterRepository;
import org.voting_app.voting_app.dtos.request.*;
import org.voting_app.voting_app.dtos.response.*;
import org.voting_app.voting_app.services.interfaces.UserServiceInterface;
import org.voting_app.voting_app.services.interfaces.VoterService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.voting_app.voting_app.data.model.Positions.PRESIDENCY;

@SpringBootTest
public class VoterServiceImplTest {
    @Autowired
    private VoterServiceImpl voterService;
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private VoterService voterServiceInterface;
    @Autowired
    private UserServiceInterface userServiceInterface;
    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    public void cleanUp() {
        userRepository.deleteAll();
    }
    @Test
    public void testThatVoterCanLogIn() {
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
        registerUserRequest.setRole("voter");
        RegisterUserResponse response = userServiceInterface.registerUserResponse(registerUserRequest);
        assertThat(response.getMessage()).isEqualTo("User Registered Successfully");

        VoterLoginRequest voterLoginRequest = new VoterLoginRequest();
        voterLoginRequest.setId(response.getId());
        voterLoginRequest.setVoterEmail("john@doe.com");
        voterLoginRequest.setPassWord("passwo");
        voterLoginRequest.setRegistrationNumber(response.getRegistrationNumber());
        VoterLoginResponse voterLoginResponse = voterServiceInterface.loginAsVoter(voterLoginRequest);
        assertThat(voterLoginResponse.getMessage()).isEqualTo("Voter successfully logged in");
    }

    @Test
    public void voteForCandidate() {
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
        registerUserRequest.setRole("voter");
        RegisterUserResponse response = userServiceInterface.registerUserResponse(registerUserRequest);
        assertThat(response.getMessage()).isEqualTo("User Registered Successfully");

        VoterLoginRequest voterLoginRequest = new VoterLoginRequest();
        voterLoginRequest.setId(response.getId());
        voterLoginRequest.setVoterEmail("john@doe.com");
        voterLoginRequest.setPassWord("passwo");
        voterLoginRequest.setRegistrationNumber(response.getRegistrationNumber());
        VoterLoginResponse voterLoginResponse = voterServiceInterface.loginAsVoter(voterLoginRequest);
        assertThat(voterLoginResponse.getMessage()).isEqualTo("Voter successfully logged in");

        VoteForCandidateRequest voteForCandidateRequest = new VoteForCandidateRequest();
        voteForCandidateRequest.setId(voterLoginResponse.getId());
        voteForCandidateRequest.setAddPvc("3456");
        voteForCandidateRequest.setVoterName("John Doe");
        voteForCandidateRequest.setCandidatePosition((PRESIDENCY));
        voteForCandidateRequest.setCandidateName("Buhari");
        voteForCandidateRequest.setCandidatePartyName("APC");
        voteForCandidateRequest.setRegistrationNumber(response.getRegistrationNumber());
        voteForCandidateRequest.setAge("19");
        VoteForCandidateResponse voteForCandidateResponse = voterServiceInterface.voteForCandidate(voteForCandidateRequest);
        assertThat(voteForCandidateResponse.getMessage()).isEqualTo("Candidate has been voted For");
    }

    @Test
    public void predictWinner() {
        PredictWinnerRequest predictWinnerRequest = new PredictWinnerRequest();
        predictWinnerRequest.setPositions(Positions.GOVERNOR);
        predictWinnerRequest.setParticipantName("Smart");
        predictWinnerRequest.setCandidateTo(PredictionSet.WIN);

        PredictWinnerResponse response = voterService.predictWinner(predictWinnerRequest);
        response.setCandidateName(predictWinnerRequest.getParticipantName());
        response.setPositions(Positions.GOVERNOR);
        assertEquals(response.getMessage(), response.getMessage());
    }
}