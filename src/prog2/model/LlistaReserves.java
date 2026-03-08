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

    @Override
    public int getNumReserves() {
        return this.llista.size();
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {

        // 1. Comprovar estada mínima
        if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() + " amb DNI: " + client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId() + ".");
        }

        // 2. Comprovar disponibilitat
        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("L'allotjament amb identificador " + allotjament.getId() + " no està disponible en la data demanada " + dataEntrada + " pel client " + client.getNom() + " amb DNI: " + client.getDni() + ".");
        }

        // 3. Si és disponible;
        Reserva novaReserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        llista.add(novaReserva);
    }

    // metodos per fer les comprovacions
    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida); // [cite: 164]
        InAllotjament.Temp temp = Camping.getTemporada(dataEntrada); // [cite: 134]
        return estada >= allotjament.getEstadaMinima(temp);
    }

    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        for (Reserva r : llista) {
            if (r.getAllotjament_().getId().equals(allotjament.getId())) {
                if (dataEntrada.isBefore(r.getDataSortida()) && dataSortida.isAfter(r.getDataEntrada())) {
                    return false;
                }
            }
        }
        return true; // Està disponible
    }
}