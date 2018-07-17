package MarineWeather.model.MarineWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
// linked to WWO Root - Data Class
public class Weather {

    String date;
    Astronomy[] astronomy;
    int maxtempC;
    int maxtempF;
    int mintempC;
    int mintempF;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Astronomy[] getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy[] astronomy) {
        this.astronomy = astronomy;
    }

    public int getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(int maxtempC) {
        this.maxtempC = maxtempC;
    }

    public int getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(int maxtempF) {
        this.maxtempF = maxtempF;
    }

    public int getMintempC() {
        return mintempC;
    }

    public void setMintempC(int mintempC) {
        this.mintempC = mintempC;
    }

    public int getMintempF() {
        return mintempF;
    }

    public void setMintempF(int mintempF) {
        this.mintempF = mintempF;
    }
}
