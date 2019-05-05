package io.infinium.insta.repository;

import io.infinium.insta.domain.UserFollow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<UserFollow,Integer> {

    UserFollow findByUserid(String id);
}
