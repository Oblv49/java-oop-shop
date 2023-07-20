package org.lessons.java.shop;
/*
 *   Creo un programma che chiede all'utente di creare delle categorie prodotto utilizzando la classe categorie,
 *   poi chiedo all'utente di inserire i prodotti e di assegnargli una categoria o più,
 *   infine mostro la lista selezionabile dei prodotti,
 *   una volta selezionato il prodotto posso decidere che info vedere:
 *   -se vedere tutte le info del prodotto
 *   -se stampare nome e codice univoco
 *   -se vedere il prezzo
 *   -se vedere il prezzo+iva
 *
 *    BONUS 2: Permettere di associare più di una Categoria ad ogni prodotto (usare quindi una ArrayList di categorie come tipo di attributo)Buon lavoro!
 */

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //declaration variables
        Scanner input = new Scanner(System.in);
        ArrayList<Category> categories = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        int userChoose;

        do {
            //welcome
            System.out.println("Benvenuto nel gestionale del tuo SHOP!");
            System.out.println("Potrai inserire Categorie Prodotto e Prodotti e visualizzare le loro informazioni!");
            System.out.println("Iniziamo!");
            System.out.println("------------------------------------------------");

            //start program
            System.out.println("Vuoi inserire una Categoria?");
            System.out.println(" ");
            System.out.println("1. Si");
            System.out.println("2. No");
            System.out.print("Scegli: ");
            userChoose = Integer.parseInt(input.nextLine());
            System.out.println("------------------------------------------------");

            switch (userChoose) {
                //case 1: user insert category
                case 1:
                    //insert categories
                    do {
                        System.out.println("Inserisci il nome della categoria:");
                        String nameCategory = input.nextLine();
                        System.out.println("Inserisci la descrizione della categoria:");
                        String descriptionCategory = input.nextLine();
                        Category category = new Category(nameCategory, descriptionCategory);
                        categories.add(category);
                        System.out.println("Vuoi inserire una Categoria?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        userChoose = Integer.parseInt(input.nextLine());
                    } while (userChoose == 1);

                    System.out.println("Hai inserito: " + categories.size() + " categorie!");
                    System.out.println("------------------------------------------------");
                    System.out.println("Vuoi inserire un prodotto?");
                    System.out.println(" ");
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    userChoose = Integer.parseInt(input.nextLine());
                    System.out.println("------------------------------------------------");

                do {
                    switch (userChoose) {
                        //case 1: user insert product
                        case 1:
                            do {
                                        System.out.println("Verrà assegnato un codice univoco ad ogni prodotto che inserirai!");
                                        System.out.println("Inserisci il nome del Prodotto: ");
                                        String nameProduct = input.nextLine();
                                        System.out.println("Inserisci una descrizione del tuo prodotto: ");
                                        String descriptionProduct = input.nextLine();
                                        System.out.println("Inserisci il prezzo del tuo prodotto senza IVA:");
                                        double price = (double) Integer.parseInt(input.nextLine());
                                        System.out.println("Inserisci l'IVA da applicare al prodotto:");
                                        double iva = (double) Integer.parseInt(input.nextLine());

                                        //user choose the category for product
                                        System.out.println("Scegli la categoria per questo prodotto:");
                                        for (int i = 0; i < categories.size(); i++) {
                                            System.out.println((i + 1) + ". " + categories.get(i).getName() + ", " + categories.get(i).getDescription());
                                        }
                                        int categoryChoice = Integer.parseInt(input.nextLine());
                                        if (categoryChoice >= 1 && categoryChoice <= categories.size()) {
                                            int indexCategory = categoryChoice - 1;
                                            Category categorySelected = categories.get(indexCategory);
                                            Product product = new Product(nameProduct, descriptionProduct, price, iva, categorySelected);
                                            products.add(product);
                                        } else {
                                            System.out.println("Scelta non valida.");
                                            break;
                                        }

                                        System.out.println("------------------------------------------------");
                                        System.out.println("Vuoi inserire un prodotto?");
                                        System.out.println("1. Si");
                                        System.out.println("2. No");
                                        userChoose = Integer.parseInt(input.nextLine());
                                        System.out.println("------------------------------------------------");

                            } while (userChoose == 1);

                                    System.out.println("Hai inserito: " + products.size() + " prodotti!");
                                    System.out.println("------------------------------------------------");

                                    System.out.println("Cosa Desideri fare adesso?");
                                    System.out.println(" ");
                                    System.out.println("1. Vedere tutti i prodotti inseriti");
                                    System.out.println("2. Vedere il nome completo (nome e codice univoco) dei prodotti.");
                                    System.out.println("3. Vedere il prezzo dei un prodotti.");
                                    System.out.println("4. Vedere il prezzo + IVA dei prodotti.");
                                    System.out.println("5. Vedere tutte le informazioni di un prodotto.");
                                    System.out.println("6. Vedere tutte le categorie.");
                                    System.out.println("7. Uscire.");
                                    userChoose = Integer.parseInt(input.nextLine());
                                    System.out.println("------------------------------------------------");

                                    switch (userChoose) {
                                        case 1:
                                            System.out.println(" ");
                                            System.out.println("Ecoo i prodotti che hai inserito: ");
                                            System.out.println("------------------------------------------------");
                                            for (int i = 0; i < products.size(); i++) {
                                                System.out.println((i + 1) + ". " + products.get(i).getName() + ", " + products.get(i).getDescription());
                                            }
                                            break;
                                        case 2:
                                            System.out.println(" ");
                                            System.out.println("Ecoo i nomi completi dei prodotti che hai inserito: ");
                                            System.out.println("------------------------------------------------");
                                            for (int i = 0; i < products.size(); i++) {
                                                System.out.println((i + 1) + ". " + products.get(i).fullNameProduct());
                                            }
                                            break;
                                        case 3:
                                            System.out.println(" ");
                                            System.out.println("Ecoo i prezzi dei prodotti: ");
                                            System.out.println("------------------------------------------------");
                                            for (int i = 0; i < products.size(); i++) {

                                                System.out.println((i + 1) + ". " + products.get(i).getName() + " " + products.get(i).getPrice());
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Ecoo i prodotti con il prezzo più IVA: ");
                                            System.out.println("------------------------------------------------");
                                            for (int i = 0; i < products.size(); i++) {
                                                double priceWhitIva = -1;
                                                System.out.println((i + 1) + ". " + products.get(i).getName() + " " + products.get(i).priceWhitIva(priceWhitIva));
                                            }
                                            break;
                                        case 5:
                                            System.out.println(" ");
                                            System.out.println("Ecoo i prodotti che hai inserito: ");
                                            System.out.println("------------------------------------------------");
                                            for (int i = 0; i < products.size(); i++) {
                                                System.out.println((i + 1) + ". " + products.get(i).getName());
                                            }
                                            System.out.println("Scegli il prodotto da Visualizare: ");
                                            double priceWhitIva = -1;
                                            userChoose = Integer.parseInt(input.nextLine()) - 1;
                                            System.out.println("Eccolo le INFO del prodotto selezionato: " + products.get(userChoose).toString() + products.get(userChoose).priceWhitIva(priceWhitIva));
                                            break;
                                        case 6:
                                            System.out.println(" ");
                                            System.out.println("Ecoo le categorie che hai inserito: ");
                                            System.out.println("------------------------------------------------");
                                            for (int i = 0; i < categories.size(); i++) {
                                                System.out.println((i + 1) + ". " + categories.get(i).getName() + ", " + categories.get(i).getDescription());
                                            }
                                            break;
                                        case 7:
                                            System.out.println(" ");
                                            System.out.println("Perfetto!");
                                            System.out.println("Grazie e Alla Prossima!");
                                            System.out.println("------------------------------------------------");
                                            break;
                                        default:
                                            System.out.println("Scelta non valida.");
                                            break;
                                    }
                                    break;

                                case 2:
                                    System.out.println("Grazie per aver inserito queste categorie: ");
                                    System.out.println(" ");
                                    for (int i = 0; i < categories.size(); i++) {
                                        System.out.println((i + 1) + ". " + categories.get(i).getName() + ", " + categories.get(i).getDescription());
                                    }
                                    System.out.println("------------------------------------------------");
                                    break;
                                default:
                                    System.out.println("Scelta non valida.");
                            }

                            System.out.println("Vuoi tornare al menù principale?");
                            System.out.println("1. Si");
                            System.out.println("2. No, voglio uscire dal programma.");
                            userChoose = Integer.parseInt(input.nextLine());

                    } while (userChoose == 1);
                    break;

                case 2:
                    System.out.println("Devi Inserire una categoria altrimenti torna dopo!");
                    break;

                default:
                    System.out.println("Scelta non valida.");
                    break;
            }

            if(userChoose == 2) {
                System.out.println("Ok stai per uscire dal programma...");
            } else {
                System.out.println("Vuoi tornare al menù principale?");
                System.out.println("1. Si");
                System.out.println("2. No, voglio uscire dal programma.");
                userChoose = Integer.parseInt(input.nextLine());
            }

        } while (userChoose == 1);

        //exit program
        System.out.println("E' stato un piacere! Alla Prossima!");

        //close scanner
        input.close();
    }
}