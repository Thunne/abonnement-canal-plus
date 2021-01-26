package com.canalplus.abonnement.repository;

import com.canalplus.abonnement.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
    List<Contrat> findAllByAbonneId(long idAbonne);
}
