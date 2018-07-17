package MarineWeather.model.database;

public class DBSearch {

    int id;
    LocationWeather locationWeathers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocationWeather getLocationWeathers() {
        return locationWeathers;
    }

    public void setLocationWeathers(LocationWeather locationWeathers) {
        this.locationWeathers = locationWeathers;
    }
}


