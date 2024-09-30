package org.voting_app.voting_app.dtos.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.voting_app.voting_app.data.model.Positions;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VoteForCandidateRequest {
    @Id
    private long id;
    private String voterName;
    private String registrationNumber;
    private String candidateName;
    private String addPvc;
    private String age;
    private Positions candidatePosition;
    private String candidatePartyName;
}
