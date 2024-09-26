package org.voting_app.voting_app.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.voting_app.voting_app.util.RegistrationNumber;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_Id;
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
