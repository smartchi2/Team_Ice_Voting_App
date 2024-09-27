package org.voting_app.voting_app.dtos.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    @Id
    private Long user_Id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
    private String nationality;
    private String religion;
    private String dateOfBirth;
    private String stateOfOrigin;
    private String profession;
    private String gender;
    private int age;
    private String role;
}
