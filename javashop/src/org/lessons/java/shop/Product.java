package org.lessons.java.shop;

/*
*   Nel progetto java-oop-shop, package org.lessons.java.shop, creare la classe Prodotto che gestisce i prodotti dello shop.
*   Un prodotto è caratterizzato da:
*    - codice (numero intero)
*    - nome
*    - descrizione
*    - prezzo
*    - iva
*   Usate opportunamente i livelli di accesso (public, private), i costruttori, i metodi getter e setter ed
*   eventuali altri metodi di “utilità” per fare in modo che:
*
*    alla creazione di un nuovo prodotto il codice sia valorizzato con un numero random
*    Il codice prodotto sia accessibile solo in lettura
*    Gli altri attributi siano accessibili sia in lettura che in scrittura
*    Il prodotto esponga sia un metodo per avere il prezzo base che uno per avere il prezzo comprensivo di iva
*    Il prodotto esponga un metodo per avere il nome esteso, ottenuto concatenando codice-nome: il codice deve avere un pad left di zeri per
*    arrivare a 8 caratteri (ad esempio codice 91 diventa 00000091, mentre codice 123445567 resta come è)
*
*   Nello stesso package aggiungete una classe Main con metodo main nella quale create uno o più prodotti e testate tutte le funzionalità della classe
*   (cioè tutti i metodi public):
*
*   BONUS 1:  Aggiungere una classe Categoria (con nome e descrizione) e associare ad ogni Prodotto una categoria usando la composizione:
*   BONUS 2: Permettere di associare più di una Categoria ad ogni prodotto (usare quindi una ArrayList di categorie come tipo di attributo)Buon lavoro!
*/
import java.util.Random;

public class Product {
    //declaration variables
    private String uniqueCode;
    private String name;
    private String description;
    private double price;
    private double iva;
    private Category categories;

    //CONSTRUCTOR
    public Product(String name, String description, double price, double iva, Category categories) {
        this.uniqueCode = uniqueCodeGenerator();
        this.name = name;
        this.description = description;
        this.price = price;
        this.iva = iva;
        this.categories = categories;
    }

    //SETTER AND GETTER
        //get
    public String getUniqueCode() {
        return uniqueCode;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public double getIva() {
        return iva;
    }
        //set
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setIva(double iva) {
        this.iva = iva;
    }


    //METHODS
        //method for full name: name + unique code
    public String fullNameProduct() {
        return uniqueCode + "-" + name;
    }

        //method for calculate price whit IVA
    public double priceWhitIva(double priceWhitIva) {
        return  priceWhitIva = price + (price * (iva/100));
    }

    //OVERRIDE METHOD
    @Override
    public String toString() {
        return "Product{" +
                "uniqueCode='" + uniqueCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", iva=" + iva +
                ", categories=" + categories +
                '}';
    }

    //PRIVATE METHODS
        // generator of unique code
    private String uniqueCodeGenerator() {
        //creation number random
        Random randomNum = new Random();
        uniqueCode = Integer.toString(randomNum.nextInt(1, 199999999));
        //Check if the length of the random number is less than 9 and if so add "0" on the left until it reaches 9 digits
        while (uniqueCode.length() < 9) {
            uniqueCode = "0" + uniqueCode;
        }
        return uniqueCode;
    }

}
