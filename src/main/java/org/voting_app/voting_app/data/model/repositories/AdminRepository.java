package org.voting_app.voting_app.data.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.voting_app.voting_app.data.model.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
//    Optional<Admin> findById(Long id);
    Admin findAdminByEmail(String email);
//    Admin findByUserId(Long candidateId);

}
