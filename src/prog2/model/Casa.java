package prog2.model;

public abstract class Casa extends Allotjament {
    // enum 'mida' de casa
    public enum Mida {PETITA, MITJANA, GRAN}

    // Atributs
    private Mida mida;
    private int numHabitacions;
    private int placesPerPersones;
    // Constructor
    public Casa(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int numHabitacions, int placesPerPersones){
        super(nom,id,estadaMinimaALTA_,estadaMinimaBAIXA_);
        this.mida = mida;
        this.placesPerPersones = placesPerPersones;
        this.numHabitacions = numHabitacions;
    }
    // getters
    public Mida getMida(){
        return mida;
    }
    public int getNumHabitacions(){
        return numHabitacions;
    }
    public int getPlacesPerPersones(){
        return placesPerPersones;
    }
}
