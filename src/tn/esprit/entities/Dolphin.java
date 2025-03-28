package tn.esprit.entities;

public class Dolphin extends Aquatic {
    private float swimmingSpeed;

    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public void swim() {
        System.out.println("This dolphin is swimming gracefully at " + swimmingSpeed + " km/h.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Speed: " + swimmingSpeed + " km/h";
    }
}