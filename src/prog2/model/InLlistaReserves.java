
package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;

import prog2.vista.ExcepcioReserva;

public class LlistaReserves implements InLlistaReserves {

    private ArrayList<Reserva> llista;

    public LlistaReserves() {
        this.llista = new ArrayList<>();
    }

    public int getNumReserves() {
        return this.llista.size();
    }

}
/**
 * Interfície per definir la forma de la llista de reserves
 * @author
 */
public interface InLlistaReserves {
    
    /**
     * Comprova que l'estada que es demani sigui més llarga o igual que l'estada mínima.
     * Comprova que l'allotjament estigui disponible pels dies indicats.
     * En cas afirmatiu, crea la reserva i l’afegeix a la llista de reserves del camping.
     * En cas negatiu, llança una excepció de tipus ExceptionReserva amb el missatge d'error.
     * 
     * @param allotjament
     * @param client
     * @param dataEntrada
     * @param dataSortida
     * @throws ExcepcioReserva 
     */
     void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva;

            if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
                throw new ExcepcioReserva("L’allotjament amb identificador " + allotjament.getID() + " no està disponible en la data demanada " + dataEntrada + " pel client " + client.nom() + " amb DNI: " + client.getDNI() + ".");
                }
            if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
                throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.nom() + " amb DNI: " + client.getDNI() + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getID() + ".");
                }
            Reserva novaReserva = new Reserva(allotjament, client, dataEntrada, dataSortida)


                /**
                 * Retorna el número de reserves de la llista.
                 * @return el número de reserves.
                 */

    } int getNumReserves();

}

boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
    long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
    InAllotjament.Temp temp = Camping.getTemporada(dataEntrada)

    return estada >= allotjament.getEstadaMinima(temp);
}


boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
    long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
    boolean disponible = true;
    return disponible;
}