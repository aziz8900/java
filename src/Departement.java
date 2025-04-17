public class Departement implements Comparable<Departement> {
    private int id;
    private String nomDepartement;
    private int nombreEmployes;


    public Departement() {}

    public Departement(int id, String nomDepartement, int nombreEmployes) {
        this.id = id;
        this.nomDepartement = nomDepartement;
        this.nombreEmployes = nombreEmployes;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNomDepartement() { return nomDepartement; }
    public void setNomDepartement(String nomDepartement) { this.nomDepartement = nomDepartement; }

    public int getNombreEmployes() { return nombreEmployes; }
    public void setNombreEmployes(int nombreEmployes) { this.nombreEmployes = nombreEmployes; }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Departement that = (Departement) obj;
        return id == that.id && nomDepartement.equals(that.nomDepartement);
    }

    @Override
    public int hashCode() {
        return 31 * id + nomDepartement.hashCode();
    }


    @Override
    public String toString() {
        return String.format("Département [ID: %d, Nom: %s, Employés: %d]",
                id, nomDepartement, nombreEmployes);
    }


    @Override
    public int compareTo(Departement o) {
        return Integer.compare(this.id, o.id);
    }
}