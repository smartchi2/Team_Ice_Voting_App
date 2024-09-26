package org.voting_app.voting_app.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.voting_app.voting_app.data.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
