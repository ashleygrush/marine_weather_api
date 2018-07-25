package MarineWeather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class Application { //extends SpringBootServletInitializer {

     // starts application to run
     public static void main(String[] args) {
         SpringApplication.run(Application.class);
    }

    // Bean to start RESTful API
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
         return builder.build();
    }

//    @Override
//    protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
//    return application.sources(Application.class);
//    }

}

// ************* TO RUN LOCALLY ******************

// to run locally again,
// comment out added "provided" dependancy, extends SpringBootServleetInit. and Override above.


// ************* IMPORTANT LINKS ******************

// actual website link
// http://api.worldweatheronline.com/premium/v1/marine.ashx?key=5e6a5cd41fa34d94b3f232909181207&format=json&q=48.834,2.394


// local search
// http://localhost:8080/marineweather/search?location=42.623,2.6784&API_Key=5e6a5cd41fa34d94b3f232909181207


// ************* TEST CONNECTION *********************

// to test connection:
// http://localhost:8080/marineweather/test

// ************* DATABASE CONNECTION *****************

// http://54.149.133.231:8080/marine_weather_api-1.0-SNAPSHOT/marineweather/search?location=41.823,3.6874&API_Key=5e6a5cd41fa34d94b3f232909181207
