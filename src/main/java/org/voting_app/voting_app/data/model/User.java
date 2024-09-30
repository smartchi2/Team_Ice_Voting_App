package org.voting_app.voting_app.data.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.voting_app.voting_app.util.RegistrationNumber;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @Id
    @GeneratedValue
    private Long id;

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
    private String registrationNumber;
    @ManyToMany
    List<User> userList = new ArrayList<User>();
}
