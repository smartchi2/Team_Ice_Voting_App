package org.voting_app.voting_app.services.implimentions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voting_app.voting_app.data.model.Admin;
import org.voting_app.voting_app.data.model.Candidates;
import org.voting_app.voting_app.data.model.User;
import org.voting_app.voting_app.data.model.repositories.AdminRepository;
import org.voting_app.voting_app.data.repositories.CandidatesRepository;
import org.voting_app.voting_app.data.repositories.UserRepository;
import org.voting_app.voting_app.dtos.request.*;
import org.voting_app.voting_app.dtos.response.*;
import org.voting_app.voting_app.exceptions.AdminException;
import org.voting_app.voting_app.exceptions.UserNotFoundException;
import org.voting_app.voting_app.services.interfaces.AdminServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminServiceInterface {

    @Autowired
   private CandidatesRepository candidate;

    @Autowired
    private AdminRepository adminRepository;
//    @Autowired
//    private Candi
    @Autowired
    UserRepository userRepository;
    @Autowired
    private CandidatesRepository candidatesRepository;

    @Override
    public LoginAdminResponse loginAdmin(LoginAdminRequest loginAdminRequest) {
        User user = new User();
        if(user.getRole().equalsIgnoreCase("admin")){
           User user1 = userRepository.findUserByEmail(loginAdminRequest.getEmail())
                    .orElseThrow(() -> new UserNotFoundException(loginAdminRequest.getEmail()));
            userRepository.save(user);
            Admin admin = new Admin();
//            admin.setEmail(loginAdminRequest.getEmail());
            admin.setAdmin_password(loginAdminRequest.getPassword());
            adminRepository.save(admin);
            LoginAdminResponse loginAdminResponse = new LoginAdminResponse();
            loginAdminResponse.setId(admin.getAdmin_Id());
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
        if (addCandidateRequest.getCandidateEmail().isBlank()) {
            throw new RuntimeException("Candidate email is blank");
        }
        Optional<Candidates> exists = candidate.findCandidatesByEmail(addCandidateRequest.getCandidateEmail());
        if (exists.equals(addCandidateRequest.getCandidateEmail())) {
            throw new AdminException("Candidate already exist");

        }
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
        for(Candidates candidate : candidate.findAll())
            if(removeCandidateRequest.getCandidateId().equals(candidate.getId())){
               candidatesRepository.delete(candidate);
            }
        throw new AdminException("Candidate not deleted");

    }

    @Override
    public List<Candidates> findCandidate() {
        return candidate.findAll();
    }

    public UpdateCandidateProfileResponse updateCandidateProfile(UpdateCandidateProfileRequest updateCandidateProfileRequest) {
        return null;
    }



}