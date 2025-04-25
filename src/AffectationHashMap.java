import java.util.*;

public class AffectationHashMap {
    private HashMap<Employe, Departement> affectations;

    public AffectationHashMap() {
        this.affectations = new HashMap<>();
    }

    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affectations.put(e, d);
    }

    public void afficherEmployesEtDepartements() {
        for (Employe e : affectations.keySet()) {
            System.out.println("Employee: " + e + " | Department: " + affectations.get(e));
        }
    }

    public void supprimerEmploye(Employe e) {
        affectations.remove(e);
    }

    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        Departement assignedDept = affectations.get(e);
        if (assignedDept != null && assignedDept.equals(d)) {
            affectations.remove(e);
        }
    }

    public void afficherEmployes() {
        for (Employe e : affectations.keySet()) {
            System.out.println("Employee: " + e);
        }
    }

    public void afficherDepartements() {
        Set<Departement> uniqueDepts = new HashSet<>(affectations.values());
        for (Departement d : uniqueDepts) {
            System.out.println("Department: " + d);
        }
    }

    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    public TreeMap<Employe, Departement> trierMap() {
        TreeMap<Employe, Departement> sortedMap = new TreeMap<>();
        sortedMap.putAll(affectations);
        return sortedMap;
    }
}