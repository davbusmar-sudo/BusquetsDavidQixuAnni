package prog2.model;

// Interfície que defineix les operacions bàsiques per als clients.
public interface InClient {
    /**
     * Obté el nom del client.
     * @return el nom del client.
     */
    public String getNom();
    /**
     * Obté el DNI del client.
     * @return el DNI del client.
     */
    public String getDni();
    /**
     * Estableix el nom del client.
     * @param nom el nom a assignar.
     */
    public void setNom(String nom);
    /**
     * Estableix el DNI del client.
     * @param dni DNI a assignar.
     */
    public void setDni(String dni);
}