package org.voting_app.voting_app.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.voting_app.voting_app.data.model.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
    Voter findVoterById(long id);
    Voter findVoterByRegistrationNumber(String registrationNumber);
    Voter findVoterByVoterEmail(String voterEmail);

}
