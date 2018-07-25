package MarineWeather.mappers;

import MarineWeather.model.database.LocationWeather;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

@Mapper
public interface MarineMapper {

    // talks to database to insert items
    String INSERT_LOCATION_WEATHER = "INSERT INTO marineweather.locationweather " +
            "(date, maxtempF, mintempF, location) " +
            "VALUES (#{date}, #{maxtempF}, #{mintempF}, #{location})";

    // searches database by ID number
    String SELECT_BY_ID = "SELECT * FROM marineweather.locationweather where id like #{id}";

    // removes row from database by ID number
    String DELETE_BY_ID = "DELETE FROM marineweather.locationweather where #{id} = id";

    // updates row of information in database by ID number
    String UPDATE_BY_ID = "UPDATE `marineweather`.locationweather "+
            "SET date = #{date}, " +
            "maxtempF = #{maxtempF}, " +
            "mintempF = #{mintempF}, " +
            "location = #{location} " +
            "WHERE id = #{id}";

    String CHECK_DUPLICATES = "INSERT IGNORE INTO marineweather.locationweather (date, maxtempF, mintempF, location) " +
            "VALUES (#{date}, #{maxtempF}, #{mintempF}, #{location})";

    // CHECKS FOR DUPLICATE VALUES
    String CHECK_DUPLICATES_OLD = "INSERT INTO marineweather.locationweather " +
                                        "(date, maxtempF, mintempF, location) " +
                                    "SELECT " +
                                        "#{date}, #{maxtempF}, #{mintempF}, #{location} " +
                                "WHERE " +
                                    "NOT EXISTS (SELECT * FROM marineweather.locationweather " +
                                         "WHERE date = #{date} AND location = #{location})";

    // selects ID number from database by location
    String FIND_ID = "SELECT id " +
            "FROM marineweather.locationweather " +
            "WHERE location = #{location}";


    // inserts results into database
    @Insert(INSERT_LOCATION_WEATHER)
    public int insertLocationWeathertoDB(LocationWeather locationWeather);

    // returns id results into LocationWeather array
    @Select(SELECT_BY_ID)
    public  LocationWeather selectByID(int id);

    // returns id results to remove from database
    @Delete(DELETE_BY_ID)
    public int deleteByIDfromDB(int id);

    // updates information by ID in database
    @Insert(UPDATE_BY_ID)
    public int insertUpdateByID(LocationWeather locationWeather);

    // inserts results from "Fill Database" method
    @Select(CHECK_DUPLICATES)
    public int duplicateSearch(LocationWeather locationWeather);

    // finds ID linked to location search
    @Select(FIND_ID)
    public int findID(String location);

}
