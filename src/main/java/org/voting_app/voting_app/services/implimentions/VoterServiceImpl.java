package org.voting_app.voting_app.services.implimentions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voting_app.voting_app.data.model.Voter;
import org.voting_app.voting_app.data.model.repositories.UserRepository;
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
//@RequiredArgsConstructor
public class VoterServiceImpl implements VoterService {
    @Autowired
    UserRepository userRepository;

    private final VoterRepository voterRepository;

    private VoterServiceImpl(VoterRepository voterRepository){
        this.voterRepository = voterRepository;
    }

    @Override
    public VoterLoginResponse loginAsVoter(VoterLoginRequest voterRequest) {
//        boolean findTheVoter = voterRepository.existsByByEmail(voterRequest.getVoterEmail());
//        if(!findTheVoter){
//            throw new VoterException("Voter not found");
//        }
////       Optional user = userRepository.findUserByEmail(voterRequest.getVoterEmail());
////        String isCorrect = user.getEmail();
     return null;
    }

    @Override
    public VoteForCandidateResponse voteForCandidate(VoteForCandidateRequest voteForCandidateRequest) {
        VoteForCandidateRequest request = new VoteForCandidateRequest();
       boolean checkCandidate = voterRepository.findByCandidateName(request.getCandidateName());
        if(!checkCandidate)
        if(request.getCandidateName().isBlank() || request.getAge().isBlank()
                || request.getAddPvc().isBlank()){
            throw new VoterException("Fields cannot be empty");
        }
        if(request.getAge().length() <= 17){
            throw new VoterException("Ages must be between 18 and above");

        }
        if(request.getVoterName().isBlank()){
            throw new VoterException("Voter name cannot be blank");
        }
        boolean checkVoterRegisteredNumber = voterRepository.existsByRegistrationNumber(request.getRegistrationNumber());
        if(!checkVoterRegisteredNumber){
            throw  new VoterException("Voter registration number does not exist");
        }
        voteForCandidateRequest.setVoterName(request.getVoterName());
        voteForCandidateRequest.setCandidateName(request.getCandidateName());
        voteForCandidateRequest.setCandidatePosition(request.getCandidatePosition());
        voteForCandidateRequest.setRegistrationNumber(request.getRegistrationNumber());
        voteForCandidateRequest.setRegistrationNumber(request.getRegistrationNumber());
        voteForCandidateRequest.setAge(request.getAge());
        voteForCandidateRequest.setAddPvc(request.getAddPvc());
        voteForCandidateRequest.setRegistrationNumber(request.getRegistrationNumber());

        VoteForCandidateResponse response = new VoteForCandidateResponse();
        response.setCandidateId(response.getCandidateId());
        response.setMessage("Candidate " + request.getCandidateName() + " has been voted");
        response.setRegistrationNumber(request.getRegistrationNumber());
        return response;
    }

    @Override
    public DeleteVotedCandidateResponse deleteCandidate(DeleteVotedCandidateRequest request) {
        for(Voter voter : voterRepository.findAll()) {
            if (voter.getCandidateId().equals(request.getCandidateId())) {
                voterRepository.delete(voter);

                DeleteVotedCandidateResponse delete = new DeleteVotedCandidateResponse();
                delete.setMessage("Candidate " + request.getCandidateName() + " has been deleted");
                return delete;
            }
        }
        throw new VoterException("Candidate not found");
    }

    @Override
    public PredictWinnerResponse predictWinner(PredictWinnerRequest request) {
        PredictWinnerRequest request1 = new PredictWinnerRequest();
        if(request1.getParticipantName().isBlank() || request1.getPartyName().isBlank()){
            throw new VoterException("Fields cannot be blank");
        }
        request1.setCandidateId(request.getCandidateId());
        request1.setPartyName(request.getPartyName());
        request1.setParticipantName(request.getParticipantName());
        request1.setPositions(request.getPositions());
        request1.setCandidateTo(request.getCandidateTo());

        PredictWinnerResponse response = new PredictWinnerResponse();
        response.setMessage("Your Have picked candidate with details"
                + request.getCandidateId()
                + request.getPartyName() +
                request.getParticipantName() +
                request.getPositions() + "to"
                + request.getCandidateTo());
        return response;
    }
}
