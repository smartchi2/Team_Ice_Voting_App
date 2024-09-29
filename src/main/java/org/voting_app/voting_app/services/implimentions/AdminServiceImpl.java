package org.voting_app.voting_app.services.implimentions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voting_app.voting_app.data.model.Admin;
import org.voting_app.voting_app.data.model.Candidates;
import org.voting_app.voting_app.data.model.User;
import org.voting_app.voting_app.data.model.repositories.AdminRepository;
import org.voting_app.voting_app.data.model.repositories.UserRepository;
import org.voting_app.voting_app.dtos.request.*;
import org.voting_app.voting_app.dtos.response.*;
import org.voting_app.voting_app.exceptions.UserNotFoundException;
import org.voting_app.voting_app.services.interfaces.AdminServiceInterface;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminServiceInterface {

    @Autowired
    private AdminRepository adminRepository;
//    @Autowired
//    private Candi
    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginAdminResponse loginAdmin(LoginAdminRequest loginAdminRequest) {
        User user = new User();
        if(user.getRole().equalsIgnoreCase("admin")){
            user = userRepository.findUserByEmail(loginAdminRequest.getEmail())
                    .orElseThrow(() -> new UserNotFoundException(loginAdminRequest.getEmail()));
            userRepository.save(user);
            Admin admin = new Admin();
//            admin.setEmail(loginAdminRequest.getEmail());
            admin.setPassword(loginAdminRequest.getPassword());
            adminRepository.save(admin);
            LoginAdminResponse loginAdminResponse = new LoginAdminResponse();
            loginAdminResponse.setId(admin.getId());
            loginAdminResponse.setMessage("Successfully logged in");
            return loginAdminResponse;
        }
        else {
            throw new UserNotFoundException("Invalid email or password");
        }
    }

    @Override
    public AddCandidateResponse addCandidate(AddCandidateRequest addCandidateRequest) {
        Candidates candidates = new Candidates();
        AddCandidateRequest addCandidateRequest1 = new AddCandidateRequest();
         Admin check = adminRepository.findByUserId(addCandidateRequest.getCandidateId());

//
//        if (addCandidateRequest.getCandidateEmail().isBlank()) {
//            throw new RuntimeException("Candidate email is blank");
//        }
//        Admin exists = adminRepository.findAdminByEmail(addCandidateRequest.getCandidateEmail());
//        if (exists) {
//            throw new RuntimeException("Candidate already exist");
//
//        }
        addCandidateRequest1.setCandidateName(addCandidateRequest1.getCandidateName());
        addCandidateRequest1.setCandidateEmail(addCandidateRequest.getCandidateEmail());
        addCandidateRequest1.setCandidateParty(addCandidateRequest.getCandidateParty());
        addCandidateRequest1.setCandidatePosition(addCandidateRequest.getCandidatePosition());

        AddCandidateResponse addCandidateResponse1 = new AddCandidateResponse();
        addCandidateResponse1.setMessage("Successfully added candidate");
        return addCandidateResponse1;

    }

    @Override
    public RemoveCandidateResponse removeCandidate(RemoveCandidateRequest removeCandidateRequest) {
       RemoveCandidateRequest removeCandidateRequest1 = new RemoveCandidateRequest();
        boolean exists = adminRepository.existsById(removeCandidateRequest1.getCandidateId());
        if (!exists) {
            throw new RuntimeException("Candidate does not exist");
        }
        adminRepository.deleteById(removeCandidateRequest1.getCandidateId());
        RemoveCandidateResponse removeCandidateResponse1 = new RemoveCandidateResponse();
        removeCandidateResponse1.setMessage("Successfully removed candidate");
        return removeCandidateResponse1;
    }

    @Override
    public FindCandidateResponse findCandidate(FindCandidateRequest request) {
       adminRepository.findAll();
       return new FindCandidateResponse();
    }

    public UpdateCandidateProfileResponse updateCandidateProfile(UpdateCandidateProfileRequest updateCandidateProfileRequest) {
        return null;
    }



}