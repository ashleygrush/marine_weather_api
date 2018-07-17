package MarineWeather.model.MarineWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
// controls all responses for weather / requests
public class Data {

    Request[] request;
    Weather[] weather;

    public Request[] getRequest() {
        return request;
    }

    public void setRequest(Request[] request) {
        this.request = request;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }
}
