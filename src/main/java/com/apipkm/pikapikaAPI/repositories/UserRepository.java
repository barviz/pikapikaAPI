package com.apipkm.pikapikaAPI.repositories;

import com.apipkm.pikapikaAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
