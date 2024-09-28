package org.voting_app.voting_app.dtos.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCandidateProfileRequest {
    @Id
    private long id;
    private String party;
    private String position;
    private String pvc;
    private String phoneNumber;
    private Long adminId;
}
