import java.util.Scanner;

class ZooManagement {
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
        
        scanner.close();
    }
}
