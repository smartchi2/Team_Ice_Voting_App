package org.voting_app.voting_app.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VoteForCandidateResponse {
    private Long voter_id;
    private String voter_name;
    private Long candidateId;
    private String registrationNumber;
    private String message;
}
