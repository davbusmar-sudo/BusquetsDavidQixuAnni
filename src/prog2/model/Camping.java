package prog2.model;

import prog2.vista.ExcepcioReserva;

import javax.swing.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.time.LocalDate;

public  abstract class Camping implements InCamping {
    //Atributs
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
    @Override
    public String getNom() {
        return nom;
    }

    // Retorna la llista d'allotjaments del camping.
    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments;
    }

    // Retorna la llista de clients del camping.
    @Override
    public ArrayList<Client> getLlistaClients() {
        return llistaClients;
    }

    // Retorna la llista de reserves del camping.
    @Override
    public LlistaReserves getLlistaReserves() {
        return llistaReserves;
    }

    // Retorna el número total d'allotjaments del càmping.
    public int getNumAllotjaments() {
        // 'size' obté el nombre d’elements de la taula
        return llistaAllotjaments.size();
    }

    // Retorna el número total de reserves del càmping
    public int getNumReserves() {
        return llistaReserves.getNumReserves();
    }

    // Retorna el número total de clients del càmping.
    public int getNumClients() {
        // 'size' obté el nombre d’elements de la taula
        return llistaClients.size();
    }

    // Mètode 'afegir clients'
    public void afegirClient(String nom_, String dni_) {
        // Crear un nou objecte de tipus Client
        Client nouClient = new Client(nom_, dni_);
        // i afegir a la llista de clients.
        llistaClients.add(nouClient);
    }

    // Afegeix una nova parcel·la a la llista d'allotjaments.
    public void afegirParcela(String nom_, String idAllotjament_, long estadaMinimaALTA_, long estadaMinimaBAIXA_, float mida, boolean connexioElectrica) {
        Parcela novaParcela = new Parcela.Parcela_(nom_, idAllotjament_, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, connexioElectrica);
        llistaAllotjaments.add(novaParcela);
    }
    // Afegeix un nou bungalow a la llista d'allotjaments.
    public void afegirBungalow(String nom_, String idAllotjament_, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Casa.Mida mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        Bungalow nouBungalow = new Bungalow.Bungalow_(nom_, idAllotjament_, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.add(nouBungalow);
    }
    // Afegeix un bungalow premium a la llista d'allotjaments.
    public void afegirBungalowPremium(String nom_, String idAllotjament_, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Casa.Mida mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi){
        BungalowPremium nouBungalowPremium = new BungalowPremium.BungalowPremium_(nom_, idAllotjament_, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.add(nouBungalowPremium);
    }
    // Afegeix una casa glamping a la llista d'allotjaments.
    public void afegirGlamping(String nom_, String idAllotjament_, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Casa.Mida mida, int habitacions, int placesPersones, Glamping.Material material, boolean casaMascota){
        Glamping nouGlamping = new Glamping.Glamping_(nom_,idAllotjament_,estadaMinimaALTA_,estadaMinimaBAIXA_,mida,habitacions,placesPersones,material,casaMascota);
        llistaAllotjaments.add(nouGlamping);
    }
    //Afegeix una mobil-home a la llista d'allotjaments.
    public void afegirMobilHome(String nom_, String idAllotjament_, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Casa.Mida mida, int habitacions, int placesPersones, boolean terrassaBarbacoa){
        MobilHome nouMobilHome = new MobilHome.MobilHome_(nom_,idAllotjament_,estadaMinimaALTA_,estadaMinimaBAIXA_,mida,habitacions,placesPersones,terrassaBarbacoa);
    }

    //Afegeix una nova reserva al càmping.
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        // buscar el client pel dni
        Client client = buscarClient(dni_);
        // buscar l'allotjament pel id
        InAllotjament allotjament = buscarAllotjament(id_);
        // convertir l'objecte InAllotjament a Allotjament,
        // perque el metode 'afegirReserva' espera un Allotjament i no interficie
        // Fer cast, perque estem segur que InAllotjament sempre serà Allotjament
        Allotjament allotjamentConcret = (Allotjament)allotjament;
        // crear i afegir a la reserva
        llistaReserves.afegirReserva(allotjamentConcret,client,dataEntrada,dataSortida);
    }

    // Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius.
    public int calculAllotjamentsOperatius(){
        int comptador = 0;
        // Crear iterator per recorrer la llista
        Iterator<Allotjament> itrAllotjament = llistaAllotjaments.iterator();
        // bucle per recorrer la llista mentre hi hagui elements a la llista
        while(itrAllotjament.hasNext()){
            Allotjament allotjament = itrAllotjament.next();
            // Comprova que funcioni correctament
            if(allotjament.correcteFuncionament()){
                comptador ++;
            }
        }
        // retorna el num total d'allotjaments que funciona correcta
        return comptador;
    }
    //
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        // si no hi ha allotjaments, retorna 'null'
        if(llistaAllotjaments.isEmpty()){
            return null;
        }
        Allotjament allotjamentEscollit = null;
        // inicialitzar el valor més gran
        int estadaMinima = Integer.MAX_VALUE;
        // crear iterator per recorrer la llista
        Iterator<Allotjament> itrAllotjament = llistaAllotjaments.iterator();
        // bucle per recorrer la llista mentre hi hagui elements a la llista
        while(itrAllotjament.hasNext()) {
            Allotjament allotjament = itrAllotjament.next();

            int estadaActual = (int) allotjament.getEstadaMinima(temp);
            // 'if' (condicio) per comprovar si aquest allotjament que tenim és la estada més curta que
            // l'estada d'actual minim que tenim ara
            if (estadaActual < estadaMinima) {
                // actualitzar l'estada si compleix la condició
                estadaMinima = estadaActual;
                // i guardar l'allotjament que tenim ara
                allotjamentEscollit = allotjament;
            }
        }
        return allotjamentEscollit;
    }
    // Mètode per obtenir la temporada
    public static InAllotjament.Temp getTemporada(LocalDate data){
        // Obté el dia i el mes de la data
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        // Sabent que la Temporada alta és del 21/3 al 20/9
        // i que la Temporada baixa és del 21/9 al 20/3

        // 'if' (condicio) per comprovar si la data es dins de la temporada alta o no
        if (( mes > 3 && mes < 9) || (mes == 3 &&  dia >= 21) || (mes == 9 && dia <= 20)) {
            return InAllotjament.Temp.ALTA;
            // si no ho és, segurament serà temporada baixa
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }

    // Mètode 'buscarAllotjament'
    private Allotjament buscarAllotjament(String idAllotjament){
        // crear un iterador per recorrer la llista d'allotjaments
        Iterator<Allotjament> itrAllotjament = llistaAllotjaments.iterator();
        // això vol dir que mentre hi hagui elements a la llista, entra en el bucle
        while (itrAllotjament.hasNext()){
            // agafa el següent element de la llista d'allotjament
            Allotjament allotjament = itrAllotjament.next();
            // usa 'if'(condicio) per comprovar si l'id és igual al que volem buscar
            if (allotjament.getId().equals(idAllotjament)){
                // si coinsideix, retorna l'allotjament
                return allotjament;
            }
        }
        // Si no es troba, retorna 'null'
        return null;
    }

    //  Mètode 'buscarClient'
    private Client buscarClient(String dni){
        // Crear iterador
        Iterator<Client> itrClient = llistaClients.iterator();
        // bucle per recorrer la llista mentre hi hagui elements a la llista
        while(itrClient.hasNext()){
            Client client = itrClient.next();
            // 'if' (coindicio) : retorna client si el DNI coincideix
            if(client.getDni().equals(dni)) {
                return client;
            }
        }
        // Si no es troba, retorna 'null'
        return null;
    }
}
