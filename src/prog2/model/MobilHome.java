package prog2.model;

public abstract class MobilHome extends Casa {

    // Atribut
    private boolean terrassaBarbacoa;
    // Constructor
    public MobilHome(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int numHabitacions, int placesPerPersones, boolean terrassaBarbacoa){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, numHabitacions, placesPerPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // una Mobil-Home té un funcionament correcte si té terrassa amb barbacoa
    @Override
    public boolean correcteFuncionament(){
        return terrassaBarbacoa;
    }

    @Override
    public String toString(){
        return super.toString()+"MobilHome{té terrassa="+terrassaBarbacoa+"}";
    }
}
