package com.canalplus.abonnement.dto;

import java.io.Serializable;

public class ContratDTO implements Serializable {

    private static final long serialVersionUID = -5200458558422477193L;

    private long id;
    private String adresse;
    private AbonneDTO abonne;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public AbonneDTO getAbonne() {
        return abonne;
    }

    public void setAbonne(AbonneDTO abonne) {
        this.abonne = abonne;
    }

}
