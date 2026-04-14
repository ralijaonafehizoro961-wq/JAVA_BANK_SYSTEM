package com.bank.services;

import com.bank.model.*;
import java.util.ArrayList;

public class BankService {
    private ArrayList<Compte> listeComptes = new ArrayList<>();

    public void ajouterCompte(String num, String nom, String prenom, double solde) {
        Personne p = new Personne(nom, prenom);
        Compte c = new Compte(num, p, solde);
        listeComptes.add(c);
    }

    public Compte trouverCompte(String numero) {
        for (Compte c : listeComptes) {
            if (c.getNumero().equals(numero)) return c;
        }
        return null;
    }

    public void afficherTousLesComptes() {
        if (listeComptes.isEmpty()) {
            System.out.println("No account registered.");
            return;
        }
        for (Compte c : listeComptes) {
            System.out.println("Account: " + c.getNumero() + " | owner: " + c.getTitulaire() + " | sales: " + c.getSolde() + "€");
        }
    }
}