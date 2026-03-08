package prog2.model;

public class Glamping extends Casa {

    // Enum 'Material' del glamping
    public enum Material {TELA, FUSTA}

    // Atributs
    private Material material;
    private boolean casaMascota;

    //Constructor
    public Glamping(String nom, String id, Casa.Mida mida, int habitacions, int placesPersones, Material material, boolean casaMascota) {
        super(nom, id, 4L, 2L, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }

        // Getters
        public Material getMaterial() { return material; }
        public boolean getCasaMascota() { return casaMascota; }

        // Setters
        public void setMaterial(Material material) { this.material = material; }
        public void setCasaMascota(boolean casaMascota) { this.casaMascota = casaMascota; }


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
}