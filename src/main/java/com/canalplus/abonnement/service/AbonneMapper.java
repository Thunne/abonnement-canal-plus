package com.canalplus.abonnement.service;

import com.canalplus.abonnement.dto.AbonneDTO;
import com.canalplus.abonnement.entity.Abonne;
import com.canalplus.abonnement.mapper.ContratMapper;
import com.canalplus.abonnement.mapper.HistoriqueMouvementMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = { ContratMapper.class, HistoriqueMouvementMapper.class})
public abstract class AbonneMapper {
    abstract Abonne fromDto(AbonneDTO abonneDTO);

    abstract AbonneDTO toDto(Abonne abonne);

    @AfterMapping
    void foreachHistoriqueMouvementSetAbonne(@MappingTarget Abonne abonne) {
        if(abonne.getHistoriqueMouvements() != null) {
            abonne.getHistoriqueMouvements().forEach(historiqueMouvement -> historiqueMouvement.setAbonne(abonne));
        }
    }
}
