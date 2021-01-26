package com.canalplus.abonnement;

import com.canalplus.abonnement.constant.HistoriqueMouvementConstant;
import com.canalplus.abonnement.dto.AbonneDTO;
import com.canalplus.abonnement.entity.Abonne;
import com.canalplus.abonnement.entity.Contrat;
import com.canalplus.abonnement.entity.HistoriqueMouvement;
import com.canalplus.abonnement.service.abonne.AbonneService;
import com.canalplus.abonnement.service.contrat.ContratService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.testng.Assert.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = AbonnementApplication.class)
public class StepDefinitions {
    private Abonne abonne;

    @Autowired
    private AbonneService abonneService;

    @Autowired
    private ContratService contratService;

    @Given("un abonné avec plusieurs contrats et une adresse principale en France")
    public void un_abonne_avec_plusieurs_contrats_et_une_adresse_principale_en_France() {
        AbonneDTO abonneDTO = new AbonneDTO();
        abonneDTO.setAdresse("8 Place de Fourvière, 69005 Lyon");
        abonneDTO.setNom("Michel");
        abonneDTO.setPrenom("Jean");
        this.abonneService.save(abonneDTO);

        contratService.creerContrat(1L, "8 Place de Fourvière, 69005 Lyon");
        contratService.creerContrat(1L, "8 Place de Fourvière, 69005 Lyon");
        contratService.creerContrat(1L, "8 Place de Fourvière, 69005 Lyon");

        this.abonne = this.abonneService.get(1L);
    }

    @Given("un abonné avec plusieurs contrats et une adresse principale à l’international")
    public void un_abonne_avec_plusieurs_contrats_et_une_adresse_principale_a_l_international() {
        AbonneDTO abonneDTO = new AbonneDTO();
        abonneDTO.setAdresse("Westminster, London SW1A 1AA, Royaume-Uni");
        abonneDTO.setNom("Michel");
        abonneDTO.setPrenom("Jean");
        this.abonneService.save(abonneDTO);

        contratService.creerContrat(1L, "Westminster, London SW1A 1AA, Royaume-Uni");
        contratService.creerContrat(1L, "Westminster, London SW1A 1AA, Royaume-Uni");
        contratService.creerContrat(1L, "Westminster, London SW1A 1AA, Royaume-Uni");

        this.abonne = this.abonneService.get(1L);
    }

    @When("le conseiller modifie l'adresse de l'abonné")
    public void le_conseiller_modifie_l_adresse_de_l_abonne() {
        AbonneDTO abonneDTO = new AbonneDTO();
        abonneDTO.setId(1L);
        abonneDTO.setAdresse("16 Place de la Concorde, 75014 Paris");
        abonneDTO.setNom("Michel");
        abonneDTO.setPrenom("Jean");

        // Modification de l'adresse de l'abonné avec une nouvelle adresse en France
        this.abonneService.save(abonneDTO);
        this.abonne = this.abonneService.get(abonneDTO.getId());
    }

    @Then("la nouvelle adresse de l’abonné est enregistrée sur l'ensemble des contrats de l'abonné")
    public void la_nouvelle_adresse_de_l_abonne_est_enregistrée_sur_l_ensemble_des_contrats_de_l_abonne() {
        for(Contrat contrat : this.abonne.getContrats()) {
            assertEquals("16 Place de la Concorde, 75014 Paris", contrat.getAdresse());
        }
    }

    @Then("l’adresse est modifiée uniquement sur le premier contrat de l’abonné")
    public void l_adresse_est_modifiee_uniquement_sur_le_premier_contrat_de_l_abonne() {
        assertEquals("Westminster, London SW1A 1AA, Royaume-Uni", this.abonne.getContrats().get(0).getAdresse());
    }

    @And("un mouvement de modification d'adresse est créé avec la nouvelle adresse")
    public void un_mouvement_de_modification_d_adresse_est_cree_avec_la_nouvelle_adresse() {
        HistoriqueMouvement historiqueMouvement = this.abonne.getHistoriqueMouvements().get(this.abonne.getHistoriqueMouvements().size() - 1);

        assertEquals("8 Place de Fourvière, 69005 Lyon", historiqueMouvement.getAncienneAdresse());
        assertEquals("16 Place de la Concorde, 75014 Paris", historiqueMouvement.getNouvelleAdresse());
        assertEquals(this.abonne, historiqueMouvement.getAbonne());
        assertEquals(HistoriqueMouvementConstant.Type.MODIFICATION.getType(), historiqueMouvement.getModificationType());
    }
}
