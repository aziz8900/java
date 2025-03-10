package tn.esprit.entities;

public non-sealed class Aquatic extends Animal {

    public String habitat;


    public Aquatic() {
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public void swim() {

        System.out.println("This aquatic animal is swimming.");
    }


    @Override
    public String toString() {
        return "Aquatic{}";
    }
}