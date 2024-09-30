package org.voting_app.voting_app.services.implimentions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voting_app.voting_app.data.model.Candidates;
//import org.voting_app.voting_app.data.model.repositories.UserRepository;
import org.voting_app.voting_app.data.model.User;
import org.voting_app.voting_app.data.model.Voter;
import org.voting_app.voting_app.data.repositories.CandidatesRepository;
import org.voting_app.voting_app.data.repositories.UserRepository;
import org.voting_app.voting_app.data.repositories.VoterRepository;
import org.voting_app.voting_app.dtos.request.DeleteVotedCandidateRequest;
import org.voting_app.voting_app.dtos.request.PredictWinnerRequest;
import org.voting_app.voting_app.dtos.request.VoteForCandidateRequest;
import org.voting_app.voting_app.dtos.request.VoterLoginRequest;
import org.voting_app.voting_app.dtos.response.DeleteVotedCandidateResponse;
import org.voting_app.voting_app.dtos.response.PredictWinnerResponse;
import org.voting_app.voting_app.dtos.response.VoteForCandidateResponse;
import org.voting_app.voting_app.dtos.response.VoterLoginResponse;
import org.voting_app.voting_app.exceptions.VoterException;
import org.voting_app.voting_app.services.interfaces.VoterService;


@Service
public class VoterServiceImpl implements VoterService {
    @Autowired
    private CandidatesRepository candidatesRepository;
    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private UserRepository userRepository;
    private VoterServiceImpl(VoterRepository voterRepository){
        this.voterRepository = voterRepository;
    }

    @Override
    public VoterLoginResponse loginAsVoter(VoterLoginRequest voterRequest) {
        User user = userRepository.findUserById(voterRequest.getId())
                .orElseThrow(() -> new VoterException("User not found"));
        if(user.getRole().equalsIgnoreCase("voter")){
            Voter voter = new Voter();
            voter.setVoterEmail(voterRequest.getVoterEmail());
            voter.setPassWord(voterRequest.getPassWord());
            voter.setRegistrationNumber(voterRequest.getRegistrationNumber());
            voterRepository.save(voter);
            userRepository.save(user);
            VoterLoginResponse voterLoginResponse = new VoterLoginResponse();
            voterLoginResponse.setId(voter.getId());
            voterLoginResponse.setMessage("Voter successfully logged in");
            return voterLoginResponse;
        }
        else {
            throw new VoterException("User not found");
        }
    }

    @Override
    public VoteForCandidateResponse voteForCandidate(VoteForCandidateRequest voteForCandidateRequest) {
        Voter voter = voterRepository.findVoterById(voteForCandidateRequest.getId());
        if(voteForCandidateRequest.getCandidateName().isBlank() || voteForCandidateRequest.getAge().isBlank()
                || voteForCandidateRequest.getAddPvc().isBlank()){
            throw new VoterException("Fields cannot be empty");
        }
        if(voteForCandidateRequest.getAge().length() > 18){
            throw new VoterException("Ages must be between 18 and above");

        }
        if(voteForCandidateRequest.getVoterName().isBlank()){
            throw new VoterException("Voter name cannot be blank");
        }
        voterRepository.findVoterByRegistrationNumber(voteForCandidateRequest.getRegistrationNumber());
        voter.setVoterName(voteForCandidateRequest.getVoterName());
        voter.setCandidateName(voteForCandidateRequest.getCandidateName());
        voter.setCandidatePosition(voteForCandidateRequest.getCandidatePosition());
        voter.setRegistrationNumber(voteForCandidateRequest.getRegistrationNumber());
        voter.setAge(voteForCandidateRequest.getAge());
        voter.setAddPvc(voteForCandidateRequest.getAddPvc());
        voter.setRegistrationNumber(voteForCandidateRequest.getRegistrationNumber());

        VoteForCandidateResponse response = new VoteForCandidateResponse();
        response.setVoter_id(voter.getId());
        response.setMessage("Candidate has been voted For");
        response.setRegistrationNumber(voter.getRegistrationNumber());
        return response;
    }

    @Override
    public PredictWinnerResponse predictWinner(PredictWinnerRequest request) {
        PredictWinnerRequest request1 = new PredictWinnerRequest();
        Voter voter= voterRepository.findVoterByVoterEmail(request.getEmail());
        request1.setPartyName(request.getPartyName());
        request1.setParticipantName(request.getParticipantName());
        request1.setPositions(request.getPositions());
        request1.setCandidateTo(request.getCandidateTo());

        PredictWinnerResponse response = new PredictWinnerResponse();
        response.setMessage("Your Have picked candidate with details"
                + request.getPartyName() +
                request.getParticipantName() +
                request.getPositions() + "to"
                + request.getCandidateTo());
        return response;
    }
}
