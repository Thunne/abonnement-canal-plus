package com.canalplus.abonnement.web;

import com.canalplus.abonnement.entity.Contrat;
import com.canalplus.abonnement.service.contrat.ContratService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContratResource {

    private final ContratService contratService;

    public ContratResource(ContratService contratService) {
        this.contratService = contratService;
    }

    /**
     * Créé un contrat pour un abonné
     * @param idAbonne L'id de l'abonné
     * @param adresse L'adresse pour le contrat
     * @return Retourne la réponse contenant le contrat créé
     */
    @PostMapping("/contrat")
    public ResponseEntity<Contrat> creerContrat(@RequestParam(value = "idAbonne") long idAbonne,
      @RequestParam(value = "adresse") String adresse) {
        Contrat contrat = this.contratService.creerContrat(idAbonne, adresse);
        return ResponseEntity.ok(contrat);
    }

    /**
     * Récupére la liste de contrat d'un abonné
     * @param idAbonne L'id de l'abonné
     * @return Retourne la réponse contenant la liste de contrat de l'abonné
     */
    @GetMapping("/contrat/abonne/{id:.+}")
    public ResponseEntity<List<Contrat>> recupererContrats(@PathVariable long idAbonne) {
        List<Contrat> contrats = this.contratService.recupererContrats(idAbonne);
        return ResponseEntity.ok(contrats);
    }
}
