package com.canalplus.abonnement.repository;

import com.canalplus.abonnement.entity.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonneRepository extends JpaRepository<Abonne, Long> {

}
