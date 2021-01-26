package com.canalplus.abonnement.service;

import com.canalplus.abonnement.dto.AbonneDTO;
import com.canalplus.abonnement.dto.ContratDTO;
import com.canalplus.abonnement.entity.Contrat;
import com.canalplus.abonnement.mapper.ContratMapper;
import com.canalplus.abonnement.repository.AbonneRepository;
import com.canalplus.abonnement.repository.ContratRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratService {

    private final ContratRepository contratRepository;
    private final AbonneRepository abonneRepository;
    private final ContratMapper contratMapper;

    public ContratService(ContratRepository contratRepository, AbonneRepository abonneRepository, ContratMapper contratMapper) {
        this.contratRepository = contratRepository;
        this.abonneRepository = abonneRepository;
        this.contratMapper = contratMapper;
    }

    public Contrat creerContrat(long idAbonne, String adresse) {
        ContratDTO contratDTO = new ContratDTO();
        contratDTO.setAdresse(adresse);

        abonneRepository.findById(idAbonne).ifPresent(abonne -> {
            contratDTO.setAbonne(new AbonneDTO(idAbonne));
        });

        return contratRepository.save(contratMapper.fromDto(contratDTO));
    }

    public List<Contrat> recupererContrats(long idAbonne) {
        return contratRepository.findAllByAbonneId(idAbonne);
    }
}
