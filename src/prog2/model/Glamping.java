package prog2.model;

public abstract class Glamping extends Casa {
    // enum 'material' del glamping
    public enum Material {TELA, FUSTA}
    // Atributs
    private Material material;
    private boolean casaMascota;

    //Constructor
    public Glamping(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int numHabitacions, int placesPerPersones, Material material, boolean casaMascota){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, numHabitacions, placesPerPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    // getters
    public Material getMaterial(){
        return material;
    }
    public boolean getCasaMascota(){
        return casaMascota;
    }
    // setters
    public void setMaterial(Material material){
        this.material= material;
    }
    public void setCasaMascota(boolean casaMascota){
        this.casaMascota = casaMascota;
    }

    // un Glamping té un funcionament correcte si té una casa per a mascota.
    @Override
    public boolean correcteFuncionament(){
        return casaMascota;
    }
    @Override
    public String toString(){
        return super.toString()+"Glamping{tipus de material="+material+", té casa per mascota="+casaMascota+"}";
    }
}
