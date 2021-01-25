package com.canalplus.abonnement.service;

import com.canalplus.abonnement.dto.AbonneDTO;
import com.canalplus.abonnement.dto.HistoriqueMouvementDTO;
import com.canalplus.abonnement.entity.Abonne;
import com.canalplus.abonnement.mapper.AbonneMapper;
import com.canalplus.abonnement.mapper.HistoriqueMouvementMapper;
import com.canalplus.abonnement.repository.AbonneRepository;
import com.canalplus.abonnement.repository.HistoriqueMouvementRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AbonneService {

    private final AbonneRepository abonneRepository;
    private final AbonneMapper abonneMapper;
    private final HistoriqueMouvementRepository historiqueMouvementRepository;
    private final HistoriqueMouvementMapper historiqueMouvementMapper;

    public AbonneService(AbonneRepository abonneRepository, HistoriqueMouvementRepository historiqueMouvementRepository, AbonneMapper abonneMapper, HistoriqueMouvementMapper historiqueMouvementMapper) {
        this.abonneRepository = abonneRepository;
        this.historiqueMouvementRepository = historiqueMouvementRepository;
        this.abonneMapper = abonneMapper;
        this.historiqueMouvementMapper = historiqueMouvementMapper;
    }

    public Abonne save(AbonneDTO abonne) {
        return abonneRepository.save(abonneMapper.fromDto(abonne));
    }
}
