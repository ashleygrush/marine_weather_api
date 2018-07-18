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
    String INSERT_LOCATION_WEATHER = "INSERT INTO marineweather.locationweather " +
            "(date, maxtempF, mintempF, location) " +
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

    String CHECK_DUPLICATE_LOC = "SELECT CASE " +
            "WHEN COUNT(location)>6 THEN 1 " +
            "ELSE 0 END Result " +
            "FROM marineweather.locationweather " +
            "WHERE location = #{location}";

    String CHECK_DUPLICATE_DATE = "SELECT CASE " +
            "WHEN COUNT(date)>0 THEN 1 " +
            "ELSE 0 END Result " +
            "FROM marineweather.locationweather " +
            "WHERE date = #{date}";

    String CHECK_DUPLICATES = "INSERT INTO marineweather.locationweather " +
            "(date, maxtempF, mintempF, location) " +
            "SELECT " +
            "#{date}, #{maxtempF}, #{mintempF}, #{location}" +
            "WHERE " +
            "NOT EXISTS (SELECT * FROM marineweather.locationweather " +
            "WHERE date = #{date} AND location = #{location})";

    String FIND_ID = "SELECT id " +
            "FROM marineweather.locationweather " +
            "WHERE location = #{location}";


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

    @Select(CHECK_DUPLICATE_LOC)
    public Boolean checkDuplicateLoc(@PathVariable("location") String location);

    @Select(CHECK_DUPLICATE_DATE)
    public Boolean checkDuplicateDate(@PathVariable("date") String date);

    @Select(CHECK_DUPLICATES)
    public boolean duplicateSearch(@PathVariable("date") String date,
                                  @PathVariable("location") String location);

    @Select(FIND_ID)
    public int findID(@PathVariable("location") String location);

}
