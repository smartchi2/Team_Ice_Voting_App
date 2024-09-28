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
public class RegisterToAdminRequest {
    @Id
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String position;
    private String phoneNumber;
}
