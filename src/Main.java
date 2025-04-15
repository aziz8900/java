
public class Main {
    public static void main(String[] args) {
        SocieteArrayList riotGames = new SocieteArrayList();

        riotGames.ajouterEmploye(new Employe(1, "Yasuo", "Le", "Midlane", 5));

        riotGames.ajouterEmploye(new Employe(2, "Lux", "La", "Midlane", 3));

        riotGames.ajouterEmploye(new Employe(3, "Darius", "Le", "Toplane", 4));

        riotGames.ajouterEmploye(new Employe(4, "Jinx", "La", "ADC", 5));
        riotGames.ajouterEmploye(new Employe(5, "Thresh", "Le", "Support", 5));

        System.out.println(" Liste des champions ");

        riotGames.displayEmploye();

        System.out.println("\n Recherche de Yasuo ");
        System.out.println("Yasuo présent: " + riotGames.rechercherEmploye("Yasuo"));
        System.out.println("\n Tri par ID ");
        riotGames.trierEmployeParId();

        riotGames.displayEmploye();


        System.out.println("\n Tri par Lane et Grade ");

        riotGames.trierEmployeParNomDepartementEtGrade();

        riotGames.displayEmploye();

        System.out.println("\n Test d'égalité ");

        Employe yasuo1 = new Employe(1, "Yasuo", "Le", "Midlane", 5);

        Employe yasuo2 = new Employe(1, "Yasuo", "Le", "Midlane", 5);
        System.out.println("Yasuo1 equals Yasuo2: " + yasuo1.equals(yasuo2));

    }
}