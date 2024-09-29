package org.voting_app.voting_app.services.implimentions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.voting_app.voting_app.data.model.Candidates;
import org.voting_app.voting_app.data.model.Positions;
import org.voting_app.voting_app.data.model.Voter;
import org.voting_app.voting_app.data.repositories.VoterRepository;
import org.voting_app.voting_app.dtos.request.DeleteVotedCandidateRequest;
import org.voting_app.voting_app.dtos.request.PredictWinnerRequest;
import org.voting_app.voting_app.dtos.response.DeleteVotedCandidateResponse;
import org.voting_app.voting_app.dtos.response.PredictWinnerResponse;
import org.voting_app.voting_app.dtos.response.VoteForCandidateResponse;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VoterServiceImplTest {
    @Autowired
    private VoterServiceImpl voterService;

    @Autowired
    private VoterRepository voterRepository;



    @Test
    void voteForCandidate() {
      Voter vote = new Voter();
      vote.setVoter_name("Peter");
      vote.setAge("18");
      vote.setCandidateName("peter Obi");
      vote.setVoterEmail("smart@gmail.comcandidateRepository");
//      vote.setRegistrationNumber("20245001");
      vote.setPassWord("123456");
      vote.setConfirmPassWord("123456");
      Voter saved = voterRepository.save(vote);

        VoteForCandidateResponse response = new VoteForCandidateResponse();
        response.setVoter_id(saved.getVoter_id());
        response.setCandidateId(saved.getCandidateId());
        response.setVoter_name(saved.getVoter_name());
        response.setMessage("Voted successfully");
        assertEquals(saved.getVoter_id(), response.getVoter_id());
    }

    @Test
    void deleteCandidate() {
//        Candidates user = new Candidates();
//        user.setCandidateName("Smart");
//        user.setPosition_name(Positions.GOVERNOR);

        DeleteVotedCandidateRequest request = new DeleteVotedCandidateRequest();
        request.setCandidateId(request.getCandidateId());
        request.setCandidateName(request.getCandidateName());
        request.setCandidatePosition(request.getCandidatePosition());
        voterService.deleteCandidate(request);

        DeleteVotedCandidateResponse response = new DeleteVotedCandidateResponse();
        response.setMessage("candidate deleted successfully");
        assertNotNull(response);
        assertEquals(response.getMessage(), response.getMessage());
    }

    @Test
    void predictWinner() {
        PredictWinnerRequest request = new PredictWinnerRequest();
        request.setCandidateId(request.getCandidateId());
        request.setPartyName(request.getPartyName());
        request.setPredictionSetId(request.getPredictionSetId());
        request.setPositions(request.getPositions());
        request.setParticipantName(request.getParticipantName());
        voterService.predictWinner(request);

        PredictWinnerResponse response = new PredictWinnerResponse();
        response.setPositions(request.getPositions());
        response.setPartyName(request.getPartyName());
        response.setCandidateName(request.getParticipantName());
        response.setMessage(response.getMessage());
        assertEquals(response.getMessage(), response.getMessage());
    }
}