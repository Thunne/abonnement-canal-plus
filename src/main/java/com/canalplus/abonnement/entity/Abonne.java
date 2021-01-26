package com.canalplus.abonnement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Abonne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "abonne", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<HistoriqueMouvement> historiqueMouvements;

    @OneToMany(mappedBy = "abonne", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Contrat> contrats;

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

    public List<HistoriqueMouvement> getHistoriqueMouvements() {
        return historiqueMouvements;
    }

    public void setHistoriqueMouvements(List<HistoriqueMouvement> historiqueMouvements) {
        this.historiqueMouvements = historiqueMouvements;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }
}
