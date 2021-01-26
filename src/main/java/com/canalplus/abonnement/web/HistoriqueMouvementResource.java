package com.canalplus.abonnement.web;

import com.canalplus.abonnement.entity.HistoriqueMouvement;
import com.canalplus.abonnement.service.historiquemouvement.HistoriqueMouvementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoriqueMouvementResource {

    private final HistoriqueMouvementService historiqueMouvementService;

    public HistoriqueMouvementResource(HistoriqueMouvementService historiqueMouvementService) {
        this.historiqueMouvementService = historiqueMouvementService;
    }

    /**
     * Retourne la liste de l'historique des mouvements d'un abonné par son id
     * @param idAbonne L'id de l'abonné
     * @return Retourne la réponse de la liste de l'historique des mouvements de l'abonné
     */
    @GetMapping("/historique/abonne/{id:.+}")
    public ResponseEntity<List<HistoriqueMouvement>> get(@PathVariable long idAbonne) {
        List<HistoriqueMouvement> historiqueMouvements = this.historiqueMouvementService.get(idAbonne);
        return ResponseEntity.ok(historiqueMouvements);
    }
}
