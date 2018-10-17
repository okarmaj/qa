package pl.jsystems.qa.qaapi.model.error;

public class ErrorResponse {

    public ErrorBody Error;

    public static class ErrorBody {
        public String errorCode;
        public String validationError;
        public String messageError;
    }

}
