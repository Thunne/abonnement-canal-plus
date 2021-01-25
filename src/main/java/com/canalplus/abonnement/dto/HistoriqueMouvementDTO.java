package com.canalplus.abonnement.dto;

import java.io.Serializable;
import java.util.Date;

public class HistoriqueMouvementDTO implements Serializable {

    private static final long serialVersionUID = -7156245548765077887L;

    private long id;
    private AbonneDTO abonne;
    private ContratDTO contrat;
    private String modificationType;
    private Date modificationDate;
    private String ancienneAdresse;
    private String nouvelleAdresse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AbonneDTO getAbonne() {
        return abonne;
    }

    public void setAbonne(AbonneDTO abonne) {
        this.abonne = abonne;
    }

    public ContratDTO getContrat() {
        return contrat;
    }

    public void setContrat(ContratDTO contrat) {
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
