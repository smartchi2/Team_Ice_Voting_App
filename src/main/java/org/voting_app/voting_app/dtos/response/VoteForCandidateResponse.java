package org.voting_app.voting_app.dtos.response;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VoteForCandidateResponse {
    @Id
    private Long voter_id;
    private String registrationNumber;
    private String message;
}
