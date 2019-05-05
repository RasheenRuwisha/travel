package io.infinium.insta.repository;

import io.infinium.insta.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {

    List<UserAccount> findByEmail(String email);
    List<UserAccount> findByUsername(String username);


}
