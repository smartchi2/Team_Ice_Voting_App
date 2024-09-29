package org.voting_app.voting_app.data.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Candidates {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String position;
    private String phoneNumber;
    private String party;
    private String pvc;
    private Long adminId;
}
