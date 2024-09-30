package org.voting_app.voting_app.services.interfaces;

import org.voting_app.voting_app.dtos.request.*;
import org.voting_app.voting_app.dtos.response.*;

public interface VoterService {
    VoterLoginResponse loginAsVoter(VoterLoginRequest voterRequest);
    VoterLogoutResponse logoutAsVoter(VoterLogoutRequest voterRequest);
    VoteForCandidateResponse voteForCandidate(VoteForCandidateRequest voteForCandidateRequest);
    VoteForLocalGovernorResponse voteForLocalGovernorResponse(VoteForLocalGovernorRequest voteForLocalGovernorRequest);
    ViewLiveResultResponse viewLiveResultResponse(ViewLiveResultRequest viewLiveResultRequest);
    ContactResponse contactResponse(ContactRequest contactRequest);
    ViewProfileResponse viewProfileResponse();
}
