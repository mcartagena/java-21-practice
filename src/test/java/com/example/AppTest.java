package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class AppTest {

    // Aceptar: "Se recomienda instalar una extensión para ejecutar pruebas java."

    @Test
    void mainPrintsGreeting() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));
            App.main(new String[0]);
        } finally {
            System.setOut(originalOut);
        }
        String expected = "Hello from Java 21 project!" + System.lineSeparator();
        assertEquals(expected, new String(out.toByteArray(), StandardCharsets.UTF_8));
    }

    @Test
    void mainHandlesNullArgs() {
        assertDoesNotThrow(() -> App.main(null));
    }

    @Test
    void mainWithArgsAlsoPrintsGreeting() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));
            App.main(new String[] { "one", "two" });
        } finally {
            System.setOut(originalOut);
        }
        assertTrue(new String(out.toByteArray(), StandardCharsets.UTF_8)
                .contains("Hello from Java 21 project!"));
    }
}

