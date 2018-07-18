package MarineWeather.model.database;

public class LocationWeather {

    // Location Weather items to import into database
    int id;
    String date;
    int maxtempF;
    int  mintempF;
    String location;
    String prettyLocation;


    public LocationWeather() {
    }

    public LocationWeather(String date, int maxtempF, int mintempF, String location) {
        this.date = date;
        this.maxtempF = mintempF;
        this.mintempF = mintempF;
        this.location = location;

    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(int maxtempF) {
        this.maxtempF = maxtempF;
    }

    public int getMintempF() {
        return mintempF;
    }

    public void setMintempF(int mintempF) {
        this.mintempF = mintempF;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrettyLocation() {
        return prettyLocation;
    }

    public void setPrettyLocation(String prettyLocation) {
        this.prettyLocation = prettyLocation;
    }

    @Override
    public String toString() {
        return "LocationWeather{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", maxtempF=" + maxtempF +
                ", mintempF=" + mintempF +
                ", location='" + location + '\'' +
                ", prettyLocation='" + prettyLocation + '\'' +
                '}';
    }
}

