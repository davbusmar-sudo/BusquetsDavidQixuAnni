package prog2.model;

public abstract class Glamping extends Casa {

    // enum 'material' del glamping
    public enum Material {TELA, FUSTA}

    // Atributs
    private Material material;
    private boolean casaMascota;

    //Constructor
    public Glamping(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int habitacions, int placesPersones, Material material, boolean casaMascota){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, habitacions, placesPersones);
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
    //Mètode 'toString'
    @Override
    public String toString(){
        return super.toString()+"Glamping{tipus de material="+material+", té casa per mascota="+casaMascota+"}";
    }

    // No em deixar fer 'new Glamping' en camping, perquè es abstract,
    // faig un 'Glamping_' que no es abstract i aixi em deixar crear 'new Glamping'
    public static class Glamping_ extends Glamping{
        public Glamping_ (String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int habitacions, int placesPersones, Material material, boolean casaMascota){
            super(nom,id,estadaMinimaALTA_,estadaMinimaBAIXA_,mida,habitacions,placesPersones,material,casaMascota);
        }

        @Override
        public boolean correcteFuncionament(){
            return getCasaMascota();
        }
    }
}