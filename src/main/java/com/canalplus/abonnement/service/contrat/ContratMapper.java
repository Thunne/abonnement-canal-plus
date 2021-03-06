package com.canalplus.abonnement.service.contrat;

import com.canalplus.abonnement.dto.ContratDTO;
import com.canalplus.abonnement.entity.Contrat;
import com.canalplus.abonnement.service.abonne.AbonneMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AbonneMapper.class)
public interface ContratMapper {

    Contrat fromDto(ContratDTO contratDTO);

    ContratDTO toDTO(Contrat contrat);
}
