package com.canalplus.abonnement.web;

import com.canalplus.abonnement.dto.AbonneDTO;
import com.canalplus.abonnement.entity.Abonne;
import com.canalplus.abonnement.service.AbonneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AbonneResource {

    private final AbonneService abonneService;

    public AbonneResource(AbonneService abonneService) {
        this.abonneService = abonneService;
    }

    @PostMapping("/abonne")
    public ResponseEntity<Abonne> save(@RequestBody AbonneDTO abonne) {
        Abonne abonneReponse = this.abonneService.save(abonne);
        return ResponseEntity.ok(abonneReponse);
    }
}