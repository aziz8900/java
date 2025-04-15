
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SocieteArrayList implements IGestion<Employe> {
    private ArrayList<Employe> employes = new ArrayList<>();

    @Override
    public void ajouterEmploye(Employe e) {
        employes.add(e);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        return employes.stream().anyMatch(e -> e.getNom().equals(nom));
    }

    @Override
    public void displayEmploye() {
        employes.forEach(System.out::println);
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(employes);
    }


    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        employes.sort(Comparator.comparing(Employe::getNomDepartement)

                .thenComparingInt(Employe::getGrade));
    }
}