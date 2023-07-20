package org.lessons.java.shop;
/*
*   BONUS 1:  Aggiungere una classe Categoria (con nome e descrizione) e associare ad ogni Prodotto una categoria usando la composizione:
*
*/
public class Category {
    //declaration variables
    private String name;
    private String description;

    //CONSTRUCTOR
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //SETTER AND GETTER
        //get
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

     //set
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
