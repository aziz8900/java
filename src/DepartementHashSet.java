import java.util.HashSet;
import java.util.TreeSet;

public class DepartementHashSet implements IDepartement<Departement> {
    private HashSet<Departement> departements = new HashSet<>();

    @Override
    public void ajouterDepartement(Departement d) {
        if (d != null) {
            departements.add(d);
        }
    }

    @Override
    public boolean rechercherDepartement(String nom) {
        return departements.stream()
                .anyMatch(d -> d.getNomDepartement().equals(nom));
    }

    @Override
    public boolean rechercherDepartement(Departement d) {
        return departements.contains(d);
    }

    @Override
    public void supprimerDepartement(Departement d) {
        departements.remove(d);
    }

    @Override
    public void displayDepartement() {
        departements.forEach(System.out::println);
    }

    @Override
    public TreeSet<Departement> trierDepartementById() {
        return new TreeSet<>(departements);
    }


    public int nombreDepartements() {
        return departements.size();
    }
}