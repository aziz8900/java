package tn.esprit.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private int currentIndex;
    private Aquatic[] aquaticAnimals = new Aquatic[10];

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
            return null;
        }
    }
    public void addAquaticAnimal(Aquatic aquatic) {
        for (int i = 0; i < aquaticAnimals.length; i++) {
            if (aquaticAnimals[i] == null) {
                aquaticAnimals[i] = aquatic;
                System.out.println("Ajout de l'animal aquatique : " + aquatic.getName());
                return;
            }
        }
        System.out.println("Impossible d'ajouter " + aquatic.getName() + ", l'espace aquatique est plein !");
    }

    public void makeAquaticAnimalsSwim() {
        System.out.println("Les animaux aquatiques nagent :");
        for (Aquatic aquatic : aquaticAnimals) {
            if (aquatic != null) {
                aquatic.swim();
            }
        }
    }
    public float maxPenguinSwimmingDepth() {
        float maxDepth = -1;

        for (Aquatic aquatic : aquaticAnimals) {
            if (aquatic instanceof Penguin) {
                Penguin penguin = (Penguin) aquatic;
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }

        if (maxDepth == -1) {
            System.out.println("Aucun pingouin trouvé dans le zoo.");
        }

        return maxDepth;
    }
    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;

        for (Aquatic aquatic : aquaticAnimals) {
            if (aquatic instanceof Dolphin) {
                dolphinCount++;
            } else if (aquatic instanceof Penguin) {
                penguinCount++;
            }
        }

        System.out.println("Nombre de dauphins dans le zoo : " + dolphinCount);
        System.out.println("Nombre de pingouins dans le zoo : " + penguinCount);
    }
}