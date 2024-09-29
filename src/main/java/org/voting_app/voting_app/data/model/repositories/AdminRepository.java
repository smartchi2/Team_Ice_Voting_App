package org.voting_app.voting_app.data.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.voting_app.voting_app.data.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUserId(Long id);
    Admin findAdminByEmail(String email);
}
