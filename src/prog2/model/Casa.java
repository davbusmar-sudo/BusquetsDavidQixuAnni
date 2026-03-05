package prog2.model;

public abstract class Casa extends Allotjament {
    // enum 'mida' de casa
    public enum Mida {PETITA, MITJANA, GRAN}

    // Atributs
    private Mida mida;
    private int habitacions;
    private int placesPersones;

    // Constructor
    public Casa(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int habitacions, int placesPersones){
        super(nom,id,estadaMinimaALTA_,estadaMinimaBAIXA_);
        this.mida = mida;
        this.placesPersones = placesPersones;
        this.habitacions = habitacions;
    }

    // getters
    public Mida getMida(){
        return mida;
    }
    public int getNumHabitacions(){
        return habitacions;
    }
    public int getPlacesPerPersones(){
        return placesPersones;
    }

    // setters
    public void setMida(Mida mida){
        this.mida = mida;
    }
    public void setHabitacions(int habitacions){
        this.habitacions = habitacions;
    }
    public void setPlacesPersones(int placesPersones){
        this.placesPersones = placesPersones;
    }
}
