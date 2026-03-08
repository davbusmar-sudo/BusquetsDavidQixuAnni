package prog2.model;

// Parcel·la hereta de la classe Allotjament
public abstract class Parcela extends Allotjament {
    // Atributs
    // la mida de la parcel·la en metres quadrats
    private float mida;
    // 'boolean' per indicar si té punt de connexió elèctrica
    private boolean connexioElectrica;

    // Constructor
    public Parcela (String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, float mida, boolean connexioElectrica){
        // cridar al constructor de la classe 'Allotjament' per inicialitzar els atributs heretats
        super(nom,id,estadaMinimaALTA_,estadaMinimaBAIXA_);
        // Atributs específics de Parcel·la
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    // getters
    public float getMida(){
        return mida;
    }
    public boolean getConnexioElectrica(){
        return connexioElectrica;
    }

    // setters
    public void setMida(float mida){
        this.mida = mida;
    }
    public void setConnexioElectrica(boolean connexioElectrica){
        this.connexioElectrica = connexioElectrica;
    }

    /*
    * Mètode que comprova si la parcel·la funciona de manera correcte
    * Per funciona correctament, la parcel·la ha de tenir punt de connexió elèctrica
    * @return true si té punt de connexió elèctrica, en cas contrari, retorna false
     */
    @Override
    public boolean correcteFuncionament(){
       // La parcel·la funciona correctament quan TÉ CONNEXIÓ ELÈCTRICA
        return connexioElectrica;
    }
    // Mètode 'toString'
    public String toString(){
        return super.toString()+"Parcela{mida="+mida+", connexioElectrica="+connexioElectrica+"}";
    }

    // No em deixar fer 'new Parcela' en camping, perquè es abstract,
    // faig un 'Parcela_' que no es abstract i aixi em deixar crear 'new Parcela'
    public static class Parcela_ extends Parcela{
        public Parcela_ (String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, float mida, boolean connexioElectrica){
            super(nom,id,estadaMinimaALTA_,estadaMinimaBAIXA_,mida,connexioElectrica);
        }

        @Override
        public boolean correcteFuncionament(){
            return getConnexioElectrica();
        }
    }
}