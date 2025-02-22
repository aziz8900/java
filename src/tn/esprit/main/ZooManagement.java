package tn.esprit.main;

import tn.esprit.entities.Animal;
import tn.esprit.entities.Aquatic;
import tn.esprit.entities.Dolphin;
import tn.esprit.entities.Penguin;
import tn.esprit.entities.Terrestrial;
import tn.esprit.entities.Zoo;
import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String zooName;
            do {
                System.out.print("Entrez le nom du zoo : ");
                zooName = scanner.nextLine().trim();
            } while (zooName.isEmpty());

            int nbrCages;
            do {
                System.out.print("Nombre de cages (positif) : ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Veuillez entrer un nombre valide : ");
                    scanner.next();
                }
                nbrCages = scanner.nextInt();
            } while (nbrCages <= 0);

            Zoo myZoo = new Zoo(zooName, "London", nbrCages);

            System.out.println("Dans " + myZoo.getName() + ", on a " + nbrCages + " cages.\n");

            Animal lion = new Animal("Felidae", "Lion", 8, true);
            Animal bear = new Animal("Ursidae", "Grizzly Bear", 7, true);
            Animal alligator = new Animal("Alligatoridae", "American Alligator", 12, false);

            System.out.println("Ajout des animaux au zoo :");
            System.out.println("Lion ajouté : " + myZoo.addAnimal(lion));
            System.out.println("Grizzly Bear ajouté : " + myZoo.addAnimal(bear));
            System.out.println("Alligator ajouté : " + myZoo.addAnimal(alligator));

            System.out.println("\nAnimaux dans le zoo :");
            myZoo.printAnimals();

            System.out.println("\nRecherche des animaux :");
            int lionIndex = myZoo.searchAnimal(lion);
            System.out.println("Lion trouvé à l'indice : " + (lionIndex != -1 ? lionIndex : "Non trouvé"));

            Animal tiger = new Animal("Felidae", "Tiger", 6, true);
            int tigerIndex = myZoo.searchAnimal(tiger);
            System.out.println("Tiger trouvé à l'indice : " + (tigerIndex != -1 ? tigerIndex : "Non trouvé"));

            System.out.println("\nSuppression d'animaux :");
            System.out.println("Suppression du Tiger : " + (myZoo.removeAnimal(tiger) ? "Réussi" : "Échec, non trouvé"));
            System.out.println("Suppression du Lion : " + (myZoo.removeAnimal(lion) ? "Réussi" : "Échec, non trouvé"));

            System.out.println("\nAnimaux après suppression :");
            myZoo.printAnimals();

            System.out.println("\nTentative de suppression d'un éléphant...");
            Animal elephant = new Animal("Elephantidae", "Elephant", 15, false);
            System.out.println("Suppression de l'Éléphant : " + (myZoo.removeAnimal(elephant) ? "Réussi" : "Échec, non trouvé"));

            if (myZoo.isZooFull()) {
                System.out.println("Le zoo est plein !");
            } else {
                System.out.println("Le zoo n'est pas encore plein.");
            }

            System.out.println("////////////////////////////////////////////////////////");
            Zoo zoo1 = new Zoo("Zoo de noxus", "noxus", 10);
            Zoo zoo2 = new Zoo("Zoo de damacia", "damacia", 11);

            zoo1.addAnimal(new Animal("Felidae", "Lion", 8, true));
            zoo1.addAnimal(new Animal("Ursidae", "Grizzly Bear", 7, true));
            zoo2.addAnimal(new Animal("Felidae", "Tiger", 6, true));

            // Compare zoos
            Zoo zooAvecPlusDAnimaux = Zoo.comparerZoo(zoo1, zoo2);

            if (zooAvecPlusDAnimaux != null) {
                // Check if zoo2 is larger
                if (zooAvecPlusDAnimaux == zoo2) {
                    System.out.println("Zoo2 est plus grand : " + zoo2.getName());
                } else {
                    System.out.println("Zoo1 est plus grand : " + zoo1.getName());
                }
            } else {
                System.out.println("Les deux zoos ont le même nombre d'animaux.");
            }

            Aquatic shark = new Aquatic("Shark", "Great White", 10, false, "Ocean");
            Terrestrial mammoth = new Terrestrial("Elephantidae", "African Elephant", 30, true, 4);
            Dolphin dolphin = new Dolphin("Delphinidae", "Bottlenose Dolphin", 15, true, "Tropical Ocean", 55.5f);
            Penguin penguin = new Penguin("Spheniscidae", "Emperor Penguin", 5, true, "Antarctic", 500f);


            Zoo Zoo5 = new Zoo("Safari Park", "Tunis", 10);


            myZoo.addAnimal(shark);
            myZoo.addAnimal(elephant);
            myZoo.addAnimal(dolphin);
            myZoo.addAnimal(penguin);


            myZoo.printAnimals();


            shark.swim();
            dolphin.swim();
            penguin.swim();


            Zoo largerZoo = Zoo.comparerZoo(zoo1, zoo2);



        }
    }
}