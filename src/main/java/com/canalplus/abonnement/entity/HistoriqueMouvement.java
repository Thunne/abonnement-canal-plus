package com.canalplus.abonnement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HistoriqueMouvement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "abonne_id")
    private Abonne abonne;

    @ManyToOne
    private Contrat contrat;

    @Column(name = "modification_type")
    private String modificationType;

    @Column(name = "modification_date")
    private Date modificationDate;

    @Column(name = "ancienne_adresse")
    private String ancienneAdresse;

    @Column(name = "nouvelle_adresse")
    private String nouvelleAdresse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public String getModificationType() {
        return modificationType;
    }

    public void setModificationType(String modificationType) {
        this.modificationType = modificationType;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getAncienneAdresse() {
        return ancienneAdresse;
    }

    public void setAncienneAdresse(String ancienneAdresse) {
        this.ancienneAdresse = ancienneAdresse;
    }

    public String getNouvelleAdresse() {
        return nouvelleAdresse;
    }

    public void setNouvelleAdresse(String nouvelleAdresse) {
        this.nouvelleAdresse = nouvelleAdresse;
    }
}
