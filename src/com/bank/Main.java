package com.bank;

import com.bank.model.*;
import com.bank.services.*;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";
    public static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        BankService banque = new BankService();
        Scanner scanner = new Scanner(System.in);
        boolean enCours = true;

        // --- LOGO ---
        System.out.println(GREEN + BOLD);
        System.out.println("     ██╗ █████╗ ██╗   ██╗ █████╗     ██████╗  █████╗ ███╗   ██╗██╗  ██╗    ███████╗██╗   ██╗███████╗████████╗███████╗███╗   ███╗");
        System.out.println("     ██║██╔══██╗██║   ██║██╔══██╗    ██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝    ██╔════╝╚██╗ ██╔╝██╔════╝╚══██╔══╝██╔════╝████╗ ████║");
        System.out.println("     ██║███████║██║   ██║███████║    ██████╔╝███████║██╔██╗ ██║█████╔╝     ███████╗ ╚████╔╝ ███████╗   ██║   █████╗  ██╔████╔██║");
        System.out.println("██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗     ╚════██║  ╚██╔╝  ╚════██║   ██║   ██╔══╝  ██║╚██╔╝██║");
        System.out.println("╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    ██████╔╝██║  ██║██║ ╚████║██║  ██╗    ███████║   ██║   ███████║   ██║   ███████╗██║ ╚═╝ ██║");
        System.out.println(" ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝    ╚══════╝   ╚═╝   ╚══════╝   ╚═╝   ╚══════╝╚═╝     ╚═╝");
        System.out.println(RESET + CYAN + "                                       >> Terminal Banking System <<\n" + RESET);

        while (enCours) {
            System.out.println("\n--- MENU ---");
            System.out.println("[ 1 ]  Create an account");
            System.out.println("[ 2 ]  make a deposit");
            System.out.println("[ 3 ]  make a withdrawal");
            System.out.println("[ 4 ]  display the list of accounts");
            System.out.println("[ 5 ]  exit");
            System.out.print("choice   : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Account number : "); String num = scanner.nextLine();
                    System.out.print("Last name : "); String nom = scanner.nextLine();
                    System.out.print("first name : "); String prenom = scanner.nextLine();
                    System.out.print("initial balance : "); double solde = scanner.nextDouble();
                    banque.ajouterCompte(num, nom, prenom, solde);
                    System.out.println(GREEN + "Account successfully created!" + RESET);
                }
                case 2 -> {
                    System.out.print("Account number : "); String n = scanner.nextLine();
                    Compte c = banque.trouverCompte(n);
                    if (c != null) {
                        System.out.print("Amount to deposit : ");
                        c.deposer(scanner.nextDouble());
                    } else { System.out.println(RED + "Account not found." + RESET); }
                }
                case 3 -> {
                    System.out.print("Account number : "); String n = scanner.nextLine();
                    Compte c = banque.trouverCompte(n);
                    if (c != null) {
                        System.out.print("Amount to withdraw : ");
                        if (!c.retirer(scanner.nextDouble())) System.out.println(RED + "Insufficient funds." + RESET);
                    } else { System.out.println(RED + "Account not found." + RESET); }
                }
                case 4 -> banque.afficherTousLesComptes();
                case 5 -> {
                    enCours = false;
                    System.out.println("Closing the system...");
                }
                default -> System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}