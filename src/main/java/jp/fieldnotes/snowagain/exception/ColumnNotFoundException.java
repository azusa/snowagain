package jp.fieldnotes.snowagain.exception;

/**
 * Created by azusa on 2017/01/14.
 */
public class ColumnNotFoundException extends RuntimeException {

    public ColumnNotFoundException() {
    }

    public ColumnNotFoundException(String message) {
        super(message);
    }

    public ColumnNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColumnNotFoundException(Throwable cause) {
        super(cause);
    }

    public ColumnNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
