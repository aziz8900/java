package tn.esprit.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private int currentIndex;

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        setCity(city);
        this.nbrCages = nbrCages;
        this.animals = new Animal[nbrCages];
        this.currentIndex = 0;
    }
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < currentIndex; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }
    public String getName() { return name; }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
        else this.name = "Default Zoo";
    }

    public void setCity(String city) {
        if (city != null && !city.trim().isEmpty()) this.city = city;
        else this.city = "Default City";
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Zoo is full!");
            return false;
        }
        for (int i = 0; i < currentIndex; i++) {
            if (animals[i].equals(animal)) {
                System.out.println("Animal already exists!");
                return false;
            }
        }
        animals[currentIndex++] = animal;
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < currentIndex; i++) {
            if (animals[i].equals(animal)) {
                System.arraycopy(animals, i + 1, animals, i, currentIndex - i - 1);
                animals[--currentIndex] = null;
                return true;
            }
        }
        return false;
    }

    public void printAnimals() {
        System.out.println("Animals in " + name + ":");
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(animals[i]);
        }
    }

    public boolean isZooFull() {
        return currentIndex >= nbrCages;
    }


    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.currentIndex > z2.currentIndex) {
            return z1;
        } else if (z1.currentIndex < z2.currentIndex) {
            return z2;
        } else {
            return null; // Zoos have the same number of animals
        }
    }



}