package org.voting_app.voting_app.services.interfaces;

import org.voting_app.voting_app.dtos.request.LogInCandidateRequest;
import org.voting_app.voting_app.dtos.request.RegisterToAdminRequest;
import org.voting_app.voting_app.dtos.request.UpdateCandidateProfileRequest;
import org.voting_app.voting_app.dtos.response.LogInCandidateResponse;
import org.voting_app.voting_app.dtos.response.RegisterToAdminResponse;
import org.voting_app.voting_app.dtos.response.UpdateCandidateProfileResponse;

public interface CandidatesServiceInterface {
    RegisterToAdminResponse registerToAdminResponse(RegisterToAdminRequest registerToAdminRequest);
    LogInCandidateResponse logInCandidateResponse(LogInCandidateRequest logInCandidateRequest);
    UpdateCandidateProfileResponse updateCandidateProfileResponse(UpdateCandidateProfileRequest updateCandidateProfileRequest);
}
