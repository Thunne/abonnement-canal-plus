package com.canalplus.abonnement.service.historiquemouvement;

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

    /**
     * Retourne tout les historiques de mouvement d'un abonné via son id
     * @param idAbonne L'id de l'abonné
     * @return Retourne la liste de l'historique de mouvement de l'abonné
     */
    public List<HistoriqueMouvement> get(long idAbonne) {
        return historiqueMouvementRepository.findAllByAbonneId(idAbonne);
    }
}
