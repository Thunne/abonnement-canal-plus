package com.canalplus.abonnement.service;

import com.canalplus.abonnement.AbonnementApplication;
import com.canalplus.abonnement.constant.HistoriqueMouvementConstant;
import com.canalplus.abonnement.dto.AbonneDTO;
import com.canalplus.abonnement.entity.Abonne;
import com.canalplus.abonnement.repository.AbonneRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.*;

@SpringBootTest(classes = AbonnementApplication.class)
@ActiveProfiles("test")
public class AbonneServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AbonneService abonneService;

    @Autowired
    private AbonneRepository abonneRepository;

    private MockMvc mockMvc;

    @BeforeClass
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @BeforeTest(enabled = false)
    private void init() {
        AbonneDTO abonneDTO = new AbonneDTO();
        abonneDTO.setAdresse("8 Place de Fourvière, 69005 Lyon");
        abonneDTO.setNom("Michel");
        abonneDTO.setPrenom("Jean");
        this.abonneService.save(abonneDTO);
    }

    @AfterTest(enabled = false)
    private void end() {
        this.abonneRepository.deleteAll();
    }

    /**
     * Test la création d'un abonné
     */
    @Test(priority = 1, enabled = false)
    public void creerAbonneTest() {
        AbonneDTO abonneDTO = new AbonneDTO();
        abonneDTO.setAdresse("8 Place de Fourvière, 69005 Lyon");
        abonneDTO.setNom("Michel");
        abonneDTO.setPrenom("Jean");

        Abonne abonne = abonneService.save(abonneDTO);

        Assert.assertEquals(abonne.getAdresse(), "8 Place de Fourvière, 69005 Lyon");
        Assert.assertEquals(abonne.getPrenom(), "Jean");
        Assert.assertEquals(abonne.getNom(), "Michel");
        Assert.assertEquals(abonne.getHistoriqueMouvements().size(), 1);
        Assert.assertEquals(abonne.getHistoriqueMouvements().get(0).getModificationType(), HistoriqueMouvementConstant.Type.CREATION.getType());
        Assert.assertTrue(abonne.getContrats().isEmpty());
    }

    @Test(priority = 2, enabled = false)
    public void modifierAbonneTest() {
        AbonneDTO abonneModifie = new AbonneDTO(1L);
        abonneModifie.setAdresse("5 rue des Paquerettes, 75016 Paris");
        abonneModifie.setNom("Marcel");
        abonneModifie.setPrenom("Pagnol");

        Abonne abonne = abonneService.save(abonneModifie);

        Assert.assertEquals(abonne.getId(), abonne.getId());
        Assert.assertEquals(abonne.getAdresse(), abonne.getAdresse());
        Assert.assertEquals(abonne.getPrenom(), abonne.getPrenom());
        Assert.assertEquals(abonne.getNom(), abonne.getNom());
        Assert.assertEquals(abonne.getHistoriqueMouvements().size(), 2);
        Assert.assertEquals(abonne.getHistoriqueMouvements().get(1).getModificationType(), HistoriqueMouvementConstant.Type.MODIFICATION.getType());
        Assert.assertTrue(abonne.getContrats().isEmpty());
    }
}
