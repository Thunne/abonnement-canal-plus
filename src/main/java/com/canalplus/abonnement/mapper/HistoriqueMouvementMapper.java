package com.canalplus.abonnement.mapper;

import com.canalplus.abonnement.dto.HistoriqueMouvementDTO;
import com.canalplus.abonnement.entity.HistoriqueMouvement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AbonneMapper.class, ContratMapper.class})
public interface HistoriqueMouvementMapper {
    HistoriqueMouvement fromDto(HistoriqueMouvementDTO historiqueMouvementDTO);

    HistoriqueMouvementDTO toDto(HistoriqueMouvement historiqueMouvement);
}
