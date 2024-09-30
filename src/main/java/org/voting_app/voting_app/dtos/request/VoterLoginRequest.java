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
public class VoterLoginRequest {
    @Id
    private Long id;
    private String registrationNumber;
    private String voterEmail;
    private String passWord;
}
