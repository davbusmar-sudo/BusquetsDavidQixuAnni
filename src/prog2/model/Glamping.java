package prog2.model;

public abstract class Glamping extends Casa {
    // enum 'material' del glamping
    public enum Material {TELA, FUSTA}
    // Atributs
    private Material material;
    private boolean casaMascota;

    //Constructor
    public Glamping(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int numHabitacions, int placesPersones, Material material, boolean casaMascota){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, numHabitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    //  un Glamping té un funcionament correcte si té una casa per a
    //mascota.
    @Override
    public boolean correcteFuncionament(){
        return casaMascota;
    }
    @Override
    public String toString(){
        return super.toString()+"Glamping{material="+material+", casaMascota="+casaMascota+"}";
    }
}
