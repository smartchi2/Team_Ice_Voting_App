package org.voting_app.voting_app.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
//    private Long voter_id;
    private Long id;
    private Long candidateId;
    private String adminEmail;
    private String voter_name;
    private String voterEmail;
    private String candidateName;
    private String age;
    private String passWord;
    private String confirmPassWord;
}
