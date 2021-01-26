package com.canalplus.abonnement.service;

import com.canalplus.abonnement.entity.HistoriqueMouvement;
import com.canalplus.abonnement.repository.HistoriqueMouvementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueMouvementService {

    private final HistoriqueMouvementRepository historiqueMouvementRepository;

    public HistoriqueMouvementService(HistoriqueMouvementRepository historiqueMouvementRepository) {
        this.historiqueMouvementRepository = historiqueMouvementRepository;
    }

    public List<HistoriqueMouvement> get(long idAbonne) {
        return historiqueMouvementRepository.findAllByAbonneId(idAbonne);
    }
}
