package org.voting_app.voting_app.services.implimentions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voting_app.voting_app.data.model.Admin;
import org.voting_app.voting_app.data.model.Candidates;
import org.voting_app.voting_app.data.repositories.CandidatesRepository;
import org.voting_app.voting_app.dtos.request.LogInCandidateRequest;
import org.voting_app.voting_app.dtos.request.RegisterToAdminRequest;
import org.voting_app.voting_app.dtos.request.UpdateCandidateProfileRequest;
import org.voting_app.voting_app.dtos.response.LogInCandidateResponse;
import org.voting_app.voting_app.dtos.response.RegisterToAdminResponse;
import org.voting_app.voting_app.dtos.response.UpdateCandidateProfileResponse;
import org.voting_app.voting_app.exceptions.*;
import org.voting_app.voting_app.services.interfaces.CandidatesServiceInterface;

import java.util.Optional;

@Service
public class CandidatesServiceImpl implements CandidatesServiceInterface {
    @Autowired
    private CandidatesRepository candidatesRepository;
    @Override
    public RegisterToAdminResponse registerToAdminResponse(RegisterToAdminRequest registerToAdminRequest) {
        validateIfIdExist(registerToAdminRequest.getId());
        validateEmail(registerToAdminRequest.getEmail());
        validatePhoneNumber(registerToAdminRequest.getPhoneNumber());
        validateIfPhoneNumberAlreadyExist(registerToAdminRequest.getPhoneNumber());
        validateTheLimitedNumberOfCanditate(registerToAdminRequest.getId());
        Candidates candidates = new Candidates();
        candidates.setFirstName(registerToAdminRequest.getFirstName());
        candidates.setLastName(registerToAdminRequest.getLastName());
        candidates.setEmail(registerToAdminRequest.getEmail());
        candidates.setPassword(registerToAdminRequest.getPassword());
        candidates.setPhoneNumber(registerToAdminRequest.getPhoneNumber());
        candidatesRepository.save(candidates);
        RegisterToAdminResponse registerToAdminResponse = new RegisterToAdminResponse();
        registerToAdminResponse.setMessage("Candidate registered successfully");
        return registerToAdminResponse;
    }

    private void validateIfIdExist(long id) {
        Optional<Candidates> candidates = candidatesRepository.findCandidatesById(id);
        if (candidates.isPresent()) {
            throw new CandidateAlreadyExistsException("Candidate Already Exists");
        }
    }

    private void validateTheLimitedNumberOfCanditate(long id) {
        if(candidatesRepository.findCandidatesById(id).equals(3)){
            throw new OnlyThreeCandidatesAreAllowedException("OnlyThreeCandidatesAreAllowed");
        }
    }

    private void validateIfPhoneNumberAlreadyExist(String phoneNumber) {
        Optional<Candidates> candidates = candidatesRepository.findCandidatesByPhoneNumber(phoneNumber);
        if (candidates.isPresent()) {
            throw new CandidateAlreadyExistsException("Candidate Already Exists");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if(phoneNumber.length() != 11) {
            throw new InvalidPhoneNumberException("Invalid phone number");
        }
    }

    private void validateEmail(String email) {
        int counter = 0;
        for (int count = 0; count < email.length(); count++){
            if(email.charAt(count) == '@'){
                counter++;
            }
        }
        if (counter != 1){
            throw new InvalidEmailException("Invalid Email");
        }
    }

    @Override
    public LogInCandidateResponse logInCandidateResponse(LogInCandidateRequest logInCandidateRequest) {
        Candidates candidates = candidatesRepository.findCandidatesByEmail(logInCandidateRequest.getEmail())
                .orElseThrow(() -> new CandidateNotFoundException("Candidate Not Found"));
        candidates.setPassword(logInCandidateRequest.getPassword());
        candidatesRepository.save(candidates);
        LogInCandidateResponse logInCandidateResponse = new LogInCandidateResponse();
        logInCandidateResponse.setId(candidates.getId());
        logInCandidateResponse.setMessage("Candidate LoggedIn Successfully");
        return logInCandidateResponse;
    }

    @Override
    public UpdateCandidateProfileResponse updateCandidateProfileResponse(UpdateCandidateProfileRequest updateCandidateProfileRequest) {
        Candidates candidates = candidatesRepository.findCandidatesById(updateCandidateProfileRequest.getId())
                .orElseThrow(() -> new CandidateNotFoundException("Candidate Not Found"));
        candidates.setPosition(updateCandidateProfileRequest.getPosition());
        candidates.setPvc(updateCandidateProfileRequest.getPvc());
        candidates.setParty(updateCandidateProfileRequest.getParty());
        candidates.setPhoneNumber(updateCandidateProfileRequest.getPhoneNumber());
        UpdateCandidateProfileResponse updateCandidateProfileResponse = new UpdateCandidateProfileResponse();
        updateCandidateProfileResponse.setId(candidates.getId());
        updateCandidateProfileResponse.setMessage("Candidate Profile Updated Successfully");
        return updateCandidateProfileResponse;
    }
}
