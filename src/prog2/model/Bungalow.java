package prog2.model;

// Els bungalows tenen places de pàrquing(1 o 2), terrassa, televisió i aire fred
// Bungalow hereta de Casa
public abstract class Bungalow extends Casa {

    // Atributs
    private int placesParking;
    // 'boolean' per indicar si tenen o no
    private boolean terrassa;
    private boolean tele;
    private boolean aireFred;

    // Constructor
    public Bungalow(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int numHabitacions, int placesPersones, int placesParking, boolean terrassa, boolean tele, boolean aireFred){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, numHabitacions, placesPersones);
        this.placesParking = placesParking;
        this.terrassa = terrassa;
        this.tele = tele;
        this.aireFred = aireFred;
    }

    // Bungalow té un funcionament correcte si té aire fred.
    @Override
    public boolean correcteFuncionament(){
        return aireFred;
    }

    @Override
    public String toString(){
        return super.toString()+" Bungalow{places de Parking="+placesParking+", té terrassa?"+terrassa+", té televisió? "+ tele+ ", té aire fred?"+aireFred+"}";
    }
}
