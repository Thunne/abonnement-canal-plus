package com.canalplus.abonnement.service.abonne;

import com.canalplus.abonnement.dto.AbonneDTO;
import com.canalplus.abonnement.entity.Abonne;
import com.canalplus.abonnement.service.contrat.ContratMapper;
import com.canalplus.abonnement.service.historiquemouvement.HistoriqueMouvementMapper;
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
