package org.voting_app.voting_app.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.voting_app.voting_app.data.model.Candidates;

import java.util.Optional;
@Repository
public interface CandidatesRepository extends JpaRepository<Candidates, Long> {
    Optional<Candidates> findCandidatesById(Long id);
    Optional<Candidates> findCandidatesByPhoneNumber(String phoneNumber);
    Optional<Candidates> findCandidatesByEmail(String email);
}
