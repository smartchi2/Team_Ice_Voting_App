package org.voting_app.voting_app.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassWord;
    private LocalDate birthday;
    private String address;
    private String nationality;
    private String religion;
    private String placeOfBirth;
    private String stateOfOrigin;
    private String profession;

}
