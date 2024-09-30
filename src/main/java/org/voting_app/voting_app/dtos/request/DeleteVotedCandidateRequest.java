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
public class DeleteVotedCandidateRequest {
    private String firstName;
    private String lastName;
    @Id
    private Long candidateId;
}
