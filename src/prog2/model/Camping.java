package prog2.model;

import prog2.vista.ExcepcioReserva;
import java.util.Iterator;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.concurrent.Callable;

public class Camping implements InCamping{
    //Atributs
    private String nom;
    private ArrayList<Allotjament>llistaDeAllotjaments;
    private ArrayList<Client> llistaDeClients;
    private LlistaReserves llistaReserves;

    // Constructor de la classe Camping
    public Camping(String nom){
        this.nom = nom;
        this.llistaDeAllotjaments = new ArrayList<>();
        this.llistaDeClients = new ArrayList<>();
        this.llistaReserves = new LlistaReserves();
    }

    // Retorna el nom del càmping.
    public String getNom(){
        return nom;
    }
    // Retorna la llista de reserves del camping.
    public LlistaReserves getLlistaReserves(){
        return llistaReserves;
    }
    // Retorna la llista d'allotjaments del camping.
    public ArrayList<Allotjament> getLlistaDeAllotjaments(){
        return llistaDeAllotjaments;
    }
    // Retorna la llista de clients del camping.
    public ArrayList<Client> getLlistaClients(){
        return llistaDeClients;
    }
    // Retorna el número total d'allotjaments del càmping.
    public int getNumAllotjaments(){
        return llistaDeAllotjaments.size();
    }
    // Retorna el número total de reserves del càmping
    public int getNumReserves(){
        return llistaReserves.getNumReserves();
    }
    // Retorna el número total de clients del càmping.
    public int getNumClients(){
        return llistaDeClients.size();
    }
    // Crea un nou objecte de tipus Client i l'afegeix a la llista de clients.
    public void afegirClient(String nom_, String dni_){
        Client nouClient = new Client(nom_, dni_);
        llistaDeClients.add(nouClient);
    }
    // Afegeix una nova parcel·la a la llista d'allotjaments.
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela novaParcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        llistaDeAllotjaments.add(novaParcela);
    }
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        Bungalow nouBungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv,aireFred);
        llistaDeAllotjaments.add(nouBungalow);
    }
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi){
        BungalowPremium nouBungalowPremium = new BungalowPremium(nom_,idAllotjament_,mida,habitacions,placesPersones,placesParquing,terrassa,tv,aireFred,serveisExtra,codiWifi);
        llistaDeAllotjaments.add(nouBungalowPremium);
    }

    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, Material material,)
}
