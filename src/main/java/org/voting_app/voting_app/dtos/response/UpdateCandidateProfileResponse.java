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
public class UpdateCandidateProfileResponse {
    @Id
    private long id;
    private String message;
}
