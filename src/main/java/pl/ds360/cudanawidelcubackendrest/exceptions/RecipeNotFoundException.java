package pl.ds360.cudanawidelcubackendrest.exceptions;

public class RecipeNotFoundException extends Exception {
    private int errorCode;

    public RecipeNotFoundException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
