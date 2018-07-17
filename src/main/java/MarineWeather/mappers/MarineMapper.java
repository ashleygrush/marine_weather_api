package MarineWeather.mappers;

import MarineWeather.model.database.LocationWeather;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface MarineMapper {

    // talks to database to insert items
    String INSERT_LOCATION_WEATHER = "INSERT INTO marineweather.locationweather (date, maxtempF, mintempF, location) " +
            "VALUES (#{date}, #{maxtempF}, #{mintempF}, #{location})";

    // searches database by ID number
    String SELECT_BY_ID = "SELECT * FROM marineweather.locationweather where id like #{id}";

    String DELETE_BY_ID = "DELETE FROM marineweather.locationweather where #{id} = id";

    String UPDATE_BY_ID = "UPDATE `marineweather`.locationweather "+
            "SET date = #{date}, " +
            "maxtempF = #{maxtempF}, " +
            "mintempF = #{mintempF}, " +
            "location = #{location} " +
            "WHERE id = #{id}";

    // inserts results into database
    @Insert(INSERT_LOCATION_WEATHER)
    public int insertLocationWeathertoDB(LocationWeather locationWeather);

    // returns id results into LocationWeather array
    @Select(SELECT_BY_ID)
    public  LocationWeather selectByID(@PathVariable("id")int id);

    @Delete(DELETE_BY_ID)
    public int deleteByIDfromDB(int id);

    @Insert(UPDATE_BY_ID)
    public int insertUpdateByID(LocationWeather locationWeather);

}
