import java.util.TreeSet;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        SocieteArrayList riotGames = new SocieteArrayList();

        riotGames.ajouterEmploye(new Employe(1, "Yasuo", "Le", "Midlane", 5));
        riotGames.ajouterEmploye(new Employe(2, "Lux", "La", "Midlane", 3));
        riotGames.ajouterEmploye(new Employe(3, "Darius", "Le", "Toplane", 4));
        riotGames.ajouterEmploye(new Employe(4, "Jinx", "La", "ADC", 5));
        riotGames.ajouterEmploye(new Employe(5, "Thresh", "Le", "Support", 5));

        System.out.println("Liste des champions");
        riotGames.displayEmploye();

        System.out.println("\nRecherche de Yasuo");
        System.out.println("Yasuo présent: " + riotGames.rechercherEmploye("Yasuo"));

        System.out.println("\nTri des champions par ID");
        riotGames.trierEmployeParId();
        riotGames.displayEmploye();

        System.out.println("\nTri des champions par Lane et Grade");
        riotGames.trierEmployeParNomDepartementEtGrade();
        riotGames.displayEmploye();

        System.out.println("\nTest d'égalité des employés");
        Employe yasuo1 = new Employe(1, "Yasuo", "Le", "Midlane", 5);
        Employe yasuo2 = new Employe(1, "Yasuo", "Le", "Midlane", 5);
        System.out.println("Yasuo1 equals Yasuo2: " + yasuo1.equals(yasuo2));

        DepartementHashSet gestionDepartements = new DepartementHashSet();

        gestionDepartements.ajouterDepartement(new Departement(1, "IT", 15));
        gestionDepartements.ajouterDepartement(new Departement(3, "HR", 8));
        gestionDepartements.ajouterDepartement(new Departement(2, "Finance", 12));
        gestionDepartements.ajouterDepartement(new Departement(4, "Midlane", 2));
        gestionDepartements.ajouterDepartement(new Departement(5, "Toplane", 1));

        System.out.println("\nTous les départements");
        gestionDepartements.displayDepartement();

        System.out.println("\nRecherche de départements");
        System.out.println("IT présent: " + gestionDepartements.rechercherDepartement("IT"));
        System.out.println("Midlane présent: " + gestionDepartements.rechercherDepartement("Midlane"));

        System.out.println("\nDépartements triés par ID");
        TreeSet<Departement> sortedDepts = gestionDepartements.trierDepartementById();
        sortedDepts.forEach(dept -> System.out.println(dept.toString()));

        System.out.println("\nTest d'égalité des départements");
        Departement it1 = new Departement(1, "IT", 15);
        Departement it2 = new Departement(1, "IT", 15);
        System.out.println("IT1 equals IT2: " + it1.equals(it2));

        System.out.println("\nStatistiques combinées");
        System.out.println("Nombre total de départements: " +
                gestionDepartements.nombreDepartements());

        System.out.println("\n=== Test d'AffectationHashMap ===");
        AffectationHashMap affectation = new AffectationHashMap();

        Employe yasuo = new Employe(1, "Yasuo", "Le", "Midlane", 5);
        Employe lux = new Employe(2, "Lux", "La", "Midlane", 3);
        Employe darius = new Employe(3, "Darius", "Le", "Toplane", 4);
        Departement midlane = new Departement(4, "Midlane", 2);
        Departement toplane = new Departement(5, "Toplane", 1);

        System.out.println("Affectations initiales:");
        affectation.ajouterEmployeDepartement(yasuo, midlane);
        affectation.ajouterEmployeDepartement(lux, midlane);
        affectation.ajouterEmployeDepartement(darius, toplane);
        affectation.afficherEmployesEtDepartements();

        System.out.println("\nAprès avoir ajouté Yasuo à un autre département:");
        affectation.ajouterEmployeDepartement(yasuo, toplane);
        affectation.afficherEmployesEtDepartements();

        System.out.println("\nAprès avoir supprimé Lux:");
        affectation.supprimerEmploye(lux);
        affectation.afficherEmployesEtDepartements();

        System.out.println("\nAprès avoir supprimé Darius de Toplane:");
        affectation.supprimerEmployeEtDepartement(darius, toplane);
        affectation.afficherEmployesEtDepartements();

        System.out.println("\nListe des employés:");
        affectation.afficherEmployes();

        System.out.println("\nListe des départements:");
        affectation.afficherDepartements();

        System.out.println("\nRecherche de Yasuo:");
        System.out.println("Yasuo présent: " + affectation.rechercherEmploye(yasuo));
        System.out.println("Lux présent: " + affectation.rechercherEmploye(lux));

        System.out.println("\nRecherche de départements:");
        System.out.println("Midlane présent: " + affectation.rechercherDepartement(midlane));
        System.out.println("Toplane présent: " + affectation.rechercherDepartement(toplane));

        System.out.println("\nAffectations triées par ID d'employé:");
        TreeMap<Employe, Departement> sortedMap = affectation.trierMap();
        for (Employe e : sortedMap.keySet()) {
            System.out.println("Employé: " + e + " | Département: " + sortedMap.get(e));
        }
    }
}