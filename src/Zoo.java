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

    public void addAnimal(Animal animal) {
        if (currentIndex < animals.length) {
            animals[currentIndex] = animal;
            currentIndex++;
        } else {
            System.out.println("Le zoo est plein !");
        }
    }



    public String toString() {
        return "Zoo Name: " + name + ", City: " + city + ", nombres des cages: " + nbrCages;
    }
}
