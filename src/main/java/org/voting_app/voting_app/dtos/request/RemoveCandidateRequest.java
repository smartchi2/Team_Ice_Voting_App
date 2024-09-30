package org.voting_app.voting_app.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RemoveCandidateRequest {
    @Id
    private Long candidateId;
    private String candidateName;
    private String candidateParty;

}
