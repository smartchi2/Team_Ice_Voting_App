package org.voting_app.voting_app.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.voting_app.voting_app.data.model.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

}
