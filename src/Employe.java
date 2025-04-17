
public class Employe implements Comparable<Employe> {
    private final int id;
    private final String nom;
    private String prenom;
    private String nomDepartement;
    private int grade;

    public Employe(int id, String nom, String prenom, String nomDepartement, int grade) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nomDepartement = nomDepartement;
        this.grade = grade;
    }


    public String getNom() { return nom; }
    public String getNomDepartement() { return nomDepartement; }
    public int getGrade() { return grade; }
    public int getId() { return id; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employe employe = (Employe) obj;
        return id == employe.id && nom.equals(employe.nom);
    }

    @Override
    public String toString() {
        return String.format("%s %s (ID: %d) - %s | Grade: %d",
                prenom, nom, id, nomDepartement, grade);
    }

    @Override
    public int compareTo(Employe o) {
        return this.id - o.id;
    }
}