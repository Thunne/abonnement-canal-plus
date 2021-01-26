package com.canalplus.abonnement.service;

import com.canalplus.abonnement.constant.HistoriqueMouvementConstant;
import com.canalplus.abonnement.dto.AbonneDTO;
import com.canalplus.abonnement.dto.ContratDTO;
import com.canalplus.abonnement.dto.HistoriqueMouvementDTO;
import com.canalplus.abonnement.entity.Abonne;
import com.canalplus.abonnement.entity.Contrat;
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

    public AbonneService(AbonneRepository abonneRepository, AbonneMapper abonneMapper) {
        this.abonneRepository = abonneRepository;
        this.abonneMapper = abonneMapper;
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
            historiqueMouvement.setNouvelleAdresse(abonne.getAdresse());

            // On modifie les adresses dans les contrats déjà présent
            if(!abonneModifie.getContrats().isEmpty()) {
                List<ContratDTO> contrats = new ArrayList<>();
                for(Contrat contrat : abonneModifie.getContrats()) {
                    ContratDTO contratDTO = new ContratDTO();
                    contratDTO.setId(contrat.getId());
                    contratDTO.setAdresse(abonne.getAdresse());
                    contratDTO.setAbonne(abonne);
                    contrats.add(contratDTO);
                }

                abonne.setContrats(contrats);
            }

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
