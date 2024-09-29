package org.voting_app.voting_app.data.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.voting_app.voting_app.data.model.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
   boolean findByCandidateName(String candidateName);
    boolean existsByRegistrationNumber(String registrationNumber);
    boolean existsByEmail(String voterEmail);
}
