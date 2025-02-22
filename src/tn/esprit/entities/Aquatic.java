package tn.esprit.entities;
import java.util.Objects;
public abstract class Aquatic extends Animal {
    private String habitat;

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }


    public abstract void swim();

    @Override
    public String toString() {
        return super.toString() + ", Habitat: " + habitat;
    }
    @Override
    public boolean equals(Object obj) {
        // Check if the object is compared to itself
        if (this == obj) {
            return true;
        }


        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }


        Aquatic aquatic = (Aquatic) obj;


        return this.getName().equals(aquatic.getName()) &&
                this.getAge() == aquatic.getAge() &&
                this.habitat.equals(aquatic.habitat);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), habitat);
    }
}