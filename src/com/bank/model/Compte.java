package com.bank.model;

public class Compte {
    private String numero;
    private double solde;
    private Personne titulaire;

    public Compte(String numero, Personne titulaire, double soldeInitial) {
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = soldeInitial;
    }

    public void deposer(double montant) {
        if (montant > 0) solde += montant;
    }

    public boolean retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            return true;
        }
        return false;
    }

    public String getNumero() { return numero; }
    public double getSolde() { return solde; }
    public Personne getTitulaire() { return titulaire; }
}