package com.apipkm.pikapikaAPI.repositories;

import com.apipkm.pikapikaAPI.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
