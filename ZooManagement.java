import java.util.Scanner;

public class ZooManagement {
    int nbrCages = 20;
    String zooName = "my zoo";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZooManagement zoo = new ZooManagement();

        System.out.print("Entrez le nom du zoo : ");
        zoo.zooName = scanner.nextLine();
        while (zoo.zooName.isEmpty()) {
            System.out.print("le nom du zoo ne peut pas etre vide : ");
            zoo.zooName = scanner.nextLine();
        }

        System.out.print("entrez le nombre de cages : ");
        while (!scanner.hasNextInt()) {
            System.out.print(" entrer un nombre valide");
            scanner.next();
        }
        zoo.nbrCages = scanner.nextInt();

        System.out.println("Dans " + zoo.zooName + ", on a " + zoo.nbrCages + " cages non utilisees.");

        Animal lion = new Animal("Felidae", "Lion", 35, true);
        Animal panda = new Animal("Ursidae", "panda", 5, true);
        Animal crocodile = new Animal("Crocodylidae", "crocodile", 12, false);

        Zoo myZoo = new Zoo(zoo.zooName, "zambia", zoo.nbrCages);
        myZoo.addAnimal(lion);
        myZoo.addAnimal(panda);
        myZoo.addAnimal(crocodile);

        System.out.println("Les animaux dans le zoo " + myZoo.name + " sont :");
        for (int i = 0; i < myZoo.currentIndex; i++) {
            System.out.println("-" + (i + 1) + "-" + myZoo.animals[i].name + " (" + myZoo.animals[i].family + "), Age: " + myZoo.animals[i].age + " ans");
        }

        System.out.println(myZoo);

        scanner.close();
    }
}
