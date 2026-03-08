package prog2.model;

public abstract class MobilHome extends Casa {

    // Atribut
    private boolean terrassaBarbacoa;

    // Constructor
    public MobilHome(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int habitacions, int placesPersones, boolean terrassaBarbacoa){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, habitacions, placesPersones);
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

    // No em deixar fer 'new MobilHome' en camping, perquè es abstract,
    // faig un 'MobilHome_' que no es abstract i aixi em deixar crear 'new MobilHome'
    public static class MobilHome_ extends MobilHome{
        public MobilHome_ (String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int habitacions, int placesPersones, boolean terrassaBarbacoa){
            super(nom,id,estadaMinimaALTA_,estadaMinimaBAIXA_,mida,habitacions,placesPersones,terrassaBarbacoa);
        }

        @Override
        public boolean correcteFuncionament(){
            return getTerrassa();
        }
    }
}