package com.canalplus.abonnement.web;

import com.canalplus.abonnement.entity.Contrat;
import com.canalplus.abonnement.service.ContratService;
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

    @PostMapping("/contrat")
    public ResponseEntity<Contrat> creerContrat(@RequestParam(value = "idAbonne") long idAbonne,
      @RequestParam(value = "adresse") String adresse) {
        Contrat contrat = this.contratService.creerContrat(idAbonne, adresse);
        return ResponseEntity.ok(contrat);
    }

    @GetMapping("/contrat/abonne/{id:.+}")
    public ResponseEntity<List<Contrat>> recupererContrats(@PathVariable long idAbonne) {
        List<Contrat> contrats = this.contratService.recupererContrats(idAbonne);
        return ResponseEntity.ok(contrats);
    }
}
