package prog2.model;

public class MobilHome extends Casa {

    // Atribut
    private boolean terrassaBarbacoa;

    /*
     * Segons l'enunciat, les estades mínimes per Mobil-Home són 5 nits (Alta) i 3 nits (Baixa).
     */
    public MobilHome(String nom, String id, Casa.Mida mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, id, 5L, 3L, mida, habitacions, placesPersones);
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