package prog2.model;

import prog2.vista.ExcepcioReserva;
import java.util.Iterator;
import java.util.ArrayList;
import java.time.LocalDate;

public class Camping implements InCamping {
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

    @Override
    // Afegeix una nova parcel·la a la llista d'allotjaments.
    public void afegirParcela(String nom_, String idAllotjament_, float mida, boolean connexioElectrica) {
        // Segons l'enunciat: Parcela = minim 1 dia sempre
        llistaAllotjaments.add(new Parcela(nom_, idAllotjament_, mida, connexioElectrica));
    }

    ;

    // Afegeix un nou bungalow a la llista d'allotjaments.
    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        // Convertim el String 'mida' al tipus Enum que entén la classe Casa/Bungalow
        // Això transforma "gran" en Casa.Mida.GRAN
        Casa.Mida midaEnum = Casa.Mida.valueOf(mida.toUpperCase());
        // Ara passem 'midaEnum' en lloc de 'mida' (el String)
        llistaAllotjaments.add(new Bungalow(nom_, idAllotjament_, midaEnum, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred));
    }

    // Afegeix un bungalow premium a la llista d'allotjaments.
    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        // 1. Convertim el String 'mida' al tipus Enum Casa.Mida
        // Això és necessari perquè el constructor de BungalowPremium espera l'Enum.
        Casa.Mida midaEnum = Casa.Mida.valueOf(mida.toUpperCase());
        // 2. Creem l'objecte passant midaEnum.
        llistaAllotjaments.add(new BungalowPremium(nom_, idAllotjament_, midaEnum, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi));
    }

    // Afegeix una casa glamping a la llista d'allotjaments.
    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Casa.Mida midaEnum = Casa.Mida.valueOf(mida.toUpperCase());
        Glamping.Material materialEnum = Glamping.Material.valueOf(material.toUpperCase());
        llistaAllotjaments.add(new Glamping(nom_, idAllotjament_, midaEnum, habitacions, placesPersones, materialEnum, casaMascota));
    }

    //Afegeix una mobil-home a la llista d'allotjaments.
    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        // 1. Convertim el String 'mida' a l'Enum Casa.Mida
        Casa.Mida midaEnum = Casa.Mida.valueOf(mida.toUpperCase());
        // 2. Creem l'objecte directament
        llistaAllotjaments.add(new MobilHome(nom_, idAllotjament_, midaEnum, habitacions, placesPersones, terrassaBarbacoa));
    }


    //Afegeix una nova reserva al càmping.
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        // buscar el client pel dni
        Client client = buscarClient(dni_);
        // buscar l'allotjament pel id
        Allotjament allotjament = buscarAllotjament(id_);

        if (client == null) throw new ExcepcioReserva("El client no existeix.");
        if (allotjament == null) throw new ExcepcioReserva("L'allotjament no existeix.");
        // Cridem a la llista de reserves que ja té la lògica de validació
        llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }

    // Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius.
    public int calculAllotjamentsOperatius() {
        int comptador = 0;
        // Crear iterator per recorrer la llista
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        // bucle per recorrer la llista mentre hi hagui elements a la llista
        while (itr.hasNext()) {
            if (itr.next().correcteFuncionament()) comptador++;
            // Comprova que funcioni correctament
        }
        return comptador;
    }

    //
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        // si no hi ha allotjaments, retorna 'null'
        if (llistaAllotjaments.isEmpty()) return null;
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        Allotjament mesCurta = itr.next();

        while (itr.hasNext()) {
            Allotjament actual = itr.next();
            if (actual.getEstadaMinima(temp) < mesCurta.getEstadaMinima(temp)) {
                mesCurta = actual;
            }
        }
        return mesCurta;
    }

    // Mètode per obtenir la temporada
    public static InAllotjament.Temp getTemporada(LocalDate data) {
        // Obté el dia i el mes de la data
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        // Sabent que la Temporada alta és del 21/3 al 20/9
        // i que la Temporada baixa és del 21/9 al 20/3

        // 'if' (condicio) per comprovar si la data es dins de la temporada alta o no
        if ((mes > 3 && mes < 9) || (mes == 3 && dia >= 21) || (mes == 9 && dia <= 20)) {
            return InAllotjament.Temp.ALTA;
            // si no ho és, segurament serà temporada baixa
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }

    // Mètode 'buscarAllotjament'
    private Allotjament buscarAllotjament(String idAllotjament) {
        // crear un iterador per recorrer la llista d'allotjaments
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        // això vol dir que mentre hi hagui elements a la llista, entra en el bucle
        while (itr.hasNext()) {
            // agafa el següent element de la llista d'allotjament
            Allotjament a = itr.next();
            // usa 'if'(condicio) per comprovar si l'id és igual al que volem buscar
            if (a.getId().equals(idAllotjament)) return a;
        }
        // Si no es troba, retorna 'null'
        return null;
    }

    //  Mètode 'buscarClient'
    private Client buscarClient(String dni) {
        // Crear iterador
        Iterator<Client> itr = llistaClients.iterator();
        // bucle per recorrer la llista mentre hi hagui elements a la llista
        while (itr.hasNext()) {
            Client c = itr.next();
            // 'if' (coindicio) : retorna client si el DNI coincideix
            if (c.getDni().equals(dni)) return c;
        }
        // Si no es troba, retorna 'null'
        return null;
    }
}
