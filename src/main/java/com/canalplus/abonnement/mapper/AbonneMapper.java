package com.canalplus.abonnement.mapper;

import com.canalplus.abonnement.dto.AbonneDTO;
import com.canalplus.abonnement.entity.Abonne;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ContratMapper.class)
public interface AbonneMapper {
    Abonne fromDto(AbonneDTO abonneDTO);

    AbonneDTO toDto(Abonne abonne);
}
