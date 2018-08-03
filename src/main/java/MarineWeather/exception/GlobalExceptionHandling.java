package MarineWeather.exception;

import MarineWeather.model.CustomResponseObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandling {

    // handles all errors
    @ExceptionHandler(Exception.class)
    public @ResponseBody CustomResponseObject handleError(HttpServletRequest req, Exception ex) {

        CustomResponseObject responseObject = new CustomResponseObject();
        ExceptionPojo error = new ExceptionPojo("Error found: see below for details.", 500);
        responseObject.setError(error);
        responseObject.setMessage("error found: 500. See server for details.");

    return responseObject;
    }

}
