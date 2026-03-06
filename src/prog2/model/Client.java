package prog2.model;

public class Client {

    // Atributs
    private String nom;
    private String dni;

    // Constructor de la classe Client
    public Client(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }

    // getters
    public String getNom() {
        return nom;
    }
    public String getDni() {
        return dni;
    }

    // setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    // Mètode 'toString'
    public String toString() {
        return "Client{nom=" + nom + ", dni=" + dni+"}";
    }
}
