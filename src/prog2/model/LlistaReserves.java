package prog2.model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import prog2.vista.ExcepcioReserva;

public class LlistaReserves implements InLlistaReserves {

    private ArrayList<Reserva> llistaReserves;
    // Constructor
    public LlistaReserves() {
        this.llistaReserves = new ArrayList<>();
    }

    /* Mètode 'allotjamentDisponible'
     * serveix per comprovar si està disponible per a les dates indicades
     * @param allotjament, l'allotjament que volem comprovar
     * @param dataEntrada
     * @param dataSortida
     * @return retorna 'true' si està disponible, i retorna 'false' si no ho està
    */
    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        // crear iterator per recorrer la llista de reserves
        Iterator<Reserva> itrReserva = llistaReserves.iterator();
        while(itrReserva.hasNext()){
            Reserva reserva = itrReserva.next();
            // 'if' (condicio) per comprovar reserves, però només del mateix allotjament
            if(reserva.getAllotjament_().getId().equals(allotjament.getId())){
                // Comprova si hi ha solapament, si n'hi ha , retorna false
                if(!(dataSortida.isBefore(reserva.getDataEntrada()) || dataEntrada.isAfter(reserva.getDataSortida()))){
                    return false;
                }
            }
        }
        // retorna true, ja que no hi ha solapament
        return true;
    }
    /*
    * Mètode 'isEstadaMinima' que comprova si estada compleix l'estada minima
    * @param allotjament, l'allotjament que volem comprovar
    * @param dataEntrada
    * @param dataSortida
    * @return retorna 'true' si compleix l'estada minima, i si no compleix retorna false
     */
    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        // Calcular el nombre de dies de l'estada
        int diesEstada = (int)dataEntrada.until(dataSortida).getDays();
        // Trobar la temporada de la data d'entrada
        InAllotjament.Temp temporada = Camping.getTemporada(dataEntrada);
        // Trobar l'estada minima per l'allotjament i temporada
        int estadaMinima;
        if (temporada == InAllotjament.Temp.ALTA){
            estadaMinima = (int) allotjament.getEstadaMinimaAlta();
        }else {
            estadaMinima = (int) allotjament.getEstadaMinimaBaixa();
        }
        // retorna true si l'estada és més llarga o igual que la minima
        // si no passa això, retorna false
        return diesEstada >= estadaMinima;
    }
    /*
    * Mètode 'afegirReserva'
    * @param allotjament, l'allotjament que volem reservar
    * @param client, el client que fa la reserva
    * @param dataEntrada
    * @param dataSortida
    * @throws ExcepcioReserva per si no compleix els requisits
     */
    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        // comprovar l'estada  minima
        if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() + " amb DNI: " + client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId() + ".");
        }
        // comprovar la disponibilitat de l'allotjament
        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("L'allotjament amb identificador " + allotjament.getId() + " no està disponible en la data demanada " + dataEntrada + " pel client " + client.getNom() + " amb DNI: " + client.getDni() + ".");
        }
        // crear 'nova reserva'
        Reserva novaReserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        // afegir la 'nova reserva' a la llista de reserves
        llistaReserves.add(novaReserva);

    }
    /*
     * Retorna el número de reserves de la llista.
     * @return el número de reserves.
     */
    public int getNumReserves() {
        return llistaReserves.size();
    }
}
