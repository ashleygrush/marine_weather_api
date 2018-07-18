package MarineWeather.service;

import MarineWeather.controller.SecurityControl;

public class SecurityService {

    // Authenticates API key entered from user against control key
    public Boolean authentication(String user_key) {

        // import control API Key
        SecurityControl controlKey = new SecurityControl();

        // compare keys
        if (user_key.equalsIgnoreCase(controlKey.getAPI_KEY())) {
            return true;

            // if false, ask to enter new key
        } else {
            System.out.println("Invalid key entered. Please enter valid key.");
        }
        return false;
    }

}
