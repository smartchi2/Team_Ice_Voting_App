package org.voting_app.voting_app.dtos.response;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.voting_app.voting_app.util.RegistrationNumber;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponse {
    @Id
    private long id;
    private String registrationNumber;
    private String message;
}
