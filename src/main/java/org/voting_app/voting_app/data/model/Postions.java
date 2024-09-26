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
public class Postions {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long postion_id;
    private String postion_name;
    private String candidateName;
}
