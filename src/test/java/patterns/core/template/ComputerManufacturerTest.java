package patterns.core.template;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class ComputerManufacturerTest {

    @Test
    void desktopBuildComputerExecutesTemplate() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));
            ComputerManufacturer cm = new DesktopManufacturer();
            cm.buildComputer();
        } finally {
            System.setOut(originalOut);
        }
        String expected = String.join(System.lineSeparator(),
                "ComputerManufacturer... buildComputer",
                "DesktopManufacturer... addHardDisk",
                "DesktopManufacturer... addRAM",
                "DesktopManufacturer... addKeyboard") + System.lineSeparator();
        assertEquals(expected, new String(out.toByteArray(), StandardCharsets.UTF_8));
    }

    @Test
    void laptopBuildComputerExecutesTemplate() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));
            ComputerManufacturer cm = new LaptopManufacturer();
            cm.buildComputer();
        } finally {
            System.setOut(originalOut);
        }
        String expected = String.join(System.lineSeparator(),
                "ComputerManufacturer... buildComputer",
                "LaptopManufacturer... addHardDisk",
                "LaptopManufacturer... addRAM",
                "LaptopManufacturer... addKeyboard") + System.lineSeparator();
        assertEquals(expected, new String(out.toByteArray(), StandardCharsets.UTF_8));
    }
}
