package pl.ds360.cudanawidelcubackendrest.exceptions;

public class ErrorMessage {
    private String message;
    private int errorCode;

    public ErrorMessage(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
