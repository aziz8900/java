import java.util.TreeSet;

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

        System.out.println("\n Tri des champions par ID ");
        riotGames.trierEmployeParId();
        riotGames.displayEmploye();

        System.out.println("\n Tri des champions par Lane et Grade ");
        riotGames.trierEmployeParNomDepartementEtGrade();
        riotGames.displayEmploye();

        System.out.println("\n Test d'égalité des employés ");
        Employe yasuo1 = new Employe(1, "Yasuo", "Le", "Midlane", 5);
        Employe yasuo2 = new Employe(1, "Yasuo", "Le", "Midlane", 5);
        System.out.println("Yasuo1 equals Yasuo2: " + yasuo1.equals(yasuo2));


        DepartementHashSet gestionDepartements = new DepartementHashSet();


        gestionDepartements.ajouterDepartement(new Departement(1, "IT", 15));

        gestionDepartements.ajouterDepartement(new Departement(3, "HR", 8));

        gestionDepartements.ajouterDepartement(new Departement(2, "Finance", 12));

        gestionDepartements.ajouterDepartement(new Departement(4, "Midlane", 2));

        gestionDepartements.ajouterDepartement(new Departement(5, "Toplane", 1));

        System.out.println("\n Tous les départements ");
        gestionDepartements.displayDepartement();

        System.out.println("\n Recherche de départements ");
        System.out.println("IT présent: " + gestionDepartements.rechercherDepartement("IT"));

        System.out.println("Midlane présent: " + gestionDepartements.rechercherDepartement("Midlane"));

        System.out.println("\n Départements triés par ID ");
        TreeSet<Departement> sortedDepts = gestionDepartements.trierDepartementById();

        sortedDepts.forEach(dept -> System.out.println(dept.toString()));

        System.out.println("\n Test d'égalité des départements ");

        Departement it1 = new Departement(1, "IT", 15);
        Departement it2 = new Departement(1, "IT", 15);

        System.out.println("IT1 equals IT2: " + it1.equals(it2));


        System.out.println("\n Statistiques combinées");
        System.out.println("Nombre total de départements: " +
                gestionDepartements.nombreDepartements());
    }
}