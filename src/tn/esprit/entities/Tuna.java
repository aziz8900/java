package tn.esprit.entities;

public class Tuna extends Aquatic {
    public Tuna(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal, habitat);
    }

    @Override
    public void swim() {
        System.out.println("This tuna is swimming quickly through the ocean!");
    }
}