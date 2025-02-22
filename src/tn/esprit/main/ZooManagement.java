package tn.esprit.main;

import tn.esprit.entities.*;

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

                if (zooAvecPlusDAnimaux == zoo2) {
                    System.out.println("Zoo2 est plus grand : " + zoo2.getName());
                } else {
                    System.out.println("Zoo1 est plus grand : " + zoo1.getName());
                }
            } else {
                System.out.println("Les deux zoos ont le même nombre d'animaux.");
            }


            Terrestrial mammoth = new Terrestrial("Elephantidae", "African Elephant", 30, true, 4);
            Dolphin dolphin = new Dolphin("Delphinidae", "Bottlenose Dolphin", 15, true, "Tropical Ocean", 55.5f);
            Penguin penguin = new Penguin("Spheniscidae", "Emperor Penguin", 5, true, "Antarctic", 500f);

            Aquatic tuna = new Tuna("Scombridae", "Bluefin Tuna", 5, false, "Ocean");

            Zoo Zoo5 = new Zoo("Safari Park", "Tunis", 10);



            myZoo.addAnimal(elephant);
            myZoo.addAnimal(dolphin);
            myZoo.addAnimal(penguin);


            myZoo.printAnimals();



            dolphin.swim();
            penguin.swim();


            Zoo largerZoo = Zoo.comparerZoo(zoo1, zoo2);

            System.out.println("///////////////////////////////");
        myZoo.addAquaticAnimal(dolphin);
            myZoo.addAquaticAnimal(tuna);



            myZoo.makeAquaticAnimalsSwim();



            Penguin penguin1 = new Penguin("Spheniscidae", "Emperor Penguin", 5, true, "Antarctic", 500f);
            Penguin penguin2 = new Penguin("Spheniscidae", "King Penguin", 4, true, "Antarctic", 450f);
            myZoo.addAquaticAnimal(penguin1);
            myZoo.addAquaticAnimal(penguin2);

            float maxDepth = myZoo.maxPenguinSwimmingDepth();
            System.out.println("La profondeur maximale de nage est : " + maxDepth + " mètres.");

            myZoo.displayNumberOfAquaticsByType();



            Aquatic dolphin1 = new Dolphin("Delphinidae", "Bottlenose Dolphin", 15, true, "Tropical Ocean", 55.5f);
            Aquatic dolphin2 = new Dolphin("Delphinidae", "Bottlenose Dolphin", 15, true, "Tropical Ocean", 55.5f);

            System.out.println("dolphin1 equals dolphin2 : " + dolphin1.equals(dolphin2)); // ouiiiiiiiii
            System.out.println("dolphin1 equals penguin : " + dolphin1.equals(penguin));   //noooooooooo

        }
    }
}