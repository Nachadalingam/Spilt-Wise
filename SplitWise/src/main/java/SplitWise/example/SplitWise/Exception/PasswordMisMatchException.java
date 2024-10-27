package SplitWise.example.SplitWise.Exception;

public class PasswordMisMatchException extends Exception{
    public PasswordMisMatchException() {
        super();
    }

    public PasswordMisMatchException(String message) {
        super(message);
    }

    public PasswordMisMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordMisMatchException(Throwable cause) {
        super(cause);
    }

    protected PasswordMisMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
