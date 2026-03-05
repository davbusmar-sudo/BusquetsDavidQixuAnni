package prog2.model;

public abstract class Allotjament implements InAllotjament {
    // Atributs
    private String nom;
    private String id;
    private long estadaMinimaALTA_;
    private long estadaMinimaBAIXA_;

    // Constructor
    public Allotjament(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }
    // getters
    public String getNom(){
        return this.nom;
    }
    public String getId(){
        return this.id;
    }
    // mètode que obté l'estada mínima segons la temporada
    public long getEstadaMinima(Temp temp){
        if(temp == Temp.ALTA){
            return estadaMinimaALTA_;
        } else {
            return estadaMinimaBAIXA_;
        }
    }
    // setters
    public void setNom(String nom){
        this.nom = nom;
    }
    public void getId(String id){
        this.id = id;
    }
    // mètode que estableix l'estada mínima per ac ada temporada
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }
}
