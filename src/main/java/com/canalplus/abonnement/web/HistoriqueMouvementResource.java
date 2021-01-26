package com.canalplus.abonnement.web;

import com.canalplus.abonnement.entity.HistoriqueMouvement;
import com.canalplus.abonnement.service.HistoriqueMouvementService;
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

    @GetMapping("/historique/abonne/{id:.+}")
    public ResponseEntity<List<HistoriqueMouvement>> get(@PathVariable long idAbonne) {
        List<HistoriqueMouvement> historiqueMouvements = this.historiqueMouvementService.get(idAbonne);
        return ResponseEntity.ok(historiqueMouvements);
    }
}
