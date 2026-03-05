
package prog2.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import prog2.vista.ExcepcioReserva;


public class LlistaReserves implements InLlistaReserves {

    private ArrayList<Reserva> llista;

    public LlistaReserves() {
        this.llista = new ArrayList<>();
    }

    /**
     * Retorna el número de reserves de la llista.
     * @return el número de reserves.
     */
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
                throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() + " amb DNI: " + client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId() + ".");
            }
            if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
                throw new ExcepcioReserva("L'allotjament amb identificador " + allotjament.getId() + " no està disponible en la data demanada " + dataEntrada + " pel client " + client.getNom() + " amb DNI: " + client.getDni() + ".");
            }

            Reserva novaReserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
            llista.add(novaReserva);

                /**
                 * Retorna el número de reserves de la llista.
                 * @return el número de reserves.
                 */

    }

}

private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
    long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
    InAllotjament.Temp temp = Camping.getTemporada(dataEntrada)
    return estada >= allotjament.getEstadaMinima(temp);
}


private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
    for (Reserva r : llista) {
        // Si és el mateix allotjament, mirem si les dates se solapen
        if (r.getAllotjament().getId().equals(allotjament.getId())) {
            // Hi ha solapament si (Entrada1 < Sortida2) i (Sortida1 > Entrada2)
            if (dataEntrada.isBefore(r.getDataSortida()) && dataSortida.isAfter(r.getDataEntrada())) {
                return false; // No disponible
            }
        }
    }
    return true; // Disponible
}
}