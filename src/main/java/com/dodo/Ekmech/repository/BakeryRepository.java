package com.dodo.Ekmech.repository;

import com.dodo.Ekmech.model.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BakeryRepository extends JpaRepository<Bakery, Long> {
    // Eğer özel sorgular eklemek isterseniz burada tanımlayabilirsiniz.
    Optional<Bakery> findByEmail(String email);
}