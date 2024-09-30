package org.voting_app.voting_app.services.interfaces;

import org.voting_app.voting_app.dtos.request.*;
import org.voting_app.voting_app.dtos.response.AddCandidateResponse;
import org.voting_app.voting_app.dtos.response.FindCandidateResponse;
import org.voting_app.voting_app.dtos.response.LoginAdminResponse;
import org.voting_app.voting_app.dtos.response.RemoveCandidateResponse;

public interface AdminServiceInterface {
    LoginAdminResponse loginAdmin(LoginAdminRequest loginAdminRequest);
    AddCandidateResponse addCandidate (AddCandidateRequest addCandidateRequest);

    RemoveCandidateResponse removeCandidate(RemoveCandidateRequest removeCandidateRequest);
    FindCandidateResponse findCandidate(FindCandidateRequest request);
}
