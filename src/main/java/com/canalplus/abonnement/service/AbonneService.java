package com.canalplus.abonnement.service;

import com.canalplus.abonnement.constant.HistoriqueMouvementConstant;
import com.canalplus.abonnement.dto.AbonneDTO;
import com.canalplus.abonnement.dto.HistoriqueMouvementDTO;
import com.canalplus.abonnement.entity.Abonne;
import com.canalplus.abonnement.entity.HistoriqueMouvement;
import com.canalplus.abonnement.mapper.HistoriqueMouvementMapper;
import com.canalplus.abonnement.repository.AbonneRepository;
import com.canalplus.abonnement.repository.HistoriqueMouvementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * Créer ou modifie un abonné
     * @param abonne L'abonné à ajouter ou à modifier (s'il y a un id)
     * @return Retourne l'objet abonné
     */
    @Transactional
    public Abonne save(AbonneDTO abonne) {
        List<HistoriqueMouvementDTO> historiqueMouvementsTmp = new ArrayList<>();

        // Initialisation de HistoriqueMouvementDTO
        HistoriqueMouvementDTO historiqueMouvement = new HistoriqueMouvementDTO();
        historiqueMouvement.setAbonne(abonne);
        historiqueMouvement.setModificationDate(new Date());
        historiqueMouvement.setNouvelleAdresse(abonne.getAdresse());

        // Dans le cas d'une modification
        if(abonne.getId() != null) {
            Abonne abonneModifie = this.get(abonne.getId());
            historiqueMouvement.setModificationType(HistoriqueMouvementConstant.Type.MODIFICATION.getType());
            historiqueMouvement.setAncienneAdresse(abonneModifie.getAdresse());

        // Dans le cas d'une création
        } else {
            historiqueMouvement.setModificationType(HistoriqueMouvementConstant.Type.CREATION.getType());
        }

        // Récupère la liste de l'historique mouvement
        historiqueMouvementsTmp.add(historiqueMouvement);
        abonne.getHistoriqueMouvements().addAll(historiqueMouvementsTmp);

        // Créer ou modifie une ligne dans la table abonné
        return abonneRepository.save(abonneMapper.fromDto(abonne));
    }

    /**
     * Récupère les informations d'un abonné par son id
     * @param id L'id de l'abonné
     * @return Retourne l'objet abonné
     */
    public Abonne get(Long id) {
        return abonneRepository.findById(id).orElse(null);
    }
}
