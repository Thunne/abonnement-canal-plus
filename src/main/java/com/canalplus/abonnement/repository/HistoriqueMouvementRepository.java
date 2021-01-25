package com.canalplus.abonnement.repository;

import com.canalplus.abonnement.entity.HistoriqueMouvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriqueMouvementRepository extends JpaRepository<HistoriqueMouvement, Long> {

    List<HistoriqueMouvement> findAllByAbonneId(long idAbonne);
}
