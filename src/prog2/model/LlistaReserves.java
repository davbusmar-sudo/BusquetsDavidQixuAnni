package prog2.model;

import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves {

    private ArrayList<Reserva> llista;

    public LlistaReserves() {
        this.llista = new ArrayList<>();
    }

    /**
     * Retorna el número de reserves de la llista.
     *
     * @return el número de reserves.
     */
    public int getNumReserves() {
        return this.llista.size();
    }

}
