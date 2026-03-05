package prog2.model;

// Els bungalows premium tenen els mateixos serveis que un bungalow, més llençols i tovalloles incloses i wifi gratuït
public abstract class BungalowPremium extends Bungalow {
    // Atributs
    // 'boolean' per indicar si tenen o no
    private boolean llencolsTovalloles;
    private boolean wifi;

    // Constructor
    public BungalowPremium(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int numHabitacions, int placesPerPersones, int placesParking, boolean terrassa, boolean tv, boolean aireFred, boolean llencolsTovalloles, boolean wifi){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, numHabitacions, placesPerPersones, placesParking, terrassa, tv, aireFred);
        this.llencolsTovalloles = llencolsTovalloles;
        this.wifi = wifi;
    }
    // Mètode per saber si el codi Wifi assignat té entre 8 i 16 caràcters.
    public boolean codiWifiCorrecte(String codi){
        if (codi.length() >= 8 && codi.length() <= 16){
            return wifi;
        }
    }
    // Bungalow Premium té un funcionament correcte si té aire fred
    //i el codi Wifi assignat té entre 8 i 16 caràcters.
    @Override
    public boolean correcteFuncionament(){
        return aireFred;
    }

    @Override
    public String toString(){
        return super.toString()+" BungalowPrenium{llençolsTovalloles = "+llencolsTovalloles+", wifi="+wifi+"}";
    }
}
