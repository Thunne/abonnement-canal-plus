package com.canalplus.abonnement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "adresse")
    private String adresse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Abonne abonne;

    @OneToMany(mappedBy = "contrat", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<HistoriqueMouvement> historiqueMouvements;

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

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public List<HistoriqueMouvement> getHistoriqueMouvements() {
        return historiqueMouvements;
    }

    public void setHistoriqueMouvements(List<HistoriqueMouvement> historiqueMouvements) {
        this.historiqueMouvements = historiqueMouvements;
    }
}
