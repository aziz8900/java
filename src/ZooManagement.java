import java.util.Scanner;

public class ZooManagement {
    int nbrCages;
    String zooName;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZooManagement zooManager = new ZooManagement();


        System.out.print("Entrez le nom du zoo : ");
        zooManager.zooName = scanner.nextLine();
        while (zooManager.zooName.isEmpty()) {
            System.out.print("Le nom du zoo ne peut pas être vide : ");
            zooManager.zooName = scanner.nextLine();
        }

        System.out.print("Nombre de cages : ");
        while (!scanner.hasNextInt()) {

            System.out.print("Veuillez entrer un nombre valide : ");
            scanner.next();
        }
        zooManager.nbrCages = scanner.nextInt();

        System.out.println("Dans " + zooManager.zooName + ", on a " + zooManager.nbrCages + " cages.\n");


        Zoo myZoo = new Zoo(zooManager.zooName, "London", zooManager.nbrCages);

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

             System.out.println("Suppression du Tiger : " + (myZoo.removeAnimal(tiger) ? "Reussi" : "echec, non trouve"));
                 System.out.println("Suppression du Lion : " + (myZoo.removeAnimal(lion) ? "Reussi" : "echec, non trouve"));


        System.out.println("\nAnimaux apres suppression :");
        myZoo.printAnimals();



        System.out.println("\nTentative de suppression d'un éléphant...");

        Animal elephant = new Animal("Elephantidae", "Elephant", 15, false);


        System.out.println("Suppression de l'Éléphant : " + (myZoo.removeAnimal(elephant) ? "Reussi" : "echec, non trouvé"));


        if (myZoo.isZooFull()) {
            System.out.println("Le zoo est plein !");
        } else {
            System.out.println("Le zoo n'est pas encore plein.");
        }




        System.out.println("////////////////////////////////////////////////////////");
        Zoo zoo1 = new Zoo("Zoo de noxus", "noxus", 10);
        Zoo zoo2 = new Zoo("Zoo de damacia", "damacia", 10);


        zoo1.addAnimal(new Animal("Felidae", "Lion", 8, true));
        zoo1.addAnimal(new Animal("Ursidae", "Grizzly Bear", 7, true));

        zoo2.addAnimal(new Animal("Felidae", "Tiger", 6, true));

        Zoo zooAvecPlusDAnimaux = new Zoo(null, null, 0);
        zooAvecPlusDAnimaux = zooAvecPlusDAnimaux.comparerZoo(zoo1, zoo2);

        if (zooAvecPlusDAnimaux != null) {
            System.out.println("Le zoo avec le plus d'animaux est : " + zooAvecPlusDAnimaux.name);
        } else {
            System.out.println("Les deux zoos ont le même nombre d'animaux.");
        }
        scanner.close();
    }
}
