package com.apipkm.pikapikaAPI.repositories;

import com.apipkm.pikapikaAPI.models.UserRolePokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRolePokemonRepository extends JpaRepository<UserRolePokemon, Long> {
}
