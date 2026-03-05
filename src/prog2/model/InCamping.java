
package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import prog2.vista.ExcepcioReserva;

/**
 * Interfície per definir la forma del Càmping
 */
public class Camping implements InCamping {

    private String nom;
    private ArrayList<Allotjament> llistaAllotjaments;
    private ArrayList<Client> llistaClients;
    private LlistaReserves llistaReserves;


     // Constructor de la classe Camping
    public Camping(String nom) {
        this.nom = nom;
        this.llistaAllotjaments = new ArrayList<>();
        this.llistaClients = new ArrayList<>();
        this.llistaReserves = new LlistaReserves();
    }

    // Retorna el nom del càmping.
    public String getNom() {
        return nom;
    }

    // Retorna la llista de reserves del camping.
    public LlistaReserves getLlistaReserves() {
        return llistaReserves;
    }

     // Retorna la llista d'allotjaments del camping.
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments;
    }

    // Retorna la llista de clients del camping.
    public ArrayList<Client> getLlistaClients() {
        return llistaClients;
    }

    // Retorna el número total d'allotjaments del càmping.
    public int getNumAllotjaments() {
        return llistaAllotjaments.size();
    }

    // Retorna el número total de reserves del càmping.
    public int getNumReserves() {
        return llistaReserves.getNumReserves();
    }

    // Retorna el número total de clients del càmping.
    public int getNumClients() {
        return llistaClients.size();
    }

    /**
     * Crea un nou objecte de tipus Client i l'afegeix a la llista de clients.
     * @param nom_ el nom del nou client.
     * @param dni_ el DNI del nou client.
     */
    public void afegirClient(String nom_, String dni_) {
        Client client = new Client(nom_, dni_);
        llistaClients.add(client);
    }

    /**
     * Afegeix una nova parcel·la a la llista d'allotjaments.
     * @param nom_ el nom de la parcela.
     * @param idAllotjament_ l'identificador únic de l'allotjament.
     * @param metres la mida de la parcela.
     * @param connexioElectrica true si disposa de connexió elèctrica, false altrament.
     */
    void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica);

    /**
     * Afegeix un nou bungalow a la llista d'allotjaments.
     * @param nom_ el nom del bungalow.
     * @param idAllotjament_ l'identificador únic de l'allotjament.
     * @param mida la mida del bungalow.
     * @param habitacions el nombre d'habitacions del bungalow.
     * @param placesPersones el nombre màxim de places per a persones.
     * @param placesParquing el nombre de places de pàrquing disponibles.
     * @param terrassa true si disposa de terrassa, false altrament.
     * @param tv true si disposa de televisió, false altrament.
     * @param aireFred true si disposa d'aire condicionat, false altrament.
     */
    void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        int placesParquing, boolean terrassa, boolean tv, boolean aireFred);

    /**
     * Afegeix un bungalow premium a la llista d'allotjaments.
     * @param serveisExtra true si ofereix serveis extra.
     * @param codiWifi el codi de la xarxa Wi-Fi.
     * (Altres paràmetres igual que `afegirBungalow`)
     */
    void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                               boolean serveisExtra, String codiWifi);

    /**
     * Afegeix una casa glamping a la llista d'allotjaments.
     * @param material el material del que està fet.
     * @param casaMascota true si accepta mascotes.
     * (Altres paràmetres igual que `afegirBungalow`)
     */
    void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        String material, boolean casaMascota);


    /**
     *  Afegeix una mobil-home a la llista d'allotjaments.
     * @param terrassaBarbacoa true si disposa de terrassa amb barbacoa.
     * (Altres paràmetres igual que `afegirBungalow`)
     */
    void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                         boolean terrassaBarbacoa);


    /**
     * Afegeix una nova reserva al càmping. Per fer-ho fa el següent: cerca el soci que vol fer la reserva i el servei que es vol reservar amb la informació necessària rebuda com a paràmetres i invoca al mètode afegirReserva de la classe LlistaReserves que crearà la reserva, si es pot, i la afegirà a la llista de reserves.
     * @param id_ l'identificador de l'allotjament.
     * @param dni_ el DNI del client que fa la reserva.
     * @param dataEntrada la data d'entrada.
     * @param dataSortida la data de sortida.
     * @throws ExcepcioReserva si no es pot realitzar la reserva.
     */
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Allotjament allotjament = buscarAllotjament(id_);
        Client client = buscarClient(dni_);

        if (allotjament == null) {
            throw new ExcepcioReserva("L'allotjament amb ID " + id_ + " no existeix.");
        }
        if (client == null) {
            throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix.");
        }

        // Posem la nova reserva a la llista de reserves
        llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }
    /**
     * Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius.
     * @return el nombre de serveis operatius.
     */
    int calculAllotjamentsOperatius();

    /**
     * Cerca i retorna l'allotjament amb estada mínima de la temporada alta més curta.
     * @return l'allotjament amb estada mínima de la temporada baixa més curta.
     */
    Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp);



}

