package com.dodo.Ekmech.repository;

import com.dodo.Ekmech.model.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BakeryRepository extends JpaRepository<Bakery, Long> {
    // Eğer özel sorgular eklemek isterseniz burada tanımlayabilirsiniz.
}