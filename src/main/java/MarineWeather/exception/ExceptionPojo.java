package MarineWeather.exception;

public class ExceptionPojo {

    String error;
    int errorResponse;

    public ExceptionPojo(String error, int errorResponse) {
        this.error = error;
        this.errorResponse = errorResponse;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(int errorResponse) {
        this.errorResponse = errorResponse;
    }
}
