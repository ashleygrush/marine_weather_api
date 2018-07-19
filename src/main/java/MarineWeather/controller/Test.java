package MarineWeather.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Test {

    @GetMapping
    public String test() {
        return "Connection successful.";
    }
}

