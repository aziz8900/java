package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

import java.util.Scanner;

public class ZooManagement {
    int nbrCages;
    Zoo zooManager;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZooManagement zooManagement = new ZooManagement();

        zooManagement.zooManager = new Zoo("", "", 0);

        System.out.print("Entrez le nom du zoo : ");
        zooManagement.zooManager.setName(scanner.nextLine());
        while (zooManagement.zooManager.getName().isEmpty()) {
            System.out.print("Le nom du zoo ne peut pas etre vide : ");
            zooManagement.zooManager.setName(scanner.nextLine());
        }

        System.out.print("Nombre de cages : ");
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un nombre valide : ");
            scanner.next();
        }
        zooManagement.nbrCages = scanner.nextInt();

        System.out.println("Dans " + zooManagement.zooManager.getName() + ", on a " + zooManagement.nbrCages + " cages.\n");

        Zoo myZoo = new Zoo(zooManagement.zooManager.getName(), "London", zooManagement.nbrCages);

        Animal lion = new Animal("Felidae", "Lion", 8, true);
        Animal bear = new Animal("Ursidae", "Grizzly Bear", 7, true);
        Animal alligator = new Animal("Alligatoridae", "American Alligator", 12, false);

        System.out.println("Ajout des animaux au zoo :");

        System.out.println("Lion ajoute : " + myZoo.addAnimal(lion));
        System.out.println("Grizzly Bear ajoute : " + myZoo.addAnimal(bear));
        System.out.println("Alligator ajoute : " + myZoo.addAnimal(alligator));

        System.out.println("\n Animaux dans le zoo :");
        myZoo.printAnimals();

        System.out.println("\n Recherche des animaux :");
        int lionIndex = myZoo.searchAnimal(lion);
        System.out.println("Lion trouvé à l'indice : " + (lionIndex != -1 ? lionIndex : "Non trouvé"));

        Animal tiger = new Animal("Felidae", "Tiger", 6, true);
        int tigerIndex = myZoo.searchAnimal(tiger);
        System.out.println("Tiger trouvé à l'indice : " + (tigerIndex != -1 ? tigerIndex : "Non trouvé"));

        System.out.println("\n Suppression d'animaux :");
        System.out.println("Suppression du Tiger : " + (myZoo.removeAnimal(tiger) ? "Reussi" : "echec, non trouve"));
        System.out.println("Suppression du Lion : " + (myZoo.removeAnimal(lion) ? "Reussi" : "echec, non trouve"));

        System.out.println("\n Animaux apres suppression :");
        myZoo.printAnimals();

        System.out.println("\n Tentative de suppression d'un éléphant...");
        Animal elephant = new Animal("Elephantidae", "Elephant", 15, false);
        System.out.println("Suppression de l'Éléphant : " + (myZoo.removeAnimal(elephant) ? "Reussi" : "echec, non trouvé"));

        if (myZoo.isZooFull()) {
            System.out.println("Le zoo est plein !");
        } else {
            System.out.println("Le zoo n'est pas encore plein.");
        }

        System.out.println("////////////////////////////////////////////////////////");
        Zoo zoo1 = new Zoo("Zoo de noxus", "noxus", 10);
        Zoo zoo2 = new Zoo("Zoo de damacia", "damaciagit", 10);

        zoo1.addAnimal(new Animal("Felidae", "Lion", 8, true));
        zoo1.addAnimal(new Animal("Ursidae", "Grizzly Bear", 7, true));

        zoo2.addAnimal(new Animal("Felidae", "Tiger", 6, true));

        Zoo zooAvecPlusDAnimaux = new Zoo(null, null, 0);
        zooAvecPlusDAnimaux = zooAvecPlusDAnimaux.comparerZoo(zoo1, zoo2);

        if (zooAvecPlusDAnimaux != null) {
            System.out.println("Le zoo avec le plus d'animaux est : " + zooAvecPlusDAnimaux.getName());
        } else {
            System.out.println("Les deux zoos ont le même nombre d'animaux.");
        }
        scanner.close();
    }
}
