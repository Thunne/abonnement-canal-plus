package com.canalplus.abonnement.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AbonneDTO implements Serializable {

    private static final long serialVersionUID = -9187874845176198895L;

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private List<ContratDTO> contrats = new ArrayList<>();
    private List<HistoriqueMouvementDTO> historiqueMouvements = new ArrayList<>();

    public AbonneDTO(Long id) {
        this.id = id;
    }

    public AbonneDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<ContratDTO> getContrats() {
        return contrats;
    }

    public void setContrats(List<ContratDTO> contrats) {
        this.contrats = contrats;
    }

    public List<HistoriqueMouvementDTO> getHistoriqueMouvements() {
        return historiqueMouvements;
    }

    public void setHistoriqueMouvements(List<HistoriqueMouvementDTO> historiqueMouvements) {
        this.historiqueMouvements = historiqueMouvements;
    }
}
