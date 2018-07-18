package MarineWeather.service;


import MarineWeather.mappers.MarineMapper;
import MarineWeather.model.MarineWeather.WWORoot;
import MarineWeather.model.MarineWeather.Weather;
import MarineWeather.model.database.DBSearch;
import MarineWeather.model.database.LocationWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.security.InvalidKeyException;

// The Brains... BRAINS!!
// Autowired into Controller
@Service
public class MarineService {

    // linked to runnable "bean" in MarineWeather.Application (run)
    @Autowired
    RestTemplate restTemplate;

    // linked to database mapper.
    @Autowired
    MarineMapper mapper;

    // searches Marine weather for location results - - location format: (48.834,2.394).
    public WWORoot searchMW(@RequestParam String location, @RequestParam String user_Key) throws InvalidKeyException {

        // import authentication method from security service class
        SecurityService verify = new SecurityService();

        // Verify API Key entered
        if (verify.authentication(user_Key)) {

            // Website URL + API key + search parameters
            String url = "http://api.worldweatheronline.com/premium/v1/marine.ashx?key=" + user_Key + "&format=json&q=" + location;

            // prints URL to check results side by side with HostLocal (Postman)
            System.out.println(url);

            // searches for location in URL.
            WWORoot wwoResponse = restTemplate.getForObject(url, WWORoot.class);
            {
                // set results to fill database.
                fillDatabase(wwoResponse, location);
            }
            return wwoResponse;
        // if key doesn't work; throw exception.
        } else {
            throw new InvalidKeyException();
        }
    }


    // GET - INPUT'S TEMPERATURE AND LAT/LONG INFO INTO DATABASE
    public void fillDatabase(WWORoot data, String location) {

        // set temp map to database
        LocationWeather tempDB = new LocationWeather();

        // pulls information from Weather array
        for (Weather weather : data.getData().getWeather()) {

            // set new values onto temp Database (must "import" location for duplicate checking)
            tempDB.setDate(weather.getDate());
            tempDB.setMaxtempF(weather.getMaxtempF());
            tempDB.setMintempF(weather.getMintempF());
            tempDB.setLocation(data.getData().getRequest()[0].getQuery());
            tempDB.setPrettyLocation(location);

            // double checks values for duplicates (inserts new data if none are found)
            try {
                mapper.duplicateSearch(tempDB);
                // if duplicate found, print exception with duplicate results.
            } catch (Exception e){
                System.out.println("duplicate found: " + tempDB.toString());
            }
        }
    }


    // GET - Searches database by ID
    public DBSearch dbSearch(@RequestParam("id") int id) {

        // import database
        DBSearch returnID = new DBSearch();

        // set DB ID (return ID) to searched "id" (id)
        returnID.setId(id);

        // return values to Location Weather method
        returnID.setLocationWeathers(mapper.selectByID(id));

        // return values
        return returnID;
    }


    // DELETE - Delete from database by ID
    public DBSearch deleteID(int id) {

        // import database
        DBSearch removeID = new DBSearch();

        // compare DB ID (removeID) to searched "id" (id)
        if (removeID.getId() == id) ;
        {
            // remove ID from DB
            removeID.setId(mapper.deleteByIDfromDB(id));
        }
        // if no results; return DB ID (remove ID)
        return removeID;
    }


    // POST - inserts new information into database
    public LocationWeather insertNew(LocationWeather data) {

        // pull from insertNew method
        LocationWeather newLoc = new LocationWeather();

        // set new values into database
        newLoc.setDate(data.getDate());
        newLoc.setMaxtempF(data.getMaxtempF());
        newLoc.setMintempF(data.getMintempF());
        newLoc.setLocation(data.getLocation());

        // import all values into database
        mapper.insertLocationWeathertoDB(newLoc);

        // return new values
        return newLoc;
    }


    // PUT - Updates information for existing information
    public LocationWeather updateID(@RequestParam("id") int id, LocationWeather data) {

        // display ID Results (from dbSearch method)
        LocationWeather newVals = new LocationWeather();

        // set new values into ID
        newVals.setDate(data.getDate());
        newVals.setMaxtempF(data.getMaxtempF());
        newVals.setMintempF(data.getMintempF());
        newVals.setLocation(data.getLocation());
        newVals.setId(id);

        // import new values into ID
        mapper.insertUpdateByID(newVals);

        // return new values
        return newVals;
    }


}
