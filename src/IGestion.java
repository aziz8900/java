
public interface IGestion<T> {
    void ajouterEmploye(T t);
    boolean rechercherEmploye(String nom);
    void displayEmploye();
    void trierEmployeParId();
    void trierEmployeParNomDepartementEtGrade();
}