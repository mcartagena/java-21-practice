package patterns.core.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Simple singleton Logger that prints messages to the console.
 * Thread-safety: log(String) is synchronized to avoid interleaved output.
 */
public final class Logger implements Cloneable{
    private static final Logger INSTANCE = new Logger();
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {
        // private constructor
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    /**
     * Prints a message to standard output with a timestamp.
     * @param message message to print
     */
    public void log(String message) {
        String ts = LocalDateTime.now().format(fmt);
        synchronized (this) {
            System.out.println(ts + " - " + message);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Logger is a singleton and cannot be cloned");
    }
}
