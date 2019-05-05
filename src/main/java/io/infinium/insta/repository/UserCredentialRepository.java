package io.infinium.insta.repository;

import io.infinium.insta.domain.UserAccount;
import io.infinium.insta.domain.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCredentialRepository extends JpaRepository<UserCredentials,Integer> {
    UserCredentials findByEmail(String email);
    UserCredentials findByUsername(String username);
}
