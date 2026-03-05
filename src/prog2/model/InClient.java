package prog2.model;

public class Client implements InClient {

    private String nom;
    private String dni;

    // Constructor de la classe Client.
    public Client(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public String getDni() {
        return dni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String toString() {
        return "Nom=" + nom + ", DNI=" + dni;
    }

}
