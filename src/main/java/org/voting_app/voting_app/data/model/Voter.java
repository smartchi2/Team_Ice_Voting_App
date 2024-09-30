package org.voting_app.voting_app.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Voter {
    @Id
    @GeneratedValue
    private Long id;
    private Long candidateId;
    private String adminEmail;
    private String voterEmail;
    private String candidateName;
    private String registrationNumber;
    private String age;
    private String passWord;
    private String confirmPassWord;
    private String voterName;
    private String addPvc;
    private Positions candidatePosition;
    private String candidatePartyName;
}
