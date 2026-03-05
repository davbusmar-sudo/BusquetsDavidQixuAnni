package prog2.model;

// Els bungalows tenen places de pàrquing(1 o 2), terrassa, televisió i aire fred
// Bungalow hereta de Casa
public abstract class Bungalow extends Casa {

    // Atributs
    private int placesParquing;
    // 'boolean' per indicar si tenen o no
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    // Constructor
    public Bungalow(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, habitacions, placesPersones);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    // getters
    public int getPlacesParquing(){
        return placesParquing;
    }
    public boolean getTerrassa(){
        return terrassa;
    }
    public boolean getTv(){
        return tv;
    }
    public boolean getAireFred(){
        return aireFred;
    }
    // setters
    public void setPlacesParquing(int placesParquing){
        this.placesParquing = placesParquing;
    }
    public  void setTerrassa(boolean terrassa){
        this.terrassa = terrassa;
    }
    public void setTv(boolean tv){
        this.tv = tv;
    }
    public void setAireFred(boolean aireFred){
        this.aireFred = aireFred;
    }
    // Bungalow té un funcionament correcte si té aire fred.
    @Override
    public boolean correcteFuncionament(){
        return aireFred;
    }

    // Mètode 'toString'
    @Override
    public String toString(){
        return super.toString()+" Bungalow{places de Parking="+placesParquing+", té terrassa="+terrassa+", té televisió= "+ tv+ ", té aire fred="+aireFred+"}";
    }
}
