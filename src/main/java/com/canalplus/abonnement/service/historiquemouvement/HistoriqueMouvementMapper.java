package com.canalplus.abonnement.service.historiquemouvement;

import com.canalplus.abonnement.dto.HistoriqueMouvementDTO;
import com.canalplus.abonnement.entity.HistoriqueMouvement;
import com.canalplus.abonnement.service.abonne.AbonneMapper;
import com.canalplus.abonnement.service.contrat.ContratMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AbonneMapper.class, ContratMapper.class})
public interface HistoriqueMouvementMapper {
    @Mapping(target = "abonne.historiqueMouvements", ignore = true)
    HistoriqueMouvement fromDto(HistoriqueMouvementDTO historiqueMouvementDTO);

    HistoriqueMouvementDTO toDto(HistoriqueMouvement historiqueMouvement);
}
