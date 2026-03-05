package prog2.model;

// Els bungalows premium tenen els mateixos serveis que un bungalow, més llençols i tovalloles incloses i wifi gratuït
public abstract class BungalowPremium extends Bungalow {
    // Atributs
    // 'boolean' per indicar si tenen o no
    private boolean serveisExtra;
    private String codiWifi;

    // Constructor
    public BungalowPremium(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, Mida mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi){
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    // getters
    public boolean getServeisExtra(){
        return serveisExtra;
    }
    public String getCodiWifi(){
        return codiWifi;
    }
    // setters
    public void setServeisExtra(boolean serveisExtra){
        this.serveisExtra = serveisExtra;
    }
    public void setCodiWifi(String codiWifi){
        this.codiWifi = codiWifi;
    }
    // Mètode per saber si el codi Wifi assignat té entre 8 i 16 caràcters.
    public boolean codiWifiCorrecte(String codi){
        if (codi.length() >= 8 && codi.length() <= 16){
            return true;
        } else {
            return false;
        }
    }
    // Bungalow Premium té un funcionament correcte si té aire fred
    //i el codi Wifi assignat té entre 8 i 16 caràcters.
    @Override
    public boolean correcteFuncionament(){
        return getAireFred() && codiWifiCorrecte(codiWifi);
    }

    @Override
    public String toString(){
        return super.toString()+" BungalowPrenium{llençolsTovalloles = "+serveisExtra+", wifi="+codiWifi+"}";
    }
}
