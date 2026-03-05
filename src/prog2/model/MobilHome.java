package prog2.model;

public abstract class MobilHome extends Casa {

    // Atribut
    private boolean terrassaBarbacoa;
    // Constructor
    public MobilHome(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int numHabitacions, int placesPerPersones, boolean terrassaBarbacoa){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, numHabitacions, placesPerPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // getter
    public boolean getTerrassa(){
        return terrassaBarbacoa;
    }
    // setter
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa){
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // una Mobil-Home té un funcionament correcte si té terrassa amb barbacoa
    @Override
    public boolean correcteFuncionament(){
        return terrassaBarbacoa;
    }

    // Mètode 'toString'
    @Override
    public String toString(){
        return super.toString()+"MobilHome{té terrassa="+terrassaBarbacoa+"}";
    }
}
