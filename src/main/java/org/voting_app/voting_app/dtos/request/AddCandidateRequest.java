package org.voting_app.voting_app.dtos.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddCandidateRequest {
    @Id
    private Long candidateId;
    private String candidateName;
    private String candidateEmail;
    private String candidatePosition;
    private String candidateParty;

}
