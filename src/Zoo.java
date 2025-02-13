package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private int currentIndex;

    public Zoo(String name, String city, int nbrCages) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Nom par defaut";
        }
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[25];
        this.currentIndex = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Le nom du zoo ne peut pas etre vide !");
        }
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein ! Impossible d'ajouter plus d'animaux.");
            return false;
        }
        for (int i = 0; i < currentIndex; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                System.out.println("cet animal existe dejà dans le zoo.");
                return false;
            }
        }
        animals[currentIndex] = animal;
        currentIndex++;
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < currentIndex; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                for (int j = i; j < currentIndex - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[currentIndex - 1] = null;
                currentIndex--;
                return true;
            }
        }
        return false;
    }

    public void printAnimals() {
        System.out.println("Les animaux dans le zoo sont :");
        for (int i = 0; i < currentIndex; i++) {
            System.out.println("- " + animals[i].getName() + " (" + animals[i].getFamily() + "), Âge: " + animals[i].getAge() + " ans");
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < currentIndex; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return "Zoo Name: " + name + ", City: " + city + ", nombre des cages: " + nbrCages;
    }

    public boolean isZooFull() {
        return currentIndex >= nbrCages;
    }

    public Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.currentIndex > z2.currentIndex) {
            return z1;
        } else if (z1.currentIndex < z2.currentIndex) {
            return z2;
        } else {
            return null;
        }
    }
}
