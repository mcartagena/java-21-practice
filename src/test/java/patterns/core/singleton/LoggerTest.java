package patterns.core.singleton;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @Test
    void singletonIsSameInstance() {
    Logger a = Logger.getInstance();
    Logger b = Logger.getInstance();
        assertSame(a, b, "getInstance should return the same instance");
    }

    @Test
    void logPrintsToConsole() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream previous = System.out;
        System.setOut(new PrintStream(baos));
        try {
            Logger.getInstance().log("hello-test-logger");
        } finally {
            System.setOut(previous);
        }
        String out = baos.toString();
        assertTrue(out.contains("hello-test-logger"), "The output should contain the logged message");
    }

    @Test
    void cloneNotSupported() {
    Logger logger = Logger.getInstance();
        assertThrows(CloneNotSupportedException.class, () -> {
            // try to invoke clone and expect it to fail
            logger.clone();
        }, "Cloning the singleton should throw CloneNotSupportedException");
    }
}
