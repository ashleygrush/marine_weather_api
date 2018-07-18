package MarineWeather.controller;

import MarineWeather.model.MarineWeather.WWORoot;
import MarineWeather.model.database.DBSearch;
import MarineWeather.model.database.LocationWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MarineWeather.service.MarineService;


// CRUD (create, retrieve, update, delete)

// RESTing API Control
@RestController

// maps to URL location
@RequestMapping("/marineweather")
public class MarineControl {

    // connected to bean in MarineService class
    @Autowired
    MarineService marineService;

    // GET - INFORMATION (/SEARCH) WEBSITE
    @RequestMapping("/search") // http://localhost:8080/marineweather/search?location=48.834,2.394
    public WWORoot search(
            @RequestParam("location") String location) {

        WWORoot response = marineService.searchMW(location);

        return response;
    }


    // GET - INFORMATION FROM DATABASE BY ID
    @RequestMapping("/{id}") // http://localhost:8080/marineweather/1
    public DBSearch searchDB(
            @PathVariable("id") int id) {

        return marineService.dbSearch(id);
    }


    // DELETE - INFORMATION FROM DATABASE BY ID
    @DeleteMapping("/{id}") //in Postman - http://localhost:8080/marineweather/delete/1
    public DBSearch deleteID(
            @PathVariable("id") int id) {

        return marineService.deleteID(id);
    }


    // POST - INSERT NEW INFORMATION
    @PostMapping // in Postman (Post - new body)
    public LocationWeather insertNew(
        @RequestBody LocationWeather locationweather) {

        return marineService.insertNew(locationweather);
    }


    // PUT - UPDATE INFORMATION IN DATABASE BY ID
    @PutMapping("/{id}") // http://localhost:8080/marineweather/1 (Postman - POST)
    public LocationWeather updateID(
            @PathVariable("id") int id,
            @RequestBody LocationWeather locationWeather) {

        return marineService.updateID(id, locationWeather);
    }
}

