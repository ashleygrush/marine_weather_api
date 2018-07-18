package MarineWeather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

     // starts application to run
     public static void main(String[] args) {
         SpringApplication.run(Application.class);
    }

    // Bean to start RESTful API
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
         return builder.build();
    }

}


// actual website link
// http://api.worldweatheronline.com/premium/v1/marine.ashx?key=5e6a5cd41fa34d94b3f232909181207&format=json&q=48.834,2.394


// local search
// http://localhost:8080/marineweather/search?location=44.723,3.6784&API_Key=5e6a5cd41fa34d94b3f232909181207

