package org.voting_app.voting_app.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VoterLoginRequest {
    private String voter_name;
    private String registrationNumber;
    private String voterEmail;
    private String passWord;
    private String confirmPassWord;
}
