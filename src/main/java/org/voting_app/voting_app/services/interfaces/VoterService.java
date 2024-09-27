package org.voting_app.voting_app.services.interfaces;

import org.voting_app.voting_app.dtos.request.DeleteVotedCandidateRequest;
import org.voting_app.voting_app.dtos.request.PredictWinnerRequest;
import org.voting_app.voting_app.dtos.request.VoteForCandidateRequest;
import org.voting_app.voting_app.dtos.request.VoterLoginRequest;
import org.voting_app.voting_app.dtos.response.DeleteVotedCandidateResponse;
import org.voting_app.voting_app.dtos.response.PredictWinnerResponse;
import org.voting_app.voting_app.dtos.response.VoteForCandidateResponse;
import org.voting_app.voting_app.dtos.response.VoterLoginResponse;

public interface VoterService {
    VoterLoginResponse loginAsVoter(VoterLoginRequest voterRequest);
    VoteForCandidateResponse voteForCandidate(VoteForCandidateRequest voteForCandidateRequest);
    DeleteVotedCandidateResponse deleteCandidate(DeleteVotedCandidateRequest request);
    PredictWinnerResponse predictWinner(PredictWinnerRequest request);



}
