package com.bank.model;

public class Personne {
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() { return nom.toUpperCase(); }
    public String getPrenom() { return prenom; }

    @Override
    public String toString() {
        return prenom + " " + getNom();
    }
}