package com.canalplus.abonnement.entity;

import javax.persistence.*;

@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "adresse")
    private String adresse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Abonne abonne;

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
}
