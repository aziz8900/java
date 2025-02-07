public class Zoo {
    Animal[] animals;
    String name;
    String city;
    int nbrCages;
    int currentIndex;

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[25];
        this.currentIndex = 0;
    }

    public boolean addAnimal(Animal animal) {
        if (currentIndex >= nbrCages) {
            System.out.println("Le zoo est plein ! Impossible d'ajouter plus d'animaux.");
            return false;
        }
        for (int i = 0; i < currentIndex; i++) {
            if (animals[i].name.equals(animal.name)) {
                System.out.println("Cet animal existe déjà dans le zoo.");
                return false;
            }
        }
        animals[currentIndex] = animal;
        currentIndex++;
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < currentIndex; i++) {
            if (animals[i].name.equals(animal.name)) {

                for (int j = i; j < currentIndex - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[currentIndex - 1] = null;
                currentIndex--;
                return true;
            }
        }
        return false; // Animal not found
    }

    public void printAnimals() {
        System.out.println("Les animaux dans le zoo sont :");
        for (int i = 0; i < currentIndex; i++) {
            System.out.println("- " + animals[i].name + " (" + animals[i].family + "), Âge: " + animals[i].age + " ans");
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < currentIndex; i++) {
            if (animals[i].name.equals(animal.name)) {
                return i; // Return index if found
            }
        }
        return -1;
    }

    public String toString() {
        return "Zoo Name: " + name + ", City: " + city + ", nombres des cages: " + nbrCages;
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
