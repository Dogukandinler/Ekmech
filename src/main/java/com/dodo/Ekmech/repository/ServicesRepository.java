package com.dodo.Ekmech.repository;

import com.dodo.Ekmech.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

    List<Services> findByServiceDate(LocalDate date);

    List<Services> findByCustomerName(String customerName);

    List<Services> findByBakeryId(Long bakeryId);
}