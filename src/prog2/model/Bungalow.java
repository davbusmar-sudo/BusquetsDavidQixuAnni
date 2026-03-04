package prog2.model;

// Els bungalows tenen pàrquing, terrassa, televisió i aire fred
public abstract class Bungalow extends Casa {

    // Atributs
    private int placesParking;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    // Constructor
    public Bungalow(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int numHabitacions, int placesPersones, int placesParking, boolean terrassa, boolean tv, boolean aireFred){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, numHabitacions, placesPersones);
        this.placesParking = placesParking;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    // Bungalow té un funcionament correcte si té aire fred.
    @Override
    public boolean correcteFuncionament(){
        return aireFred;
    }

    @Override
    public String toString(){
        return super.toString()+" Bungalow{placesParking="+placesParking+", terrassa="+terrassa+", tv="+ tv+ ", aireFred="+aireFred+"}";
    }
}
