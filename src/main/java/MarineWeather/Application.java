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

// localhost:8080/marineweather/Locationsearch?location=48.834,2.394

// localhost:8080/marineweather/search?location=48.834,2.394
